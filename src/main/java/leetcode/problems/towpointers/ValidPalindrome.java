package leetcode.problems.towpointers;


/**
 * 
 * 125. Valid Palindrome
Easy

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

 

Constraints:

    1 <= s.length <= 2 * 10^5
    s consists only of printable ASCII characters.


 * 
 * @author Moataz Lasheen
 *
 */
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if ( s.length() == 1 ) {
			return true;
		}
		
		int left = 0; 
		int right = s.length()-1;
		
		while (left<right) {
			if ( !Character.isLetterOrDigit(s.charAt(left)) ) {
				left++;
			} else if ( !Character.isLetterOrDigit(s.charAt(right)) ) {
				right--;
			} else {
				// both left and right are alphanumerics
				if ( Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--)) ) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	// good but nested loops are complicating the algo, it should be simpler
	// TC : O(n)
	// SC : O(1)
	public boolean isPalindrome2(String s) {
		if ( s.length() == 1 ) {
			return true;
		}
		
		s = s.toLowerCase();
		int left = 0;
		int right = s.length()-1;
		
		while (left<right) {
			while (left<right && !Character.isLetterOrDigit(s.charAt(left)) ) {
				left++;
				
			}
			
			while (left<right && !Character.isLetterOrDigit(s.charAt(right)) ) {
				right--;
			}
			
			if ( s.charAt(left++) != s.charAt(right--) ) {
				return false;
			}
			
		}
		
		return true;
    }

}
