package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UniquePathsTest {
	
	private UniquePaths underTest = new UniquePaths();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int m, int n, int expected) {
		int actual = underTest.uniquePaths(m, n);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(3, 7, 28),
			Arguments.of(3, 2, 3)
		);
	}
}
