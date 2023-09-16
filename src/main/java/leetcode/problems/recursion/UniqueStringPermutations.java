package leetcode.problems.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 * 
 * Permutations of a given string
Medium

100+ Candidates recieved offers in the last 3 months through Job-A-Thon. Your call is just a click away

Given a string S. The task is to print all unique permutations of the given string in lexicographically sorted order.

Example 1:

Input: ABC
Output:
ABC ACB BAC BCA CAB CBA
Explanation:
Given string ABC has permutations in 6 
forms as ABC, ACB, BAC, BCA, CAB and CBA .

Example 2:

Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
Explanation:
Given string ABSG has 24 permutations.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function find_permutation() which takes the string S as input parameter and returns a vector of string in lexicographical order.

Expected Time Complexity: O(n! * n)
Expected Space Complexity: O(n! * n)

Constraints:
1 <= length of string <= 5
 * 
 * @author Moataz Lasheen
 *
 */
public class UniqueStringPermutations {
	
	public List<String> findPermutations(String input) {
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		List<String> uniquePermutations = new ArrayList<>();
		findPermutations(new String(chars), "", uniquePermutations);
		return uniquePermutations;
	}

	private void findPermutations(String input, String currentPermutation, List<String> uniquePermutations) {
		if (input.length() == 0 ) {
			uniquePermutations.add(currentPermutation);
		}
		Set<Character> seen = new HashSet<>();
		String newInput;
		char ch;
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (!seen.contains(ch)) {
				// current character will be chosen to be the next character
				// in the current permutation
				newInput = input.substring(0, i) + input.substring(i+1);
				findPermutations(newInput, currentPermutation+ch, uniquePermutations);
			}
			seen.add(ch);
		}
	}

}
