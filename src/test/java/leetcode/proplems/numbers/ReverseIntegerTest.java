package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leetcode.problems.numbers.ReverseInteger;

class ReverseIntegerTest {
	
	
	@Test
	void testReverse_positiveIntWithinRange ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = 12458;
		int expected = 85421;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testReverse_positiveWithinRangeTrailingZeros ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = 1245800000;
		int expected = 85421;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	
	
	@Test
	void testReverse_negativeIntWithinRange ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = -85246;
		int expected = -64258;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testReverse_negativeIntWithinRangeTrailingZeros ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = -1524600000;
		int expected = -64251;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testReverse_positiveOutOfRange ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = 2147483647;
		int expected = 0;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testReverse_negativeOutOfRange ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = -2147483648;
		int expected = 0;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	
	
	@Test
	void testReverse_positiveOutOfRange2 ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = 1111947412;
		int expected = 0;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testReverse_negativeOutOfRange2 ( ) {
		ReverseInteger reverseInteger = new ReverseInteger();
		int input = -1117847412;
		int expected = 0;
		
		int actual = reverseInteger.reverse(input);
		
		assertEquals(expected, actual);
	}

}
