package leetcode.problems.matrix;

public class NumMatrix {
	
	int [][] dp;

	
	// TC : O(m*n)
	// SC : O(m*n)
	// instantiate the dynamic programming matrix
	// each element in the dynamic programming matrix represents the sum of the range 
	// from index 0,0 in the original array to the index i, j
    public NumMatrix(int[][] matrix) {
        dp = new int [matrix.length+1][matrix[0].length+1];
        for ( int i=0; i<matrix.length; i++ ) {
        	for ( int j=0; j<matrix[0].length; j++ ) {
        		dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + matrix[i][j];
        	}
        }
    }
    
    
    // TC : O(1)
 	// SC : O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1]; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
