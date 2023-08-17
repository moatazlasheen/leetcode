package leetcode.problems.linkedlist;


/**
 * 
 * 25. Reverse Nodes in k-Group
Hard

Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

Example 2:

Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]

 

Constraints:

    The number of nodes in the list is n.
    1 <= k <= n <= 5000
    0 <= Node.val <= 1000

 

Follow-up: Can you solve the problem in O(1) extra memory space?

 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class ReverseNodesInKGroupsProblem {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if ( k == 1 ) {
			return head;
		}
		
		// formerly the first group's last element, after reversing
		// it will be the first element in the first group, i.e list head
		ListNode newHead = null;
		
		// the first element in the current group before revering it.
		ListNode currentGroupStartNode = head;
		// the last element in the current group before revering it
		ListNode currentGroupEndNode = null;
		// the first element in the next group before reversing the next group
		ListNode nextGroupStartNode;
		// initially referers to the first element in the current group
		ListNode currentGroupPointer = currentGroupStartNode;
		// last element in the current group after reversing, formerly, the first item in the 
		// current group before reversing, it should refer to the first element in the next group
		// after reversing the next group
		ListNode previousGroupLastElement = null;
		// traverse the list till the end
		while (currentGroupPointer!=null) {
			int currentGroupLength = 1;
			while ( currentGroupLength < k && currentGroupPointer.next != null ) {
				currentGroupPointer = currentGroupPointer.next;
				currentGroupLength++;
			}
			
			
			
			if ( currentGroupLength == k ) {
				// this group has sufficient length
				currentGroupEndNode = currentGroupPointer;
				nextGroupStartNode = currentGroupPointer.next;
				reverseSubList(currentGroupStartNode, nextGroupStartNode);
				if ( newHead == null ) {
					newHead = currentGroupEndNode;
				}
				if ( previousGroupLastElement != null ) {
					// current group start now
					previousGroupLastElement.next = currentGroupEndNode;
				}
				previousGroupLastElement = currentGroupStartNode;
				currentGroupStartNode = nextGroupStartNode;
				currentGroupPointer = currentGroupStartNode;
				
				
			} else {
				if ( previousGroupLastElement != null ) {
					// current group start now
					previousGroupLastElement.next = currentGroupStartNode;
				}
				break;
			}
			
		}
		
		return newHead;
    }

	private void reverseSubList(ListNode currentGroupStartNode,
			ListNode nextGroupStartNode) {
		
		
		ListNode prev = currentGroupStartNode;
		ListNode current = currentGroupStartNode.next;
		
		ListNode tmp;
		while (current!=nextGroupStartNode) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
			
		}
		currentGroupStartNode.next = null;
		
		
	}
	
}
