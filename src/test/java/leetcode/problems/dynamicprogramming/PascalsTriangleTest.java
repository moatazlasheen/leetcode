package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PascalsTriangleTest {
	
	private PascalsTriangle underTest = new PascalsTriangle();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int rows, List<List<Integer>> expected) {
		List<List<Integer>> actual = underTest.generate(rows);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(1, Arrays.asList(Arrays.asList(1))),
			Arguments.of(2, Arrays.asList(Arrays.asList(1), Arrays.asList(1,1))),
			Arguments.of(3, Arrays.asList(Arrays.asList(1), Arrays.asList(1,1), Arrays.asList(1,2,1))),
			Arguments.of(4, Arrays.asList(Arrays.asList(1), Arrays.asList(1,1), Arrays.asList(1,2,1), Arrays.asList(1,3,3,1))),
			Arguments.of(5, Arrays.asList(Arrays.asList(1), Arrays.asList(1,1), Arrays.asList(1,2,1), Arrays.asList(1,3,3,1), Arrays.asList(1,4,6,4,1)))
		);
	}
}
