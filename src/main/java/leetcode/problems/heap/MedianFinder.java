package leetcode.problems.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 295. Find Median from Data Stream
Hard

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

    For example, for arr = [2,3,4], the median is 3.
    For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.

Implement the MedianFinder class:

    MedianFinder() initializes the MedianFinder object.
    void addNum(int num) adds the integer num from the data stream to the data structure.
    double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

 

Constraints:

    -10^5 <= num <= 10^5
    There will be at least one element in the data structure before calling findMedian.
    At most 5 * 10^4 calls will be made to addNum and findMedian.

 

Follow up:

    If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
    If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?


 * 
 * @author Moataz Lasheen
 *
 */
public class MedianFinder {
	
	// this heap will hold half of the input stream, smallest n/2 numbers
	Queue<Integer> smallerPartMaxHeap;
	// this heap will hold the other half of the input stream, biggest n/2 numbers
	// if the stream length is even, then the two queues will have the same size
	// if the stream length is odd, then the size of biggerPartMinHeap will be the size of smallerPartMaxHeap+1
	Queue<Integer> biggerPartMinHeap;

    public MedianFinder() {
        smallerPartMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        biggerPartMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        biggerPartMinHeap.add(num);
        smallerPartMaxHeap.add(biggerPartMinHeap.poll());
        // the smallerPartMaxHeap can not be larger than biggerPartMinHeap 
        if (smallerPartMaxHeap.size() > biggerPartMinHeap.size()) {
        	biggerPartMinHeap.add(smallerPartMaxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallerPartMaxHeap.size() == biggerPartMinHeap.size()) {
        	// stream length is even
        	return (smallerPartMaxHeap.peek() + biggerPartMinHeap.peek())/ 2.0;
        } else {
        	// stream length is odd
        	return biggerPartMinHeap.peek();
        }
    }
	
	
	// also works , but has a worse performance
	// linked list, exceeded time limit
	// array list, beats only 5% of the java solutions
	
//		List<Integer> stream = new ArrayList<>();
//		
//
//	    public MedianFinder() {
//	    }
//	    
//	    public void addNum(int num) {
//	    	if ( stream.isEmpty()) {
//	    		stream.add(num);
//	    	} else {
//		    	int i=0;
//		    	for (; i < stream.size() && stream.get(i) <= num;)
//		    		i++;
//		    	
//		    	stream.add(i, num);
//	    	}
//	    	
//	    }
//	    
//	    public double findMedian() {
//	        if (stream.size()%2 == 0) {
//	        	return (stream.get(stream.size()/2 - 1) + stream.get(stream.size()/2)) / 2.0;  
//	        } else {
//	        	return stream.get(stream.size()/2);
//	        }
//	    }
    
    
    
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
