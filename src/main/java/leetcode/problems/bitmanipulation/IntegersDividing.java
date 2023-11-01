package leetcode.problems.bitmanipulation;

/**
 * 29. Divide Two Integers
Medium

Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.

 

Constraints:

    -2^31 <= dividend, divisor <= 2^31 - 1
    divisor != 0


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class IntegersDividing {

	public int divide(int dividend, int divisor) {
		long result = 0;
		boolean isNegativeResult = false;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isNegativeResult = true;
		}
		
		// casting int to long to force the call to the math.abs(long), so that 
		// it returns long
		// abs(Integer.MIN_VAL) has to be long, otherwise, overflow will happen and you
		// get 0 is the abs(Integer.MIN_VAL)
		long absDividend = Math.abs((long)dividend);
		long absDivisor = Math.abs((long)divisor);
		while (absDividend >= absDivisor) {
			long temp = absDivisor;
			long qoutient = 1;
			while(temp <= absDividend) {
				// left shift means multiplying by 2
				temp = temp << 1;
				qoutient = qoutient << 1;
			}
			// last value for temp is greater than absDividend
			// get the value before the last value
			result += qoutient >> 1;
			// remainder
			absDividend = absDividend - (temp >> 1);
		}
		
		if(isNegativeResult) {
			// return the 2's complement for the result
			return (int) (~result + 1);
		} else if (result > Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		}
		
		return (int)result;
    }

}
