package leetcode.problems.dynamicprogramming;


/**
 * 198. House Robber
Medium

https://leetcode.com/problems/house-robber/

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 400


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class HouseRobber {
	
	
	  // TC O(n)
		// SC O(1)
		public int rob(int[] nums) {
			if (nums.length == 1) {
				return nums[0];
			}
			
			// suppose the current house is the 3rd house
			
			
			
			// the max amount till index zero
			int beforePrev = nums[0];
			// the max amount till index 1
			int prev = Math.max(nums[0], nums[1]);
			
			
			// for greater indexes than 1
			// we have to calculate the max amount we can rob up to the current house
			// it is either the max value we can rob up to the previous house --------------> will not rob this house
			// or the sum of the value in the current house and the max amount we can rob till
			// the before previous house ---------------> will rob current house but hence, we can't rob prev
			int current;
			for (int i = 2; i < nums.length; i++) {
				current = Math.max(beforePrev + nums[i], prev);
				
				beforePrev = prev;
				prev = current;
			}
			
			return prev;
			
			
	    }
		
		
	/*
		// TC : O(n)
		// SC : O(n)
		public int rob(int[] nums) {
			if (nums.length == 1) {
				return nums[0];
			}
			
			// it will hold the max amount we can rob from all houses
			// up to the current index
			int [] dp = new int [nums.length];
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);
			
			int withCurrentHouse;
			int withoutCurrentHouse;
			for (int i = 2; i < nums.length; i++) {
				withCurrentHouse = nums[i] + dp[i-2];
				withoutCurrentHouse = dp[i-1];
				dp[i] = Math.max(withoutCurrentHouse, withCurrentHouse);
			}
			
			return dp[nums.length-1];
	    }
			*/

}
