package leetcode.problems.towpointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 15. 3Sum
Medium
27.4K
2.5K
Companies

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

 

Constraints:

    3 <= nums.length <= 3000
    -10^5 <= nums[i] <= 10^5




 * @author Moataz Lasheen
 *
 */
public class ThreeSum {
	
	//TC : O(n log(n)) for the sorting + O(n^2) for the traversing
	//SC : O(1), no data structure needed ignoring the result arraylist and the space complexity
	// of the sorting algorithm
	public List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> out = new ArrayList<>();
		 Arrays.sort(nums);
		 for ( int i=0; i<nums.length-2; i++ ) {
			 if ( nums[i]>0 || (i>0 && nums[i] == nums[i-1])) {
				 continue;
			 }
			 
			 // we need to find a couple whose sum is negative nums[i]
			 int target = 0-nums[i];
			 int left = i+1;
			 int right = nums.length-1;
			 while ( left<right ) {
				 if ( nums[left] + nums[right]  == target ) {
					 out.add(Arrays.asList(nums[i], nums[left], nums[right]));
					 
					 // there could be more unique couples that sum to target
					 // try to find them before incrementing i
					 while ( left<right && left<nums.length-2 && nums[left] == nums[left+1]) 
						 left++;
					 
					 while ( left<right && right>i+1 && nums[right-1] == nums[right]) 
						 right--;
					 
					 left++;
					 right--;
					 
				 } else if ( nums[left] + nums[right] > target ) {
					 right--;
				 } else {
					 left++;
				 }
			 }
		 }
		 return out;
	 }

}
