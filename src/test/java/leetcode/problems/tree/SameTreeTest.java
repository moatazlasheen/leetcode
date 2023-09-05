package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SameTreeTest {
	
	
	private SameTree underTest = new SameTree();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode p, TreeNode q, boolean expected) {
		boolean actual = underTest.isSameTree(p, q);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode case1Tree1l2n2 = new TreeNode(3);
		TreeNode case1Tree1l2n1 = new TreeNode(2);
		TreeNode case1Tree1l1n1 = new TreeNode(1, case1Tree1l2n1, case1Tree1l2n2);
		
		TreeNode case1Tree2l2n2 = new TreeNode(3);
		TreeNode case1Tree2l2n1 = new TreeNode(2);
		TreeNode case1Tree2l1n1 = new TreeNode(1, case1Tree2l2n1, case1Tree2l2n2);
		
		TreeNode case2Tree1l2n1 = new TreeNode(2);
		TreeNode case2Tree1l1n1 = new TreeNode(1, case2Tree1l2n1, null);
		
		TreeNode case2Tree2l2n1 = new TreeNode(2);
		TreeNode case2Tree2l1n1 = new TreeNode(1, null, case2Tree2l2n1);
		
		
		TreeNode case3Tree1l2n2 = new TreeNode(3);
		TreeNode case3Tree1l2n1 = new TreeNode(2);
		TreeNode case3Tree1l1n1 = new TreeNode(1, case3Tree1l2n1, case3Tree1l2n2);
		
		TreeNode case3Tree2l2n2 = new TreeNode(2);
		TreeNode case3Tree2l2n1 = new TreeNode(3);
		TreeNode case3Tree2l1n1 = new TreeNode(1, case3Tree2l2n1, case3Tree2l2n2);
		
		
		return Stream.of(
			Arguments.of(null, null, true),	
			Arguments.of(null, case1Tree2l1n1, false),
			Arguments.of(case1Tree1l1n1, case1Tree2l1n1, true),
			Arguments.of(case2Tree1l1n1, case2Tree2l1n1, false),
			Arguments.of(case3Tree1l1n1, case3Tree2l1n1, false)
		);
	}

}
