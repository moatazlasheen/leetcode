package leetcode.problems.dynamicprogramming;


/**
 * 516. Longest Palindromic Subsequence
Medium
https://leetcode.com/problems/longest-palindromic-subsequence/description/

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".

 

Constraints:

    1 <= s.length <= 1000
    s consists only of lowercase English letters.


 * 
 * @author Moataz Lasheen
 *
 */
public class LongestPalindromicSubSequence {
	
	// dynamic programming memoization
	// TC O(n^2)
	// SC O(n + n^2),  O(n^2)
	public int longestPalindromeSubseq(String s) {
        int [][] dp = new int [s.length()][s.length()];
        return longestPalindromeSubseq(0, s.length()-1, s, dp);
    }

    public int longestPalindromeSubseq(int start, int end, String s, int [][] dp) {
        if (start > end) {
            return 0;
        } 
        if (start == end) {
            return 1;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        
        if ( s.charAt(start) == s.charAt(end)) {
            int num = longestPalindromeSubseq(start + 1, end - 1, s, dp);
            dp[start+1][end-1] = num;
            return 2 + num;
        } else {
            int num1 = longestPalindromeSubseq(start + 1, end, s, dp);
            dp[start+1][end] = num1;
            int num2 = longestPalindromeSubseq(start, end - 1, s, dp);
            dp[start][end-1] = num2;
            return Math.max(num1, num2);
        }

    }
    
    /*
    // time limit excceded 
    // TC O(2^n)
    // SC O(n) for the recursion  
    public int longestPalindromeSubseq(String s) {
        return longestPalindromeSubseq(0, s.length()-1, s);
    }

    public int longestPalindromeSubseq(int start, int end, String s) {
        if (start > end) {
            return 0;
        } 
        if (start == end) {
            return 1;
        }
        

        if ( s.charAt(start) == s.charAt(end)) {
            return 2 + longestPalindromeSubseq(start + 1, end - 1, s);
        } else {
            return Math.max(longestPalindromeSubseq(start + 1, end, s), longestPalindromeSubseq(start, end - 1, s));
        }

    }
    */

}
