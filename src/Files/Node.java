package Files;

/**
 * Clase Node. Permite la creacion de nodos para utlizar en una lista simplemente enlazada.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T> Tipo de dato a guardar en un nodo
 */
public class Node<T> {
	private T value; //Valor a guardar
	private Node<T> next; //Nodo siguiente
	
	/**
	 * Metodo constructor.
	 * @param value
	 */
	public Node(T value) {
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
	public Node<T> getNext() {
		return next;
	}
	
	/**
	 * Metodo setNext. Permite establecer el nodo siguiente al nodo en cuestion.
	 * @param next Node<T>
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
}
