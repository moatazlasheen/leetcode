package leetcode.problems.linkedlist;


/**
 * 
 * 206. Reverse Linked List
Easy

Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []

 

Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000

 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

 * 
 * 
 * @author Moataz Lasheen
 *
 */

public class LinkedListReversing {
	
	ListNode newHead;

	// recursive
	public ListNode reverseList(ListNode head) {
		if ( head == null || head.next == null ) {
			return head;
		}
		return reverse(null, head); // reversed list head "new head", unreversed list head
	}
	
	private ListNode reverse(ListNode reversedListHead, ListNode unReversedListHead) {
		if ( unReversedListHead == null ) {
			return reversedListHead;
		}
		
		ListNode newUnreversedListHead = unReversedListHead.next;
		unReversedListHead.next = reversedListHead;
		reversedListHead = unReversedListHead;
		return reverse(reversedListHead, newUnreversedListHead);
		
	}

	// recursive
	public ListNode reverseList3(ListNode head) {
		if ( head == null || head.next == null ) {
			return head;
		}
		reverseList(head, head.next);
		return newHead;
		
	}
	
	private ListNode reverseList(ListNode head, ListNode restHead) {
		if ( restHead == null ) {
			newHead = head;
			head.next = null;
			return head;
		} 
		if ( restHead.next == null ) {
			newHead = restHead;
			restHead.next = head;
			head.next = null;
			return restHead;
		}
		
		ListNode tail = reverseList(restHead, restHead.next);
		tail.next = restHead;
		restHead.next = head;
		head.next = null;
		return restHead;
		
		
		
	}

	// iterative
	public ListNode reverseList2(ListNode head) {
		if ( head == null || head.next == null ) {
			return head;
		}
		ListNode prev = head;
		ListNode current = head.next;
		head.next = null;
		ListNode next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}

}
