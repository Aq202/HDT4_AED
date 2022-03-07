package Files;
/**
 * Clase StackFactory. Permite instanciar la implementacion adecuada del ADT Stack.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T>
 */
public class StackFactory<T> {
	
	private IStack<T> stack; //Tipo de stack a instanciar
	
	/**
	 * Metodo constructor.
	 * @param implementation Determina la clase de stack a instanciar.
	 */
	public StackFactory(int implementation){
		
		//modificar la implementacion a utilizar
		if (implementation == 1) { //ArrayList
			stack = new Stack_ArrayList<>();
		}
		else if(implementation == 2) {
			stack = new Stack_Vector<>();
		}
		else if (implementation == 3) { //Lista simplemente enlazada
			stack = new Stack_SingleLinkedList<>();
		}
		else if (implementation == 4) { //Lista doblemente enlazada
			stack = new Stack_DoubleLinkedList<>();
		}
		
	}
	
	/**
	 * Metodo getInstance. Devuelve la instancia correspondiente de stack.
	 * @return IStack<T>
	 */
	public IStack<T> getInstance() {
		return stack;
	}

}
