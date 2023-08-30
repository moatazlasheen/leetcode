package leetcode.problems.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * 144. Binary Tree Preorder Traversal
Easy

Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]

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


 * @author Moataz Lasheen
 *
 */

public class PreOrderMorrisTraversal {
	
	// Ro, L, R
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
        	return result;
        }
        
        TreeNode current = root;
        TreeNode rightMostNode;
        while (current != null) {
        	
        	// there is no left subtree,
        	// just add current then move to the right subtree
        	if (current.left == null) {
        		result.add(current.val);
        		current = current.right;
        	} else {
        		// find the right most node in the left subtree and link
            	// it to the current node temporarily, so that when you reach
            	// the right most node in the left subtree you can move to the 
            	// right subtree
            	rightMostNode = current.left;
            	while (rightMostNode.right != null && rightMostNode.right!=current) {
    				rightMostNode = rightMostNode.right;
    			}
            	
            	
            	// found the right most node in the left subtree,
            	//the above loop will break in one of two conditions
            	 
            	// 1- if the right most node has no right, then link its
            	// right temporarily to the current
            	// so that you can reach the right subtree of current 
            	// after processing right most node
            	if (rightMostNode.right==null) {
            		rightMostNode.right = current;
            		result.add(current.val);
            		current = current.left;
            	} 
            	
            	// 2- the right most node is already linked to some root
            	// then break the remp link and move to the right subtree of current
            	if (rightMostNode.right == current) {
            		rightMostNode.right= null;
            		current = current.right;
            	}
        	}
        	
        	
		}
        
        return result;
        
        
    }

}
