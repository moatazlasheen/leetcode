package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.DuplicateRemoving;
import leetcode.problems.linkedlist.ListNode;

class DuplicateRemovingTest {
	
	private DuplicateRemoving underTest = new DuplicateRemoving();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode head, ListNode expectedHead ) {
		ListNode actual = underTest.deleteDuplicates(head);
		ListNode currExpeted = expectedHead;
		ListNode currActual = actual;
		
		
		if ( currExpeted != null ) {
			while (currExpeted.next != null ) {
				currExpeted = currExpeted.next;
				currActual = currActual.next;
				assertEquals(currExpeted.val, currActual.val);
			}
		}
	}
	
	
	
	private static Stream<Arguments> testWithParams ( ) {
		
		
		// 1 > 1 > 3 > 3 > 5
		ListNode inputList1Node5 = new ListNode(5);
		ListNode inputList1Node4 = new ListNode(3, inputList1Node5);
		ListNode inputList1Node3 = new ListNode(3, inputList1Node4);
		ListNode inputList1Node2 = new ListNode(1, inputList1Node3);
		ListNode inputList1Node1 = new ListNode(1, inputList1Node2);
		
		
		
		// 1 > 3 > 5
		ListNode outList1Node3 = new ListNode(5);
		ListNode outList1Node2 = new ListNode(3, outList1Node3);
		ListNode outList1Node1 = new ListNode(1, outList1Node2);
		
		
		
		// 1 > 2 > 3 > 30
		ListNode inputList2Node4 = new ListNode(30);
		ListNode inputList2Node3 = new ListNode(3, inputList2Node4);
		ListNode inputList2Node2 = new ListNode(2, inputList2Node3);
		ListNode inputList2Node1 = new ListNode(1, inputList2Node2);
		
		
		
		return Stream.of(
			Arguments.of(null, null), // zero length
			Arguments.of(inputList1Node5, inputList1Node5), // only one item
			Arguments.of(inputList1Node1, outList1Node1), // has some duplication
			Arguments.of(inputList2Node1, inputList2Node1) // has no duplications
		);
		
	}

}
