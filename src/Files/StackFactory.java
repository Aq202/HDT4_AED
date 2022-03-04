package Files;

public class StackFactory<T> {
	
	private IStack<T> stack;
	
	public StackFactory(){
		
		//modificar la implementacion a utilizar
		stack = new Stack_ArrayList<>();
	}
	
	public IStack<T> getInstance() {
		return stack;
	}

}
