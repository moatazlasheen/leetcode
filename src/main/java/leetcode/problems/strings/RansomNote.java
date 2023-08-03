package leetcode.problems.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 383. Ransom Note
Easy

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true

 

Constraints:

    1 <= ransomNote.length, magazine.length <= 10^5
    ransomNote and magazine consist of lowercase English letters.




 * @author Moataz Lasheen
 *
 */
public class RansomNote {
	
//	public boolean canConstruct ( String ransomeNote, String magazine ) {
//		Map<Character, Integer> magazineLettersMap = new HashMap<>();
//		Character currentChar;
//		Integer count;
//		boolean result = true;
//		if ( magazine.length() < ransomeNote.length() ) {
//			result = false;
//		}
//		else {
//			for ( int i=0; i<magazine.length(); i++ ) {
//				currentChar = magazine.charAt(i);
//				count = magazineLettersMap.get(currentChar);
//				if ( count == null ) {
//					magazineLettersMap.put(currentChar, 1);
//				} else {
//					magazineLettersMap.put(currentChar, ++count);
//				}
//			}
//			for ( int i=0; i<ransomeNote.length(); i++ ) {
//				currentChar = ransomeNote.charAt(i);
//				count = magazineLettersMap.get(currentChar);
//				if ( count == null || count == 0 ) {
//					result = false;
//					break;
//				} else {
//					magazineLettersMap.put(currentChar, --count);
//				}
//			}
//		}
//		return result;
//	}
	
	public boolean canConstruct ( String ransomeNote, String magazine ) {
		int [] frequency = new int[26];
		Character currentChar;
		Integer count;
		boolean result = true;
		if ( magazine.length() < ransomeNote.length() ) {
			result = false;
		}
		else {
			for ( int i=0; i<magazine.length(); i++ ) {
				currentChar = magazine.charAt(i);
				frequency[currentChar - 'a']++;
			}
			for ( int i=0; i<ransomeNote.length(); i++ ) {
				currentChar = ransomeNote.charAt(i);
				count = frequency[currentChar - 'a'];
				if ( count <= 0 ) {
					result = false;
					break;
				} else {
					frequency[currentChar - 'a']--;
				}
			}
		}
		return result;
	}

}
