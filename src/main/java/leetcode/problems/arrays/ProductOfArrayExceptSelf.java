package leetcode.problems.arrays;

/**
 * 238. Product of Array Except Self
Medium

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

 

Constraints:

    2 <= nums.length <= 10^5
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


 * @author Moataz Lasheen
 *
 */
public class ProductOfArrayExceptSelf {
	
	// this works but it is stated that you can't use the devision operator
	// TC : O(n), SC : O(1) 
//	public int[] productExceptSelf(int[] nums) {
//		int product = 1;
//		int zerosCount = 0;
//		int zeroIndex = -1;
//		for ( int i=0; i<nums.length; i++ ) {
//			if ( nums[i] == 0 ) {
//				zerosCount++;
//				if ( zerosCount > 1 ) {
//					break;
//				} else {
//					zeroIndex = i;
//				}
//			} else {
//				product *= nums[i];
//			}
//			
//		}
//		for ( int i=0; i<nums.length; i++) {
//			if ( zerosCount > 1 ) {
//				nums[i] = 0;
//			}
//			else if (zerosCount ==1) {
//				if ( i == zeroIndex ) {
//					nums[i] = product;
//				} else {
//					nums[i] = 0;
//				}
//			} else {
//				nums[i] = product/nums[i];
//			}
//		}
//		
//		return nums;
//    }
	
	// TC : O(n), SC : O(n)
	public int[] productExceptSelf(int[] nums) {
		int [] result = new int [nums.length];
		
		// fill the result [] with the prefix product fo each element in the array initially
		result[0] = 1; // there is no elements before element at index 0, so the prefix product is 1
		 
		
		for ( int i=1; i<nums.length; i++ ) {
			result[i] = result[i-1] * nums[i-1];  // product of the previous element and the prefix product of the previous element
		}
		
		int suffixProduct = 1;
		for ( int i=nums.length-1; i>=0; i-- ) {
			result[i] = suffixProduct * result[i];
			suffixProduct = suffixProduct * nums[i];
		}
		return result;
	}

}
