package leetcode.problems.towpointers;

/**
 * 
 * 167. Two Sum II - Input Array Is Sorted
Medium
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

 

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

 

Constraints:

    2 <= numbers.length <= 3 * 10^4
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.


 * 
 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int left = 0;
        int right = nums.length-1;
        int sum;
        int [] result = new int[2];
        while (right > left ) {
            sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = left+1;
                result[1] = right+1;
                break;
            } else if ( sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
	}
	
//	public int[] twoSum(int[] nums, int target) {
//		int right;
//		for (int left = 0; left < nums.length; left++) {
//			right = left+1;
//			while(nums[left] + nums[right] < target && right < nums.length-1) {
//				right ++;
//			}
//			if ( nums[left] + nums[right] == target) {
//				return new int[] {left+1, right+1};
//			}
//		}
//		return null;
//	}
	
	
	
	// SC : O(1)
//	public int[] twoSum(int[] numbers, int target) {
//        int [] result = new int [2];
//        for (int i = 0; i < numbers.length; i++) {
//            int diff = target-numbers[i];
//            int index = getIndexOf(numbers, diff, i+1); 
//            if (index > -1) {
//                result[0] = i+1;
//                result[1] = index+1;
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    private int getIndexOf(int [] numbers, int target, int start) {
//        int left = start;
//        int right = numbers.length-1;
//        int mid;
//        while (left <= right) {
//            mid = (left + right)/2;
//            if(target == numbers[mid]) {
//                return mid;
//            } else if (target > numbers[mid]) {
//                 left = mid+1;
//            } else {
//                right = mid-1;
//            }
//        }
//        return -1;
//    }

}
