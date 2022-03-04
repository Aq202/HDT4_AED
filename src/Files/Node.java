package Files;

public class Node<T> {
	
	private Node pointer;
	private T value;
	
	public Node(T value) {
		this.value = value;
	}
	
	public Node(T value, Node<T> pointer) {
		this.value = value;
		this.pointer = pointer;
	}
	
	public Node getPointer() {
		return pointer;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setPointer(Node<T> pointer) {
		this.pointer = pointer;
	}
	
	

}
