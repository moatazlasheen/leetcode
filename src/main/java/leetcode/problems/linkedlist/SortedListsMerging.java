package leetcode.problems.linkedlist;

/**
 * 
 * 21. Merge Two Sorted Lists
Easy

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 

Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class SortedListsMerging {
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode fakeNewHead = new ListNode(Integer.MIN_VALUE);
		ListNode p1 = list1;
		ListNode p2 = list2;
		ListNode current = fakeNewHead;
		
		while ( p1!=null && p2!=null ) {
			if ( p1.val <= p2.val ) {
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}
			current = current.next;
		}
		
		if ( p1 == null ) {
			current.next = p2;
		}
		if ( p2 == null ) {
			current.next = p1;
		}
		
		
		// return the real head
		return fakeNewHead.next;
		
		
	}
	 public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
		 ListNode sortedListHead;
		 ListNode sortedListPointer;
		 ListNode l1Next;
		 ListNode l2Next;
		 
		 if ( list1 == null ) {
			 return list2;
		 }
		 
		 if ( list2 == null ) {
			 return list1;
		 }
		 
		 if( list1.val <= list2.val ) {
			 sortedListHead = list1; 
			 l1Next = list1.next;
			 l2Next = list2;
			 sortedListPointer = sortedListHead;
			 
		 } else {
			 sortedListHead = list2;
			 l1Next = list1;
			 l2Next = list2.next;
			 sortedListPointer = sortedListHead;
		 }
		 
		 while (l1Next!=null && l2Next!= null) {
			if ( l1Next.val <= l2Next.val ) {
				sortedListPointer.next = l1Next;
				sortedListPointer = l1Next;
				l1Next = l1Next.next;
				
			} else {
				sortedListPointer.next = l2Next;
				sortedListPointer = l2Next;
				l2Next = l2Next.next;
				
			}
		 }
		 
		 while (l1Next!=null) {
			 sortedListPointer.next = l1Next;
			 sortedListPointer = l1Next;
			 l1Next = l1Next.next;
			 
		 }
		 
		 while (l2Next!=null) {
			 sortedListPointer.next = l2Next;
			 sortedListPointer = l2Next;
			 l2Next = l2Next.next;
			 
		 }
			 
		 
		 
		 return sortedListHead;
	 }
}
