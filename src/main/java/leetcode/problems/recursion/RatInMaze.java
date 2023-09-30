package leetcode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
	List<String> findPath(int [][] m, int n) {
		List<String> paths = new ArrayList<>();
		if (m[n-1][n-1] == 1 && m[0][0] != 0) {
			boolean [][] visited = new boolean [n][n];
			findPath(m, n, paths, visited, new StringBuilder(), 0, 0);
		}
		return paths;
	}

	private void findPath(int[][] m, int n, List<String> paths, boolean [][] visited, StringBuilder path, int row, int col) {
		if (row == n-1 && col == n-1) {
			paths.add(path.toString());
			return;
		}
		
		if (row < 0 || row >= n || col < 0 || col >= n || m[row][col] == 0 || visited[row][col] == true)  {
		    return;
		}
		
		visited[row][col] = true;
		
		// try down
		if (row+1 < n && m[row+1][col] != 0 && !visited[row+1][col])  {
			findPath(m, n, paths, visited, path.append("D"), row+1, col);
			path.deleteCharAt(path.length()-1);
		}
		// try up
		if (row-1 >= 0 && m[row-1][col] != 0 && !visited[row-1][col])  {
			findPath(m, n, paths, visited, path.append("U"), row-1, col);
			path.deleteCharAt(path.length()-1);
		}
		// try right
		if (col+1 < n && m[row][col+1] != 0 && !visited[row][col+1])  {
			findPath(m, n, paths, visited, path.append("R"), row, col+1);
			path.deleteCharAt(path.length()-1);
		}
		// try left
		if (col-1 >= 0 && m[row][col-1] != 0 && !visited[row][col-1])  {
			findPath(m, n, paths, visited, path.append("L"), row, col-1);
			path.deleteCharAt(path.length()-1);
		}
		
		visited[row][col] = false;
		
	}
}
