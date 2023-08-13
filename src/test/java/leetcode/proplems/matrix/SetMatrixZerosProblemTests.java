package leetcode.proplems.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.matrix.SetMatrixZerosProblem;

class SetMatrixZerosProblemTests {
	
	private SetMatrixZerosProblem underTest = new SetMatrixZerosProblem();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [][] matrix, int [] nullifiedRows, int [] nullifiedCols ) {
		underTest.setZeroes(matrix);
		int indexVal;
		for ( int i=0; i<nullifiedRows.length; i++) {
			indexVal = nullifiedRows[i];
			for ( int col=0; col<matrix[indexVal].length-1; col++) {
				assertEquals(0, matrix[indexVal][col]);
			}
		}
		for ( int i=0; i<nullifiedCols.length; i++) {
			indexVal = nullifiedCols[i];
			for ( int row=0; row<matrix.length-1; row++) {
				assertEquals(0, matrix[row][indexVal]);
			}
		}
		
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [][] {{1,1,1}, {1,0,1}, {1,1,1}}, new int [] {1}, new int [] {1}),
			Arguments.of( new int [][] {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}}, new int [] {0}, new int [] {0,3})
		);
	}
}
