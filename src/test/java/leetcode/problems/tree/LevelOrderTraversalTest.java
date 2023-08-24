package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LevelOrderTraversalTest {
	
	private LevelOrderTraversal underTest = new LevelOrderTraversal();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, List<List<Integer>> expected) {
		List<List<Integer>> actual = underTest.levelOrder(root);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode list1L3Node1 = new TreeNode(15); 
		TreeNode list1L3Node2 = new TreeNode(7);
		TreeNode list1L2Node1 = new TreeNode(9);
		TreeNode list1L2Node2 = new TreeNode(2, list1L3Node1, list1L3Node2);
		TreeNode list1L1Node1 = new TreeNode(3, list1L2Node1, list1L2Node2);
		
		List<List<Integer>> tree1Out = Arrays.asList(Arrays.asList(3), Arrays.asList(9,2), 
				Arrays.asList(15,7));
		
		
		return Stream.of(
			Arguments.of(null, new ArrayList<List<Integer>>()),
			Arguments.of(list1L1Node1, tree1Out),
			Arguments.of(list1L3Node1, Arrays.asList(Arrays.asList(15)))
		);
	}
	
}
