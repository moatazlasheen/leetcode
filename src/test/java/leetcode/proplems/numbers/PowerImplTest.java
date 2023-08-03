package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leetcode.problems.numbers.PowerImpl;

class PowerImplTest {

	private PowerImpl underTest = new PowerImpl();
	
	
	@Test
	void testSmallPositivePower ( ) {
		double expected = 4;
		double inputBase = 2;
		int inputPower = 2;
		
		double actual = underTest.calculatePower(inputBase, inputPower);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testSmallNegativePower ( ) {
		double expected = 0.25;
		double inputBase = 2;
		int inputPower = -2;
		
		double actual = underTest.calculatePower(inputBase, inputPower);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testPositivePower ( ) { 
		double expected = 3125;
		double inputBase = 5;
		int inputPower = 5;
		
		double actual = underTest.calculatePower(inputBase, inputPower);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNegativePower ( ) { 
		double expected = 0.00032;
		double inputBase = 5;
		int inputPower = -5;
		
		double actual = underTest.calculatePower(inputBase, inputPower);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFractionBasePositivePower ( ) { 
		double expected = 0.015625;
		double inputBase = 0.5;
		int inputPower = 6;
		
		double actual = underTest.calculatePower(inputBase, inputPower);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFractionBaseNegativePower ( ) { 
		double expected = 16384;
		double inputBase = 0.25;
		int inputPower = -7;
		
		double actual = underTest.calculatePower(inputBase, inputPower);
		
		assertEquals(expected, actual);
	}
	
	
}
