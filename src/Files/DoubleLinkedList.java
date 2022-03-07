package Files;

/**
 * Clase DoubleLinkedList. Posee los metodos necesarios para crear y manipular una lista doblemente enlazada.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T> Tipo de dato a manejar
 */
public class DoubleLinkedList<T> implements IList<T> {

	private DoubleNode<T> start; //Nodo inicial
	private DoubleNode<T> end; //Nodo final
	private int count; //Cuenta de nodos
	
	/**
	 * Metodo constructor. Se inician los atributos en null o 0.
	 */
	public DoubleLinkedList() {
		start = null;
		end = null;
		count = 0;
	}
	
	@Override
	public void InsertAtStart(T value) {
		DoubleNode<T> newNode = new DoubleNode<T>(value);
		
		if (IsEmpty()) {
		
			start = newNode;
			end = newNode;
			start.setNext(start);
			start.setPrevious(start);
		} else {
			
			newNode.setNext(start);
			start.setPrevious(newNode);
			newNode.setPrevious(end);
			end.setNext(newNode);
			start = newNode;
		}
		
		count++;
	}

	@Override
	public void InsertAtEnd(T value) {
		
	DoubleNode<T> newNode = new DoubleNode<T>(value);
		
		if (IsEmpty()) {
		
			start = newNode;
			end = newNode;
			start.setNext(start);
			start.setPrevious(start);
		} else {
			
			newNode.setPrevious(end);
			newNode.setNext(start);
			start.setPrevious(newNode);
			end.setNext(newNode);
			end = newNode;
		}
		
		count++;
		
	}

	@Override
	public void Insert(T value, int index) {
		
		if (IsEmpty()) //Si la lista esta vacia, el nodo se inserta al inicio
        {
            InsertAtStart(value);
        }
        else 
        {
            if (index >= Count()) //Si el indice es mayor o igual a la cuenta, el nodo se inserta al final
            {
                InsertAtEnd(value);
            } 
            else if (index == 0) //Si el indice es igual a 0 y la lista no esta vacia
            {
                InsertAtStart(value);
            }
            else if ((index > 0) && (index < Count())) //Si el indice esta entre uno y cuenta-1
            {
                DoubleNode<T> newNode = new DoubleNode<T>(value);
                DoubleNode<T> temp = start;
                int i = 0;

              //Buscar la posicion en la que se insertara el nodo
                while ((temp != null) && (i < index)) {
                    temp = temp.getNext();
                    i++;
                }

              //Se inserta el nodo
                newNode.setNext(temp);
                newNode.setPrevious(temp.getPrevious());
                temp.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                count++;
            }
        }
		
	}

	@Override
	public T Delete(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T DeleteAtStart() {
		if (!IsEmpty()) {
			
			if (Count() == 1) {
				DoubleNode<T> temp = start;
				start = null;
				end = null;
				count--;
				return temp.getValue();
			} else {
				DoubleNode<T> temp = start;
				end.setNext(temp.getNext());
				temp.getNext().setPrevious(end);
				start = temp.getNext();
				count--;
				return temp.getValue();
			}
			
		} else {
			return null;
		}
		
		
	}

	@Override
	public T DeleteAtEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Get(int index) {
	    if (!IsEmpty())
        {
            if (index == 0)
            {
                return start.getValue();
            }
            else if (index == (Count() - 1))
            {
                return end.getValue();
            }
            else if ((index > 0) && (index < (Count() - 1)))
            {
                DoubleNode<T> temp = start;
                int i = 0;
                while ((temp != null) && (i != index))
                {
                    temp = temp.getNext();
                    i++;
                }

                if (temp != null)
                {
                    return temp.getValue();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }

        return null;

	}

	@Override
	public boolean IsEmpty() {
		return count == 0;
	}

	@Override
	public int Count() {
		return count;
	}

	
}