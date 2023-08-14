package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.ListNode;
import leetcode.problems.linkedlist.SortedListsMerging;

public class SortedListsMergingTest {
	
	private SortedListsMerging underTest = new SortedListsMerging();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode list1, ListNode list2, ListNode expectedHead, int expextedLength ) {
		ListNode actualHead = underTest.mergeTwoLists(list1, list2);
		assertEquals(expectedHead, actualHead);
		int size = 1;
		ListNode pointer = actualHead;
		if ( expectedHead != null ) {
			int lastVal = Integer.MIN_VALUE;
			while (pointer.next != null ) {
				assertTrue(pointer.val>=lastVal);
				pointer = pointer.next;
				size++;
				lastVal = pointer.val;
			}
			assertEquals(expextedLength, size);
		}
	}
	
	private static Stream<Arguments> testWithParams( ) {
		
		ListNode list1ThirdItem = new ListNode(4);
		ListNode list1SecondItem = new ListNode(2, list1ThirdItem);
		ListNode list1FirstItem = new ListNode(1, list1SecondItem);
		
		ListNode list2ThirdItem = new ListNode(4);
		ListNode list2SecondItem = new ListNode(3, list2ThirdItem);
		ListNode list2FirstItem = new ListNode(1, list2SecondItem);
		
		return Stream.of(
			Arguments.of(list1FirstItem, list2FirstItem, list1FirstItem,6),
			Arguments.of(null, null, null,0),
			Arguments.of(null, list2ThirdItem, list2ThirdItem,1)
		);
	}
	

}
