package leetcode.problems.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 143. Reorder List
Medium

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln

Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:

Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:

Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

 

Constraints:

    The number of nodes in the list is in the range [1, 5 * 104].
    1 <= Node.val <= 1000


 * 
 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class Reordering {
	
	// TC : O(n)
	// SC : O(1)
	public void reorderList(ListNode head) {
		
		if ( head == null || head.next == null ) {
			return;
		}
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
        
        ListNode secondHalfHead = slowPointer.next;
        slowPointer.next = null;
        
        secondHalfHead = reverse (secondHalfHead);
        
        ListNode firstHalfCurrent = head;
        ListNode secondHalfCurrent = secondHalfHead;
        ListNode tmp1;
        ListNode tmp2;
        
        while (secondHalfCurrent!=null) {
			tmp1 = firstHalfCurrent.next;
        	tmp2 = secondHalfCurrent.next;
			firstHalfCurrent.next = secondHalfCurrent;
			secondHalfCurrent.next = tmp1;
			firstHalfCurrent = tmp1;
			secondHalfCurrent = tmp2;
		}
        
		
	}
	private ListNode reverse(ListNode secondHalfHead) {
		if ( secondHalfHead == null || secondHalfHead.next == null ) {
			return secondHalfHead;
		}
		ListNode newHead = null;
		ListNode prev = secondHalfHead;
		ListNode current = secondHalfHead.next;
		ListNode tmp;
		while (current!= null) {
			tmp = current.next;
			current.next = prev;
			if ( newHead == null ) {
				prev.next = null;
			}
			newHead = current;
			prev = current;
			current = tmp;
		}
		return newHead;
	}
	public void reorderList2(ListNode head) {
		if ( head == null || head.next == null ) {
			return;
		}
        int length = 0;
        ListNode current = head;
        while (current!=null) {
			length++;
			current = current.next;
		}
        
        int middle = (int) Math.ceil((double)length/2);
        
        current = head;
        int currentIndex = 0;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (current != null) {
			if ( currentIndex >= middle ) {
				stack.push(current);
			}
			current = current.next;
			currentIndex++;
		}
        
        current = head;
        ListNode tmp;
        ListNode tmp2;
        while (!stack.isEmpty()) {
        	tmp = current.next;
        	tmp2 = stack.pop();
			current.next = tmp2;
			tmp2.next = tmp;
			current = tmp;
			
		}
        current.next = null;
    }
}
