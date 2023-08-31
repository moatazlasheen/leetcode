package leetcode.problems.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 94. Binary Tree Inorder Traversal
Easy

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

 

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

 
Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Moataz Lasheen
 *
 */
public class InOrderMorrisTraversal {
	
	// Left, root, right 
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
        	return result;
        
        TreeNode current = root;
        TreeNode rightMostNode;
        while (current != null) {
			
        	// if left is null then add the root to 
        	// the result and move to the right subtree
        	if (current.left == null) {
        		result.add(current.val);
        		current = current.right;
        	} else {
        		// left is not null, handle left
        		
        		// get the right most node of the left subtree
        		// and link its right temporarily to current
        		rightMostNode = current.left;
        		while (rightMostNode.right!=null && rightMostNode.right!=current) {
					rightMostNode = rightMostNode.right;
				}
        		
        		// right most node is not linked to its root, link it
        		if (rightMostNode.right == null) {
        			rightMostNode.right = current;
        			current = current.left;
        		} else {
        			// right most node is linked 
        			// and left sub tree of the current node
        			// is handled, add the value of current then
        			// move to the right subtree
        			rightMostNode.right = null;
        			result.add(current.val);
        			current = current.right;
        			
        		}
        		
        	}
        	
		}
        
        return result;
    }
	
	
}
