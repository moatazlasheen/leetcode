package leetcode.proplems.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.matrix.NumMatrix;

class NumMatrixTest {
	
	
	private static NumMatrix underTest;
	
	
	@BeforeAll 
	static void setup ( ) {
		int [][]matrix = new int [][] {{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}};
				
		underTest = new NumMatrix(matrix);
	}
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int row1, int col1, int row2, int col2, int expected) {
		int actual = underTest.sumRegion(row1, col1, row2, col2);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams () {
		return Stream.of(
			Arguments.of(2, 1, 4, 3, 8),
			Arguments.of(1, 1, 2, 2, 11),
			Arguments.of(1, 2, 2, 4,12)
			
		);
	}
	
	
	

}
