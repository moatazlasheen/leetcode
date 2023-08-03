package leetcode.problems.arrays;

/**
 * 41. First Missing Positive
Hard

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

 

Constraints:

    1 <= nums.length <= 105
    -2^31 <= nums[i] <= 2^31 - 1


 * @author Moataz Lasheen
 *
 */
public class FirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
        for ( int i=0; i<nums.length; i++ ) {
        	if ( nums[i] <= 0 ) {
        		// set it to any number that is greater than the length on the array
        		nums[i] = nums.length+20;
        	}
        }
        int tmp;
        // mark the correct index of the current number in the array as seen, if the correct index
        // exist in the array
        for ( int i=0; i<nums.length; i++ ) {
        	tmp = Math.abs(nums[i]);
        	if ( tmp-1 < nums.length && nums[tmp-1] > 0 ) {
        		nums[tmp-1] *= -1;
        	}
        }
        
        // return the first unmarked index + 1
        for ( int i=0; i<nums.length; i++ ) {
        	if ( nums[i] > 0 ) {
        		return i+1;
        	}
        }
        
        return nums.length+1;
    }

}
