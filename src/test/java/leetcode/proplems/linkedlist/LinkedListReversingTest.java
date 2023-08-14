package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.LinkedListReversing;
import leetcode.problems.linkedlist.ListNode;

class LinkedListReversingTest {
	
	private LinkedListReversing underTest = new LinkedListReversing();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode givenHead, ListNode expectedReversedHead ) {
		ListNode actual = underTest.reverseList(givenHead);
		
		ListNode p1 = actual;
		ListNode p2 = expectedReversedHead;
		
		while ( p2 != null ) {
			assertEquals(p1.val, p2.val);
			p1 = p1.next;
			p2 = p2.next;
		}
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList1Node5 = new ListNode(5);
		ListNode inputList1Node4 = new ListNode(4, inputList1Node5);
		ListNode inputList1Node3 = new ListNode(3, inputList1Node4);
		ListNode inputList1Node2 = new ListNode(2, inputList1Node3);
		ListNode inputList1Node1 = new ListNode(1, inputList1Node2);
		
		
		
		// 5 > 4 > 3 > 2 > 1
		ListNode outList1Node5 = new ListNode(1);
		ListNode outList1Node4 = new ListNode(2, outList1Node5);
		ListNode outList1Node3 = new ListNode(3, outList1Node4);
		ListNode outList1Node2 = new ListNode(4, outList1Node3);
		ListNode outList1Node1 = new ListNode(5, outList1Node2);
		
		
		
		// 25 > 18 > 30
		ListNode inputList2Node3 = new ListNode(30);
		ListNode inputList2Node2 = new ListNode(18, inputList2Node3);
		ListNode inputList2Node1 = new ListNode(25, inputList2Node2);
		
		
		
		// 30 > 18 > 25
		ListNode outList2Node3 = new ListNode(25);
		ListNode outList2Node2 = new ListNode(18,outList2Node3);
		ListNode outList2Node1 = new ListNode(30, outList2Node2);
		
		return Stream.of(
			Arguments.of(null, null), // zero length
			Arguments.of(inputList1Node5, inputList1Node5), // only one item
			Arguments.of(inputList1Node1, outList1Node1), // the whole list (5 items)
			Arguments.of(inputList2Node1, outList2Node1) // the whole list (3 items)
		);
		
	}
}
