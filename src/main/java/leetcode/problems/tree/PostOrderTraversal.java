package leetcode.problems.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 145. Binary Tree Postorder Traversal
Easy

Given the root of a binary tree, return the postorder traversal of its nodes' values.

 

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

 

Constraints:

    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

 
Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author Moataz Lasheen
 *
 */
public class PostOrderTraversal {
	// the need order is left the right then root
	// we can handle this the same way as we handled the pre order traversal
	// the only difference is that we insert in the final result in reverse direction
	// so we will insert the root in the result the we will insert the right sub tree just before it, i.e insert at index 0
	// the we will insert the left subtree just before the right subtree, i.e insert at index 0
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if (root == null) {
			return result;
		}
		
		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);
		TreeNode tmp;
		while (!stack.isEmpty()) {
			tmp = stack.pop();
			result.add(0, tmp.val);
			if (tmp.left!=null)
				stack.push(tmp.left);
			if (tmp.right!=null)
				stack.push(tmp.right);
		}
		
		
		return result;
    }
}
