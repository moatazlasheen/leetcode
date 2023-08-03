package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import leetcode.problems.numbers.NthRoot;

class NthRootTest {
	
	private NthRoot underTest = new NthRoot();
	
	
	@Test
	void testCase1() {
		
		double num = 27.0;
		int root = 3;
		double expected = 3;
		double actual = underTest.findNthRoot(num, root);
		
		System.out.println( "actual : " + actual + ", expected : " + expected );
		
		assertTrue( Math.abs(actual-expected) < .001 );
		
	}
	
	@Test
	void testCase2() {
		
		double num = 7.0;
		int root = 3;
		double expected = 1.913;
		double actual = underTest.findNthRoot(num, root);
		
		System.out.println( "actual : " + actual + ", expected : " + expected );
		
		assertTrue( Math.abs(actual-expected) < .001 );
		
	}
	
	
	@Test
	void testCase3() {
		
		double num = 83828.4860;
		int root = 8;
		double expected = 4.125;
		double actual = underTest.findNthRoot(num, root);
		
		System.out.println( "actual : " + actual + ", expected : " + expected );
		
		assertTrue( Math.abs(actual-expected) < .001 );
		
	}
	

}
