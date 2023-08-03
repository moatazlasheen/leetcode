package leetcode.problems.strings;

/**
 * 5. Longest Palindromic Substring


Level : Medium

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

 

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.


 * @author Moataz Lasheen
 *
 */

public class LongestPalidromicSubstring {

//	public String longestPalindrome(String input) {
//		String currentLongestPalindrome = "";
//		 
//		for ( int left=0; left<input.length()-currentLongestPalindrome.length(); left++ ) {
//			for ( int right = input.length(); right>left&&(right-left+1>currentLongestPalindrome.length()); right-- ) {
//				String potential = input.substring(left, right);
//				if ( isPalindrome(potential) && potential.length()>currentLongestPalindrome.length() ) {
//					currentLongestPalindrome = potential;
//				}
//			}
//		}
//		
//		return currentLongestPalindrome;
//	}
	
//	public String longestPalindrome(String input) {
//		String currentLongestPalindrome = "";
//		 
//		for ( int left=0; left<input.length(); left++ ) {
//			for ( int right = input.length(); right>left&&(right-left+1>currentLongestPalindrome.length()); right-- ) {
//				String potential = input.substring(left, right);
//				if ( isPalindrome(potential) && potential.length()>currentLongestPalindrome.length() ) {
//					currentLongestPalindrome = potential;
//				}
//			}
//		}
//		
//		return currentLongestPalindrome;
//	}

//	public String longestPalindrome(String input) {
//		String currentLongestPalindrome = "";
//		 
//		for ( int left=0; left<input.length()-currentLongestPalindrome.length(); left++ ) {
//			for ( int right=left+1; right<=input.length(); right++ ) {
//				String potential = input.substring(left, right);
//				if ( isPalindrome(potential) && potential.length()>currentLongestPalindrome.length() ) {
//					currentLongestPalindrome = potential;
//				} 
//			}
//		}
//		
//		return currentLongestPalindrome;
//	}
//
//	
//	private boolean isPalindrome(String s) {
//		for ( int i=0; i<s.length(); i++ ) {
//			if ( s.charAt(i) != s.charAt(s.length()-1-i)) {
//				return false;
//			}
//		}
//		return true;
//	}
	int start = 0;
	int end = 0;
	
	public String longestPalindrome(String input) {
		
		if ( input.length() == 1) {
			return input;
		}
		
		for ( int i=0; i<input.length(); i++ ) {
			// for aba the center is b
			// for abba the center is neither the first b or the last b but in between them
			expandInputAroundCenter(input, i,i);
			expandInputAroundCenter(input, i,i+1);
		}
		
		return input.substring(start, end+1);
	}

	private void expandInputAroundCenter(String input, int left, int right) {
		while ( left >=0 && right < input.length() ) {
			if ( left == right || input.charAt(left) == input.charAt(right) ) {
				left--;
				right++;
			}
			else {
				break;
			}
		}
		
		// the loop will break if the char on left doesn't equal the char on the right,
		// so you need to rollback to the last matching combination of left and right
		left++;
		right--;
		
		
		if ( end-start < right-left ) {
			start = left;
			end = right;
		}
	}

}
