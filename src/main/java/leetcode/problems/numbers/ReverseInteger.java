package leetcode.problems.numbers;


/**
 * Given a signed 32-bit integer x, return x with digits reversed. 
 * if reversing x causes the value to go outside the signed 32-bit integer
 *  range [-2^31, 2^31 -1] then return 0
 * @author Moataz Lasheen
 *
 */

public class ReverseInteger {

	public int reverse ( int num ) {
		
		long result = 0;
		
		while ( num != 0 ) {
			result = result * 10 + num % 10;
			num = num / 10;
		}
		
		if ( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ) {
			result = 0;
		}
		
		return (int)result;
		
	}
	
}
