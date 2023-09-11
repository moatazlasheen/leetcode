package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortedArrayToBSTTest {

	
	private SortedArrayToBST underTest = new SortedArrayToBST();
	private SameTree sameTree = new SameTree();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] in, TreeNode expected) {
		TreeNode actual = underTest.sortedArrayToBST(in);
		
		// the implementation always puts the middle element as
		// root of the output tree and creates a BST from the left 
		// subarray and attaches it to the root, do the same for the 
		// right subtree, there could be other solutions
		
		// if the implementation changes, the test cases may fail although the solution is okay
		// a better assertion is to make sure that the actual is a valid BST having the same 
		// numbers mentioned in the original array,
		// i don't know how to do this in a simple way yet
		assertTrue(sameTree.isSameTree(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode case1L3n2 = new TreeNode(5);
		TreeNode case1L3n1 = new TreeNode(-10);
		TreeNode case1L2n2 = new TreeNode(9, case1L3n2, null);
		TreeNode case1L2n1 = new TreeNode(-3, case1L3n1, null);
		TreeNode case1L1n1 = new TreeNode(0, case1L2n1, case1L2n2);
		
		TreeNode case2L2n1 = new TreeNode(1);
		TreeNode case2L1n1 = new TreeNode(3, case2L2n1, null);
		
		return Stream.of(
			Arguments.of(new int [] {-10,-3,0,5,9}, case1L1n1),
			Arguments.of(new int [] {1,3}, case2L1n1)
		);
	}
}
