package leetcode.problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Topological sort
Medium

https://practice.geeksforgeeks.org/problems/topological-sort/1

Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any Topological Sorting of that Graph.

Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.

Example 2:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 5, 4, 2, 1, 3, 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them. If your returned topo sort is correct then the console output will be 1 else 0.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2
 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class TopologicalSort {
	
	

	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
    	// maps each node with the count of unvisited nodes the can reach this node
        int [] indegree = new int [V];
        int [] sort = new int [V];
        // populate the indegree array
        for (int i = 0; i < adj.size(); i++) {
        	for (int j = 0; j < adj.get(i).size(); j++) {
        		indegree[adj.get(i).get(j)]++;
        	}
        }
        
        // workaround to pass integer by reference
        int [] insertionIndex = {0};
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < indegree.length; i++ ) {
        	if (indegree[i] == 0 && !visited.contains(i)) {
        		traversDepthFirst(adj, sort, indegree, i, insertionIndex, visited);
        	}
        }
        
        return sort;
    }

	private static void traversDepthFirst(ArrayList<ArrayList<Integer>> adj, int[] sort, int[] indegree, int currentNode, int [] insertionIndex, Set<Integer> visited) {
		if (insertionIndex[0] == indegree.length || visited.contains(currentNode)) {
			return;
		}
		sort[insertionIndex[0]++] = currentNode;
		visited.add(currentNode);
		for ( int i : adj.get(currentNode)) {
			indegree[i]--;
			if (indegree[i] == 0) {
				traversDepthFirst(adj, sort, indegree, i, insertionIndex, visited);
			}
		}
		
		
	}
	
	// BFS
//    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
//    {
//    	// maps each node with the count of unvisited nodes the can reach this node
//        int [] indegree = new int [V];
//        int [] sort = new int [V];
//        Queue<Integer> queue = new LinkedList<>();
//        // populate the indegree array
//        for (int i = 0; i < adj.size(); i++) {
//        	for (int j = 0; j < adj.get(i).size(); j++) {
//        		indegree[adj.get(i).get(j)]++;
//        	}
//        }
//        
//        for (int i = 0; i < indegree.length; i++ ) {
//        	if (indegree[i] == 0) {
//        		queue.add(i);
//        	}
//        }
//        
//        int currentNode;
//        ArrayList<Integer> currentNodeAdjacents;
//        int insertionIndex = 0;
//        while (!queue.isEmpty()) {
//			currentNode = queue.poll();
//			sort[insertionIndex++] = currentNode;
//			// loop through adjacents and decrees the indegree for all adjacents
//			currentNodeAdjacents = adj.get(currentNode);
//			for (int i = 0; i < currentNodeAdjacents.size(); i++) {
//				indegree[currentNodeAdjacents.get(i)]--;
//				if (indegree[currentNodeAdjacents.get(i)] == 0) {
//					queue.add(currentNodeAdjacents.get(i));
//				}
//			}
//		}
//        
//        return sort;
//    }
	
}
