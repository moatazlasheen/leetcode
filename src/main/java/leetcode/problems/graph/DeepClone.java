package leetcode.problems.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * 133. Clone Graph
Medium

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

 

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

 

Example 1:

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

Example 2:

Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.

 

Constraints:

    The number of nodes in the graph is in the range [0, 100].
    1 <= Node.val <= 100
    Node.val is unique for each node.
    There are no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.


 * 
 * @author Moataz Lasheen
 *
 */
public class DeepClone {

	
	// Depth First Search algorithm
	public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        
        return cloneGraph(node, map);
    }

    private Node cloneGraph (Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        
        if(map.get(node) != null) {
            return map.get(node);
        }
        
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        
        List<Node> copiedNeighbors = new ArrayList<>();

        for (int i = 0; i < node.neighbors.size(); i++) {
            Node copiedNeighbor = map.get(node.neighbors.get(i));
            if (copiedNeighbor == null) {
                copiedNeighbor = cloneGraph(node.neighbors.get(i), map);
                map.put(node.neighbors.get(i), copiedNeighbor);
            } 
            copiedNeighbors.add(copiedNeighbor);
        }

        newNode.neighbors = copiedNeighbors;
        
        return newNode;
    }
	// Breadth First Search Algorithm
//	public Node cloneGraph(Node node) {
//        Map<Node, Node> map = new HashMap<>();
//        if (node == null) {
//            return null;
//        }
//        if (node.neighbors.isEmpty()) {
//            return new Node(node.val);
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(node);
//
//        Node current;
//        Node newRoot = new Node(node.val);
//        map.put(node, newRoot);
//        Node newNode;
//        while(!queue.isEmpty()) {
//            current = queue.poll();
//            newNode =  map.get(current);
//            List<Node> newNeighbors = newNode.neighbors;
//            for (Node neighbor : current.neighbors) {
//                Node neighborCopy = map.get(neighbor);
//                if (neighborCopy == null) {
//                	neighborCopy = new Node(neighbor.val);
//                    map.put(neighbor, neighborCopy);
//                    queue.add(neighbor);
//                } 
//                newNeighbors.add(neighborCopy);
//            }
//
//        }
//        
//        return newRoot;
//    }
}
