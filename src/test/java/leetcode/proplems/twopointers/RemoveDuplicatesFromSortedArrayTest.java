package leetcode.proplems.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.towpointers.RemoveDuplicatesFromSortedArray;

class RemoveDuplicatesFromSortedArrayTest {

	private RemoveDuplicatesFromSortedArray underTest = new RemoveDuplicatesFromSortedArray();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] in, int [] expected ) {
		int actualLength = underTest.removeDuplicates(in);
		
		assertEquals(expected.length, actualLength);
		for ( int i=0; i<expected.length; i++) {
			assertEquals(expected[i], in[i]);
		}
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1}, new int [] {1}),
			Arguments.of(new int [] {1,1}, new int [] {1}),
			Arguments.of(new int [] {1,1,1}, new int [] {1}),
			Arguments.of(new int [] {-1,0,1}, new int [] {-1,0,1}),
			Arguments.of(new int [] {-1,0,0,0,0,0,0,1}, new int [] {-1,0,1}),
			Arguments.of(new int [] {-1,-1,0,0,0,0,0,1}, new int [] {-1,0,1}),
			Arguments.of(new int [] {-1,-1,0,0,0,0,1,1}, new int [] {-1,0,1})
		);
	}
	
	
}
