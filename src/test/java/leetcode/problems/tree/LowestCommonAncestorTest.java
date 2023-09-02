package leetcode.problems.tree;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LowestCommonAncestorTest {
	
	private LowestCommonAncestor unserTest = new LowestCommonAncestor();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, TreeNode p, TreeNode q, TreeNode expected) {
		TreeNode actual = unserTest.lowestCommonAncestor(root, p, q);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		
		TreeNode t1l4n1 = new TreeNode(4);
		TreeNode t1l4n2 = new TreeNode(7);
		TreeNode t1l3n1 = new TreeNode(6);
		TreeNode t1l3n2 = new TreeNode(2, t1l4n2, t1l4n1);
		TreeNode t1l3n3 = new TreeNode(0);
		TreeNode t1l3n4 = new TreeNode(8);
		TreeNode t1l2n1 = new TreeNode(5, t1l3n1, t1l3n2);
		TreeNode t1l2n2 = new TreeNode(1, t1l3n3, t1l3n4);
		TreeNode t1l1n1 = new TreeNode(3, t1l2n2, t1l2n1);
		
		
		
		
		
		
		
		return Stream.of(
			Arguments.of(t1l1n1, t1l1n1, t1l4n1, t1l1n1), // root is the one of the nodes 1
			Arguments.of(t1l1n1, t1l4n1, t1l1n1, t1l1n1), // root is the one of the nodes
			Arguments.of(t1l1n1, t1l3n1, t1l4n1, t1l2n1), 
			Arguments.of(t1l1n1, t1l3n3, t1l3n4, t1l2n2),
			Arguments.of(t1l1n1, t1l3n1, t1l3n4, t1l1n1)
			
		);
	}

}
