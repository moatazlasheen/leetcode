package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NextRightPopulatingTest {
	
	private NextRightPopulating unserTest = new NextRightPopulating();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(Node root, Node expected) {
		Node actual = unserTest.connect(root);
		if (expected == null) {
			assertNull(actual);
		} else if (expected.left == null && expected.right == null && expected.next == null ) {
			// leaf node
			assertNull(actual.left);
			assertNull(actual.right);
			assertNull(actual.next);
		} else {
			assertTrue(compareTrees(expected, actual));
		}
	}
	
	private boolean compareTrees(Node expected, Node actual) {
		if (expected == null && actual == null) {
			return true;
		}
		if (expected == null && actual != null) {
			return false;
		}
		if (expected != null && actual == null) {
			return false;
		}
		if (expected.val != actual.val) {
			return false;
		}
		return compareTrees(expected.left, actual.left) && 
				compareTrees(expected.right, actual.right) &&
				compareTrees(expected.next, actual.next);
	}

	private static Stream<Arguments> testWithParams() {
		
		
		Node t1l3n1 = new Node(4);
		Node t1l3n2 = new Node(5);
		Node t1l3n3 = new Node(6);
		Node t1l3n4 = new Node(7);
		Node t1l2n1 = new Node(2, t1l3n1, t1l3n2);
		Node t1l2n2 = new Node(3, t1l3n3, t1l3n4);
		Node t1l1n1 = new Node(1, t1l2n1, t1l2n2);
		
		
		Node t1l3n1Result = new Node(4);
		Node t1l3n2Result = new Node(5);
		Node t1l3n3Result = new Node(6);
		Node t1l3n4Result = new Node(7);
		t1l3n1Result.next = t1l3n2Result;
		t1l3n2Result.next = t1l3n3Result;
		t1l3n3Result.next = t1l3n4Result;
		Node t1l2n1Result = new Node(2, t1l3n1Result, t1l3n2Result);
		Node t1l2n2Result = new Node(3, t1l3n3Result, t1l3n4Result);
		t1l2n1Result.next = t1l2n2Result;
		Node t1l1n1Result = new Node(1, t1l2n1Result, t1l2n2Result);
		
		Node t2l4n1 = new Node(15);
		Node t2l4n2 = new Node(14);
		Node t2l4n3 = new Node(13);
		Node t2l4n4 = new Node(12);
		Node t2l4n5 = new Node(11);
		Node t2l4n6 = new Node(10);
		Node t2l4n7 = new Node(9);
		Node t2l4n8 = new Node(8);
		Node t2l3n1 = new Node(4, t2l4n8, t2l4n7);
		Node t2l3n2 = new Node(5, t2l4n6, t2l4n5);
		Node t2l3n3 = new Node(6, t2l4n4, t2l4n3);
		Node t2l3n4 = new Node(7, t2l4n2, t2l4n1);
		Node t2l2n1 = new Node(2, t2l3n1, t2l3n2);
		Node t2l2n2 = new Node(3, t2l3n3, t2l3n4);
		Node t2l1n1 = new Node(1, t2l2n1, t2l2n2);
		
		
		Node t2l4n1Result = new Node(15);
		Node t2l4n2Result = new Node(14);
		Node t2l4n3Result = new Node(13);
		Node t2l4n4Result = new Node(12);
		Node t2l4n5Result = new Node(11);
		Node t2l4n6Result = new Node(10);
		Node t2l4n7Result = new Node(9);
		Node t2l4n8Result = new Node(8);
		t2l4n8Result.next = t2l4n7Result;
		t2l4n7Result.next = t2l4n6Result;
		t2l4n6Result.next = t2l4n5Result;
		t2l4n5Result.next = t2l4n4Result;
		t2l4n4Result.next = t2l4n3Result;
		t2l4n3Result.next = t2l4n2Result;
		t2l4n2Result.next = t2l4n1Result;
		Node t2l3n1Result = new Node(4, t2l4n8Result, t2l4n7Result);
		Node t2l3n2Result = new Node(5, t2l4n6Result, t2l4n5Result);
		Node t2l3n3Result = new Node(6, t2l4n4Result, t2l4n3Result);
		Node t2l3n4Result = new Node(7, t2l4n2Result, t2l4n1Result);
		t2l3n1Result.next = t2l3n2Result;
		t2l3n2Result.next = t2l3n3Result;
		t2l3n3Result.next = t2l3n4Result;
		Node t2l2n1Result = new Node(2, t2l3n1Result, t2l3n2Result);
		Node t2l2n2Result = new Node(3, t2l3n3Result, t2l3n4Result);
		t2l2n1Result.next = t2l2n2Result;
		Node t2l1n1Result = new Node(1, t2l2n1Result, t2l2n2Result);
		
		
		
		return Stream.of(
			Arguments.of(t1l1n1, t1l1n1Result),
			Arguments.of(null, null),
			Arguments.of(t1l3n1, t1l3n1),
			Arguments.of(t2l1n1, t2l1n1Result)
		);
	}

}
