package leetcode.proplems.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.towpointers.ThreeSum;

class ThreeSumTest {

	private ThreeSum underTest = new ThreeSum();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] in, List<List<Integer>> expected ) {
		List<List<Integer>> actual = underTest.threeSum(in);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of( 
			Arguments.of(new int [] {-1,0,1,2,-1,-4}, Arrays.asList(Arrays.asList(-1,-1,2), Arrays.asList(-1,0,1)))	,
			Arguments.of(new int [] {0,0,0,0}, Arrays.asList(Arrays.asList(0,0,0)))
		);
	}
	
}
