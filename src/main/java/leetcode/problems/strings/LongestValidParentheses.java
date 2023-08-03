package leetcode.problems.strings;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 32. Longest Valid Parentheses
Hard
11.1K
354
Companies

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring
.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:

Input: s = ""
Output: 0

 

Constraints:

    0 <= s.length <= 3 * 104
    s[i] is '(', or ')'.


 * @author Moataz Lasheen
 *
 */
public class LongestValidParentheses {

//	public int longestValidParentheses(String input) {
//		int start = 0;
//		int end = 0;
//		Deque<Character> stack = new ArrayDeque<>();
//		if ( input.length() > 1 ) {
//			for ( int i=0; input.length()-i > end-start; i++ ) {
//				stack.clear();
//				if ( input.charAt(i) == '(' ) {
//					stack.push(input.charAt(i));
//					for ( int j=i+1; j<input.length(); j++ ) {
//						if ( input.charAt(j) == '(' ) {
//							stack.push(input.charAt(j));
//						} else if ( input.charAt(j) == ')') {
//							if ( stack.isEmpty() ) {
//								// invalid parentheses
//								break;
//							} else {
//								stack.pop();
//							}
//							if ( stack.isEmpty() && (j-i) > (end-start)) {
//								end = j;
//								start = i;
//							}
//						} 
//						
//					}
//				}
//			}
//		}
//		
//		if ( end == start) {
//			return 0;
//		} else {
//			return end-start +1;
//		}
//		
//		
//	}
	
	public int longestValidParentheses(String input) {
		if ( input == null || input.length() < 2 ) {
			return 0;
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(-1);
		int result = 0;
		for ( int i=0; i<input.length(); i++ ) {
			if ( input.charAt(i) == '(' ) {
				stack.push(i);
			} else {
				stack.pop();
				if ( stack.isEmpty() ) {
					stack.push(i);
				} else {
					result = Math.max(result, i-stack.peek());
				}
			}
		}
		
		return result;
		
	}

}
