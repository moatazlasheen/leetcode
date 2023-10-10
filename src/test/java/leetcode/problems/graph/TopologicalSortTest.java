package leetcode.problems.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TopologicalSortTest {

	
	@ParameterizedTest
	@MethodSource
	void testWithParams( int v, ArrayList<ArrayList<Integer>> adjacencyList) {
		int [] actual = TopologicalSort.topoSort(v, adjacencyList);
		assertEquals(v, actual.length);
		Set<Integer> unique = new HashSet<>();
		for (int i = 0; i < actual.length; i++) {
			assertTrue(unique.add(actual[i]));
		}
		assertValidTopologicalSort(actual, adjacencyList, v);
	}
	
	private void assertValidTopologicalSort(int[] actual, ArrayList<ArrayList<Integer>> adj, int v) {
		int [] indegree = new int [v];
		for (int i = 0; i < adj.size(); i++) {
        	for (int j = 0; j < adj.get(i).size(); j++) {
        		indegree[adj.get(i).get(j)]++;
        	}
        }
		
		for (int i = 0; i< actual.length; i++)  {
			assertEquals(0, indegree[actual[i]]);
			for (int a : adj.get(actual[i])) {
				indegree[a]--;
			}
		}
	}

	private static Stream<Arguments> testWithParams() {
		
		ArrayList<ArrayList<Integer>> testCase1Input = new ArrayList<>();
		ArrayList<Integer> testCase1Node0AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase1Node1AdjancencyList = new ArrayList<>();
		testCase1Node1AdjancencyList.add(0);
		ArrayList<Integer> testCase1Node2AdjancencyList = new ArrayList<>();
		testCase1Node2AdjancencyList.add(0);
		ArrayList<Integer> testCase1Node3AdjancencyList = new ArrayList<>();
		testCase1Node3AdjancencyList.add(0);
		testCase1Input.add(testCase1Node0AdjancencyList);
		testCase1Input.add(testCase1Node1AdjancencyList);
		testCase1Input.add(testCase1Node2AdjancencyList);
		testCase1Input.add(testCase1Node3AdjancencyList);
		
		
		ArrayList<ArrayList<Integer>> testCase2Input = new ArrayList<>();
		ArrayList<Integer> testCase2Node0AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase2Node1AdjancencyList = new ArrayList<>();
		testCase2Node1AdjancencyList.add(3);
		ArrayList<Integer> testCase2Node2AdjancencyList = new ArrayList<>();
		testCase2Node2AdjancencyList.add(3);
		ArrayList<Integer> testCase2Node3AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase2Node4AdjancencyList = new ArrayList<>();
		testCase2Node4AdjancencyList.add(0);
		testCase2Node4AdjancencyList.add(1);
		ArrayList<Integer> testCase2Node5AdjancencyList = new ArrayList<>();
		testCase2Node5AdjancencyList.add(0);
		testCase2Node5AdjancencyList.add(2);
		
		testCase2Input.add(testCase2Node0AdjancencyList);
		testCase2Input.add(testCase2Node1AdjancencyList);
		testCase2Input.add(testCase2Node2AdjancencyList);
		testCase2Input.add(testCase2Node3AdjancencyList);
		testCase2Input.add(testCase2Node4AdjancencyList);
		testCase2Input.add(testCase2Node5AdjancencyList);
		
		
		ArrayList<ArrayList<Integer>> testCase3Input = new ArrayList<>();
		ArrayList<Integer> testCase3Node0AdjancencyList = new ArrayList<>();
		testCase3Node0AdjancencyList.add(3);
		ArrayList<Integer> testCase3Node1AdjancencyList = new ArrayList<>();
		testCase3Node1AdjancencyList.add(0);
		testCase3Node1AdjancencyList.add(3);
		ArrayList<Integer> testCase3Node2AdjancencyList = new ArrayList<>();
		testCase3Node2AdjancencyList.add(1);
		testCase3Node2AdjancencyList.add(3);
		ArrayList<Integer> testCase3Node3AdjancencyList = new ArrayList<>();
		testCase3Node3AdjancencyList.add(6);
		ArrayList<Integer> testCase3Node4AdjancencyList = new ArrayList<>();
		testCase3Node4AdjancencyList.add(1);
		testCase3Node4AdjancencyList.add(2);
		ArrayList<Integer> testCase3Node5AdjancencyList = new ArrayList<>();
		testCase3Node5AdjancencyList.add(4);
		ArrayList<Integer> testCase3Node6AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase3Node7AdjancencyList = new ArrayList<>();
		testCase3Node7AdjancencyList.add(2);
		testCase3Node7AdjancencyList.add(4);
		ArrayList<Integer> testCase3Node8AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase3Node9AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase3Node10AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase3Node11AdjancencyList = new ArrayList<>();
		testCase3Node11AdjancencyList.add(8);
		
		testCase3Input.add(testCase3Node0AdjancencyList);
		testCase3Input.add(testCase3Node1AdjancencyList);
		testCase3Input.add(testCase3Node2AdjancencyList);
		testCase3Input.add(testCase3Node3AdjancencyList);
		testCase3Input.add(testCase3Node4AdjancencyList);
		testCase3Input.add(testCase3Node5AdjancencyList);
		testCase3Input.add(testCase3Node6AdjancencyList);
		testCase3Input.add(testCase3Node7AdjancencyList);
		testCase3Input.add(testCase3Node8AdjancencyList);
		testCase3Input.add(testCase3Node9AdjancencyList);
		testCase3Input.add(testCase3Node10AdjancencyList);
		testCase3Input.add(testCase3Node11AdjancencyList);
		
		
		ArrayList<ArrayList<Integer>> testCase4Input = new ArrayList<>();
		ArrayList<Integer> testCase4Node0AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase4Node1AdjancencyList = new ArrayList<>();
		testCase4Node1AdjancencyList.add(0);
		ArrayList<Integer> testCase4Node2AdjancencyList = new ArrayList<>();
		testCase4Node2AdjancencyList.add(0);
		testCase4Node2AdjancencyList.add(1);
		ArrayList<Integer> testCase4Node3AdjancencyList = new ArrayList<>();
		testCase4Node3AdjancencyList.add(4);
		ArrayList<Integer> testCase4Node4AdjancencyList = new ArrayList<>();
		testCase4Node4AdjancencyList.add(0);
		testCase4Node4AdjancencyList.add(5);
		ArrayList<Integer> testCase4Node5AdjancencyList = new ArrayList<>();
		testCase4Node5AdjancencyList.add(2);
		ArrayList<Integer> testCase4Node6AdjancencyList = new ArrayList<>();
		testCase4Node6AdjancencyList.add(0);
		ArrayList<Integer> testCase4Node7AdjancencyList = new ArrayList<>();
		testCase4Node7AdjancencyList.add(5);
		ArrayList<Integer> testCase4Node8AdjancencyList = new ArrayList<>();
		ArrayList<Integer> testCase4Node9AdjancencyList = new ArrayList<>();
		testCase4Node9AdjancencyList.add(8);
		
		testCase4Input.add(testCase4Node0AdjancencyList);
		testCase4Input.add(testCase4Node1AdjancencyList);
		testCase4Input.add(testCase4Node2AdjancencyList);
		testCase4Input.add(testCase4Node3AdjancencyList);
		testCase4Input.add(testCase4Node4AdjancencyList);
		testCase4Input.add(testCase4Node5AdjancencyList);
		testCase4Input.add(testCase4Node6AdjancencyList);
		testCase4Input.add(testCase4Node7AdjancencyList);
		testCase4Input.add(testCase4Node8AdjancencyList);
		testCase4Input.add(testCase4Node9AdjancencyList);
		
		
		return Stream.of(
			Arguments.of(4, testCase1Input),
			Arguments.of(6, testCase2Input),
			Arguments.of(12, testCase3Input),
			Arguments.of(10, testCase4Input)
		);
	}
}
