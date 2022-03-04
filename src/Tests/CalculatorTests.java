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
			assertEquals("129*+",calculator.infixToPostfixConverter("1+2*9"));
			assertEquals("12+9*",calculator.infixToPostfixConverter("(1+2)*9"));
		
		} catch (IllegalAccessException e) {
			fail(e);
		}
		
		
	}

}
