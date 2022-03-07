package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Files.Calculator;

class CalculatorTests {
	
	Calculator calculator;
	
	public CalculatorTests() {
		calculator = Calculator.getInstance();
	}

	@Test
	void infixToPostfixTest() {
		try {
			assertEquals("1 2 9 * +",calculator.infixToPostfixConverter("1+2*9",1));
			assertEquals("7 9 * 5 -",calculator.infixToPostfixConverter("7*9-5",2));
			assertEquals("1 2 + 9 *",calculator.infixToPostfixConverter("(1+2)*9",3));
			assertEquals("5 8 + 0 /",calculator.infixToPostfixConverter("(5+8)/0",4));
		} catch (IllegalAccessException e) {
			fail(e);
		}
	}
	
	@Test
	void evaluatePostfix() {
		assertEquals(19.0,calculator.evaluatePostfix("1 2 9 * +"));
		assertEquals(58.0,calculator.evaluatePostfix("7 9 * 5 -"));
		assertEquals(27.0,calculator.evaluatePostfix("1 2 + 9 *"));
		assertEquals(7.0,calculator.evaluatePostfix("5 9 + 2 /"));
	}
	
	@Test
	void calculateInfix() {
		try {
			assertEquals(27,calculator.evaluateInfix("(1+2)*9 ",1));
			assertEquals(30,calculator.evaluateInfix("(1+2+3)*4+6",2));
			assertEquals(103,calculator.evaluateInfix("(3*9+8)*3-2",3));
		
		} catch (IllegalAccessException e) {
			fail(e);
		}
	}
	
	

}
