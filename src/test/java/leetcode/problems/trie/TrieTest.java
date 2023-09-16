package leetcode.problems.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TrieTest {
	
	private Trie underTest = new Trie();
	
	@Test
	void testTrieOperations() {
		underTest.insert("apple");
		assertTrue(underTest.search("apple"));
		assertFalse(underTest.search("app"));
		assertTrue(underTest.startsWith("app"));
		underTest.insert("app");
		assertTrue(underTest.search("app"));
	}

}
