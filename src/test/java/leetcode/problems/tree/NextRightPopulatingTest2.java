package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NextRightPopulatingTest2 {
	
	private NextRightPopulating2 unserTest = new NextRightPopulating2();
	
	
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
		Node t1l3n4 = new Node(7);
		Node t1l2n1 = new Node(2, t1l3n1, t1l3n2);
		Node t1l2n2 = new Node(3, null, t1l3n4);
		Node t1l1n1 = new Node(1, t1l2n1, t1l2n2);
		
		
		Node t1l3n1Result = new Node(4);
		Node t1l3n2Result = new Node(5);
		Node t1l3n4Result = new Node(7);
		t1l3n1Result.next = t1l3n2Result;
		t1l3n2Result.next = t1l3n4Result;
		Node t1l2n1Result = new Node(2, t1l3n1Result, t1l3n2Result);
		Node t1l2n2Result = new Node(3, null, t1l3n4Result);
		t1l2n1Result.next = t1l2n2Result;
		Node t1l1n1Result = new Node(1, t1l2n1Result, t1l2n2Result);
		
		
		return Stream.of(
			Arguments.of(t1l1n1, t1l1n1Result),
			Arguments.of(null, null)
		);
	}

}
