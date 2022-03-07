package Files;

/**
 * Clase Stack_DoubleLinkedList. Permite crear y manipular un stack que implementa una lista doblemente enlazada.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T> Tipo de dato a manipular
 */
public class Stack_DoubleLinkedList<T> implements IStack<T> {

	private DoubleLinkedList<T> listaInterna; //Lista doblemente enlazada que almacenara los valores
	
	public Stack_DoubleLinkedList() {
		listaInterna = new DoubleLinkedList<T>();
	}
	
	@Override
	public int count() {
		return listaInterna.Count();
	}

	@Override
	public boolean isEmpty() {
		return listaInterna.IsEmpty();
	}

	@Override
	public void push(T value) {
		listaInterna.InsertAtStart(value);
	}

	@Override
	public T pull() {
		return listaInterna.DeleteAtStart();
	}

	@Override
	public T peek() {
		return listaInterna.Get(0);
	}

	
}
