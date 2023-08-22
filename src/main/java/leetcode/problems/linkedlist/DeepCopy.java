package leetcode.problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 138. Copy List with Random Pointer
Medium

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.

Your code will only be given the head of the original linked list.

 

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

 

Constraints:

    0 <= n <= 1000
    -10^4 <= Node.val <= 10^4
    Node.random is null or is pointing to some node in the linked list.


 * 
 * @author Moataz Lasheen
 *
 */
public class DeepCopy {
	
	
	public Node copyNode (Node node, Map<Node, Node> copies) {
        if (node == null) {
            return null;
        }
        if ( copies.get(node) != null ) {
            return copies.get(node);
        }
        Node newNode = new Node(node.val);
        copies.put(node, newNode);
        if ( node.next != null ) {
            Node nextCopy = copyNode(node.next, copies);
            newNode.next = nextCopy;
        }

        if ( node.random != null ) {
            Node randomCopy = copyNode(node.random, copies);
            newNode.random = randomCopy;
        }

        return newNode;

    }
	
	// this solution works but it uses extra memory, the memory for the hashmap and the recursion
    public Node copyRandomList2(Node head) {
        if ( head == null ) {
            return head;
        }

        Node current = head;
        Map<Node, Node> copiedNodesMap = new HashMap<>();
        Node newHead = copyNode(current, copiedNodesMap);

        return newHead;
    }
    
    public Node copyRandomList(Node head) {
    	if ( head == null ) {
    		return null;
    	}
    	
    	
    	// after each node create a new node with the same value and 
    	// make current refer to next of the current node as its next 
    	// and make current node refer to the new node as its next
    	// then move current to the original next
    	// i.e insert new noder between each two original nodes with the same value the 
    	// the original befor this node
    	Node current = head;
    	Node tmp = null;
    	while (current!=null) {
    		Node node = new Node(current.val, current.next);
    		tmp = current.next;
    		current.next = node;
    		current = tmp;
		}
    	
    	
    	// loop throug the list and make the random of the copy, i.e the random of the next
    	// equal to the copy of the original random, i.e the node next to the original random
    	current = head;
    	while (current!=null && current.next!=null) {
			if ( current.random != null ) {
				current.next.random = current.random.next;
			}
			current = current.next.next;
		}
    	
    	
    	
    	current = head;
    	Node newHead = head.next;
    	// loop through the list and make each node refer to the next of the next node as its next
    	// this will split the current list to two lists
    	while (current!=null &&current.next!=null) {
    		tmp = current.next;
			current.next = current.next.next;
			current=tmp;
		}
    	
    	return newHead;
    }

}
