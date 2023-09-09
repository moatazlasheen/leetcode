package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MonitoringCamerasTest {
	
	
	private MonitoringCameras underTest = new MonitoringCameras();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(TreeNode root, int expected) {
		int actual = underTest.minCameraCover(root);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		TreeNode case1Tree1l3n2 = new TreeNode(0);
		TreeNode case1Tree1l3n1 = new TreeNode(0);
		TreeNode case1Tree1l2n1 = new TreeNode(0,case1Tree1l3n1, case1Tree1l3n2);
		TreeNode case1Tree1l1n1 = new TreeNode(0, case1Tree1l2n1, null);
		
		TreeNode case2Tree1l5n1 = new TreeNode(0);
		TreeNode case2Tree1l4n1 = new TreeNode(0, null, case2Tree1l5n1);
		TreeNode case2Tree1l3n1 = new TreeNode(0, case2Tree1l4n1, null);
		TreeNode case2Tree1l2n1 = new TreeNode(0, case2Tree1l3n1, null);
		TreeNode case2Tree1l1n1 = new TreeNode(0, case2Tree1l2n1, null);
		
		
		
		return Stream.of(
			Arguments.of(null, 0),
			Arguments.of(case1Tree1l1n1, 1),
			Arguments.of(case2Tree1l1n1, 2)
		);
	}

}
