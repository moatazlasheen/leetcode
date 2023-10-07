package leetcode.problems.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DeepCloneTest {

	private DeepClone underTest = new DeepClone();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(Node node, Node expected) {
		Node actual = underTest.cloneGraph(node);
		Map<Node, Node> seen = new HashMap<>();
		assertEqualGraphs(expected, actual, seen);
		
	}
	

	private void assertEqualGraphs(Node expected, Node actual, Map<Node, Node> seen) {
		if (expected == null && actual == null) {
			return;
		}
		if (seen.containsKey(expected)) {
			return;
		}
		assertEquals(expected.val, actual.val);
		seen.put(expected, actual);
		for (int i = 0; i < expected.neighbors.size(); i++) {
			assertEqualGraphs(expected.neighbors.get(i), actual.neighbors.get(i), seen);
		}
	}


	private static Stream<Arguments> testWithParams() {
		
		Node testCase1Node1 = new Node(1);
		Node testCase1Node2 = new Node(2);
		Node testCase1Node3 = new Node(3);
		Node testCase1Node4 = new Node(4);
		
		testCase1Node1.neighbors.add(testCase1Node2);
		testCase1Node1.neighbors.add(testCase1Node4);
		testCase1Node2.neighbors.add(testCase1Node1);
		testCase1Node2.neighbors.add(testCase1Node3);
		testCase1Node3.neighbors.add(testCase1Node2);
		testCase1Node3.neighbors.add(testCase1Node4);
		testCase1Node4.neighbors.add(testCase1Node1);
		testCase1Node3.neighbors.add(testCase1Node3);
		
		Node testCase1ResultNode1 = new Node(1);
		Node testCase1ResultNode2 = new Node(2);
		Node testCase1ResultNode3 = new Node(3);
		Node testCase1ResultNode4 = new Node(4);
		
		testCase1ResultNode1.neighbors.add(testCase1Node2);
		testCase1ResultNode1.neighbors.add(testCase1Node4);
		testCase1ResultNode2.neighbors.add(testCase1Node1);
		testCase1ResultNode2.neighbors.add(testCase1Node3);
		testCase1ResultNode3.neighbors.add(testCase1Node2);
		testCase1ResultNode3.neighbors.add(testCase1Node4);
		testCase1ResultNode4.neighbors.add(testCase1Node1);
		testCase1ResultNode3.neighbors.add(testCase1Node3);
		
		
		
		return Stream.of(
			Arguments.of(null, null),
			Arguments.of(new Node(1), new Node(1)),
			Arguments.of(testCase1Node1, testCase1ResultNode1)
		);
	}
}
