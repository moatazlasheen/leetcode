package leetcode.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 785. Is Graph Bipartite?
Medium

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

    There are no self-edges (graph[u] does not contain u).
    There are no parallel edges (graph[u] does not contain duplicate values).
    If v is in graph[u], then u is in graph[v] (the graph is undirected).
    The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.

A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.

 

Example 1:

Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: There is no way to partition the nodes into two independent sets such that every edge connects a node in one and a node in the other.

Example 2:

Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.

 

Constraints:

    graph.length == n
    1 <= n <= 100
    0 <= graph[u].length < n
    0 <= graph[u][i] <= n - 1
    graph[u] does not contain u.
    All the values of graph[u] are unique.
    If graph[u] contains v, then graph[v] contains u.


 * 
 * @author Moataz Lasheen
 *
 */
public class BiPartiteGraph {
	
	// DFS
	public boolean isBipartite(int[][] graph) {
		int[] nodeColors = new int [graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			if (nodeColors[i] == 0) {
				if (!dfs(graph, nodeColors, i, 1)) {
					return false;
				}
			}
		}
		
		return true;
	}

	private boolean dfs(int[][] graph, int[] nodeColors, int nodeIndex, int color) {
		
		if (nodeColors[nodeIndex] == color) {
			return true;
		}
		if (nodeColors[nodeIndex] == -1 * color) {
			return false;
		}
		
		nodeColors[nodeIndex] = color;
		
		int [] adjacents = graph[nodeIndex];
		for (int i = 0; i < adjacents.length; i++) {
			if (!dfs(graph, nodeColors, adjacents[i], -1*color)) {
				return false;
			}
		}
		
		return true;
	}
	
	
//	// BFS
//	public boolean isBipartite(int[][] graph) {
//       int [] nodeColors = new int [graph.length];
//       for (int i = 0; i < graph.length; i++) {
//    	  if (nodeColors[i] == 0) {
//    		  if (!bfs(graph, nodeColors, i)) {
//        		  return false;
//        	  }
//    	  }
//       }
//       
//       return true;
//    }
//
//	private boolean bfs(int[][] graph, int[] nodeColors, int nodeIndex) {
//		Queue<Integer> queue = new LinkedList<>();
//		
//		nodeColors[nodeIndex] = 1;
//		
//		queue.add(nodeIndex);
//		
//		while (!queue.isEmpty()) {
//			int current = queue.poll();
//			int [] adjacents = graph[current];
//			for (int i = 0; i < adjacents.length; i++) {
//				if (nodeColors[adjacents[i]] == 0) {
//					nodeColors[adjacents[i]] = -1 * nodeColors[current];
//					queue.add(adjacents[i]);
//				} else if (nodeColors[adjacents[i]] == nodeColors[current]) {
//					return false;
//				}
//			}
//		}
//		
//		return true;
//		
//	}
	
	
	// backtracking , exceeds time limits
//	public boolean isBipartite(int[][] graph) {
//        int [] nodeColors = new int [graph.length];
//        
//        return colorGraph(graph, nodeColors, 2, 0);
//    }
//
//    private boolean colorGraph(int [][] graph, int [] nodeColors, int numColors, int currentNodeIndex) {
//        if (currentNodeIndex == graph.length) {
//            return true;
//        }
//
//        for (int color = 1; color <= 2; color++) {
//            if (canColorNode(graph, nodeColors, currentNodeIndex, color)) {
//                nodeColors[currentNodeIndex] = color;
//                if (colorGraph(graph, nodeColors, numColors, currentNodeIndex+1)) return true;
//                nodeColors[currentNodeIndex] = 0;
//            }
//        }
//
//        return false;
//    }
//
//    private boolean  canColorNode(int [][] graph, int [] nodeColors, int currentNodeIndex, int color) {
//        int [] nodeAdjacency = graph[currentNodeIndex];
//        for (int i = 0; i < nodeAdjacency.length; i++)  {
//            if (nodeColors[nodeAdjacency[i]] == color) {
//                return false;
//            }
//        }
//        return true;
//    }
}
