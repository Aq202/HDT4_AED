package Files;

import java.util.ArrayList;

public class Stack_Vector<T> implements IStack {

	private Object[] arreglo;
	
	public Stack_Vector() {
		arreglo = new Object[2];
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
		Object[] temp = new Object[arreglo.length+5];
		System.arraycopy(arreglo, 0, temp, 0, arreglo.length);
		arreglo = temp;
	}
	
	@Override
	public void push(Object value) {
		int lastBusy = indexLastElement();
		int indexNew = 0;
		if(lastBusy == arreglo.length-1) {
			indexNew = arreglo.length;
			extendArray();
		}else
			indexNew = lastBusy+1;
		arreglo[indexNew] = value;
	}

	@Override
	public Object pull() {
		try {
			Object temp = arreglo[indexLastElement()];
			arreglo[indexLastElement()] = null;
			return temp;
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Object peek() {
		try { 
			return arreglo[indexLastElement()];
		}catch(Exception e){
			return arreglo[0];
		}
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
