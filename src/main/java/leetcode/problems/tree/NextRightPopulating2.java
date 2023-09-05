package leetcode.problems.tree;

/**
 * 
 * 117. Populating Next Right Pointers in Each Node II
Medium

Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:

Input: root = []
Output: []

 

Constraints:

    The number of nodes in the tree is in the range [0, 6000].
    -100 <= Node.val <= 100

 

Follow-up:

    You may only use constant extra space.
    The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.



 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class NextRightPopulating2 {
	
	
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}
		
		Node currentLevelStart = root;
		Node nextLevelStart;
		Node current;
		while (currentLevelStart != null) {
			// connect next level nodes then move to the next level
			nextLevelStart = getNextLevelStartNode(currentLevelStart);
			
			current = currentLevelStart;
			while (current != null) {
				if (current.left != null && current.right != null) {
					current.left.next = current.right;
				}
				else if (current.left != null && current.right == null && current.next != null) {
					current.left.next = getNextSubNode(current.next); 
				}
				
				if (current.right != null && current.next != null) {
					current.right.next = getNextSubNode(current.next);
				}
				current = current.next;
			}
			
			
			currentLevelStart = nextLevelStart;
		}
		
		return root;
	}

	private Node getNextSubNode(Node current) {
		while (current != null) {
			if (current.left != null) {
				return current.left;
			} else if (current.right != null) {
				return current.right;
			} else {
				current = current.next;
			}
		}
		return null;
	}

	private Node getNextLevelStartNode(Node currentLevelStart) {
		if ( currentLevelStart != null ) {
			return getNextSubNode(currentLevelStart);
		}
		return null;
	}
	
	
}
