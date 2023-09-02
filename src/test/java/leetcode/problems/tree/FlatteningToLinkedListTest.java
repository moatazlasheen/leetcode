package leetcode.problems.tree;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FlatteningToLinkedListTest {
	
	private FlatteningToLinkedList unserTest = new FlatteningToLinkedList();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, TreeNode expected) {
		unserTest.flatten(root);
		if (root == null) {
			assertNull(expected);
		} else if (root.left == null && root.right == null) {
			assertEquals(root.val, expected.val);
			assertNull(expected.left);
			assertNull(expected.right);
		} else {
			TreeNode expectedCurrent = expected;
			TreeNode actualCurrent = root;
			assertEquals(expectedCurrent.val, actualCurrent.val);
			assertNull(expected.left);
			while (expectedCurrent.right != null) {
				expectedCurrent = expectedCurrent.right;
				actualCurrent = actualCurrent.right;
				assertEquals(expectedCurrent.val, actualCurrent.val);
				assertNull(expected.left);
			}
		}
	}
	
	private static Stream<Arguments> testWithParams() {
		
		
		TreeNode t1l3n1 = new TreeNode(3);
		TreeNode t1l3n2 = new TreeNode(4);
		TreeNode t1l3n3 = new TreeNode(6);
		TreeNode t1l2n1 = new TreeNode(2, t1l3n1, t1l3n2);
		TreeNode t1l2n2 = new TreeNode(5, null, t1l3n3);
		TreeNode t1l1n1 = new TreeNode(1, t1l2n1, t1l2n2);
		
		TreeNode t1l6n1Result = new TreeNode(6);
		TreeNode t1l5n1Result = new TreeNode(5, null, t1l6n1Result);
		TreeNode t1l4n1Result = new TreeNode(4, null, t1l5n1Result);
		TreeNode t1l3n1Result = new TreeNode(3, null, t1l4n1Result);
		TreeNode t1l2n1Result = new TreeNode(2, null, t1l3n1Result);
		TreeNode t1l1n1Result = new TreeNode(1, null, t1l2n1Result);
		
		
		
		
		
		return Stream.of(
			Arguments.of(t1l1n1, t1l1n1Result),
			Arguments.of(t1l3n1, t1l3n1)
		);
	}

}
