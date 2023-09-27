package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumEqualPartitionsTest {

	private SumEqualPartitions underTest = new SumEqualPartitions();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( int [] input, int k, boolean expected) {
		boolean actual = underTest.canPartitionKSubsets(input, k);
		assertEquals(expected, actual);
	}
	
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of( new int [] {4,3,2,3,5,2,1}, 4, true),
			Arguments.of( new int [] {1,2,3,4}, 3, false),
			Arguments.of( new int [] {1,2}, 2, false),
			Arguments.of( new int [] {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269}, 5, true)
			
		);
	}
}
