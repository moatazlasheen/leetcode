package leetcode.problems.arrays;

/**
 * 58. Length of Last Word
Easy

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal
substring
consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

 

Constraints:

    1 <= s.length <= 10^4
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.


 * @author Moataz Lasheen
 *
 */
public class LastWordLength {
	public int lengthOfLastWord(String s) {
        int left = -1;
        int right = -1;
        for ( int i=s.length()-1; i>=0; i--) {
        	if ( !Character.isWhitespace(s.charAt(i)) ) {
        		right = i;
        		break;
        	}
        }
        if ( right > -1 ) {
        	for ( int i=right-1; i>=0; i--) {
            	if ( Character.isWhitespace(s.charAt(i)) ) {
            		left = i;
            		break;
            	}
            }
        }
        return right-left;
        
    }
}
