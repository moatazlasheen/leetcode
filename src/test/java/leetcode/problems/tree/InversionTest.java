package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InversionTest {
	
	
	private SameTree sameTree = new SameTree();
	private Inversion underTest = new Inversion();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode original, TreeNode expected) {
		TreeNode actual = underTest.invertTree(original);
		assertTrue(sameTree.isSameTree(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode case1Tree1l2n2 = new TreeNode(3);
		TreeNode case1Tree1l2n1 = new TreeNode(2);
		TreeNode case1Tree1l1n1 = new TreeNode(1, case1Tree1l2n1, case1Tree1l2n2);
		
		TreeNode case1Tree2l2n2 = new TreeNode(2);
		TreeNode case1Tree2l2n1 = new TreeNode(3);
		TreeNode case1Tree2l1n1 = new TreeNode(1, case1Tree2l2n1, case1Tree2l2n2);
		
		TreeNode case2Tree1l3n1 = new TreeNode(1);
		TreeNode case2Tree1l3n2 = new TreeNode(3);
		TreeNode case2Tree1l3n3 = new TreeNode(6);
		TreeNode case2Tree1l3n4 = new TreeNode(9);
		TreeNode case2Tree1l2n1 = new TreeNode(2, case2Tree1l3n1, case2Tree1l3n2);
		TreeNode case2Tree1l2n2 = new TreeNode(7, case2Tree1l3n3, case2Tree1l3n4);
		TreeNode case2Tree1l1n1 = new TreeNode(4, case2Tree1l2n1, case2Tree1l2n2);
		
		TreeNode case2Tree2l3n1 = new TreeNode(9);
		TreeNode case2Tree2l3n2 = new TreeNode(6);
		TreeNode case2Tree2l3n3 = new TreeNode(3);
		TreeNode case2Tree2l3n4 = new TreeNode(1);
		TreeNode case2Tree2l2n1 = new TreeNode(7, case2Tree2l3n1, case2Tree2l3n2);
		TreeNode case2Tree2l2n2 = new TreeNode(2, case2Tree2l3n3, case2Tree2l3n4);
		TreeNode case2Tree2l1n1 = new TreeNode(4, case2Tree2l2n1, case2Tree2l2n2);
		
		
		return Stream.of(
			Arguments.of(null, null),
			Arguments.of(case1Tree1l1n1, case1Tree2l1n1),
			Arguments.of(case2Tree1l1n1, case2Tree2l1n1)
		);
	}

}
