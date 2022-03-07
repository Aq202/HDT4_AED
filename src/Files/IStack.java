package Files;

/**
 * Interfaz IStack. Especifica los metodos que debe implementar cualquier clase Stack.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T>
 */
public interface IStack<T> {
	
	/**
	 * Metodo push. Permite almacenar un valor en la ultima posicion de la pila.
	 * Pre: El tipo del valor a almacenar debe ser el mismo que el de los que ya estan en la pila.
	 * Post: Se almacena el valor en la utlima posicion de la pila.
	 * @param T
	 */
	void push(T value);

	/**
	 * Metodo pull. Permite obtener el valor almacenado en la ultima posicion de la pila y eliminarlo de esta.
	 * @return T
	 */
	T pull();

	/**
	 * Metodo peek. Permite obtener el valor almacenado en la utlima posicion de la pila sin eliminarlo de esta.
	 * @return T
	 */
	T peek();

	/**
	 * Metodo count. Devuelve la cantidad de valores almacenados en la pila.
	 * @return int
	 */
	int count();

	/**
	 * Metodo isEmpty. Permite determinar si la pila esta vacia.
	 * @return boolean True si esta vacia, false si no lo esta.
	 */
	boolean isEmpty();
}
