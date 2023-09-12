package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PreOrderTraversalToBSTTest {

	
	private PreOrderTraversalToBST underTest = new PreOrderTraversalToBST();
	private SameTree sameTree = new SameTree();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] in, TreeNode expected) {
		TreeNode actual = underTest.bstFromPreorder(in);
		
		assertTrue(sameTree.isSameTree(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode case1L3n3 = new TreeNode(12);
		TreeNode case1L3n2 = new TreeNode(7);
		TreeNode case1L3n1 = new TreeNode(1);
		TreeNode case1L2n2 = new TreeNode(10, null, case1L3n3);
		TreeNode case1L2n1 = new TreeNode(5, case1L3n1, case1L3n2);
		TreeNode case1L1n1 = new TreeNode(8, case1L2n1, case1L2n2);
		
		TreeNode case2L2n1 = new TreeNode(3);
		TreeNode case2L1n1 = new TreeNode(1, null, case2L2n1);
		
		TreeNode case3L2n1 = new TreeNode(2);
		TreeNode case3L1n1 = new TreeNode(4, case3L2n1, null);
		
		TreeNode case4L4n1 = new TreeNode(12, null, null);
		TreeNode case4L3n1 = new TreeNode(19, case4L4n1, null);
		TreeNode case4L2n1 = new TreeNode(20, case4L3n1, null);
		TreeNode case4L1n1 = new TreeNode(7, null, case4L2n1);
		
		return Stream.of(
			Arguments.of(new int [] {8,5,1,7,10,12}, case1L1n1),
			Arguments.of(new int [] {1,3}, case2L1n1),
			Arguments.of(new int [] {4,2}, case3L1n1),
			Arguments.of(new int [] {7,20,19,12},case4L1n1)
		);
	}
}
