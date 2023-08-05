package leetcode.problems.famousalgo;


/**
 * 
 * 53. Maximum Subarray
Medium

Given an integer array nums, find the
subarray
with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

 

Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4

 

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


 * 
 * @author Moataz Lasheen
 *
 */
public class MaxSubarray {
	
	
	// TC : O(n)
	// SC : O(1)
	public int optimalSilution(int[] nums) {
		int maxSum = nums[0];
		int currentSum = nums[0];
		
		for ( int i=1; i<nums.length; i++ ) {
			currentSum = Math.max(nums[i], nums[i]+currentSum);
			maxSum = Math.max(maxSum, currentSum);
		}
		
		return maxSum;
	}
	
	// same as above
	public int maxSubArray(int[] nums) {
			int maxSum = nums[0];
			int currentSum = nums[0];
			
			for ( int i=1; i<nums.length; i++ ) {
				if ( nums[i] >= currentSum && nums[i] >= currentSum + nums[i] ) {
					// fresh potential start
					currentSum = nums[i];
				} else {
					currentSum = currentSum + nums[i];
				}

				if ( maxSum < currentSum )
					maxSum = currentSum;
			}
			
			return maxSum;
		}
	
	
	// Brute force solution (try all possible subarrays)
	// TC : O(n^2)
	// SC : O(1)
	public int bruteForce(int[] nums) {
		
		if ( nums.length == 1 ) {
			return nums[0];
		}
		int maxSum = Integer.MIN_VALUE;
		int potentialSum;
		for ( int i=0; i<nums.length; i++ ) {
			potentialSum = nums[i];
			for ( int j=i+1; j<nums.length; j++) {
				potentialSum+=nums[j];
				if ( potentialSum > maxSum ) {
					maxSum = potentialSum;
				}
			}
		}
		return maxSum;
    }
	
	
}
