package leetcode.problems.dynamicprogramming;


/**
 * 416. Partition Equal Subset Sum
Medium

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100


 * 
 * @author Moataz Lasheen
 *
 */
public class EqualSumSubSets {
	
	
	/*
	 * 
    // exceeds time limit
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int left = 0;
        int right = sum;

        for (int i = 0; i < nums.length; i++) {
            if (canPartition(nums, left, right,0)) {
                return true;
            }
        }

        return false;
        
    }

    private boolean canPartition(int[] nums, int left, int right, int index) {
        if (left == right) {
            return true;
        }

        if (index >= nums.length) {
            return false;
        }

        return canPartition(nums, left + nums[index], right-nums[index], index + 1) ||  canPartition(nums, left, right, index + 1);

    }*/

    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum /2;
        boolean [] dp = new boolean [target + 1];
        // base case, do we have an array on the left that sums up to index, you can consider that empty array
        // exists and it sums to zero for the index zero
        dp[0] = true;

        // for each element in the given array
        for (int i = 0; i < nums.length; i++) {
            // for each number that is less than or equal to target
            // do we have sub array on the left the sums up to the index ??
            // this will set the dp array element to true if
            // the current value is equal to the current target or
            // the there is a sub array on the left that
            // sums up to difference between the current target and the current element 
            for (int current = dp.length-1; current >= 0; current--) {
                if (current >= nums[i]) {
                    dp[current] = dp[current] || dp[current-nums[i]];
                }
            }
        }

        return dp[target];
    }

}
