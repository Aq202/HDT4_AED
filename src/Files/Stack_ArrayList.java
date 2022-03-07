package Files;

import java.util.ArrayList;

/**
 * Clase Stack_ArrayList. Permite crear y manipular un stack de tipo ArrayList.
 * @author Erick Guerra, Pablo Zamora, Diego Morales
 * @version 06/03/2022
 * @param <T> Tipo de dato a manipular
 */
public class Stack_ArrayList<T> implements IStack<T>{

	private ArrayList<T> elements; //Arraylist que almacenara los valores

	public Stack_ArrayList() {
		elements = new ArrayList<T>();
	}
	
	/**
	 * Agrega un nuevo elemento al inicio de la pila.
	 */
	@Override
	public void push(T value) {		
		elements.add(0, value);		
	}

	/**
	 * Retorna el primer elemento y lo elimina.
	 * @return T. Primer elemento de la pila. Retorna null si esta vacia.
	 */
	@Override
	public T pull() {
		if(isEmpty()) return null;
		return elements.remove(0);
	}

	/**
	 * Retorna el primer elemento sin eliminarlo.
	 * @return T. Primer elemento de la pila. Retorna null si esta vacía.
	 */
	@Override
	public T peek() {
		if(isEmpty()) return null;
		return elements.get(0);
	}

	/**
	 * Retorna el tamano de la pila
	 * @return int. Tamano de la pila.
	 */
	@Override
	public int count() {
		return elements.size();
	}

	/**
	 * Verifica si la lista esta vacia
	 * @return boolean. True si esta vacia. False si posee al menos un elemento.
	 */
	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	
}
