package leetcode.problems.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
public class InOrderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
        	return result;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        TreeNode current = root;
        while (!stack.isEmpty() || current!=null ) {
        	while (current!=null) {
        		stack.push(current);
        		current = current.left;
			}
        	// current is now null, so the parent or the head of the stack 
        	// is the left most node of the current sub tree
        	// i.e Left subtree is handled, handle the root
        	current = stack.pop();
        	// add the root to the result
        	result.add(current.val);
        	// move to right subtree to handle it
        	current = current.right;
		}
        
        return result;
    }
	
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
        	return result;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
        	tmp = stack.pop();
        	if (tmp.right!=null) {
        		stack.push(tmp.right);        		
        	}
        	if (tmp.left == null) {
        		result.add(tmp.val);
        	} else {
        		stack.push(new TreeNode(tmp.val));
        	}
        	if(tmp.left!=null) {
        		stack.push(tmp.left);
        	}
		}
        
        return result;
    }
}
