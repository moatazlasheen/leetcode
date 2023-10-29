package leetcode.problems.bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Power Set
Easy

GfG Weekly + You = Perfect Sunday Evenings!
Register for free now
banner

Given a string S, Find all the possible subsequences of the String in lexicographically-sorted order.

Example 1:

Input : str = "abc"
Output: a ab abc ac b bc c
Explanation : There are 7 subsequences that 
can be formed from abc.

Example 2:

Input: str = "aa"
Output: a a aa
Explanation : There are 3 subsequences that 
can be formed from aa.

Your Task:
You don't need to read input or print anything. Your task is to complete the function AllPossibleStrings() which takes S as the input parameter and returns a list of all possible subsequences (non-empty) that can be formed from S in lexicographically-sorted order.

Expected Time Complexity: O(n*2^n) where n is the length of the String
Expected Space Complexity: O(n * 2^n)
 

Constraints: 
1 <= Length of String <= 16
 * 
 * @author Moataz Lasheen
 *
 */
public class PowerSet {

	public List<String> AllPossibleStrings(String s)
    {
		int powerSetLength = (1 << s.length()) -1;
		List<String> powerSet = new ArrayList<>(powerSetLength);
        if (s.length() == 1) {
        	powerSet.add(s);
        	return powerSet;
        } 
        
        for(int i = 1; i <= powerSetLength; i++) {
        	StringBuilder sb = new StringBuilder();
        	for (int bit = 0; bit < s.length(); bit++) {
        		if ((i & (1 << bit)) != 0)  {
        			sb.insert(0,s.charAt(s.length()-1-bit));
        		}
        	}
        	powerSet.add(sb.toString());
        }
        
        Collections.sort(powerSet);
        return powerSet;
    }
	
}
