package leetcode.problems.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 735. Asteroid Collision
Medium

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

 

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

 

Constraints:

    2 <= asteroids.length <= 10^4
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0


 * 
 * 
 * @author Moataz Lasheen
 *
 */
public class AsteroidCollisions {
	
	public int[] asteroidCollision(int[] asteroids) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        Integer tmp = null;
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0) {
            	stack.push(asteroids[i]);
            } else {
            	// stack is not empty
            	// head of stack is heading right
            	// current asteriod is heading left
            	// there should be a collision
            	while (!stack.isEmpty()) {
            		
            		tmp = stack.pop();
            		if (tmp<0) {
            			stack.push(tmp);
            			stack.push(asteroids[i]);
            			break;
            		} else if (Math.abs(tmp) == Math.abs(asteroids[i])) {
            			break;
            		}
            		else if (Math.abs(tmp) > Math.abs(asteroids[i])) {
            			stack.push(tmp);
            			break;
            		}
    			
    			}
            	
            	if (stack.isEmpty() && Math.abs(asteroids[i]) > Math.abs(tmp)) {
            		stack.push(asteroids[i]);
            	}
            }
        }
        
        if (stack.isEmpty()) {
        	return new int [] {};
        } else {
        	int [] result = new int [stack.size()];
        	for (int i=stack.size()-1; i>=0; i--) {
        		result[i] = stack.pop();
        	}
        	return result;
        }
    }

}
