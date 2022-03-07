package Files;

/**
 * Clase SingleLinkedList. Posee los metodos necesarios para crear y manipular una lista simplemente enlazada.
 * @author Pablo Zamora, Erick Guerra, Diego Morales
 * @version 06/03/2022
 * @param <T> Tipo de dato a manejar
 */
public class SingleLinkedList<T> implements IList<T> {

	private int count; //Cuenta de los nodos en la lista
    private Node<T> start; //Nodo inicial
    private Node<T> end; //Nodo final

	@Override
	public void InsertAtStart(T value) {
		Node<T> newNode = new Node<T>(value);

        if (IsEmpty())
        {
            start = newNode;
            end = newNode;
        }
        else
        {
            newNode.setNext(start);
            start = newNode;
        }
        count++;
	}

	@Override
	public void InsertAtEnd(T value) {
		Node<T> newNode = new Node<T>(value);

        if (IsEmpty())
        {
            start = newNode;
            end = newNode;
        }
        else {
            end.setNext(newNode);
            end = newNode;
        }

        count++;
		
	}

	@Override
	public void Insert(T value, int index){
		
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
                Node<T> newNode = new Node<T>(value);
                Node<T> pretemp = start;
                Node<T> temp = start.getNext();
                int i = 1;

                //Buscar la posicion en la que se insertara el nodo
                while ((temp != null) && (i < index)) {
                    pretemp = temp;
                    temp = temp.getNext();
                    i++;
                }

                //Se inserta el nodo
                newNode.setNext(temp);
                pretemp.setNext(newNode);
                count++;
            }
        }
	}

	@Override
	public T Delete(int index) {
		
		if (index == 0)
        {
            return DeleteAtStart();
        }
        else if (index == (Count() - 1))
        {
            return DeleteAtEnd();
        }
        else if ((index > 0) && (index < (Count() - 1)))
        {
            Node<T> pretemp = start;
            Node<T> temp = start.getNext();
            int i = 1;

            //Buscar la posicion del nodo a eliminar
            while ((temp != null) && (i < (Count() - 1)))
            {
                pretemp = temp;
                temp = temp.getNext();
                i++;
            }

            //Eliminar el nodo
            pretemp.setNext(temp.getNext());
            count--;
            return temp.getValue(); //Se devuelve el valor del nodo eliminado
        }
        else
        {
            return null;
        }
	}

	@Override
	public T DeleteAtStart() {
		
		if (!IsEmpty()) 
        {
            Node<T> temp = start;
            start = start.getNext();
            count--;
            return temp.getValue();
        }

        return null;
	}

	@Override
	public T DeleteAtEnd() {
		if (!IsEmpty()) 
        {

            if (Count() == 1) //Si solo hay un nodo en la lista
            {
                Node<T> temp = start;
                start = null;
                end = null;
                count--;
                return temp.getValue();
            }
            else
            {
                Node<T> pretemp = start;
                Node<T> temp = start.getNext();

                //Buscar la posicion del nodo a eliminar
                while (temp != null)
                {
                    pretemp = temp;
                    temp = temp.getNext();
                }

                //Eliminar el nodo
                end = pretemp;
                end.setNext(null);
                count--;
                return temp.getValue();
            }

        }

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
                Node<T> temp = start;
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
		// TODO Auto-generated method stub
		return count;
	}

}
