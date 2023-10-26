package leetcode.problems.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;


/**
 * 300. Longest Increasing Subsequence
Medium

Given an integer array nums, return the length of the longest strictly increasing
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 

Constraints:

    1 <= nums.length <= 2500
    -104 <= nums[i] <= 104
s
 * @author Moataz Lasheen
 *
 */
public class LongestIncreasingSubSequence {
	public int lengthOfLIS(int[] nums) {
		int result = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = 1 + max;
			result = Math.max(result, dp[i]);
		}

		return result;
	}
	
	/*public int lengthOfLIS(int[] nums) {
	List<Integer> list = new ArrayList<>();
	list.add(nums[0]);
	for ( int i=1; i<nums.length; i++ ) {
		if ( nums[i] > list.get(list.size()-1) ) {
			list.add(nums[i]);
		} else {
			// update the list
			int insertionIndex = findInsertionIndex(list, nums[i]);
			list.set(insertionIndex, nums[i]);
		}
	}
	return list.size();
	}
	
	private int findInsertionIndex(List<Integer> list, int num) {
	int left=0;
	int right=list.size()-1;
	while ( left <= right ) {
		int mid = (left + right) /2;
		if ( list.get(mid) <= num ) {
			left = mid+1;
		} else {
			right = mid-1;
		}
	}
	return list.get(Math.max(right, 0)) == num ? right : left;
	}*/
}
