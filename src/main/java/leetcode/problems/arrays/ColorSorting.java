package leetcode.problems.arrays;

/**
 * 75. Sort Colors
Medium

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

 

Constraints:

    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2
 * @author Moataz Lasheen
 *
 */
public class ColorSorting {
	
	// TC : O(n log n)
//	public void sortColors(int[] nums) {
//        int temp;
//        for ( int i=0; i<nums.length; i++ ) {
//        	for ( int j=i+1; j<nums.length; j++ ) {
//        		if ( nums[j] < nums[i] ) {
//        			temp = nums[i];
//        			nums[i] = nums[j];
//        			nums[j] = temp;
//        		}
//        	}
//        }
//    }
	
	// TC : O(n)
//	public void sortColors(int[] nums) {
//        int zerosCount = 0;
//        int onesCount = 0; 
//        for ( int i=0; i< nums.length; i++ ) {
//        	if ( nums[i] == 0 ) {
//        		zerosCount++;
//        	} else if (nums[i] == 1) {
//				onesCount++;
//			} 
//        }
//        
//        for ( int i=0; i<zerosCount; i++ ) {
//        	nums[i] = 0;
//        }
//        for ( int i=zerosCount; i<zerosCount+onesCount; i++ ) {
//        	nums[i] = 1;
//        }
//        for ( int i=zerosCount+onesCount; i<nums.length; i++ ) {
//        	nums[i] = 2;
//        }
//    }

	// TC : O(n)
	// all the element till left are zeros
	// all the element from left + 1 till middle are ones
	// all element starting from right are twos
	public void sortColors(int[] nums) {
        int left = 0;
        int middle = 0;
        int right = nums.length-1;
        int temp;
        while ( right>=middle) {
        	if ( nums[middle] == 0 ) {
        		temp = nums[left];
        		nums[left] = nums[middle];
        		nums[middle] = temp;
        		left++;
        		middle++;
        	} else if ( nums[middle] == 1) {
        		middle++;
        	}
        	else {
        		temp = nums[right];
        		nums[right] = nums[middle];
        		nums[middle] = temp;
        		right--;
        	}
        }
    }

}
