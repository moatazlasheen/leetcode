package leetcode.problems.linkedlist;


/**
 * 
 * 83. Remove Duplicates from Sorted List
Easy

Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

 

Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.



 * @author Moataz Lasheen
 *
 */
public class DuplicateRemoving {

	 public ListNode deleteDuplicates(ListNode head) {
		 if ( head == null || head.next == null ) {
			 return head;
		 }
		 
		 ListNode lastUniqueNode = head;
		 ListNode current = head.next;
		 while (current != null) {
			if ( current.val == lastUniqueNode.val ) {
				current = current.next;
			} else {
				lastUniqueNode.next = current;
				lastUniqueNode = current;
				current = current.next;
			}
		}
		lastUniqueNode.next = current;
		return head;
	 }
	 
}
