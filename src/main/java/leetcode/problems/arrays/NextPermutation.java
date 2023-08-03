package leetcode.problems.arrays;

/**
 * 31. Next Permutation
Medium

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

    For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].

The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

    For example, the next permutation of arr = [1,2,3] is [1,3,2].
    Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
    While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.

Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]

Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]

Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 100


 * @author Moataz Lasheen
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		
		// loop start from the end till you find a pair in increasing order from left to right
		int i = nums.length-2;
		while (i>=0) {
			if(nums[i]<nums[i+1]) {
				break;
			}
			i--;
		}
		
		// all items in the right of i are sorted in increasing or order form left to right (this part is sorted)
		// find the next greater element than the element in index i and exists in the sorted part.
	
		int tmp;
		for ( int j=nums.length-1; j>i && i>=0; j-- ) {
			if ( nums[j] > nums[i] ) {
				tmp = nums[j];
				nums[j] = nums[i];
				nums[i] = tmp;
				break;
			}
		}
		
		// reverse the sorted part, from i+1 to the end of the array
		// even after the swap (if swap was done), the part from i+1 till the end is still sorted
        swap(nums, i+1, nums.length-1);
		
    }

	private void swap(int[] nums, int start, int end) {
		int middle = start + (end-start)/2;
		int tmp;	
		for ( int i=start; i<=middle; i++ ) {
			tmp = nums[i];
			nums[i] = nums[end-i+start];
			nums[end-i+start] = tmp;
		}
	}
}
