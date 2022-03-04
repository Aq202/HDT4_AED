package Files;

public class ListFactory<T> {
	
	private IList<T> simpleList;
	
	public ListFactory() {
		simpleList = new SimpleList<T>();
	}
	
	public IList<T> getInstance() {
		return simpleList;
	}

}
