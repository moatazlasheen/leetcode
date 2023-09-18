package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CombinationsSumTest {

	private CombinationsSum underTest = new CombinationsSum();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] candidtaes, int target, List<List<Integer>> expected){
		List<List<Integer>> actual = underTest.combinationSum(candidtaes, target);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [] {2,3,6,7}, 7, 
					Arrays.asList(
							Arrays.asList(2,2,3),
							Arrays.asList(7)
							)),
			Arguments.of(new int [] {2,3,5}, 8, 
					Arrays.asList(
							Arrays.asList(2,2,2,2),
							Arrays.asList(2,3,3),
							Arrays.asList(3,5)
							))
		);
	}
	
}
