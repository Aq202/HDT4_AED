package Files;

public class StackFactory<T> {
	
	private IStack<T> stack;
	
	public StackFactory(int implementation){
		
		//modificar la implementacion a utilizar
		if (implementation == 1) { //ArrayList
			stack = new Stack_ArrayList<>();
		}
		else if (implementation == 2) { //Lista simplemente enlazada
			stack = new Stack_SingleLinkedList<>();
		}
		else if (implementation == 3) { //Lista doblemente enlazada
			stack = new Stack_DoubleLinkedList<>();
		}
		
	}
	
	public IStack<T> getInstance() {
		return stack;
	}

}
