package leetcode.problems.arrays;


/**
 * 283. Move Zeroes
Easy

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]

 

Constraints:

    1 <= nums.length <= 10^4
    -2^31 <= nums[i] <= 2^31 - 1

 * @author Moataz Lasheen
 *
 */
public class ZeroMoving {
	
	
	public void moveZeroes(int[] nums) {
		if ( nums.length < 2 ) {
			return;
		}
		int left = 0;
		for ( int right=0; right<nums.length; right++ ) {
			if ( nums[right] != 0 ) {
				nums[left] = nums[right];
				left++;
			}
			
		}
		for ( int i=left; i<nums.length; i++ ) {
			nums[i] = 0;
		}
    }
	
//	public void moveZeroes(int[] nums) {
//		if ( nums.length < 2 ) {
//			return;
//		}
//		int zerosCount = 0;
//		for ( int i=0; i<nums.length-zerosCount; i++ ) {
//        	if ( nums[i] == 0 ) {
//        		zerosCount++;
//        		for ( int j=i; j<nums.length-zerosCount; j++ ) {
//        			nums[j] = nums[j+1];
//        		}
//        		nums[nums.length-zerosCount] = 0;
//        	}
//        	if (nums[i] == 0)
//				i--;
//        }
//    }
	
	
//	public void moveZeroes(int[] nums) {
//		if ( nums.length < 2 ) {
//			return;
//		}
//		int temp;
//		for ( int i=0; i<nums.length; i++ ) {
//        	if ( nums[i] == 0 ) {
//        		for ( int j=i+1; j<nums.length; j++ ) {
//        			if ( nums[j] != 0 ) {
//        				temp = nums[j];
//        				nums[j] = nums[i];
//        				nums[i] = temp;
//        				if ( j == nums.length-1 ) {
//        					return;
//        				}
//        				break;
//        			}
//        		}
//        	}
//        }
//    }
}
