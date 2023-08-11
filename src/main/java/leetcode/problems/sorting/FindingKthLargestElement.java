package leetcode.problems.sorting;

import java.util.Arrays;

/**
 * 
 * 215. Kth Largest Element in an Array
Medium

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

 

Constraints:

    1 <= k <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4



 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class FindingKthLargestElement {
	
	public int findKthLargest(int[] nums, int k) {
		int [] copy = Arrays.copyOf(nums, nums.length);
		return findKthLargest(copy,k,0,nums.length-1);
    }
	
	private int findKthLargest(int[] copy, int k, int start, int end) {
		return quickSort(copy, k, start, end);
	}

	private int quickSort(int[] nums, int k, int low, int high) {
			int pivotIndex = partition(nums, low, high);
			if ( pivotIndex == nums.length-k ) {
				return nums[pivotIndex];
			} else if ( pivotIndex > nums.length-k){
				return quickSort(nums, k, low, pivotIndex-1);
			} else {
				return quickSort(nums, k, pivotIndex+1, high);
			}
	}

	private int partition(int[] nums, int low, int high) {
		// all the element before the pivot index should be less than pivot value, 
		// initially the first item in the range
		int pivotIndex = low;
		int pivotVal = nums[high]; // the chosen pivot is the last item in the given range
		for ( int i=low; i<high; i++ ) {
			if ( nums[i] < pivotVal ) {
				swap(nums, pivotIndex++, i);
			}
			// other wise , check the next element in the range
		}
		swap(nums, pivotIndex, high);
		return pivotIndex;
	}

	private void swap(int [] nums, int i, int j) {
		if (i!=j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	}

	
	
	
}
