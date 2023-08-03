package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leetcode.problems.numbers.SingleNumber;


/**
 * in the passed array, every item in the leat should appear twice except fo one item
 * 
 * and the purpose of the method under test is to find that item that appears only once 
 * with linear time complexity O(n) and a constant space complexity O(1)
 * 
 *  given that if a number is xored with itself it will give 0, the each couple will result in a zero,
 *  the single item will give the final result
 *  
 *  for example 4,1,2,1,2 > the result should be 4
 *  
 *  1 0 0 (4)
 *  0 0 1 (1)
 *  ------
 *  1 0 1 (5)
 *  0 1 0 (2)
 *  -----
 *  1 1 1 (7)
 *  0 0 1 (1)
 *  -----
 *  1 1 0 (6)
 *  0 1 0 (2)
 *  -----
 *  1 0 0 (4)
 * 
 */

class SingleNumberTest {
	
	@Test
	void testSingleNumber_singleItem ( ) {
		SingleNumber singleNumber = new SingleNumber();
		int expectedResult = 2;
		int [] input = {2};
		
		int actualResult = singleNumber.findSingleNumber(input);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testSingleNumber_multipleItems_testCase1 ( ) {
		SingleNumber singleNumber = new SingleNumber();
		int expectedResult = 1;
		int [] input = {2, 2, 1};
		
		int actualResult = singleNumber.findSingleNumber(input);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testSingleNumber_multipleItems_testCase2 ( ) {
		SingleNumber singleNumber = new SingleNumber();
		int expectedResult = 4;
		int [] input = {4, 1, 2, 1, 2};
		
		int actualResult = singleNumber.findSingleNumber(input);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void testSingleNumber_multipleItems_testCase3 ( ) {
		SingleNumber singleNumber = new SingleNumber();
		int expectedResult = 9;
		int [] input = {8, 3, 4, 7, 9, 1, 8, 3, 4, 1, 7};
		
		int actualResult = singleNumber.findSingleNumber(input);
		
		assertEquals(expectedResult, actualResult);
	}

}
