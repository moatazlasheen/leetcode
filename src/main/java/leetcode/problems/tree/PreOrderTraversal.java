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

public class PreOrderTraversal {
	
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
        	return result;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
        	tmp = stack.pop();
    		result.add(tmp.val);
    		if ( tmp.right!=null) {
    			stack.push(tmp.right);
    		}
    		if (tmp.left!=null) {
    			stack.push(tmp.left);
    		}
			
			
		}
        
        return result;
        
        
    }
	
	// recursive
//	public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) {
//        	return result;
//        }
//        
//        result.add(root.val);
//        result.addAll(preorderTraversal(root.left));
//        result.addAll(preorderTraversal(root.right));
//        
//        return result;
//        
//        
//    }

}
