package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import leetcode.problems.linkedlist.ListNode;
import leetcode.problems.linkedlist.Rotation;

class RotationTest {
	
	private Rotation underTest = new Rotation();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode head, int k, ListNode expectedHead ) {
		ListNode actual = underTest.rotateRight(head, k);
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
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList1Node5 = new ListNode(5);
		ListNode inputList1Node4 = new ListNode(4, inputList1Node5);
		ListNode inputList1Node3 = new ListNode(3, inputList1Node4);
		ListNode inputList1Node2 = new ListNode(2, inputList1Node3);
		ListNode inputList1Node1 = new ListNode(1, inputList1Node2);
		
		
		// 2 > 3 > 4 > 5 > 1 , rotated by 1
		ListNode outputList1Node5 = new ListNode(4);
		ListNode outputList1Node4 = new ListNode(3, outputList1Node5);
		ListNode outputList1Node3 = new ListNode(2, outputList1Node4);
		ListNode outputList1Node2 = new ListNode(1, outputList1Node3);
		ListNode outputList1Node1 = new ListNode(5, outputList1Node2);
		
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList2Node5 = new ListNode(5);
		ListNode inputList2Node4 = new ListNode(4, inputList2Node5);
		ListNode inputList2Node3 = new ListNode(3, inputList2Node4);
		ListNode inputList2Node2 = new ListNode(2, inputList2Node3);
		ListNode inputList2Node1 = new ListNode(1, inputList2Node2);
		
		// 3 > 4 > 5 > 1 > 2 , rotated by 2
		ListNode outputList2Node5 = new ListNode(3);
		ListNode outputList2Node4 = new ListNode(2, outputList2Node5);
		ListNode outputList2Node3 = new ListNode(1, outputList2Node4);
		ListNode outputList2Node2 = new ListNode(5, outputList2Node3);
		ListNode outputList2Node1 = new ListNode(4, outputList2Node2);
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList3Node5 = new ListNode(5);
		ListNode inputList3Node4 = new ListNode(4, inputList3Node5);
		ListNode inputList3Node3 = new ListNode(3, inputList3Node4);
		ListNode inputList3Node2 = new ListNode(2, inputList3Node3);
		ListNode inputList3Node1 = new ListNode(1, inputList3Node2);
		
		// 3 > 4 > 5 > 1 > 2 , rotated by 8
		ListNode outputList3Node5 = new ListNode(2);
		ListNode outputList3Node4 = new ListNode(1, outputList3Node5);
		ListNode outputList3Node3 = new ListNode(5, outputList3Node4);
		ListNode outputList3Node2 = new ListNode(4, outputList3Node3);
		ListNode outputList3Node1 = new ListNode(3, outputList3Node2);
		
		
		
		
		
		
		return Stream.of(
			Arguments.of(null,0, null), // zero length
			Arguments.of(inputList1Node1, 0, inputList1Node1), // rotated by zero
			Arguments.of(inputList1Node1, 1, outputList1Node1), // rotated by one
			Arguments.of(inputList2Node1, 2, outputList2Node1), // rotated by two
			Arguments.of(inputList3Node1, 8, outputList3Node1) // rotated by eight
		);
		
	}

}
