package Files;

public class Stack_Vector<T> implements IStack<T> {

	private T[] arreglo;
	
	public Stack_Vector() {
		arreglo = (T[]) new Object[2];
	}
	
	private int indexLastElement() {
		int index = 0;
		for(int i = 0; i<arreglo.length;i++) {
			if(arreglo[i] == null) {
				index = i-1;
				return index;
			}
		}
		return arreglo.length-1;
	}
	
	private void extendArray() {
		T[] temp = (T[]) new Object[arreglo.length+5];
		System.arraycopy(arreglo, 0, temp, 0, arreglo.length);
		arreglo = temp;
	}
	
	@Override
	public void push(T value) {
		if(!isEmpty()) {
			if(indexLastElement() == arreglo.length-1)
				extendArray();
			System.arraycopy(arreglo,0,arreglo,1,arreglo.length-1);
		}
		arreglo[0] = value;
	}

	@Override
	public T pull() {
		T temp = arreglo[0];
		if(indexLastElement()==arreglo.length-1)
			extendArray();
		System.arraycopy(arreglo, 1, arreglo, 0, arreglo.length-1);
		return temp;
	}

	@Override
	public T peek() { 
		return arreglo[0];
	}

	@Override
	public int count() {
		return indexLastElement()+1;
	}

	@Override
	public boolean isEmpty() {
		if(indexLastElement()<0)
			return true;
		return false;
	}
	

}
