package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.ListNode;
import leetcode.problems.linkedlist.Reordering;

class ReorderingTest {
	
	private Reordering underTest = new Reordering();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode head, ListNode expectedHead ) {
		underTest.reorderList(head);
		ListNode currExpeted = expectedHead;
		ListNode currActual = head;
		
		
		if ( currExpeted != null ) {
			while (currExpeted.next != null ) {
				currExpeted = currExpeted.next;
				currActual = currActual.next;
				assertEquals(currExpeted.val, currActual.val);
			}
		}
	}
	
	
	
	private static Stream<Arguments> testWithParams ( ) {
		
		
		// 1 > 2 > 3 > 4
		ListNode inputList1Node4 = new ListNode(4);
		ListNode inputList1Node3 = new ListNode(3, inputList1Node4);
		ListNode inputList1Node2 = new ListNode(2, inputList1Node3);
		ListNode inputList1Node1 = new ListNode(1, inputList1Node2);
		
		
		
		// 1 > 4 > 2 > 3
		ListNode outList1Node4 = new ListNode(3);
		ListNode outList1Node3 = new ListNode(2, outList1Node4);
		ListNode outList1Node2 = new ListNode(4, outList1Node3);
		ListNode outList1Node1 = new ListNode(1, outList1Node2);
		
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList2Node5 = new ListNode(5);
		ListNode inputList2Node4 = new ListNode(4, inputList2Node5);
		ListNode inputList2Node3 = new ListNode(3, inputList2Node4);
		ListNode inputList2Node2 = new ListNode(2, inputList2Node3);
		ListNode inputList2Node1 = new ListNode(1, inputList2Node2);
		
		// 1 > 5 > 2 > 4 > 3
		ListNode outputList2Node5 = new ListNode(3);
		ListNode outputList2Node4 = new ListNode(4, outputList2Node5);
		ListNode outputList2Node3 = new ListNode(2, outputList2Node4);
		ListNode outputList2Node2 = new ListNode(5, outputList2Node3);
		ListNode outputList2Node1 = new ListNode(1, outputList2Node2);
		
		
		// 1 > 2
		ListNode inputList3Node2 = new ListNode(2);
		ListNode inputList3Node1 = new ListNode(1, inputList3Node2);
		
		
		// 1 > 2 > 3 > 4 > 5 > 6 > 7
		ListNode inputList4Node7 = new ListNode(7);
		ListNode inputList4Node6 = new ListNode(6, inputList4Node7);
		ListNode inputList4Node5 = new ListNode(5, inputList4Node6);
		ListNode inputList4Node4 = new ListNode(4, inputList4Node5);
		ListNode inputList4Node3 = new ListNode(3, inputList4Node4);
		ListNode inputList4Node2 = new ListNode(2, inputList4Node3);
		ListNode inputList4Node1 = new ListNode(1, inputList4Node2);
		
		
		
		// 1 > 2 > 3 > 4 > 5 > 6 > 7
		ListNode outputList4Node7 = new ListNode(4);
		ListNode outputList4Node6 = new ListNode(5, outputList4Node7);
		ListNode outputList4Node5 = new ListNode(3, outputList4Node6);
		ListNode outputList4Node4 = new ListNode(6, outputList4Node5);
		ListNode outputList4Node3 = new ListNode(2, outputList4Node4);
		ListNode outputList4Node2 = new ListNode(7, outputList4Node3);
		ListNode outputList4Node1 = new ListNode(1, outputList4Node2);
		
		
		
		
		return Stream.of(
			Arguments.of(inputList1Node1, outList1Node1), // even length
			Arguments.of(inputList2Node1, outputList2Node1), // odd length
			Arguments.of(inputList3Node1, inputList3Node1),
			Arguments.of(inputList4Node1, outputList4Node1)
		);
		
	}

}
