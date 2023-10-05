package leetcode.problems.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberOfIslandsTest {

	
	private NumberOfIslands underTest = new NumberOfIslands();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(char [][] grid, int expected) {
		int actual = underTest.numIslands(grid);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of( new char [][] {
					{'1','1','1','1','0'},
					{'1','1','0','1','0'},
					{'1','1','0','0','0'},
					{'0','0','0','0','0'}
				}, 1),
			Arguments.of( new char [][] {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
			}, 3)
		
		);
	}
}
