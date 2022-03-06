package Files;


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
	public String infixToPostfixConverter(String expression, int implementation) throws IllegalAccessException {

		if (expression == null)
			throw new IllegalAccessException("La expresion infix no es valida.");

		expression = expression.trim();
		char[] values = expression.toCharArray();
		String validOperators = "^*/+-()";
		
		StackFactory<String> stackFactory = new StackFactory<>(implementation);
				
		
		IStack<String> stack = stackFactory.getInstance();
		String postfix = "";
				

		for (int i = 0; i < expression.length(); i++) {

			String character = String.valueOf(values[i]).trim();
			
			//caracter vacio
			if(character.length() == 0) continue;

			// Agregar digito a stack
			if (parseDigit(character) != null)
				postfix += character;

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
							postfix += stack.pull();
						else {
							stack.pull();
							break;
						}
				}

				// verificar si el top operator es mayor
				else if (parseDigit(stack.peek()) == null && !stack.isEmpty()
						&& getOperatorPrecedence(stack.peek()) > getOperatorPrecedence(character)) {
					postfix += stack.pull();
					stack.push(character);
				}

				else
					stack.push(character);
			}
		}

		// anadir operadores restantes
		while (!stack.isEmpty()) {
			postfix += stack.pull();
		}

		return postfix.replace("", " ").trim();
	}
	
	/**
	 * Metodo que se encarga de efectuar la operacion especificada en una expresion
	 * postfix.
	 * 
	 * Pre: Los elementos de la expresion deben de estar separados por un espacio en blanco. 
	 * 		Solo se admiten las operaciones + - / *.
	 * 		Para realizar una operacion se necesitan al menos dos operandos.
	 * 		La calculadora no admite la division por cero.
	 * Post: Se devuelve el resultado como valor entero.
	 * 
	 * @param expresion String. Expresion en formato postfix. 
	 * @return int. Resultado de la operacion.
	 */
	public double evaluatePostfix(String expresion) throws ArithmeticException {

		String[] values = expresion.split(" ");
		Stack_ArrayList<Integer> stack = new Stack_ArrayList<>();
		// Stack_Kiesling<Integer> stack = new Stack_Kiesling<Integer>();
		double result = 0;

		for (String value : values) {

			if (value.trim() != "") {

				Integer digit = parseDigit(value);

				// caracter es digito
				if (digit != null) {
					stack.push(digit);
				}
				// caracter es Signo
				else {

					final String sign = value.trim();
					final String validSigns = "+-*/";

					// validar signo
					if (!validSigns.contains(value))
						throw new IllegalArgumentException(
								"La expresion ingresada no se encuentra en un formato valido.");

					// validar cantidad de operandos
					if (stack.count() < 2)
						throw new IllegalArgumentException("Cantidad de operandos insuficiente.");

					int operatorB = stack.pull();
					int operatorA = stack.pull();

					switch (sign) {

					case "+":
						result = operatorA + operatorB;
						break;
					case "-":
						result = operatorA - operatorB;
						break;
					case "*":
						result = operatorA * operatorB;
						break;
					case "/":
						result = (double)operatorA / (double)operatorB;
						break;

					}

					// add result
					stack.push((int)result);

				}
			}
		}

		return result;
	}
	
	/**
	 * Se encarga de realizar la operacion especificada en formato infix.
	 * @param expression Infix.
	 * @return Int.
	 * @throws IllegalAccessException 
	 */
	public double evaluateInfix(String expression, int implementation) throws IllegalAccessException,ArithmeticException {
		
		String postfix = infixToPostfixConverter(expression, implementation);
		return evaluatePostfix(postfix);
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
