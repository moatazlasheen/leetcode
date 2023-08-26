package leetcode.problems.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 
 * 103. Binary Tree Zigzag Level Order Traversal
Medium

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100


 * 
 * @author Moataz Lasheen
 *
 */
public class ZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
        	return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int currentLevelIndex = -1;
        int size;
        TreeNode tmp;
        List<Integer> currentLevelList;
        while (!queue.isEmpty()) {
			currentLevelIndex++;
			size = queue.size();
			if (currentLevelIndex%2 ==0) {
				currentLevelList = new LinkedList<>();
			} else {
				currentLevelList = new ArrayList<>();
			}
			result.add(currentLevelList);
			while (size>0) {
				tmp = queue.poll();
				if (currentLevelIndex%2 == 0) {
					currentLevelList.add(tmp.val);
				} else {
					currentLevelList.add(0, tmp.val);
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				size--;
			}
		}
        
        return result;
    }
}
