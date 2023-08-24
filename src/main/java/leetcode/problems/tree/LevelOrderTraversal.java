package leetcode.problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * 102. Binary Tree Level Order Traversal Medium
 * 
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]]
 * 
 * Example 2:
 * 
 * Input: root = [1] Output: [[1]]
 * 
 * Example 3:
 * 
 * Input: root = [] Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val
 * <= 1000
 * 
 * 
 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size(); // current level nodes number
			List<Integer> currentLevelValues = new ArrayList<>(size);
			result.add(currentLevelValues);
			while (size > 0) {
				TreeNode treeNode = queue.poll();
				currentLevelValues.add(treeNode.val);
				if (treeNode.left!=null) {
					queue.offer(treeNode.left);
				}
				if (treeNode.right!=null) {
					queue.add(treeNode.right);
				}
				size--;
			}
		}

		return result;

	}
}
