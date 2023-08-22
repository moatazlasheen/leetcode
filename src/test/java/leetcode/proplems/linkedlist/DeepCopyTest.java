package leetcode.proplems.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.linkedlist.DeepCopy;
import leetcode.problems.linkedlist.Node;

class DeepCopyTest {
	
	private DeepCopy underTest = new DeepCopy();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( Node head, Node expected ) {
		Node actual = underTest.copyRandomList(head);
		Node currentExpected = expected;
		Node currentActual = actual;
		while (currentExpected != null) {
			assertEquals(currentExpected.val, currentActual.val);
			assertNotEquals(currentExpected,currentActual);
			if ( currentExpected.next == null ) {
				assertNull(currentActual.next);
			} else {
				assertEquals(currentExpected.next.val, currentActual.next.val);
			}
			
			if ( currentExpected.random == null ) {
				assertNull(currentActual.random);
			} else {
				assertEquals(currentExpected.random.val, currentActual.random.val);
			}
			currentExpected = currentExpected.next;
			currentActual = currentActual.next;
		}
	}
	
	
	
	private static Stream<Arguments> testWithParams ( ) {
		
		// [node, random index] > next
		// [7,null] > [13,0] > [11,4] > [10,2] > [1,0]
		Node inputList1Node5 = new Node(1);
		Node inputList1Node4 = new Node(10,inputList1Node5);
		Node inputList1Node3 = new Node(11, inputList1Node4);
		Node inputList1Node2 = new Node(13, inputList1Node3);
		Node inputList1Node1 = new Node(7, inputList1Node2);
		inputList1Node2.random = inputList1Node1;
		inputList1Node3.random = inputList1Node5;
		inputList1Node4.random = inputList1Node3;
		inputList1Node5.random = inputList1Node1;
		
		// [7,null] > [13,0] > [11,4] > [10,2] > [1,0]
		Node outputList1Node5 = new Node(1);
		Node outputList1Node4 = new Node(10,inputList1Node5);
		Node outputList1Node3 = new Node(11, inputList1Node4);
		Node outputList1Node2 = new Node(13, inputList1Node3);
		Node outputList1Node1 = new Node(7, inputList1Node2);
		outputList1Node2.random = outputList1Node1;
		outputList1Node3.random = outputList1Node5;
		outputList1Node4.random = outputList1Node3;
		outputList1Node5.random = outputList1Node1;
		
		
		
		
		// [4,4] > [8,null] > [15,2] > [1,1] > [100,2]
		Node inputList2Node5 = new Node(100);
		Node inputList2Node4 = new Node(1,inputList2Node5);
		Node inputList2Node3 = new Node(15, inputList2Node4);
		Node inputList2Node2 = new Node(8, inputList2Node3);
		Node inputList2Node1 = new Node(4, inputList2Node2);
		inputList2Node1.random = inputList2Node5;
		inputList2Node3.random = inputList2Node3;
		inputList2Node4.random = inputList2Node2;
		inputList2Node5.random = inputList2Node3;
		
		// [4,4] > [8,null] > [15,2] > [1,1] > [100,2]
		Node outputList2Node5 = new Node(100);
		Node outputList2Node4 = new Node(1, outputList2Node5);
		Node outputList2Node3 = new Node(15, outputList2Node4);
		Node outputList2Node2 = new Node(8, outputList2Node3);
		Node outputList2Node1 = new Node(4, outputList2Node2);
		outputList2Node1.random = outputList2Node5;
		outputList2Node3.random = outputList2Node3;
		outputList2Node4.random = outputList2Node2;
		outputList2Node5.random = outputList2Node3;
		
		
		
		return Stream.of(
			Arguments.of(inputList1Node1, outputList1Node1),
			Arguments.of(inputList2Node1, outputList2Node1)
		);
		
	}

}
