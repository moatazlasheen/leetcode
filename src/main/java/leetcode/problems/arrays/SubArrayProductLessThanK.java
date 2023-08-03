package leetcode.problems.arrays;

/**
 * 713. Subarray Product Less Than K
Medium

Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

 

Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Example 2:

Input: nums = [1,2,3], k = 0
Output: 0

 

Constraints:

    1 <= nums.length <= 3 * 10^4
    1 <= nums[i] <= 1000
    0 <= k <= 10^6


 * @author Moataz Lasheen
 *
 */

public class SubArrayProductLessThanK {
	
	
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int result = 0;
		int product = 1;
		int left = 0;
		for ( int right=0; right<nums.length; right++ ) {
			product *= nums[right];
			while ( left<=right && product >= k ) {
				product /= nums[left];
				left++;
			}
			if ( product < k ) {
				result += right-left+1;
			}
			
		}
		
		return result;
	}
	// TC : O(N^2), not efficient
//	public int numSubarrayProductLessThanK(int[] nums, int k) {
//        int result =0;
//        for ( int i=0; i<nums.length; i++ ) {
//        	for ( int j=i; j<nums.length; j++ )  {
//        		if ( getSubArrayProduct(nums, i, j) < k ) {
//        			result++;
//        		}
//        		else {
//        			break;
//        		}
//        	}
//        }
//        return result;
//    }
//
//	private int getSubArrayProduct(int[] nums, int i, int j) {
//		int prod = 1;
//		for ( ; i<=j; i++ ) {
//			prod *= nums[i];
//		}
//		return prod;
//	}
}
