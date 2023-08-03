package leetcode.problems.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * 
 * The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

    For example, "ACGAATTCCG" is a DNA sequence.

When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.

 

Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]

 

Constraints:

    1 <= s.length <= 105
    s[i] is either 'A', 'C', 'G', or 'T'.


 * 
 * 
 * */

public class RepeatedDNASeq {

//	public List<String> findRepeatedDnaSequences(String input) {
//		Set<String> repeatedSequencesSet = new HashSet<>();
//		if ( input.length() > 10 ) {
//			for ( int i=0; i< input.length()-10; i++ ) {
//				if ( input.indexOf(input.substring(i, i+10), i+1) > 0 ) {
//					repeatedSequencesSet.add(input.substring(i, i+10));
//				}
//			}
//		}
//		return new ArrayList<>(repeatedSequencesSet);
//	}
	
	// okay but exceeds the time limit
//	public List<String> findRepeatedDnaSequences(String input) {
//		Set<String> examinedTokens = new HashSet<>();
//		List<String> repeatedSequences = new ArrayList<>();
//		if ( input.length() > 10 ) {
//			String potentialToken;
//			for ( int i=0; i< input.length()-10; i++ ) {
//				potentialToken = input.substring(i, i+10);
//				if ( examinedTokens.add(potentialToken) ) {
//					if ( input.indexOf(potentialToken, i+1) > 0 ) {
//						repeatedSequences.add(input.substring(i, i+10));
//					}
//				}
//				
//			}
//		}
//		return repeatedSequences;
//	}
	
	
	// okay but exceeds time limit
//	public List<String> findRepeatedDnaSequences(String s) {
//		List<String> repeatedSequences = new ArrayList<>();
//		if ( s.length() > 10 ) {
//			Set<String> examinedTokens = new HashSet<>();
//			String potentialToken;
//			for ( int i=0; i<s.length()-10; i++ ) {
//				potentialToken = s.substring(i, i+10);
//				if ( examinedTokens.add(potentialToken) ) {
//					if ( s.indexOf(potentialToken, i+1) > 0 ) {
//						repeatedSequences.add(potentialToken);
//					}
//				}
//			}
//		}
//		return repeatedSequences;
//	}
	
	
	
	public List<String> findRepeatedDnaSequences(String s) {
	Set<String> seen = new HashSet<>();
	Set<String> repeated = new HashSet<>();
    for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        if (!seen.add(ten))
            repeated.add(ten);
    }
    return new ArrayList<String>(repeated);
	}

}
