package leetcode.problems.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BSTInOrderSuccessorTest {

	private BSTInOrderSuccessor underTest = new BSTInOrderSuccessor();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(Node rootNode, Node given, Node expected) {
		Node actual = underTest.inorderSuccessor(rootNode, given);
		assertEquals(expected.val, actual.val);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		Node testCase1L3N2 = new Node(14, null, null);
		Node testCase1L3N1 = new Node(10, null, null);
		Node testCase1L2N2 = new Node(12, testCase1L3N1, testCase1L3N2);
		Node testCase1L2N1 = new Node(4, null, null);
		Node testCase1L1N2 = new Node(22, null, null);
		Node testCase1L1N1 = new Node(8, testCase1L2N1, testCase1L2N2);
		Node testCase1Root = new Node(20, testCase1L1N1, testCase1L1N2);
		
		
		return Stream.of(
			Arguments.of(testCase1Root, testCase1L1N1, testCase1L3N1),
			Arguments.of(testCase1Root, testCase1L2N2, testCase1L3N2),
			Arguments.of(testCase1Root, testCase1L2N1, testCase1L1N1)
		);
	}
}
