package leetcode.problems.arrays;


/**
 * 55. Jump Game
Medium

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 

Constraints:

    1 <= nums.length <= 10^4
    0 <= nums[i] <= 10^5


 * @author Moataz Lasheen
 *
 */
public class JumpGame {
	
	
	public boolean canJump(int[] nums) {
		boolean canJump = false;
		int reachable = 0;
		for ( int i=0; i<nums.length && reachable>=i; i++ ) {
			reachable = Math.max(reachable, i+nums[i]);
			if ( reachable >= nums.length-1 ) {
				canJump = true;
				break;
			}
		}
		return canJump;
	}
	
	// works but not efficient ( excceded time on leet code)
	// time complexity O(n^2)
//	public boolean canJump(int[] nums) {
//        
//		boolean result = false ;
//		if ( nums.length == 1 ) {
//			result = true;
//		}
//		else if ( nums.length > 1 && nums[0]>0 ) {
//			result = jump(nums,0);
//		}
//        
//        return result;
//    }
//
//	private boolean jump(int[] nums, int startIndex) {
//		boolean result = false;
//		if ( startIndex >= nums.length-1 || startIndex + nums[startIndex] > nums.length-1 ) {
//			result = true;
//		}
//		else {
//			for ( int j = startIndex+nums[startIndex]; j>startIndex; j-- ) {
//				if ( j+nums[j] >= nums.length-1 || jump(nums, j)) {
//					result = true;
//					break;
//				}
//			}
//		}
//		
//		return result;
//	}
}
