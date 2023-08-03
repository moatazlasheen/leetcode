package leetcode.problems.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 49. Group Anagrams
Level : Medium

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]

 

Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.


 * @author Moataz Lasheen
 *
 */
public class AnagramGroups {

//	public List<List<String>> groupAnagrams(String [] input) {
//		List<List<String>> result = new ArrayList<>();
//		Set<Integer> toSkipSet = new HashSet<>();
//		for ( int i=0; i<input.length; i++ ) {
//			if ( toSkipSet.contains(i) ) {
//				continue;
//			}
//			String currString = input[i];
//			List<String> currentStringAnagrams = new ArrayList<>();
//			currentStringAnagrams.add(currString);
//			for ( int j=i+1; j<input.length; j++) {
//				if ( !toSkipSet.contains(j) && currString.length() == input[j].length() ) {
//					String potentialAnagram = input[j];
//					if ( areAnagrams(currString, potentialAnagram) ) {
//						currentStringAnagrams.add(potentialAnagram);
//						toSkipSet.add(j);
//					}
//				}
//			}
//			result.add(currentStringAnagrams);
//		}
//		
//		return result;
//	}
//
//	private boolean areAnagrams(String str1, String str2) {
//		boolean anagrams = false;
//		if ( str1.equals(str2) || sort(str1).equals(sort(str2))) {
//			anagrams = true;
//		}
//		
//		return anagrams;
//	}
//
//	private String sort(String str1) {
//		char [] chars = str1.toCharArray();
//		Arrays.sort(chars);
//		return new String(chars);
//	}
	
	public List<List<String>> groupAnagrams(String [] input) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for ( int i=0; i<input.length; i++ ) {
			
			String currString = input[i];
			String currStringSorted = sort(currString);
			if ( !map.containsKey(currStringSorted) ) {
				map.put(currStringSorted, new ArrayList<String>());
			}
			
			map.get(currStringSorted).add(currString);
		}
		
		result.addAll(map.values());
		
		return result;
	}

	private String sort(String str1) {
		char [] chars = str1.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
