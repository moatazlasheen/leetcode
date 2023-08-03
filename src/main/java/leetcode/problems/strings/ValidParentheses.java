package leetcode.problems.strings;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

 

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

 

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.


 * @author Moataz Lasheen
 *
 * Level : Easy
 *
 */

public class ValidParentheses {

	public boolean isValid(String s) {
		boolean isValid = true;
		Deque<Character> stack = new ArrayDeque<>();
		char c;
		for ( int i=0; i< s.length(); i++ ) {
			c = s.charAt(i);
			if ( isOpeningParentheses(c)) {
				stack.push(c);
			} else {
				// closing parentheses
				if ( stack.isEmpty() || !areMatchingParentheses(stack.pop(), c) ) {
					isValid = false;
					break;
				}
				
			}
		}
		
		if ( !stack.isEmpty() ) {
			isValid = false;
		}
		
		return isValid;
	}

	private boolean areMatchingParentheses(char openingParenthes, char closingParenthes) {
		return ( (openingParenthes == '(' && closingParenthes == ')') || 
				 (openingParenthes == '{' && closingParenthes == '}') || 
				 (openingParenthes == '[' && closingParenthes == ']') );
	}

	private boolean isOpeningParentheses(char c) {
		return c == '(' || c == '{' || c == '[';
	}

}
