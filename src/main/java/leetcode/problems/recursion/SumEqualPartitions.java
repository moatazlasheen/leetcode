package leetcode.problems.recursion;

import java.util.Arrays;

/**
 * 
 * 698. Partition to K Equal Sum Subsets
Medium

Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

 

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.

Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false

 

Constraints:

    1 <= k <= nums.length <= 16
    1 <= nums[i] <= 104
    The frequency of each element is in the range [1, 4].


 * 
 * @author Moataz Lasheen
 *
 */
public class SumEqualPartitions {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		int sum = getAllElementsSum(nums);
		boolean [] consumed = new boolean[nums.length];
		if (sum % k == 0 ) {
			return canPartitionKSubsets(nums, k, sum / k, 0, consumed, nums.length-1);
		} 
		return false;
    }

	private boolean canPartitionKSubsets(int[] nums, int k, int targetSum, int currentSum, boolean [] consumed, int index) {
		if(k == 0) {
			return true;
		}
		
		if (targetSum == currentSum) {
			return canPartitionKSubsets(nums, k-1, targetSum, 0, consumed, nums.length-1);
		}
		
		for (int i = index; i >= 0; i--) {
			if (consumed[i] || nums[i] > targetSum || currentSum + nums[i] > targetSum ) {
				continue;
			}
			if (i + 1 < nums.length && nums[i] == nums[i+1] && !consumed[i+1]) {
				continue;
			}
			
			consumed[i] = true;
			if (canPartitionKSubsets(nums, k, targetSum, currentSum + nums[i], consumed, i-1)) {
				return true;
			}
			consumed[i] = false;
			
		}
		
		return false;
	}

	private int getAllElementsSum(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}

	
}
