package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Files.DoubleLinkedList;

class DoubleLinkedListTest {

	@Test
	void testInsertAtStart() {
		DoubleLinkedList<Integer> lista = new DoubleLinkedList<Integer>();
		lista.InsertAtStart(1);
		lista.InsertAtStart(2);
		lista.InsertAtStart(3);
		lista.InsertAtStart(4);
		lista.InsertAtStart(5);
		assertEquals(5, lista.Get(0));
	}

	@Test
	void testInsertAtEnd() {
		DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
		lista.InsertAtEnd("Palabra1");
		lista.InsertAtEnd("Palabra2");
		lista.InsertAtEnd("Palabra3");
		lista.InsertAtEnd("Palabra4");
		lista.InsertAtEnd("Palabra5");
		assertEquals("Palabra1", lista.Get(0));
	}

	@Test
	void testInsert() {
		DoubleLinkedList<Boolean> lista = new DoubleLinkedList<Boolean>();
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.Insert(true, 3);
		assertEquals(true, lista.Get(3));
	}

	@Test
	void testDeleteAtStart() {
		DoubleLinkedList<Character> lista = new DoubleLinkedList<Character>();
		lista.InsertAtStart('a');
		lista.InsertAtStart('b');
		lista.InsertAtStart('c');
		lista.InsertAtStart('d');
		lista.InsertAtStart('e');
		assertEquals('e', lista.DeleteAtStart());
		assertEquals('d', lista.Get(0));
	}

	@Test
	void testGet() {
		DoubleLinkedList<Integer> lista = new DoubleLinkedList<Integer>();
		lista.InsertAtStart(1);
		lista.InsertAtStart(2);
		lista.InsertAtStart(3);
		lista.InsertAtStart(4);
		lista.InsertAtStart(5);
		assertEquals(5, lista.Get(0));
		assertEquals(2, lista.Get(3));
	}

	@Test
	void testIsEmpty() {
		DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
		assertEquals(true, lista.IsEmpty());
		lista.InsertAtEnd("Palabra1");
		lista.InsertAtEnd("Palabra2");
		lista.InsertAtEnd("Palabra3");
		lista.InsertAtEnd("Palabra4");
		lista.InsertAtEnd("Palabra5");
		assertEquals(false, lista.IsEmpty());
	}

	@Test
	void testCount() {
		DoubleLinkedList<Boolean> lista = new DoubleLinkedList<Boolean>();
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		lista.InsertAtStart(false);
		assertEquals(5, lista.Count());
	}

}
