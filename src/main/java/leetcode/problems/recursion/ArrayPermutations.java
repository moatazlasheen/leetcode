package leetcode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 46. Permutations
Medium

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]

 

Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.



 * @author Moataz Lasheen
 *
 */
public class ArrayPermutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, new ArrayList<Integer>(nums.length), permutations);
        return permutations;
    }

    private void permute(int[] nums, List<Integer> currentPermutation, List<List<Integer>> permutations) {
        if (currentPermutation.size() == nums.length){
            permutations.add(new ArrayList<>(currentPermutation));
        }

        for (int i = 0; i < nums.length; i++){
            if (currentPermutation.contains(nums[i]))  {
                continue;
            }
            currentPermutation.add(nums[i]);
            permute(nums, currentPermutation, permutations);
            currentPermutation.remove(currentPermutation.size()-1);

        }
    }
}
