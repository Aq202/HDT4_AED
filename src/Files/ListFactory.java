package Files;

public class ListFactory<T> {
	
	private IList simpleList;
	
	public ListFactory() {
		simpleList = new SimpleList<T>();
	}
	
	public IList getInstance() {
		return simpleList;
	}

}
