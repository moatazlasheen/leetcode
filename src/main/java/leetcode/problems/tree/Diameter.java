package leetcode.problems.tree;

/**
 * 
 * 543. Diameter of Binary Tree
Easy

Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

 

Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

Example 2:

Input: root = [1,2]
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    -100 <= Node.val <= 100



 * 
 * @author Moataz Lasheen
 *
 */
public class Diameter {
	
//	public int diameterOfBinaryTree(TreeNode root) {
//        if (root == null || (root.left == null && root.right == null))
//            return 0;
//
//        int maxDiameter = 0;
//        
//        int leftMaxDepth = calculateMaxDetpth(root.left);
//        int rightMaxDepth = calculateMaxDetpth(root.right);
//
//        int diameter = leftMaxDepth + rightMaxDepth;
//        maxDiameter = Math.max(maxDiameter, diameter);
//        maxDiameter = Math.max(maxDiameter, diameterOfBinaryTree(root.left));
//        maxDiameter = Math.max(maxDiameter, diameterOfBinaryTree(root.right));
//        
//        return maxDiameter;
//        
//    }
	
//	private int calculateMaxDetpth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        if (root.left == null && root.right == null)
//            return 1;
//
//        if (root.left == null) {
//            return 1 + calculateMaxDetpth(root.right);
//        } else if (root.right == null) {
//            return 1  + calculateMaxDetpth(root.left);
//        } else {
//            return 1 + Math.max(calculateMaxDetpth(root.left), calculateMaxDetpth(root.right));
//        }
//    }
	
	int maxDiameter = 0;
	
	public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return 0;

        calculateMaxDepth(root);
        
        return maxDiameter;
        
    }

    private int calculateMaxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int left = calculateMaxDepth(root.left);
        int right = calculateMaxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
        
    }

}
