package leetcode.problems.recursion;

import java.util.List;

/**
 * 1239. Maximum Length of a Concatenated String with Unique Characters
Medium

You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.

Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").

Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters.

 

Constraints:

    1 <= arr.length <= 16
    1 <= arr[i].length <= 26
    arr[i] contains only lowercase English letters.


 * 
 * @author Moataz Lasheen
 *
 */
public class MaxLengthOfConcatenatedStrings {
	
int max = 0;
	
	public int maxLength(List<String> arr) {
		maxLength(arr, new StringBuilder(), 0);
		
        return max;
    }

	private void maxLength(List<String> arr, StringBuilder currentPossibility, int startIndex) {
		if (startIndex == arr.size()) {
			return;
		}
		
		
		// taking token at the current index
		currentPossibility.append(arr.get(startIndex));
		if (isUnique(currentPossibility)) {
			if (currentPossibility.length() > max) {
				max = currentPossibility.length();
			}
			maxLength(arr, currentPossibility, startIndex+1);
		}
		
		// backtracking
		currentPossibility.delete(currentPossibility.length()-arr.get(startIndex).length(), currentPossibility.length());
		 
		// dropping token at current index
		maxLength(arr, currentPossibility, startIndex+1);
	}

	private boolean isUnique(StringBuilder currentPossibility) {
		int [] englishLetters = new int [26];
		int currentIndex;
		for (int i = 0; i < currentPossibility.length(); i++) {
			currentIndex = currentPossibility.charAt(i)-'a';
			if (englishLetters[currentIndex] < 1) {
				englishLetters[currentIndex]++;
			} else {
				return false;
			}
		}
		
		return true;
	}

}
