package leetcode.problems.numbers;

public class PalindromeInteger {

//	public boolean isPalindrome(int input) {
//		boolean result = true;
//		String inputStr = String.valueOf(input);
//		
//		for ( int i=0; i<inputStr.length()/2; i++ ) {
//			if ( inputStr.charAt(i) != inputStr.charAt(inputStr.length()-1-i) ) {
//				result = false;
//				break;
//			}
//		}
//		return result;
//	}
	
	public boolean isPalindrome(int input) {
		boolean result;
		
		// negative numbers are not palindromes
		
		// single digit int is guaranteed to be palindrome
		if ( input >=0 && input<10) {
			result = true;
		}
		// if the number ends with zero, it is not palindrome
		else if ( input%10 == 0 ) {
			result = false;
		} else {
			
			int reversedHalf = 0;
			
			while ( reversedHalf < input ) {
				reversedHalf = reversedHalf * 10 + input % 10 ;
				input = input / 10;
			}
			
			if ( reversedHalf == input || reversedHalf/10 == input ) {
				result = true;
			} else {
				result = false;
			}
		}
		
		
		return result;
	}
	
	

}
