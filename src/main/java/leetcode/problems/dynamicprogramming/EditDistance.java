package leetcode.problems.dynamicprogramming;


/**
 * 72. Edit Distance
Medium

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 

Constraints:

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class EditDistance {
	
	public int minDistance(String word1, String word2) {
		if (word1.equals(word2)) {
			return 0;
		}
		
		// each cell holds how many action do you need to
		// convert the current part of word1 to the current part of word2, 
		int [][] dp = new int [word1.length()+1][word2.length()+1];
		
		// first cell is always 0
		// the number of insertions, deletion or replacements needed to convert "", to ""
		dp[0][0] = 0;
		
		// fill in the first row
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = j;
		}
		
		// fill in the first column 
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = i;
		}
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					// no extra action needed in this step
					dp[i][j] = dp[i-1][j-1]; // diagonal, no extra action needed for the current letter
				} else {
					// you need to do one more action here
					// so the total number of action till this point is
					// 1 + the minimum number in the upper, left and diagonal cells
					dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
				}
			}
		}
		
		return dp[word1.length()][word2.length()];
    }

}
