package leetcode.problems.tree;

/**
 * 
 * 116. Populating Next Right Pointers in Each Node
Medium
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 2^12 - 1].
    -1000 <= Node.val <= 1000

 

Follow-up:

    You may only use constant extra space.
    The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class NextRightPopulating {
	
	
	// iterative, better in memory consumption 
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		
		if (root.left == null && root.right == null) {
			return root;
		}
		
		Node levelStart = root;
		Node current = root;
		while (levelStart != null) {
			current = levelStart;
			while (current != null) {
				if (current.left != null) {
					current.left.next = current.right;
					if (current.next != null) {
						current.right.next = current.next.left;
					}
				}
				current = current.next;
			} 
			levelStart = levelStart.left;
		}
		
		return root;
	}
	
	
	// recursive approach
//	public Node connect(Node root) {
//        if (root == null) {
//        	return null;
//        }
//        if (root.left == null || root.right == null) {
//        	return root;
//        }
//        
//        root.left.next = root.right;
//        if (root.next != null) {
//        	root.right.next = root.next.left;
//        }
//        
//        connect(root.left);
//        connect(root.right);
//        
//        return root;
//        
//    }
}
