package leetcode.problems.dynamicprogramming;


/**
 * 
 * 97. Interleaving String
Medium
https://leetcode.com/problems/interleaving-string/

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m
substrings
respectively, such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...

Note: a + b is the concatenation of strings a and b.

 

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.

Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.

Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true

 

Constraints:

    0 <= s1.length, s2.length <= 100
    0 <= s3.length <= 200
    s1, s2, and s3 consist of lowercase English letters.

 * 
 * @author Moataz Lasheen
 *
 */
public class InterleavingString {
	
	// dynamic programming
	public boolean isInterleave(String s1, String s2, String s3) {
        
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		
		if (s1.equals("")) {
        	return s2.equals(s3);
        }
        if (s2.equals("")) {
        	return s1.equals(s3);
        }
        
        boolean [][] dp = new boolean [s1.length()+1][s2.length()+1];
        // is it possible to construct "" by interleaving "" and "", yes
        dp[s1.length()][s2.length()] = true;
        
        for (int i = dp.length-1; i >= 0; i-- ) {
        	for (int j = dp[0].length-1; j >= 0; j--) {
        		// if we take the next character from the first string, 
        		// will it be possible to construct the rest of s3 
        		// from the rest of s1 and the rest of s2
        		if (i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && dp[i+1][j]) {
        			dp[i][j] = true;
        		}
        		// if we take the next character from the second string, 
        		// will it be possible to construct the rest of s3 
        		// from the rest of s1 and the rest of s2
        		if (j < s2.length() && s2.charAt(j) == s3.charAt(i+j) && dp[i][j+1]) {
        			dp[i][j] = true;
        		}
        	}
        }
        
        return dp[0][0];
    }
    
	
//	// Time limit exceeded, after passing 97 / 106
//	public boolean isInterleave(String s1, String s2, String s3) {
//        if (s1.equals("")) {
//        	return s2.equals(s3);
//        }
//        if (s2.equals("")) {
//        	return s1.equals(s3);
//        }
//        return isInterleave(s1, 0, s2, 0, s3, 0, 0, 0);    
//    }
//    private boolean isInterleave(String s1, int index1, String s2, int index2, String s3, int index3, int sub1, int sub2) {
//        if ( s3.length() - index3 != s1.length() - index1 + s2.length() - index2) {
//            return false;
//        }
//
//        if (index3 == s3.length()) {
//            return true;
//        }
//        
//        if (index1 < s1.length() && s1.charAt(index1) != s3.charAt(index3) && index2 < s2.length() && s2.charAt(index2) != s3.charAt(index3)) {
//            return false;
//        }
//
//        // next character from s1
//        boolean b1 = index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3) && isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1, sub1 + 1, sub2);
//        // next character from s2
//        boolean b2 = index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3) && isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1, sub1, sub2 + 1);
//        
//        
//        return b1 || b2;
//        
//        // taking as many characters as long as they match the result may not give
//        // the correct result, see this test case "aa", "ab", "aaba"
//        // if you decided to take aa from the first string in the first step, the it will
//        // give false but if you take one a from aa the ab (second string) the a it will 
//        // give true, you have to make it one by one
//
////        int max1 = 0;
////        for (int i = 1; i <= s1.length() - index1; i++) {
////            if (s1.substring(index1, index1+i).equals(s3.substring(index3, index3 +i))) {
////                max1++;
////            } else {
////                break;
////            }
////        }
////        int max2 = 0;
////        for (int i = 1; i <= s2.length() - index2; i++) {
////            if (s2.substring(index2, index2+i).equals(s3.substring(index3, index3 +i))) {
////                max2++;
////            } else {
////                break;
////            }
////        }
////
////        if (max1 == 0 && max2 == 0) {
////            return false;
////        }
////
////        if (max1 >= max2) {
////            return isInterleave(s1, index1 + max1, s2, index2, s3, index3 + max1, sub1 + 1, sub2);
////        } else {
////            return isInterleave(s1, index1, s2, index2 + max2, s3, index3 + max2, sub1, sub2+1);
////        }
//
//
//    }

}
