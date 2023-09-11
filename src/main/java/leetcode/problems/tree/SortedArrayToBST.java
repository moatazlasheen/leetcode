package leetcode.problems.tree;

/**
 * 
 * 108. Convert Sorted Array to Binary Search Tree
Easy

Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
binary search tree.

 

Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

 

Constraints:

    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums is sorted in a strictly increasing order.




 * @author Moataz Lasheen
 *
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);
        
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (end-start <= 0){
            return null;
        }
        if (end-start == 1){
            return new TreeNode(nums[start]);
        }
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left= sortedArrayToBST(nums, start, mid);
        root.right= sortedArrayToBST(nums, mid+1, end);
        
        return root;
    }
}
