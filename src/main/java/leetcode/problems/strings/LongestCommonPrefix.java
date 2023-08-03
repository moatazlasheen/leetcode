package leetcode.problems.strings;

public class LongestCommonPrefix {

//	public String findLongestCommonPrefix(String[] input) {
//		StringBuilder commonPrefixSb = new StringBuilder("");
//		if ( input.length > 0 ) {
//			commonPrefixSb.append(input[0]);
//			for ( int i=1; i< input.length; i++ ) {
//				commonPrefixSb = getCommonPrefix(commonPrefixSb, input[i]);
//			}
//		}
//		return commonPrefixSb.toString();
//	}

//	private StringBuilder getCommonPrefix(CharSequence charSeq1, CharSequence charSeq2) {
//		StringBuilder sb = new StringBuilder();
//		for ( int i=0; i<charSeq1.length(); i++ ) {
//			if ( charSeq1.charAt(i) == charSeq2.charAt(i) ) {
//				sb.append(charSeq1.charAt(i));
//			}else {
//				break;
//			}
//		}
//		return sb;
//	}
	
	public String findLongestCommonPrefix(String[] input) {
		String commonPrefix = "";
		if ( input.length > 0 ) {
			commonPrefix = input[0];
			for ( int i=1; i< input.length; i++ ) {
				commonPrefix = getCommonPrefix(commonPrefix, input[i]);
			}
		}
		return commonPrefix;
	}
	
	private String getCommonPrefix(String str1, String str2) {
		String prefix = str1;
		while ( !str2.startsWith(prefix) ) {
			prefix = prefix.substring(0, prefix.length()-1);
		}
		return prefix;
	}
	
	// Wrong implementation : indexof searches for the string anywhere, the requirement is to search
	// for the string in the beginning of the string (prefix)
	
//	private String getCommonPrefix(String str1, String str2) {
//		String prefix = str1;
//		while ( str2.indexOf(prefix) < 0 ) {
//			prefix = prefix.substring(0, prefix.length()-1);
//		}
//		return prefix;
//	}

}
