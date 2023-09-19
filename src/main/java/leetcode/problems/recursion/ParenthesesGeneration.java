package leetcode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

 

Constraints:

    1 <= n <= 8


 * 
 * @author Moataz Lasheen
 *
 */
public class ParenthesesGeneration {
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, result, new StringBuilder(), 0, 0);
        return result;
    }

	private void generateParenthesis(int n, List<String> result, StringBuilder currentPossibility, int opentingCount, int closingCount) {
		if (currentPossibility.length() == n*2) {
			result.add(currentPossibility.toString());
			return;
		}
		
		
		if (opentingCount < n) {
			currentPossibility.append("(");
			generateParenthesis(n, result, currentPossibility, opentingCount+1, closingCount);
			currentPossibility.deleteCharAt(currentPossibility.length()-1);
		} 
		if (closingCount < opentingCount){
			currentPossibility.append(")");
			generateParenthesis(n, result, currentPossibility, opentingCount, closingCount+1);
			currentPossibility.deleteCharAt(currentPossibility.length()-1);
		}
		
	}
}
