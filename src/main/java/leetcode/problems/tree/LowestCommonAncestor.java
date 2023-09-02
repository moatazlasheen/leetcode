package leetcode.problems.tree;

/**
 * 
 * 236. Lowest Common Ancestor of a Binary Tree
Medium

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1

 

Constraints:

    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the tree.


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// root will never be null for the entry tree node (client call) 
		// but it can be null in a recursive call
		if (root == null || (root == p || root == q)) {
			return root;
		}
		
		// a leaf node can not be the ancestor of two nodes 
		if (root.left == null && root.right == null) {
			// root is a leaf node
			return null;
		}
		
		// try to find the lowest common ancestor in the left subtree
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		// try to find the lowest common ancestor in the right subtree
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		
		// if no ancestor found in the left sub tree, then it must be in the right subtree
		if (left == null) {
			return right;
		} else if (right == null) {
			// if no ancestor found in the right sub tree, then it must be in the left subtree
			return left;
		} 
		
		// not found in the left sub tree nor in the right subtree
		return root;
    }
}
