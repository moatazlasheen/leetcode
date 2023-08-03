package leetcode.problems.towpointers;

/**
 * 977. Squares of a Sorted Array
Easy

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 

Constraints:

    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums is sorted in non-decreasing order.

 
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?


 * @author Moataz Lasheen
 *
 */
public class SquaresOfSortedArray {
	
	public int[] sortedSquares(int[] nums) {
		int [] out = new int [nums.length];
		
		int left = 0;
		int right = nums.length-1;
		int insertionIndex = nums.length-1;
		
		while ( left <= right ) {
			if ( Math.abs(nums[left]) < Math.abs(nums[right]) ) {
				out[insertionIndex--] = nums[right] * nums[right--];
			} else {
				out[insertionIndex--] = nums[left] * nums[left++];
			}
		}
		
		return out;
	}
	
	// TC : O(n)
	// SC : O(n) > the output array
	// little bit complex
	public int[] sortedSquares2(int[] nums) {
		int [] out = new int [nums.length];
		int smallestModulusIndex = getSmallestModulusIndex(nums);
		int i=0;
		if ( smallestModulusIndex >= 0 && smallestModulusIndex < nums.length) {
			out[i++] = nums[smallestModulusIndex] * nums[smallestModulusIndex];
		}
		int left = smallestModulusIndex -1;
		int right = smallestModulusIndex +1;
		
		while ( left >= 0 || right < nums.length ) {
			if ( left<0 || ( right<nums.length && nums[right] <= -1*nums[left]) ) {
				out[i++] = nums[right] * nums[right];
				right++;
			} else if ( right >= nums.length || -1*nums[left] <= nums[right] ) {
				out[i++] = nums[left] * nums[left];
				left--;
			}
		}
		return out;
    }

	private int getSmallestModulusIndex(int[] nums) {
		int index=nums.length;
		for ( int i= 0; i<nums.length; i++ ) {
			if ( nums [i] >=0 ) {
				if ( i==0 || nums[i] == 0 || nums[i] < -1*nums[i-1] ) {
					index = i;
				}
				else {
					index = i-1;
				}
				break;
			}
		}
		return index;
		
	}
}
