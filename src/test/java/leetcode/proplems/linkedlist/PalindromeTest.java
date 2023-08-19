package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.ListNode;
import leetcode.problems.linkedlist.Palindrome;

class PalindromeTest {
	
	private Palindrome underTest = new Palindrome();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode head, boolean expected ) {
		boolean actual = underTest.isPalindrome(head);
		assertEquals(expected, actual);
	}
	
	
	
	private static Stream<Arguments> testWithParams ( ) {
		
		
		// 1 > 2 > 2 > 2
		ListNode inputList1Node4 = new ListNode(1);
		ListNode inputList1Node3 = new ListNode(2, inputList1Node4);
		ListNode inputList1Node2 = new ListNode(2, inputList1Node3);
		ListNode inputList1Node1 = new ListNode(1, inputList1Node2);
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList2Node5 = new ListNode(5);
		ListNode inputList2Node4 = new ListNode(4, inputList2Node5);
		ListNode inputList2Node3 = new ListNode(3, inputList2Node4);
		ListNode inputList2Node2 = new ListNode(2, inputList2Node3);
		ListNode inputList2Node1 = new ListNode(1, inputList2Node2);
		
		
		
		return Stream.of(
			Arguments.of(inputList1Node4, true), // single node
			Arguments.of(inputList1Node1, true), // 4 nodes, palindrome
			Arguments.of(inputList2Node1, false) // 5 nodes, none palindrome
		);
		
	}

}
