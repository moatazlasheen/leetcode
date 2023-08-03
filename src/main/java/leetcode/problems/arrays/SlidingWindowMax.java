package leetcode.problems.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * 239. Sliding Window Maximum
Hard

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:

Input: nums = [1], k = 1
Output: [1]

 

Constraints:

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    1 <= k <= nums.length



 * @author Moataz Lasheen
 *
 */
public class SlidingWindowMax {
	
	
	// TC : O(n)
	// SC : O(n+k)
	public int[] maxSlidingWindow(int[] nums, int k) {
		
		int [] output = new int [nums.length-k+1];
		// first item in this deque should hold the maximum number in the current window
		Deque<Integer> currentWindowDeque = new ArrayDeque<>(k);
		for ( int i=0; i<nums.length; i++) {
			// remove from the start of the deque all element that are outside the
			// boundaries of the current window
			while ( !currentWindowDeque.isEmpty() && currentWindowDeque.peekFirst() < i-k+1 ) {
				currentWindowDeque.pollFirst();
			}
			// place the current value in the deque in the correct position
			// remove from the end of the deque all elements that are less than the 
			// current element
			while ( !currentWindowDeque.isEmpty() && nums[currentWindowDeque.peekLast()] < nums[i] ) {
				currentWindowDeque.pollLast();
			}
			
			currentWindowDeque.offer(i);
			
			// if the current index is the end of a possible window, insert the maximum
			// of the current window in the output array
			if ( i >= k-1 ) {
				output[i-k+1] = nums[currentWindowDeque.peekFirst()];
			}
		}
		
		return output;
		
	}
	// TC : O(n*k)
	// SP : O(n), the result array
	public int[] maxSlidingWindow2(int[] nums, int k) {
		int [] output = new int [nums.length-k+1];
		output[0] = getMax(nums, 0, k-1);
		int left = 1;
		for ( int right = left + k - 1; right<nums.length; right++ ) {
			if ( nums[right] > output[left-1] ) {
				output[left] = nums[right];
			}else {
				if ( nums[left-1] < output[left-1] ) {
					output[left] = output[left-1];
				} else {
					output[left] = getMax(nums, left, right);
				}
			}
			
			left++;
		}
		
		return output;
    }

	private int getMax(int[] nums, int left, int right) {
		int max = nums[left];
		for ( int i=left+1; i<=right; i++) {
			if ( nums[i] > max ) {
				max = nums[i];
			}
		}
		return max;
	}
}
