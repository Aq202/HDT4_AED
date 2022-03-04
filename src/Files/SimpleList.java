package Files;

public class SimpleList<T> implements IList<T> {

	Node<T> firstElement, lastElement;

	@Override
	public void addFirst(T value) {

		firstElement = new Node<T>(value, firstElement);
		if (lastElement == null)
			lastElement = firstElement;

	}

	@Override
	public void addLast(T value) {

		Node node = new Node(value);
		if (isEmpty())
			addFirst(value);
		else {
			lastElement.setPointer(node);
			lastElement = node;
		}

	}

	@Override
	public T getFirst() {
		
		return isEmpty() ? null : firstElement.getValue();
	}

	@Override
	public T getLast() {
		
		return isEmpty() ? null : lastElement.getValue();
	}

	@Override
	public boolean isEmpty() {
		return firstElement == null;
	}

}
