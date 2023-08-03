package leetcode.problems.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

//	public boolean isAnagram(String s, String t) {
//		char[] sChars = s.toCharArray();
//		char[] tChars = t.toCharArray();
//		
//		if ( s.length() != t.length()) {
//			return false;
//		}
//		
//		for ( int i=0; i<s.length(); i++ ) {
//			char c = sChars[i];
//			boolean found = false;
//			for ( int j=0; j<t.length(); j++ ) {
//				if (tChars[j] == c ) {
//					tChars[j] = '#';
//					found = true;
//					break;
//				}
//			}
//			if ( !found ) {
//				return false;
//			}
//		}
//		return true;
//	}
	
//	public boolean isAnagram(String s, String t) {
//		if ( s.length() != t.length() ) {
//			return false;
//		}
//		char[] sChars = s.toCharArray();
//		char[] tChars = t.toCharArray();
//		
//		Arrays.sort(sChars);
//		Arrays.sort(tChars);
//		
//		return Arrays.equals(sChars, tChars);
//	}
	
//	public boolean isAnagram(String s, String t) {
//		if ( s.length() != t.length() ) {
//			return false;
//		}
//		Map<Character, Integer> sMap = new HashMap<>();
//		Map<Character, Integer> tMap = new HashMap<>();
//		
//		for ( int i=0; i< s.length(); i++ ) {
//			char sChar = s.charAt(i);
//			char tChar = t.charAt(i);
//			sMap.putIfAbsent(sChar, 1);
//			tMap.putIfAbsent(tChar, 1);
//			sMap.put(sChar, sMap.get(sChar)+1);
//			tMap.put(tChar, tMap.get(tChar)+1);
//			
//		}
//		
//		return sMap.equals(tMap);
//		
//	}
	
//	public boolean isAnagram(String s, String t) {
//		if ( s.length() != t.length() ) {
//			return false;
//		}
//		
//		int [] freq = new int[26];
//		
//		for ( int i=0; i< s.length(); i++ ) {
//			freq[s.charAt(i) - 'a']++;
//			freq[t.charAt(i) - 'a']--;
//			
//		}
//
//		for ( int i=0; i<freq.length; i++ ) {
//			if ( freq[i] != 0 ) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
	
	public boolean isAnagram(String s, String t) {
		if ( s.length() != t.length() ) {
			return false;
		}
		
		int [] freq = new int[26];
		
		for ( int i=0; i< s.length(); i++ ) {
			freq[s.charAt(i) - 'a']++;
		}
		
		for ( int i=0; i< s.length(); i++ ) {
			if ( freq[t.charAt(i) - 'a'] == 0 ) {
				return false;
			}else {
				freq[t.charAt(i) - 'a']--;
			}
			
		}

		for ( int i=0; i<freq.length; i++ ) {
			if ( freq[i] != 0 ) {
				return false;
			}
		}
		
		return true;
	}

}
