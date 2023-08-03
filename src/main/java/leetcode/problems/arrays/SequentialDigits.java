package leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. Sequential Digits
Medium

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]

Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

 

Constraints:

    10 <= low <= high <= 10^9


 * @author Moataz Lasheen
 *
 */
public class SequentialDigits {
	
	public List<Integer> sequentialDigits(int low, int high) {
        
        String maxSequentialDigits = "123456789";
        List<Integer> result = new ArrayList<>();
        int lowDigitsCout = getDigitsCount(low);
        int highDigitsCount = getDigitsCount(high);
        String potentialSubString;
        int potintialNumber;
        for ( int i=lowDigitsCout; i<=highDigitsCount; i++ ) {
        	for ( int j=0; j+i<=9; j++ ) {
        		potentialSubString = maxSequentialDigits.substring(j, j+i);
        		potintialNumber = Integer.parseInt(potentialSubString);
        		if ( potintialNumber >= low && potintialNumber <= high ) {
        			result.add(potintialNumber);
        		} else if (potintialNumber>high) {
					break;
				}
        	}
        }
        
		return result;
    }

	

	private int getDigitsCount(int num) {
		int digitsCount = 0;
		int x = 1;
		while (num/x > 0 ) {
			digitsCount++;
			x *= 10;
		}
		
		return digitsCount;
	}

}
