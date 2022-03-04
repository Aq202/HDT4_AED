package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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

	public static void main(String[] args) {
		Calculator calc = Calculator.getInstance();
		Scanner scan = new Scanner(System.in);
		String path = "";
		boolean end = false;
		
		System.out.println("Bienvenido a la calculadora de Infix a Posfix");
		while(!end) {
			String menu = """
					1. Iniciar ejecucion de archivo data.txt
					2. Salir
					""";
			int option = getValidInt(scan, menu, false, 1, 2, 3, 4);
			
			switch(option) {
			case 1:
				String[] fileContent = null;
				boolean repeat = true;
				while(repeat) {
					try {
						fileContent = FileController.readFile();
						repeat = false;
					} catch (IOException e) {
						System.out.println("Archivo no encontrado.\nPor favor, asegurese de que el archivo data.txt sea valido y se encuentre en la carpeta donde se encuentra el programa.");
						System.out.println("Presione enter para volver a buscar el archivo.");
						scan.nextLine();
					}
				}
				System.out.println("Archivo encontrado");
				int lineCount = 1;
				for (String row : fileContent) {
					try {
						String posfixExpression = calc.infixToPostfixConverter(row);
						System.out.println("Operacion en formato infix: " + row);
						System.out.println("Operacion en formato posfix: " + posfixExpression);
						System.out.println("Resultado: " +  "\n");
					}catch(IllegalAccessException e) {
						System.out.println("La expresion en la linea "+ lineCount + " no es valida.");
					}
					lineCount++;
				}
					
				break;
			case 2:
				System.out.println("Gracias por utilizar el programa!");
				end = true;
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		}
	}

}
