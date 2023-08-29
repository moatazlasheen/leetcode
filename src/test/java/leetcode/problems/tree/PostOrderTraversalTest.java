package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PostOrderTraversalTest {
	
	private PostOrderTraversal underTest = new PostOrderTraversal();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, List<Integer> expected) {
		List<Integer> actual = underTest.postorderTraversal(root);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode list1L3Node1 = new TreeNode(3);
		TreeNode list1L2Node1 = new TreeNode(2,list1L3Node1, null);
		TreeNode list1L1Node1 = new TreeNode(1, null, list1L2Node1);
		
		List<Integer> tree1Out = Arrays.asList(3,2,1);
		
		
		return Stream.of(
			Arguments.of(null, new ArrayList<Integer>()),
			Arguments.of(list1L1Node1, tree1Out),
			Arguments.of(list1L2Node1, Arrays.asList(3,2)),
			Arguments.of(list1L3Node1, Arrays.asList(3))
		);
	}
	
}
