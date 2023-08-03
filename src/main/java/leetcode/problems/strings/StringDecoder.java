package leetcode.problems.strings;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 394. Decode String
Medium

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

 

Constraints:

    1 <= s.length <= 30
    s consists of lowercase English letters, digits, and square brackets '[]'.
    s is guaranteed to be a valid input.
    All the integers in s are in the range [1, 300].


 * @author Moataz Lasheen
 *
 */
public class StringDecoder {

	public String decode(String encoded) {
		
		StringBuilder resultSb = new StringBuilder();
		
		Deque<String> stringStack = new ArrayDeque<>();
		Deque<Integer> intgerStack = new ArrayDeque<>();
		
		for ( int i=0; i<encoded.length(); i++ ) {
			Character currentChar = encoded.charAt(i);
			if ( Character.isDigit(currentChar) ) {
				int intValue = Character.getNumericValue(currentChar);
				while ( i<encoded.length()-1 && Character.isDigit(encoded.charAt(++i)) ) {
					intValue = intValue * 10 + Character.getNumericValue(encoded.charAt(i));
				}
				i--;
				intgerStack.push(intValue);
			} else if ( Character.isAlphabetic(currentChar) ) {
				stringStack.push(currentChar.toString());
			} else if (  currentChar == '[' ) {
				stringStack.push(currentChar.toString());
			} else if ( currentChar == ']' ) {
				String poppedOut = stringStack.pop();
				String toRepeat = "";
				String temp = "";
				while (!poppedOut.equals("[")) {
					toRepeat = poppedOut + toRepeat;
					poppedOut = stringStack.pop();
				}
				int repeatition = intgerStack.pop();
				for ( int j=0; j< repeatition; j++ ) {
					temp += toRepeat;
				}
				stringStack.push(temp);
			}
		}
		
		while (!stringStack.isEmpty()) {
			resultSb.insert(0, stringStack.pop());
			
		}
		return resultSb.toString();
	}

}
