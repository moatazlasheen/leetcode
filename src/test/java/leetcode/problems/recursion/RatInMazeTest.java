package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RatInMazeTest {

	private RatInMaze underTest = new RatInMaze();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [][] m, int n, List<String> expected) {
		List<String> actual = underTest.findPath(m, n);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [][] {{0}}, 1, Arrays.asList()),
			Arguments.of(new int [][] {{1,0}, {1,0}}, 2, Arrays.asList()),
			Arguments.of(new int [][] {{1,0,0,0}, {1,1,0,1}, {1,1,0,0}, {0,1,1,1}}, 4, Arrays.asList("DDRDRR", "DRDDRR"))
		);
	}
	
}
