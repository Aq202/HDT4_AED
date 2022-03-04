package Files;

public interface IList<T> {
	
	void addFirst(T value);
	void addLast(T value);
	T getFirst();
	T getLast();
	boolean isEmpty();

}
