package leetcode.proplems.matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.matrix.SearchMatrix;

class SearchMatrixTest {

	
	private SearchMatrix underTest = new SearchMatrix();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [][] matrix, int target, boolean expected ) {
		boolean actual = underTest.searchMatrix(matrix, target);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3, true),
			Arguments.of( new int [][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13, false),
			Arguments.of( new int [][] {{1,3,5}}, 1, true)
		);
	}
}
