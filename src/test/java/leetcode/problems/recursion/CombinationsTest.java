package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CombinationsTest {

	private Combinations underTest = new Combinations();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int n, int k, List<List<Integer>> expected){
		List<List<Integer>> actual = underTest.combine(n, k);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(4, 2, 
					Arrays.asList(
							Arrays.asList(1,2),
							Arrays.asList(1,3),
							Arrays.asList(1,4),
							Arrays.asList(2,3),
							Arrays.asList(2,4),
							Arrays.asList(3,4)
							)),
			Arguments.of(4, 3, 
					Arrays.asList(
							Arrays.asList(1,2,3),
							Arrays.asList(1,2,4),
							Arrays.asList(1,3,4),
							Arrays.asList(2,3,4)
							))
		);
	}
	
}
