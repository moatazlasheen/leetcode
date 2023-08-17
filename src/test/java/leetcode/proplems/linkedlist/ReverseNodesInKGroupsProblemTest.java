package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.ListNode;
import leetcode.problems.linkedlist.ReverseNodesInKGroupsProblem;

public class ReverseNodesInKGroupsProblemTest {
	
	private ReverseNodesInKGroupsProblem underTest = new ReverseNodesInKGroupsProblem();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( ListNode givenHead, int k, ListNode expectedReversedHead ) {
		ListNode actual = underTest.reverseKGroup(givenHead,k);
		
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
		
		
		
		// 2 > 1 > 4 > 3 > 5
		ListNode outList1Node5 = new ListNode(5);
		ListNode outList1Node4 = new ListNode(3, outList1Node5);
		ListNode outList1Node3 = new ListNode(4, outList1Node4);
		ListNode outList1Node2 = new ListNode(1, outList1Node3);
		ListNode outList1Node1 = new ListNode(2, outList1Node2);
		
		
		// 1 > 2 > 3 > 4 > 5
		ListNode inputList2Node5 = new ListNode(5);
		ListNode inputList2Node4 = new ListNode(4, inputList2Node5);
		ListNode inputList2Node3 = new ListNode(3, inputList2Node4);
		ListNode inputList2Node2 = new ListNode(2, inputList2Node3);
		ListNode inputList2Node1 = new ListNode(1, inputList2Node2);
		
		
		
		// 2 > 1 > 4 > 3 > 5
		ListNode outList2Node5 = new ListNode(5);
		ListNode outList2Node4 = new ListNode(4, outList2Node5);
		ListNode outList2Node3 = new ListNode(1, outList2Node4);
		ListNode outList2Node2 = new ListNode(2, outList2Node3);
		ListNode outList2Node1 = new ListNode(3, outList2Node2);
		
		
		// 1 > 2 > 3 > 4
		ListNode inputList3Node4 = new ListNode(4);
		ListNode inputList3Node3 = new ListNode(3, inputList3Node4);
		ListNode inputList3Node2 = new ListNode(2, inputList3Node3);
		ListNode inputList3Node1 = new ListNode(1, inputList3Node2);
		
		
		
		// 1 > 2 > 3 > 4
		ListNode outList3Node4 = new ListNode(1);
		ListNode outList3Node3 = new ListNode(2, outList3Node4);
		ListNode outList3Node2 = new ListNode(3, outList3Node3);
		ListNode outList3Node1 = new ListNode(4, outList3Node2);
		
		return Stream.of(
			Arguments.of(inputList1Node5, 1, inputList1Node5), // one element groups
			Arguments.of(inputList1Node1, 2, outList1Node1), // two elements groups
			Arguments.of(inputList2Node1, 3, outList2Node1), // three elements groups
			Arguments.of(inputList3Node1, 4, outList3Node1) // 4 elements groups, whole list
		);
		
	}
}
