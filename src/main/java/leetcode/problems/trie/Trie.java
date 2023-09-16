package leetcode.problems.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 208. Implement Trie (Prefix Tree)
Medium

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

    Trie() Initializes the trie object.
    void insert(String word) Inserts the string word into the trie.
    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True

 

Constraints:

    1 <= word.length, prefix.length <= 2000
    word and prefix consist only of lowercase English letters.
    At most 3 * 10^4 calls in total will be made to insert, search, and startsWith.



 * @author Moataz Lasheen
 *
 */
public class Trie {
	
	private class Node {
		Map<Character, Node> map = new HashMap<>();
		boolean isWordEnd;
	}
	
	Node root;
	
	public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
    	Node current = root;
    	Character ch;
        for (int i = 0; i < word.length(); i++ ) {
        	ch = word.charAt(i);
        	if (current.map.get(ch) == null) {
        		current.map.put(ch, new Node());
        	}
        	
        	current = current.map.get(ch);
        }
        current.isWordEnd = true;
    }
    
    public boolean search(String word) {
        Node current = root;
        Character ch;
    	for (int i = 0; i < word.length(); i++) {
        	ch = word.charAt(i);
        	if (current.map.get(ch) == null) {
        		return false;
        	}
        	current = current.map.get(ch);
        }
    	return current.isWordEnd;
    }
    
    public boolean startsWith(String prefix) {
    	Node current = root;
        Character ch;
    	for (int i = 0; i < prefix.length(); i++) {
        	ch = prefix.charAt(i);
        	if (current.map.get(ch) == null) {
        		return false;
        	}
        	current = current.map.get(ch);
        }
    	return true;
    }

}
