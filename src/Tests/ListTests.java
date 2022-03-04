package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Files.SimpleList;

class ListTests {
	
	private SimpleList<Integer> simpleList;
	
	public ListTests() {
		simpleList = new SimpleList<>();
	}

	@Test
	void simpleListTest() {
		
		assertEquals(null, simpleList.getFirst());
		
		assertEquals(true, simpleList.isEmpty());
		
		simpleList.addFirst(2);
		assertEquals(2, simpleList.getLast());
		
		simpleList.addFirst(1);
		assertEquals(1, simpleList.getFirst());

		simpleList.addLast(3);
		assertEquals(3, simpleList.getLast());
		assertEquals("123", simpleList.asString());
		assertEquals(false, simpleList.isEmpty());
		
		
	}

}
