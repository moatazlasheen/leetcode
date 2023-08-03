package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSumZero {
	
	public int getLongestSubArrayLengthWithSumZero( int [] nums ) {
		
		Map<Integer, Integer> tillIndexSumMap = new HashMap<>();
		int sum = 0;
		int length = 0;
		for ( int i=0; i<nums.length; i++ ) {
			sum += nums[i];
			if ( sum == 0 ) {
				length = Math.max(length, i+1);
			}
			if ( tillIndexSumMap.get(sum) == null ) {
				tillIndexSumMap.put(sum, i);
			} else {
				length = Math.max(length, i - tillIndexSumMap.get(sum));
			}
		}
		
		return length;
		
		
		
	}

}
