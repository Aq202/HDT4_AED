package Files;

import java.util.ArrayList;

public class Calculator {

	private static Calculator instance = null;

	private Calculator() {

	}

	/**
	 * Provee la instancia unica del objeto Calculator
	 * 
	 * @return Calculator.
	 */
	public static Calculator getInstance() {
		if (instance == null)
			instance = new Calculator();
		return instance;
	}

	/**
	 * Se encarga de convertir una expresion en formato infix a formato postfix
	 * @param expression Formato infix
	 * @return String. Expresion en formato postfix
	 * @throws IllegalAccessException
	 */
	public String infixToPostfixConverter(String expression) throws IllegalAccessException {

		if (expression == null)
			throw new IllegalAccessException("La expresion infix no es valida.");

		expression = expression.trim();
		char[] values = expression.toCharArray();
		String validOperators = "^*/+-()";
		
		StackFactory<String> stackFactory = new StackFactory<>();
		ListFactory<String> listFactory = new ListFactory<>();
		
		
		IStack<String> stack = stackFactory.getInstance();
		IList<String> list = listFactory.getInstance();
				

		for (int i = 0; i < expression.length(); i++) {

			String character = String.valueOf(values[i]).trim();
			
			//caracter vacio
			if(character.length() == 0) continue;

			// Agregar digito a stack
			if (parseDigit(character) != null)
				list.addLast(character);

			//operadores
			else {
				
				//validar operador
				if (!validOperators.contains(character))
					throw new IllegalArgumentException(
							"La expresion ingresada no se encuentra en un formato valido.");

				//inicio de parentesis
				if (character.equals("("))
					stack.push(character);

				// verificar fin de parentesis
				else if (character.equals(")")) {

					while (!stack.isEmpty())
						if (!stack.peek().equals("("))
							list.addLast(stack.pull());
						else {
							stack.pull();
							break;
						}
				}

				// verificar si el top operator es mayor
				else if (parseDigit(stack.peek()) == null && !stack.isEmpty()
						&& getOperatorPrecedence(stack.peek()) > getOperatorPrecedence(character)) {
					list.addLast(stack.pull());
					stack.push(character);
				}

				else
					stack.push(character);
			}
		}

		// anadir operadores restantes
		while (!stack.isEmpty()) {
			list.addLast(stack.pull());
		}

		return list.asString().replace("", " ").trim();
	}

	/**
	 * Metodo que se encarga de convertir un String a Integer.
	 * 
	 * @param value String.
	 * @return Integer. Si el valor no es un int retorna null.
	 */
	private Integer parseDigit(String value) {

		try {
			return Integer.parseInt(value);
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Retorna un valor relativo al orden de las operaciones
	 * @param op Signo de la operacion.
	 * @return Int.
	 */
	private int getOperatorPrecedence(String op) {

		switch (op) {

		case "^":
			return 2;
		case "*":
			return 1;
		case "/":
			return 1;
		case "+":
			return 0;
		case "-":
			return 0;
		default:
			return -1;

		}

	}

}
