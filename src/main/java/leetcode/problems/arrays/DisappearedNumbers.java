package leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 448. Find All Numbers Disappeared in an Array
Easy

Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:

Input: nums = [1,1]
Output: [2]

 

Constraints:

    n == nums.length
    1 <= n <= 10^5
    1 <= nums[i] <= n

 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 * @author Moataz Lasheen
 *
 */
public class DisappearedNumbers {
	
	// TC : O(n), SC : O(n) excluding the returned list
//	public List<Integer> findDisappearedNumbers(int[] nums) {
//		Map<Integer, Boolean> map = new HashMap<>();
//		List<Integer> result = new ArrayList<>();
//		for ( int i=0; i<nums.length; i++) {
//			map.put(nums[i], true);
//		}
//		
//		for ( int i=1; i<=nums.length; i++) {
//			if ( map.get(i) == null ) {
//				result.add(i);
//			}
//		}
//		
//		return result;
//		
//    }
	
	
	// TC : O(1), SC : O(1), excluding the returned list
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int val;
		for ( int i=0; i<nums.length; i++) {
			val = Math.abs(nums[i]);
			if ( nums[val-1] > 0 ) {
				nums[val-1] *= -1;
			}
			
		}
		
		for ( int i=0; i<nums.length; i++) {
			if ( nums[i]>0 ) {
				result.add(i+1);
			}
		}
		
		return result;
		
    }
	
	

}
