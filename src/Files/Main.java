package Files;
/**
 * Programa que permite convertir expresiones infix dentro de un archivo de texto a postfix y evaluarlas, utilizando
 * diferentes implementaciones del ADT stack y del ADT lista.
 * Realizado por:
 * Erick Stiv Junior Guerra - 21781
 * Diego Andres Morales Aquino - 21762
 * Pablo Andres Zamora Vasquez - 21780
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase Main. Permite indicarle al usuario si se encontro algun archivo de texto y que tipo de implementacion
 * del ADT pila desea utilizar para la conversion y evaluacion de las expresiones dentro de este
 * @author Pablo Zamora, Diego Morales, Erick Guerra
 * @version 06/03/2022
 */
public class Main {
	
	/**
	 * Metodo getValidInt. Permite verificar si la opcion ingresada por el usuario es valida.
	 * @param sc Scanner utilizado para el texto que ingresa el usuario
	 * @param message Texto ingresado
	 * @param absoluteValues Permite convertir cualquier entero a positivo
	 * @param validValues Valores validos
	 * @return int Opcion ingresada
	 */
	private static int getValidInt(Scanner sc, String message, boolean absoluteValues, Integer... validValues) {

		while (true) {

			try {

				System.out.println(message);
				int value = sc.nextInt();
				sc.nextLine();

				if (Arrays.asList(validValues).contains(value) || validValues.length == 0)
					return absoluteValues ? Math.abs(value) : value;
				else
					System.out.println("Por favor, ingresa un numero valido");

			} catch (Exception ex) {
				System.out.println("Por favor, ingresa un numero valido");
				sc.nextLine();
			}
		}
	}

	/**
	 * Metodo main. Crea una instancia de la clase Calculadora y le indica al usuario si se encontro el archivo "datos.txt". 
	 * De ser asi, tambien le pregunta la implementacion del ADT Stack a utilizar y llama al metodo correspondiente de la
	 * calculadora para convertir y evualuar las expresiones dentro del archivo.
	 * @param args
	 */
	public static void main(String[] args) {
		Calculator calc = Calculator.getInstance();
		Scanner scan = new Scanner(System.in);
		String path = "";
		boolean end = false;
		
		System.out.println("Bienvenido a la calculadora de Infix a Posfix");
		while(!end) { //Bucle principal
			String menu = """
					\nSeleccione la implementacion que desea utilizar:
					1. ArrayList
					2. Vectores
					3. Lista simple
					4. Lista doble""";
			int implementation = getValidInt(scan, menu, false, 1,2,3,4);
			menu = """
					\n1. Iniciar ejecucion de archivo data.txt
					2. Salir""";
			int option = getValidInt(scan, menu, false, 1, 2);
			
			switch(option) { 
			case 1: //Encontrar el archivo "datos.txt"
				String[] fileContent = null;
				boolean repeat = true;
				while(repeat) { //Bucle para encontrar el archivo
					try { //Se encuentra el archivo
						fileContent = FileController.readFile();
						repeat = false;
					} catch (IOException e) { //Si no se encuentra el archivo
						System.out.println("\nArchivo no encontrado.\nPor favor, asegurese de que el archivo data.txt sea valido y se encuentre en la carpeta donde se encuentra el programa.");
						System.out.println("Presione enter para volver a buscar el archivo.");
						scan.nextLine();
					}
				}
				System.out.println("\nArchivo encontrado");
				int lineCount = 1;
				for (String row : fileContent) { //Bucle para evaluar cada expresion del archivo
					try {
						System.out.println("\nLinea numero: "+lineCount);
						System.out.println("Operacion en formato infix: " + row);
						String posfixExpression = calc.infixToPostfixConverter(row, implementation); //Se convierte la expresion a postfix
						System.out.println("Operacion en formato posfix: " + posfixExpression);
						System.out.println("Resultado: " + calc.evaluatePostfix(posfixExpression)); //Se evalua la expresion
					}catch(Exception e) {
						System.out.println("La expresion en la linea "+ lineCount + " no es valida.");
					}
					lineCount++;
				}
					
				break;
			case 2: //Finaliza el programa
				System.out.println("Gracias por utilizar el programa!"); 
				end = true;
				break;
			default: //Opcion no valida
				System.out.println("Opcion no valida");
				break;
			}
		}
	}

}
