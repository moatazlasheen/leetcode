package leetcode.problems.arrays;


/**
 * 605. Can Place Flowers
Easy

You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false

 

Constraints:

    1 <= flowerbed.length <= 2 * 10^4
    flowerbed[i] is 0 or 1.
    There are no two adjacent flowers in flowerbed.
    0 <= n <= flowerbed.length



 * @author Moataz Lasheen
 *
 */
public class FlowerBed {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for ( int current=0; current<flowerbed.length && n>0; current++ ) {
        	if ( flowerbed[current] == 0 &&
        			getPreviousPlotValue(flowerbed, current) == 0 && 
        			getNextPlotValue(flowerbed, current) == 0) {
        		flowerbed[current] = 1;
        		n--;
        	}
        }
        
        
		return n<1;
    }

	private int getNextPlotValue(int[] flowerbed, int index) {
		if ( index >= flowerbed.length-1 ) {
			return 0;
		} else {
			return flowerbed[index+1];
		}
	}
	
	private int getPreviousPlotValue(int[] flowerbed, int index) {
		if ( index <= 0 ) {
			return 0;
		} else {
			return flowerbed[index-1];
		}
	}
}
