package leetcode.problems.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 118. Pascal's Triangle
Easy

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]

 

Constraints:

    1 <= numRows <= 30


 * 
 * @author Moataz Lasheen
 *
 */
public class PascalsTriangle {
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Arrays.asList(1));
        int rowSize = 2;
        for (int i = 1; i < numRows; i++)  {
            result.add(new ArrayList<>(rowSize));
            result.get(i).add(1);
            
            for(int j = 1; j < rowSize-1; j++ ) {
                result.get(i).add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            
            result.get(i).add(1);
            rowSize++;
        }
        return result;
    }

}
