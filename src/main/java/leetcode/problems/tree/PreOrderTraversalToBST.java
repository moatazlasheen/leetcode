package leetcode.problems.tree;

/**
 * 
 * 1008. Construct Binary Search Tree from Preorder Traversal
Medium

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

 

Example 1:

Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Example 2:

Input: preorder = [1,3]
Output: [1,null,3]

 

Constraints:

    1 <= preorder.length <= 100
    1 <= preorder[i] <= 1000
    All the values of preorder are unique.


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class PreOrderTraversalToBST {
	public TreeNode bstFromPreorder(int[] preorder) {
		
		return bstFromPreorder(preorder, 0, preorder.length-1);
        
    }

	private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
		if(start>end)
			return null;
		
		TreeNode root = new TreeNode(preorder[start]);
		if (start == end) {
			return root;
		}
		
        int rightSubTreeStartIndex = getRightSubTreeStartIndex(preorder, root.val, start+1, end);
        if (rightSubTreeStartIndex > start+1) {
        	// there is a left subtree;
        	root.left = bstFromPreorder(preorder, start+1, rightSubTreeStartIndex-1);
        }
        if (rightSubTreeStartIndex <= end) {
        	// there is a right subtree
        	root.right = bstFromPreorder(preorder, rightSubTreeStartIndex, end);
        }
        
        return root;
	}

	private int getRightSubTreeStartIndex(int[] preorder, int val, int searchStartIndex, int searchEndIndex) {
		for (int i = searchStartIndex; i<=searchEndIndex; i++) {
			if (preorder[i] > val) {
				return i;
			}
		}
		return searchEndIndex+1;
	}
}
