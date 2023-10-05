package leetcode.problems.graph;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MatrixTest {
	private Matrix underTest = new Matrix();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [][] in, int [][] expected) {
		int [][] actual = underTest.updateMatrix(in);
		for (int i = 0; i < expected.length; i++) {
			assertTrue(Arrays.equals(expected[i], actual[i]));
		}
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [][] {{0,0,0},{0,1,0},{0,0,0}}, new int [][] {{0,0,0},{0,1,0},{0,0,0}}),
			Arguments.of(new int [][] {{0,0,0},{0,1,0},{1,1,1}}, new int [][] {{0,0,0},{0,1,0},{1,2,1}})
		);
	}
	
	
}
