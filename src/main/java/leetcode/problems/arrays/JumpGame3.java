package leetcode.problems.arrays;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 1306. Jump Game III
Medium

Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation: 
All possible ways to reach at index 3 with value 0 are: 
index 5 -> index 4 -> index 1 -> index 3 
index 5 -> index 6 -> index 4 -> index 1 -> index 3 

Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true 
Explanation: 
One possible way to reach at index 3 with value 0 is: 
index 0 -> index 4 -> index 1 -> index 3

Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.

 

Constraints:

    1 <= arr.length <= 5 * 10^4
    0 <= arr[i] < arr.length
    0 <= start < arr.length


 * @author Moataz Lasheen
 *
 */
public class JumpGame3 {

	public boolean canReach(int[] arr, int start) {
		
		if ( start >= arr.length || start < 0 || arr[start] < 0 ) {
			return false;
		}
		
		if ( arr[start] == 0 ) {
			return true;
		}
		
		// mark the node as visted, can be done on an another array but this would increase 
		// the space complexity of the algo
		// orginal value is guaranteed to be positive
		arr[start] *= -1;
		boolean left = canReach(arr, start + arr[start]);
		boolean right = canReach(arr, start - arr[start]);
		
		return left || right;
		
	}
	
	
	public static void main(String[] args) {
		Calendar lastMomentInTheYear = Calendar.getInstance();
        lastMomentInTheYear.set(2023, Calendar.DECEMBER, 31, 23, 59, 59);
        System.out.println(lastMomentInTheYear.getTime());
        System.out.println("sad*a*".replace('*', '%'));
        
	}

}
