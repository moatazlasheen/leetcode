package leetcode.problems.linkedlist;


/**
 * 61. Rotate List
Medium

Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

 

Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 109


 * 
 * @author Moataz Lasheen
 *
 */
public class Rotation {
	
	public ListNode rotateRight(ListNode head, int k) {
		
		if (head == null || head.next == null || k == 0)  {
			return head;
		}
		
		int length = 1;
		ListNode prev = head;
		ListNode current = head.next;
		while (current!=null) {
			length++;
			prev = current;
			current = current.next;
		}
		
		// make it cyclic for now, will break the cycle later
		prev.next = head;
		
		int newHeadIndex = length - (k % length);
		
		ListNode newHead;
		
		current = head;
		int count = 0;
		while (count<newHeadIndex) {
			prev = current;
			current = current.next;
			count++;
		}
		newHead = current;
		// break the cycle
		prev.next = null;
		
		
		return newHead;
    }

}
