package leetcode.proplems.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import leetcode.problems.heap.MedianFinder;

class MedianFinderTest {

	private MedianFinder underTest = new MedianFinder();
	
	@Test
	void testFindMedian() {
		underTest.addNum(1);
		assertEquals(1, underTest.findMedian());
		underTest.addNum(2);
		assertEquals(1.5, underTest.findMedian());
		underTest.addNum(3);
		assertEquals(2, underTest.findMedian());
		underTest.addNum(-1);
		assertEquals(1.5, underTest.findMedian());
		underTest.addNum(-20);
		assertEquals(1, underTest.findMedian());
	}
	
}
