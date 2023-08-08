package leetcode.problems.sorting;


/**
 * 
 * 912. Sort an Array
Medium

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
public class QuickSort {
	
	// TC: O(nlog(n))
	// SC: O(1) ignoring space complexity of the recursion stack
	public int[] sortArray(int[] nums) {
		return quickSort(nums,0,nums.length-1);
    }

	private int[] quickSort(int[] nums, int low, int high) {
		if ( low < high ) {
			int pivotIndex = partition(nums, low, high);
			quickSort(nums, low, pivotIndex-1);
			quickSort(nums, pivotIndex+1, high);
		}
		return nums;
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
