package leetcode.problems.search;


/**
 * 704. Binary Search
Easy

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

 

Constraints:

    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.


 * @author Moataz Lasheen
 *
 */
public class BinarySearch {
//	public int search(int[] nums, int target) {
//		int targetIndex = -1;
//		int left = 0;
//		int right = nums.length-1;
//		int middle = -1;
//		while ( right-left > 1 ) {
//			middle = (left + right)/2;
//			if ( nums [middle] == target ) {
//				targetIndex = middle;
//				break;
//			} 
//			else if ( nums[left] == target ) {
//				targetIndex = left;
//				break;
//			} else if ( nums[middle] > target ) {
//				right = middle;
//			} else {
//				left = middle;
//			}
//			
//		}
//		
//		if ( nums[left] == target ) {
//			targetIndex = left;
//		}
//		else if ( nums[right] == target ) {
//			targetIndex = right;
//		}
//		
//		return targetIndex;
//        
//    }
	
	public int search(int[] nums, int target) {
        int left = 0; // initialize left pointer to 0
        int right = nums.length - 1; // initialize right pointer to the last index of the array
        
        while (left <= right) { // continue the loop till left pointer is less than or equal to right pointer
            int mid = left + (right - left) / 2; // calculate the middle index of the array
            
            if (nums[mid] == target) { // check if the middle element is equal to target
                return mid; // return the middle index
            } else if (nums[mid] < target) { // check if the middle element is less than target
                left = mid + 1; // move the left pointer to the right of middle element
            } else { // if the middle element is greater than target
                right = mid - 1; // move the right pointer to the left of middle element
            }
        }
        
        return -1; // target not found in the array
    }
}
