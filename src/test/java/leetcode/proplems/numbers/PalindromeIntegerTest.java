package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leetcode.problems.numbers.PalindromeInteger;



class PalindromeIntegerTest {

	
	PalindromeInteger underTest = new PalindromeInteger();
	
	@Test
	void testSimpleEvenLengthPalindromInt ( ) {
		boolean expectedResult = true;
		int input =  1331;
		boolean actualResult =  underTest.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testSimpleOddLengthPalindromInt ( ) {
		boolean expectedResult = true;
		int input =  54845;
		boolean actualResult =  underTest.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	void testNegativeInt ( ) {
		boolean expectedResult = false;
		int input =  -45354;
		boolean actualResult =  underTest.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testSimpleEvenLengthNonePalindromInt ( ) {
		boolean expectedResult = false;
		int input =  41050;
		boolean actualResult =  underTest.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	void testMaxIntValue ( ) {
		boolean expectedResult = false;
		int input =  Integer.MAX_VALUE;
		boolean actualResult =  underTest.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testTenDigitsPalindromInt ( ) {
		boolean expectedResult = true;
		int input =  1234554321;
		boolean actualResult =  underTest.isPalindrome(input);
		assertEquals(expectedResult, actualResult);
	}
}
