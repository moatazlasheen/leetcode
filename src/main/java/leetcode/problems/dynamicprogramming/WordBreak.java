package leetcode.problems.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
Medium
https://leetcode.com/problems/word-break/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 

Constraints:

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class WordBreak {
	
	public boolean wordBreak(String s, List<String> wordDict) {
        // for each cell in this dynamic programming table
		// it will hold true if the current corresponding letter in the input string
		// can be the end of a word from the dictionary, false otherwise
		// which means the next character can be the start of the new word
		boolean [] dp = new boolean [s.length()+1];
        // the next character, which is the first character in the given string can
		// definitely be the start of a word from the dictionary, actually it has to be
		// the start of one word from the dictionary
		dp[0] = true;
		
		// faster in the contains call
		Set<String> dictionarySet = new HashSet<>(wordDict);
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				// the word from j to i inclusive exists in the dictionary and j-1 is the 
				// end of a word, i.e j can be the start of a word
				if (dp[j] && dictionarySet.contains(s.substring(j, i+1))) {
					dp[i+1] = true;
					break;
				}
			}
		}
		return dp[dp.length-1];
    }

}
