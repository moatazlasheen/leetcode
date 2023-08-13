package leetcode.problems.matrix;


/**
 * 73. Set Matrix Zeroes
Medium

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 

Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -2^31 <= matrix[i][j] <= 2^31 - 1

 

Follow up:

    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?


 * @author Moataz Lasheen
 *
 */
public class SetMatrixZerosProblem {
	public void setZeroes(int[][] matrix) {
		
		boolean nullifyFirstRow = false;
		boolean nullifyFirstCol = false;
		
		
		// check if first row should be nullified
		for ( int i=0; i<matrix[0].length; i++ ) {
			if ( matrix[0][i] == 0 ) {
				nullifyFirstRow = true;
				break;
			}
		}
		
		// check if first column should be nullified
		for ( int i=0; i<matrix.length; i++ ) {
			if ( matrix[i][0] == 0 ) {
				nullifyFirstCol = true;
				break;
			}
		}
		
		
		for ( int i=1; i<matrix.length; i++ ) {
			for ( int j=1; j<matrix[0].length; j++ ) {
				if ( matrix[i][j] == 0 ) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// nullify all columns that has the first item equals to zero
		for ( int i=1; i<matrix[0].length; i++ ) {
			if ( matrix[0][i] == 0 ) {
				nullifyColumn(matrix, i);
			}
		}
		
		// nullify all rows that has the first item equals to zero
		for ( int i=1; i<matrix.length; i++ ) {
			if ( matrix[i][0] == 0 ) {
				nullifyRow(matrix,i);
			}
		}
		
		if ( nullifyFirstCol ) {
			nullifyColumn(matrix, 0);
		}
		
		if ( nullifyFirstRow ) {
			nullifyRow(matrix, 0);
		}
		
    }

	private void nullifyColumn(int[][] matrix, int colIndex) {
		for ( int i = 0; i<matrix.length; i++ ) {
			matrix[i][colIndex] = 0;
		}
	}
	
	private void nullifyRow(int[][] matrix, int rowIndex) {
		for ( int i = 0; i<matrix[0].length; i++ ) {
			matrix[rowIndex][i] = 0;
		}
	}
}
