package leetcode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 77. Combinations
Medium

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.

 

Constraints:

    1 <= n <= 20
    1 <= k <= n



 * @author Moataz Lasheen
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        combine(n,k, new ArrayList<>(), combinations, 1);
        return combinations;
    }
    private void combine(int n, int k, List<Integer> currentCombination, List<List<Integer>> combinations, int start) {

        if (currentCombination.size() == k){
            combinations.add(new ArrayList<Integer>(currentCombination));
            return;
        }

        for (int i = start; i <= n; i++){
            currentCombination.add(i);
            combine(n,k, currentCombination, combinations, i+1);
            currentCombination.remove(currentCombination.size() -1);
        }

    }
}
