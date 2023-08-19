package leetcode.problems.linkedlist;

/**
 * 
 * 234. Palindrome Linked List Easy
 * 
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [1,2,2,1] Output: true
 * 
 * Example 2:
 * 
 * Input: head = [1,2] Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 105]. 0 <= Node.val <= 9
 * 
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author Moataz Lasheen
 *
 */
public class Palindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		while (fastPointer.next != null && fastPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		ListNode secondHalfHead = slowPointer.next;
		slowPointer.next = null;
		secondHalfHead = reverse(secondHalfHead);
		slowPointer.next = secondHalfHead;

		ListNode firstHalfCurrent = head;
		ListNode secondHalfCurrent = secondHalfHead;

		while (secondHalfCurrent != null) {
			if (secondHalfCurrent.val != firstHalfCurrent.val) {
				return false;
			}
			firstHalfCurrent = firstHalfCurrent.next;
			secondHalfCurrent = secondHalfCurrent.next;
		}
		return true;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode prev = head;
		ListNode current = head.next;
		prev.next = null;
		ListNode tmp;
		ListNode newHead = null;

		while (current != null) {
			newHead = current;
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;

		}
		return newHead;
	}
}
