package Files;

/**
 * Interfaz IList. Posee los metodos que debe implementar una lista.
 * @author Pablo Zamora
 * @param <T> Tipo de dato a guardar en los nodos
 */
public interface IList<T> {
	
	/**
	 * Metodo InsertAtStart. Permite insertar un nodo al inicio de la lista.
	 * 	Pre: El valor que almacena el nodo debe ser el mismo tipo que el de la lista.
	 * 	Post: Se inserta un nodo al inicio de la lista.
	 * @param T
	 */
	void InsertAtStart(T value);

	/**
	 * Metodo InsertAtEnd. Permite insertar un nodo al inicio de la lista.
	 * 	Pre: El valor que almacena el nodo debe ser el mismo tipo que el de la lista.
	 * 	Post: Se inserta un nodo al final de la lista.
	 * @param T
	 */
    void InsertAtEnd(T value);

    /**
     * Metodo Insert. Permite insertar un nodo en una posicion determinada de la lista.
     * 	Pre: El valor que almacena el nodo debe ser el mismo tipo que el de la lista.
     * 		 Si la lista no esta vacia, el indice de la posicion a insertar debe estar entre 0 y el tamano de la lista - 1.
     *  Post: Se inserta el nodo en la posicion indicada.
     *  	  El nodo que estaba anteriormente en dicha posicion se desplaza una posicion atras.
     * @param T
     * @param int
     */
    void Insert(T value, int index);

    /**
     * Metodo Delete. Permite eliminar el nodo que se encuentra en la posicion indicada.
     * Pre: La lista no debe estar vacia. 
     * 		El indice de la posicion a eliminar debe estar entre 0 y el tamano de la lista - 1.
     * Post: Se elimina el nodo de la posicion indicada y se devuelve el valor que este almacenaba o null.
     * @param int
     * @return T
     */
    T Delete(int index);

    /**
     * Metodo DeleteAtStart. Permite eliminar el nodo que se encuentra al inicio de la lista.
     * Post: Se elimina el nodo al inicio de la lista y se devuelve el valor que este almacenaba o null.
     * @param int
     * @return T
     */
    T DeleteAtStart();

    /**
     * Metodo DeleteAtEnd. Permite eliminar el nodo que se encuentra al final de la lista.
     * Post: Se elimina el nodo al final de la lista y se devuelve el valor que este almacenaba o null.
     * @param int
     * @return T
     */
    T DeleteAtEnd();

    /**
     * Metodo Get. Permite obtener el valor del nodo que se encuentra en la posicion indicada.
     * Pre: Si la lista no esta vacia, el indice del nodo cuyo valor se desea debe estar entre 0 y el tamano de la lista - 1.
     * Post: Se obtiene el valor del nodo indicado.
     * @param int
     * @return T
     */
    T Get(int index);

    /**
     * Metodo isEmpty. Permite determinar si una lista esta vacia.
     * @return boolean True si esta vacia, false si no lo esta.
     */
    boolean IsEmpty();
    /**
     * Permite obtener la cuenta actual de nodos en la lista.
     * @return int
     */
    int Count();
}
