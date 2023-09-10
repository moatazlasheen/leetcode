package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InsertionInBSTTest {

	
	private InsertionInBST underTest = new InsertionInBST();
	private SameTree sameTree = new SameTree();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, int val,TreeNode expected) {
		TreeNode actual = underTest.insertIntoBST(root, val);
		// the implementation always puts the value as a new leaf node 
		// this is not the only solution, the value can be placed in place 
		// of an existing node and the existing node can be put in some other place
		// keeping in mind that the tree should still be a BST
		assertTrue(sameTree.isSameTree(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode case1L3n2 = new TreeNode(3);
		TreeNode case1L3n1 = new TreeNode(1);
		TreeNode case1L2n2 = new TreeNode(7);
		TreeNode case1L2n1 = new TreeNode(2, case1L3n1, case1L3n2);
		TreeNode case1L1n1 = new TreeNode(4, case1L2n1, case1L2n2);
		
		TreeNode case1L3n3Result = new TreeNode(5);
		TreeNode case1L3n2Result = new TreeNode(3);
		TreeNode case1L3n1Result = new TreeNode(1);
		TreeNode case1L2n2Result = new TreeNode(7, case1L3n3Result, null);
		TreeNode case1L2n1Result = new TreeNode(2, case1L3n1Result, case1L3n2Result);
		TreeNode case1L1n1Result = new TreeNode(4, case1L2n1Result, case1L2n2Result);
		
		return Stream.of(
			Arguments.of(case1L1n1, 5, case1L1n1Result)
		);
	}
}
