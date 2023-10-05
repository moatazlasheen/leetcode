package leetcode.problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 542. 01 Matrix
Medium

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 

Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

 

Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 10^4
    1 <= m * n <= 10^4
    mat[i][j] is either 0 or 1.
    There is at least one 0 in mat.


 * 
 * @author Moataz Lasheen
 *
 */
public class Matrix {
	private class Pair {
        int row;
        int col;

        public Pair( int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> queue = new LinkedList<Pair>();
        for (int i=0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)  {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int [][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // down, up, right, left
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for ( int d = 0; d < 4; d++) {
                int adjacentY = pair.row + directions[d][0];
                int adjacentX = pair.col + directions[d][1];
                if (adjacentY >= 0 && adjacentY < mat.length && adjacentX >= 0 && adjacentX < mat[0].length && mat[adjacentY][adjacentX] == -1) {
                    mat[adjacentY][adjacentX] = 1 + mat[pair.row][pair.col];
                    queue.add(new Pair(adjacentY, adjacentX));    
                }
            }
        }

        return mat;
    }
}
