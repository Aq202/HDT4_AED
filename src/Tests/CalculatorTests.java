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
			assertEquals("1 2 9 * +",calculator.infixToPostfixConverter("1+2*9"));
			assertEquals("1 2 + 9 *",calculator.infixToPostfixConverter("(1+2)*9"));
		
		} catch (IllegalAccessException e) {
			fail(e);
		}
		
		
	}
	
	
	@Test
	void calculateInfix() {
		
		
		try {
			assertEquals(27,calculator.evaluateInfix("(1+2)*9 "));
			assertEquals(30,calculator.evaluateInfix("(1+2+3)*4+6"));
		
		} catch (IllegalAccessException e) {
			fail(e);
		}
		
		
	}

}
