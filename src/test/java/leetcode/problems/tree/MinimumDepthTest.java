package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MinimumDepthTest {
	
	private MinimumDepth unserTest = new MinimumDepth();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, int expected) {
		int actual = unserTest.minDepth(root);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		
		TreeNode t1l3n1 = new TreeNode(15);
		TreeNode t1l3n2 = new TreeNode(7);
		TreeNode t1l2n1 = new TreeNode(9);
		TreeNode t1l2n2 = new TreeNode(20, t1l3n1, t1l3n2);
		TreeNode t1l1n1 = new TreeNode(3, t1l2n1, t1l2n2);
		
		
		TreeNode t2l5n1 = new TreeNode(6);
		TreeNode t2l4n1 = new TreeNode(5, null, t2l5n1);
		TreeNode t2l3n1 = new TreeNode(4, null, t2l4n1);
		TreeNode t2l2n1 = new TreeNode(3, null, t2l3n1);
		TreeNode t2l1n1 = new TreeNode(2, null, t2l2n1);
		
		
		
		return Stream.of(
			Arguments.of(t1l1n1, 2),
			Arguments.of(t2l1n1, 5)
		);
	}

}
