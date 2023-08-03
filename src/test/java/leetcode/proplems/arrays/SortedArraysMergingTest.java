package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.SortedArraysMerging;

class SortedArraysMergingTest {
	
	private SortedArraysMerging underTest = new SortedArraysMerging();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums1, int m, int [] nums2, int n, int [] expected ) {
		underTest.merge(nums1, m, nums2, n);
		
		for ( int i =0 ; i<nums1.length; i++ ) {
			assertEquals(expected[i], nums1[i]);
		}
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [] {1,2,3,0,0,0} , 3, new int [] {2,5,6}, 3, new int [] {1,2,2,3,5,6}),
			Arguments.of( new int [] {1,5,6,0,0,0} , 3, new int [] {2,2,3}, 3, new int [] {1,2,2,3,5,6})
		);
	}

}
