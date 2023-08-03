package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.DuplicateRemoval;

class DuplicateRemovalTest {
	
	private DuplicateRemoval underTest = new DuplicateRemoval();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int expectedLength, int [] expectedArray ) {
		
		int actualLength = underTest.removeDuplicates(nums);
		
		assertEquals(expectedLength, actualLength);
		for ( int i=0;i<expectedLength; i++ ) {
			assertEquals(expectedArray[i], nums[i]);
		}
		
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1,1,1,2,2,3}, 5 , new int [] {1,1,2,2,3}),
			Arguments.of(new int [] {0,0,1,1,1,1,2,3,3}, 7 , new int [] {0,0,1,1,2,3,3}),
			Arguments.of(new int [] {0,1,2,2,3,3,3,4,4,4,4,4}, 8 , new int [] {0,1,2,2,3,3,4,4})
		);
	}

}
