package Files;

/**
 * Clase DoubleNode. Permite la creacion de nodos para utlizar en una lista doblemente enlazada.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T> Tipo de dato a guardar en un nodo
 */
public class DoubleNode<T> {
	private T value; //Valor a almacenar
	private DoubleNode<T> next; //Nodo siguiente
	private DoubleNode<T> previous; //Nodo anterior
	
	/**
	 * Metodo constructor.
	 * @param value
	 */
	public DoubleNode(T value) {
		this.setValue(value);
	}
	
	/**
	 * Metodo getValue. Devuelve el valor almacenado en el nodo.
	 * @return T
	 */
	public T getValue() {
		return value;
	}
	
	/**
	 * Metodo setValue. Permite establecer el valor a almacenar.
	 * @param T
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * Metodo getNext. Permite obtener el nodo siguiente al nodo en cuestion.
	 * @return Node<T>
	 */
	public DoubleNode<T> getNext() {
		return next;
	}
	
	/**
	 * Metodo setNext. Permite establecer el nodo siguiente al nodo en cuestion.
	 * @param next Node<T>
	 */
	public void setNext(DoubleNode<T> next) {
		this.next = next;
	}
	
	/**
	 * Metodo getNext. Permite obtener el nodo anterior al nodo en cuestion.
	 * @return Node<T>
	 */
	public DoubleNode<T> getPrevious() {
		return previous;
	}
	
	/**
	 * Metodo getNext. Permite establecer el nodo anterior al nodo en cuestion.
	 * @return Node<T>
	 */
	public void setPrevious(DoubleNode<T> previous) {
		this.previous = previous;
	}
	
	
}