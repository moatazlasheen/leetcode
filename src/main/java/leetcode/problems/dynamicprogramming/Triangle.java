package leetcode.problems.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;


/**
 * 120. Triangle
Medium

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:

Input: triangle = [[-10]]
Output: -10

 

Constraints:

    1 <= triangle.length <= 200
    triangle[0].length == 1
    triangle[i].length == triangle[i - 1].length + 1
    -10^4 <= triangle[i][j] <= 10^4

 
Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class Triangle {
	
	
	public int minimumTotal(List<List<Integer>> triangle) {

        int[] dynamicProgramming = new int [triangle.size()];
        
        
        // start from the top and caculate the cost for each cell,
        // last row is not changed
        int lastRowIndex = triangle.size()-1;
        for (int i = 0; i < triangle.get(lastRowIndex).size(); i++) {
        	dynamicProgramming[i] = triangle.get(lastRowIndex).get(i);
        }
        
        for (int i = triangle.size()-2; i >= 0; i--) {
        	for (int j = 0; j < triangle.get(i).size(); j++) {
        		dynamicProgramming[j] = triangle.get(i).get(j) + Math.min(dynamicProgramming[j], dynamicProgramming[j+1]);
//        		if (dynamicProgramming[j] <= dynamicProgramming[j+1]) {
//        			dynamicProgramming[j] += triangle.get(i).get(j);
//        		} else {
//        			dynamicProgramming[j] = triangle.get(i).get(j) + dynamicProgramming[j+1];
//        		}
        	}
        }
        
        return dynamicProgramming[0];
    }
	
	// dynamic programing, better but could be enhance, arrays are faster than lists 
//	public int minimumTotal(List<List<Integer>> triangle) {
//
//        List<Integer> dynamicProgramming = new ArrayList<>(triangle.size());
//        
//        
//        // start from the top and caculate the cost for each cell,
//        // last row is not changed
//        int lastRowIndex = triangle.size()-1;
//        for (int i = 0; i < triangle.get(lastRowIndex).size(); i++) {
//        	dynamicProgramming.add(triangle.get(lastRowIndex).get(i));
//        }
//        
//        for (int i = triangle.size()-2; i >= 0; i--) {
//        	for (int j = 0; j < triangle.get(i).size(); j++) {
//        		if (dynamicProgramming.get(j) <= dynamicProgramming.get(j+1)) {
//        			dynamicProgramming.set(j,triangle.get(i).get(j) + dynamicProgramming.get(j));
//        		} else {
//        			dynamicProgramming.set(j, triangle.get(i).get(j) + dynamicProgramming.get(j+1));
//        		}
//        	}
//        }
//        
//        return dynamicProgramming.get(0);
//    }

	// dynamic programming, accepted but could be enhanced
//	public int minimumTotal(List<List<Integer>> triangle) {
//
//        List<List<Integer>> dynamicProgramming = new ArrayList<>(triangle.size());
//        for (int i = 0; i < triangle.size(); i++) {
//        	dynamicProgramming.add(new ArrayList<>(triangle.get(i).size()));
//        }
//        
//        // start from the top and caculate the cost for each cell,
//        // last row is not changed
//        int lastRowIndex = triangle.size()-1;
//        dynamicProgramming.add(lastRowIndex, triangle.get(lastRowIndex));
//        
//        for (int i = triangle.size()-2; i >= 0; i--) {
//        	for (int j = 0; j < triangle.get(i).size(); j++) {
//        		if (dynamicProgramming.get(i+1).get(j) <= dynamicProgramming.get(i+1).get(j+1)) {
//        			dynamicProgramming.get(i).add(triangle.get(i).get(j) + dynamicProgramming.get(i+1).get(j));
//        		} else {
//        			dynamicProgramming.get(i).add(triangle.get(i).get(j) + dynamicProgramming.get(i+1).get(j+1));
//        		}
//        	}
//        }
//        
//        return dynamicProgramming.get(0).get(0);
//    }
	
	// exceeds time limits
	// brute force, check all possible
//	public int minimumTotal(List<List<Integer>> triangle) {
//
//        int total = triangle.get(0).get(0);
//        int currentIndex = 0;
//
//        return total + minimumTotal(triangle, 1, currentIndex);
//        
//    }
//
//	private int minimumTotal(List<List<Integer>> triangle, int currentRowIndex, int currentIndex) {
//		if(currentRowIndex >= triangle.size()) {
//			return 0;
//		}
//		
//		int sameIndexTotal = triangle.get(currentRowIndex).get(currentIndex) + minimumTotal(triangle, currentRowIndex+1, currentIndex);
//		int nextIndexTotal = triangle.get(currentRowIndex).get(currentIndex+1) + minimumTotal(triangle, currentRowIndex+1, currentIndex+1);
//		
//		return Math.min(sameIndexTotal, nextIndexTotal);
//	}
	
}
