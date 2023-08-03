package leetcode.problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1007. Minimum Domino Rotations For Equal Row
Medium

In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.

 

Example 1:

Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:

Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

 

Constraints:

    2 <= tops.length <= 2 * 10^4
    bottoms.length == tops.length
    1 <= tops[i], bottoms[i] <= 6


 * @author Moataz Lasheen
 *
 */
public class MinimumDominoRotations {
	
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int minRotations = -1;

		int potentialRotations = solve(tops, bottoms, tops[0]);
		if ( potentialRotations != -1 && ( minRotations== -1 || minRotations > potentialRotations )) {
			minRotations = potentialRotations;
		}
		
		potentialRotations = solve(tops, bottoms, bottoms[0]);
		if ( potentialRotations != -1 && ( minRotations== -1 || minRotations > potentialRotations )) {
			minRotations = potentialRotations;
		}
		
		return minRotations;
		
		
    }

	private int solve(int[] tops, int[] bottoms, int val) {
		int rotationsTop = 0;
		int rotationsBottom = 0;
		for ( int i=0; i<tops.length; i++ ) {
			if ( tops[i] != val && bottoms[i] != val ) {
				return -1;
			}
			else if ( bottoms[i] != val ) {
				rotationsBottom++;
			} else if ( tops[i] != val ) {
				rotationsTop++;
			}
		}
		return Math.min(rotationsTop, rotationsBottom);
	}
	
	
//	public int minDominoRotations(int[] tops, int[] bottoms) {
//		int minRotations = -1;
//		Map<Integer, Integer> map = new HashMap<>(); 
//		for ( int i=0; i<tops.length; i++) {
//			if ( map.get(tops[i]) == null ) {
//				map.put(tops[i], 1);
//			} else {
//				map.put(tops[i], map.get(tops[i]) + 1);
//			}
//			if ( map.get(bottoms[i]) == null ) {
//				map.put(bottoms[i], 1);
//			} else {
//				map.put(bottoms[i], map.get(bottoms[i]) + 1);
//			}
//		}
//		
//		int potentialNumber;
//		
//		try {
//			potentialNumber = map.entrySet().stream()
//			.filter( entry -> entry.getValue() >= tops.length)
//			.sorted( (a,b)-> a.getValue().compareTo(b.getValue()))
//			.findFirst().orElseThrow( () -> new RuntimeException() ).getKey();
//		} catch (Exception e) {
//			return -1;
//		}
//		
//		int topsAdjustedCount = 0;
//		int bottomsAdjustedCount = 0;
//		for ( int i=0; i<tops.length; i++ ) {
//			if ( tops[i] != potentialNumber && bottoms[i] != potentialNumber ) {
//				return -1;
//			} 
//			if ( tops[i] == potentialNumber ) {
//				topsAdjustedCount++;
//			}
//			if ( bottoms[i] == potentialNumber ) {
//				bottomsAdjustedCount++;
//			}
//		}
//		
//		if ( topsAdjustedCount >= bottomsAdjustedCount ) {
//			minRotations = tops.length-topsAdjustedCount;
//		} else {
//			minRotations = tops.length - bottomsAdjustedCount;
//		}
//		
//		return minRotations;
//		
//		
//    }
}
