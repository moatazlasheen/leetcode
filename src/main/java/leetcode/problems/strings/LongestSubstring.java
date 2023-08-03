package leetcode.problems.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest
substring
without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.


 * @author Moataz Lasheen
 *
 */

public class LongestSubstring {

//	public int lengthOfLongestSubstring(String input) {
//		int result = 0;
//		if ( input.length() == 1 ) {
//			result = 1;
//		}
//		else {
//			Set<Character> seenChars = new HashSet<>();
//			int longestSubStringStartIndex = 0;
//			for ( int i=0; i<input.length(); i++ ) {
//				if ( seenChars.add(input.charAt(i)) ) {
//					result++;
//				} else {
//					int potentialResult = lengthOfLongestSubstring(input.substring(longestSubStringStartIndex+1));
//					if ( potentialResult > result ) {
//						result = potentialResult;
//					}
//					break;
//				}
//			}
//		}
//		
//		return result;
//	}
	
	public int lengthOfLongestSubstring(String input) {
		StringBuilder sb = new StringBuilder("");
		int result = 0;
		
		Set<Character> seenCharacters = new HashSet<>();
		for ( int i=0; i<input.length(); i++ ) {
			Character currentCharacter = input.charAt(i);
			if ( seenCharacters.add(currentCharacter) ) {
				sb.append(currentCharacter);
			} else {
				if ( result < sb.length() ) {
					result = sb.length();
				}
				int index = sb.indexOf(currentCharacter.toString());
				for ( int j=0; j<index; j++ ) {
					seenCharacters.remove(sb.charAt(j));
				}
				sb.delete(0, index+1);
				sb.append(currentCharacter);
				
			}
		}
		
		if ( result < sb.length() ) {
			result = sb.length();
		}
		
		return result;
	}
	
	
	// stolen
//	public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet();
//        int max = 0;
//        int left = 0;
//        for (int right = 0; right < s.length(); right++) {
//            while(!set.add(s.charAt(right))) {
//                set.remove(s.charAt(left++));
//            }
//            max = Math.max(max, right - left + 1);
//        }
//        return max;
//    }


}
