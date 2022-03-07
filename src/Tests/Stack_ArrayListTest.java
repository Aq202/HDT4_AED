package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Files.IStack;
import Files.Stack_ArrayList;
import Files.Stack_DoubleLinkedList;

class Stack_ArrayListTest {

	@Test
	void testPush() {
		IStack<Integer> stack = new Stack_ArrayList<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertEquals(5, stack.peek());
	}

	@Test
	void testPull() {
		IStack<String> stack = new Stack_ArrayList<String>();
		stack.push("Palabra1");
		stack.push("Palabra2");
		stack.push("Palabra3");
		stack.push("Palabra4");
		stack.push("Palabra5");
		assertEquals("Palabra5", stack.pull());
		assertEquals("Palabra4", stack.peek());
	}

	@Test
	void testPeek() {
		IStack<Boolean> stack = new Stack_ArrayList<Boolean>();
		stack.push(false);
		stack.push(false);
		stack.push(false);
		stack.push(false);
		stack.push(true);
		assertEquals(true, stack.peek());
	}

	@Test
	void testCount() {
		IStack<Character> stack = new Stack_ArrayList<>();
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		stack.push('e');
		assertEquals(5, stack.count());
	}

	@Test
	void testIsEmpty() {
		IStack<Character> stack = new Stack_ArrayList<Character>();
		assertEquals(true, stack.isEmpty());
		stack.push('a');
		stack.push('b');
		stack.push('c');
		stack.push('d');
		stack.push('e');
		assertEquals(false, stack.isEmpty());
	}

}
