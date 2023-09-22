package leetcode.problems.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
Medium

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].


 * 
 * @author Moataz Lasheen
 *
 */
public class PhoneNumberCombinations {
	
	String [] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public List<String> letterCombinations(String digits) {
        LinkedList<String> out = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
        	return out;
        }
        
        letterCombinations(digits, out, new StringBuilder(), 0);
        
        return out;
    }

	private void letterCombinations(String digits, LinkedList<String> out, StringBuilder comb, int startIndex) {
		if(comb.length() == digits.length()) {
			out.add(comb.toString());
			return;
		}
		if (startIndex >= digits.length() ) {
			return;
		}
		
		String potentialChars = mapping[Character.getNumericValue(digits.charAt(startIndex))];
		
		for ( int i = 0; i < potentialChars.length(); i++) {
			comb.append(potentialChars.charAt(i));
			letterCombinations(digits, out, comb, startIndex+1);
			comb.deleteCharAt(comb.length()-1);
		}
		
	}
	
//	// this solution is iterative
//	public List<String> letterCombinations(String digits) {
//        LinkedList<String> out = new LinkedList<>();
//        if (digits == null || digits.length() == 0) {
//        	return out;
//        }
//        
//        // add all posible elements of size 0
//        out.add("");
//        String [] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        for (int i = 0; i<digits.length(); i++) {
//        	int currentDigit = digits.charAt(i);
//        	int currentDigitmappingIndex = Character.getNumericValue(currentDigit);
//        	while (out.peek().length() == i) {
//        		// remove all elements with size i from the front of the list
//        		// and for each removed element append a charcter from the next string mapping
//        		String tmp = out.remove();
//        		
//        		for (char ch : mapping[currentDigitmappingIndex].toCharArray()) {
//        			out.add(tmp+ch);
//        		}
//				
//			}
//        }
//        return out;
//    }
}
