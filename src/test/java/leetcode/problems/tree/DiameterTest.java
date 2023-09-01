package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DiameterTest {
	
	private Diameter unserTest = new Diameter();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, int expected) {
		int actual = unserTest.diameterOfBinaryTree(root);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		
		TreeNode t1l3n1 = new TreeNode(4);
		TreeNode t1l3n2 = new TreeNode(5);
		TreeNode t1l2n1 = new TreeNode(2, t1l3n1, t1l3n2);
		TreeNode t1l2n2 = new TreeNode(3);
		TreeNode t1l1n1 = new TreeNode(1, t1l2n1, t1l2n2);
		
		
		TreeNode t2l2n1 = new TreeNode(2);
		TreeNode t2l1n1 = new TreeNode(1, t2l2n1, null);
		
		
		
		return Stream.of(
			Arguments.of(t1l1n1, 3),
			Arguments.of(t2l1n1, 1)
		);
	}

}
