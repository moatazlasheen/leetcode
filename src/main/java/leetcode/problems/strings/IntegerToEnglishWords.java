package leetcode.problems.strings;


/**
 * 273. Integer to English Words
Hard

Convert a non-negative integer num to its English words representation.

 

Example 1:

Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:

Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 

Constraints:

    0 <= num <= 2^31 - 1


 * @author Moataz Lasheen
 *
 */
public class IntegerToEnglishWords {
	
	final static String [] lessThan20 = new String [] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", 
			"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
			"Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	final static String [] tens = new String [] {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	final static String hundred = "Hundred"; 
	final static String [] thousands = new String [] {"", "Thousand", "Million", "Billion"};

	public String numberToWords(int num) {
		
		StringBuilder sb = new StringBuilder();
		
		if ( num == 0 ) {
			return "Zero";
		}
		else {
		
			int j = 0;
			while(num>0) {
				
				int remainder = num%1000;
				if (remainder > 0 ) {
					sb.insert(0, maxThreeDigitsTranslator(remainder).append(" ").append(thousands[j]).append(" "));
				} 
				
				num = num/1000;
				
				j++;
			}
		}
		return sb.toString().trim();
	}
	
	private StringBuilder maxThreeDigitsTranslator ( int num ) {
		StringBuilder result = new StringBuilder();
		if ( num < 20 ) {
			result.append(lessThan20[num]);
		}
		else if ( num<100 && num % 10 == 0 ) {
			result.append(tens[num/10]);
		}
		else if ( num<100 && num % 10 != 0 ) {
			result.append(tens[num/10]).append(" ").append(lessThan20[num%10]);
		} 
		else {
			result.append(lessThan20[num/100]).append(" ").append(hundred);
			if ( num%100 > 0 ) {
				result.append(" ").append(maxThreeDigitsTranslator(num%100));
			}
		}
		return result;
	}
	
	
//	public String numberToWords(int num) {
//		
//		StringBuilder sb = new StringBuilder();
//		
//		String [] array1 = new String [] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
//		String [] array2 = new String [] {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//		String [] array3 = new String [] {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//		String [] array4 = new String [] {"Hundred", "Thousand", "Million", "Billion"};
//		
//		if ( num == 0 ) {
//			return "Zero";
//		}
//		if ( num < 10 ) {
//			return array1[num-1];
//		}
//		else if ( num>10 && num<20) {
//			return array2[num%10-1];
//		}
//		else if ( num<100 && num % 10 == 0 ) {
//			return array3[num/10-1];
//		}
//		else if ( num<100 && num % 10 != 0 ) {
//			return array3[num/10-1] + " " + array1[num%10-1];
//		} else if ( num < 1000 ) {
//			if ( num%100 == 0) {
//				return array1[num/100-1]  + " " + array4[0];
//			} else {
//				return array1[num/100-1]  + " " + array4[0] + " " + numberToWords(num%100);
//			}
//		}
//		else {
//		
//		int rest = num;
//		int j = 3;
//		for ( int i=1000000000; i>0; i=i/1000) {
//			int result = rest/i;
//			rest = rest % i; 
//			if (result > 0 ) {
//				sb.append(numberToWords(result) );
//				sb.append(" ").append(array4[j]);
//				if ( rest > 0 ) {
//					sb.append(" ").append(numberToWords(rest));
//					break;
//				}
//			}
//			
//			j--;
//		}
//		}
//		
//		return sb.toString();
//	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}

}
