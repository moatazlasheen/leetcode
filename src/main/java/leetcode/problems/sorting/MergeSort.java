package leetcode.problems.sorting;


/**
 * 
 * 912. Sort an Array
Medium
5.3K
704
Companies

Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).

Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.

 

Constraints:

    1 <= nums.length <= 5 * 10^4
    -5 * 10^4 <= nums[i] <= 5 * 10^4


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class MergeSort {
	
	// TC: O(nlog(n))
	// SP : O(n), for the merging
	public int[] sortArray(int[] nums) {
		sortSubArray(nums,0,nums.length-1);
		return nums;
    }

	private void sortSubArray(int[] nums, int start, int end) {
		if ( start == end ) {
			return;
		}
		int mid = start + (end-start)/2;
		// sort the left part;
		sortSubArray(nums, start, mid);
		
		// sort the right part 
		sortSubArray(nums, mid+1, end);
		
		merge(nums, start, mid, end);
		
	}

	private void merge(int[] nums, int start, int mid, int end) {
		// will hold the left sub array
		int [] leftCopy = new int [mid-start+1];
		// will hold the right sub array
		int [] rightCopy = new int [end-mid];
		
		
		// copy from original array to the new left copy array
		for ( int i=0; i<leftCopy.length; i++ ) {
			leftCopy[i] = nums[start+i];
		}
		
		// copy from the original array to the right copy array
		for ( int i=0; i<rightCopy.length; i++ ) {
			rightCopy[i] = nums[mid+1+i];
		}
		
		
		int leftIndex = 0;
		int rightIndex = 0;
		int updateIndex = start;
		
		// while we didn't get out of the boundaries of both copies
		while ( leftIndex<leftCopy.length && rightIndex<rightCopy.length) {
			if ( leftCopy[leftIndex] <= rightCopy[rightIndex] ) {
				nums[updateIndex++] = leftCopy[leftIndex++]; 
			} else {
				nums[updateIndex++] = rightCopy[rightIndex++];
			}
		}
		
		// we got out of the boundaries of one or the two copies ( left and/or right )
		
		// we got out of the right copy boundaries first, left copy still has some items
		while (leftIndex<leftCopy.length) {
			nums[updateIndex++] = leftCopy[leftIndex++];
		}
		
		// we got out of left copy boundaries first, right copy still has some items
		while (rightIndex<rightCopy.length) {
			nums[updateIndex++] = rightCopy[rightIndex++];
		}
		
	}
	
	
}
