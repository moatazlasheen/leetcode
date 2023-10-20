package leetcode.problems.dynamicprogramming;


/**
 * 322. Coin Change
Medium
https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0

 

Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 2^31 - 1
    0 <= amount <= 10^4


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		
		// the dp array will hold the minimum number of coins from the array 
		// that add up to the current index
		int [] dp = new int [amount+1];
		// default is zero, can be omitted
		dp[0] = 0;
		
		int min;
		
		// for each amount less than or equal to the target amount
		for (int i = 1; i < dp.length; i++) {
			// suppose we need infinite amount of coins initially,
			// will be compared later with other possible values
			min = Integer.MAX_VALUE;
			// for each coin
			// if you can use one of this coin and you already have the
			// minimum number of coins for the remaining ( remaining is absolutely less than current)
			for (int j = 0; j < coins.length; j++) {
				// if the current coin is already bigger than the current terget
				// then do nothing, it couldn't be used
				if (i >= coins[j]) {
					
					if (dp[i-coins[j]] != -1) {
						// the difference between current target and current coin
						// can be collected from the array
						min = Math.min(min, 1 + dp[i-coins[j]]);
					}
					
				}
			}		
			dp[i] = min == Integer.MAX_VALUE ? -1 : min;
		}
		
		return dp[amount];
    }
}
