package leetcode.problems.towpointers;


/**
 * 
 * 
 * 392. Is Subsequence
Easy

Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false

 

Constraints:

    0 <= s.length <= 100
    0 <= t.length <= 10^4
    s and t consist only of lowercase English letters.

 
Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 10^9, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?


 * @author Moataz Lasheen
 *
 */
public class IsSubsequence {
	
	public boolean isSubsequence(String s, String t) {
		if ( s.length() > t.length() ) {
			return false;
		}
		int sLeft = 0;
		for ( int tLeft=0; tLeft<t.length()&&sLeft<s.length(); tLeft++ ) {
			if ( t.charAt(tLeft) == s.charAt(sLeft) ) {
				sLeft++;
			}
		}
		
		
		return sLeft==s.length();
    }

}
