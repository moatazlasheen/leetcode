package leetcode.problems.matrix;


/**
 * 
 * 
 * 74. Search a 2D Matrix
Medium

You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

 

Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

 

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -10^4 <= matrix[i][j], target <= 10^4


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class SearchMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {

		// find the target row in which the target may reside
		
		// search the right most column for an
		// item whose value is the smallest value bigger than 
		// the actual target,
		int low = 0;
        int high = matrix.length-1;
        int targetRowIndex = -1; // initailly out of bound
        
        int mid = -1;
        int val;
        while ( low <= high ) {
			mid = low + (high-low)/2;
			val = matrix[mid][matrix[mid].length-1];
			if ( val == target ) {
				return true;
			}
			else if ( val < target ) {
				low = mid + 1;
			} else {
				high = mid -1;
				targetRowIndex = mid;
			}
		}
        
        if ( targetRowIndex > -1 ) {
        	// the target should exist in this row if it exists in the matrix
        	low = 0;
        	high = matrix[targetRowIndex].length-1;
        	while (low<=high) {
        		mid = low + (high-low)/2;
    			val = matrix[targetRowIndex][mid];
    			if ( val == target ) {
    				return true;
    			} else if ( val > target ) {
    				high = mid-1;
    			} else {
    				low = mid+1;
    			}
				
			}
        }
        
        return false;
    }

}
