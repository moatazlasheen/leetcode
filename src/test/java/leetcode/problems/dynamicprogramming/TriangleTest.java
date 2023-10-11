package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TriangleTest {
	
	private Triangle underTest = new Triangle();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(List<List<Integer>> triangle, int expected) {
		int actual = underTest.minimumTotal(triangle);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(Arrays.asList(Arrays.asList(2), Arrays.asList(3,4), Arrays.asList(6,5,7), Arrays.asList(4,1,8,3)), 11),
			Arguments.of(Arrays.asList(Arrays.asList(-10)), -10),
			Arguments.of(Arrays.asList(Arrays.asList(-1), Arrays.asList(2,3), Arrays.asList(1,-1, -3)), -1)
		);
	}
}
