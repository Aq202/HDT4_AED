package Files;

public class ListFactory<T> {
	
	private IList<T> simpleList;
	
	public ListFactory() {
		simpleList = new SingleLinkedList<T>();
	}
	
	public IList<T> getInstance() {
		return simpleList;
	}

}
