package leetcode.problems.strings;

public class StringReversing {

//	public String reverse(String input) {
//		if ( input == null || input.isEmpty() || input.length() == 1 ) {
//			return input;
//		}
//		
//		StringBuilder sb = new StringBuilder(input);
//		char temp;
//		
//		for ( int i=0; i<input.length()/2; i++) {
//			temp = sb.charAt(i);
//			sb.replace(i, i+1, String.valueOf(input.charAt(input.length()-1-i)));
//			sb.replace(input.length()-1-i, input.length()-i, String.valueOf(temp));
//			
//		}
//		
//		return sb.toString();
//	}
	
//	public String reverse(String input) {
//		if ( input == null || input.isEmpty() || input.length() == 1 ) {
//			return input;
//		}
//		
//		char[] chars = input.toCharArray();
//		char temp;
//		
//		for ( int i=0; i<chars.length/2; i++) {
//			temp = chars[i];
//			chars[i] = chars[chars.length-1-i];
//			chars[chars.length-1-i] = temp;
//			
//		}
//		
//		return new String(chars);
//	}

	public String reverse(String input) {
		if ( input == null || input.isEmpty() || input.length() == 1 ) {
			return input;
		}
		
		char[] chars = input.toCharArray();
		char temp;
		int leftIndex = 0;
		int rightIndex = chars.length-1;
		
		while ( rightIndex > leftIndex ) {
			temp = chars[leftIndex];
			chars[leftIndex] = chars[rightIndex];
			chars[rightIndex] = temp;
			
			leftIndex++;
			rightIndex--;
			
		}
		
		return new String(chars);
	}

	

}
