package leetcode.problems.dynamicprogramming;


/**
 * 
 * 70. Climbing Stairs
Easy

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 

Constraints:

    1 <= n <= 45


 * 
 * @author Moataz Lasheen
 *
 */
public class ClimbingStairs {
	
	// it is always the summtion of ways to reach to the previous step + the ways to reach the 
	// step beforE the previous step, 
	// it is more like fibonacci series
	
	// if you write down the results for 1,2,3,4,5,6 steps, you will find the pattern
	// [1, 2, 3, 5, 8], except that fibonacci series starts with 0, 1, 1, 2, 3
	// but this series starts 1, 2 , 3, 5
//	// TC : O(n), SC: O(n)
//	public int climbStairs(int n) {
//        if (n < 3) {
//            return n;
//        }
//
//        int [] dp = new int [n];
//        dp[0] = 1;
//        dp[1] = 2;
//
//        for (int i = 2; i < n; i++ ) { 
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//
//        return dp[n-1];
//        
//    }
	
	// TC : O(n), SC: O(1)
	public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int beforePrev = 1;
        int prev = 2;
        int current;
        for (int i = 3; i <= n; i++ ) { 
            current = beforePrev + prev;
            beforePrev = prev;
            prev = current;
            
        }

        return prev;
        
    }

}
