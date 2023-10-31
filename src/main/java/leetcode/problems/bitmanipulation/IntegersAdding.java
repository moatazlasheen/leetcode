package leetcode.problems.bitmanipulation;

/**
 * 
 * 371. Sum of Two Integers
Medium

https://leetcode.com/problems/sum-of-two-integers/submissions/

Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3

Example 2:

Input: a = 2, b = 3
Output: 5

 

Constraints:

    -1000 <= a, b <= 1000


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class IntegersAdding {
	public int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = a & b;
        if (carry == 0) {
        	return xor;
        } else {
        	return getSum(xor, carry << 1);
        }
    }
}
