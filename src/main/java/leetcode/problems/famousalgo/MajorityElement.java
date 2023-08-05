package leetcode.problems.famousalgo;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
Easy

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

 

Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -10^9 <= nums[i] <= 10^9

 
Follow-up: Could you solve the problem in linear time and in O(1) space?


 * @author Moataz Lasheen
 *
 */
public class MajorityElement {
	
	// TC : O(n)
	// SC : O(1)
	public int majorityElement(int[] nums) {
		int count = 0; // difference between majority element count and none majority element(s)
		int majorityElement = nums[0];
		for ( int i=0; i<nums.length; i++ ) {
			// the sub array on the left has no majority element
			if ( count == 0 ) {
				majorityElement = nums[i];
				count = 1;
			}
			
			else if ( nums[i] == majorityElement ) {
				count++;
			} else {
				count--;
			}
		}
		
		return majorityElement;
	}
	
	// TC : O(n)
	// SC : O(n)
	public int majorityElement2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
        Integer currentElementOcc;
        for ( int i=0; i<nums.length; i++) {
        	currentElementOcc = map.get(nums[i]); 
        	if ( currentElementOcc == null ) {
        		map.put(nums[i], 1);
        	}
        	else {
        		currentElementOcc++;
        		map.put(nums[i], currentElementOcc);
        	}
        }
        
        return map.entrySet().stream().filter(e-> e.getValue() > nums.length/2).findFirst().get().getKey();
    }

}
