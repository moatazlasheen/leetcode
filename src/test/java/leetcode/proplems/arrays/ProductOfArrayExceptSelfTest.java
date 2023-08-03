package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.ProductOfArrayExceptSelf;

class ProductOfArrayExceptSelfTest {
	
	private ProductOfArrayExceptSelf underTest = new ProductOfArrayExceptSelf();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] input, int [] expected ) {
		int [] actual = underTest.productExceptSelf(input);
		
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [] {0,5}, new int [] {5,0}),	
			Arguments.of(new int [] {0,5,0}, new int [] {0,0,0}),
			Arguments.of(new int [] {0,5,1}, new int [] {5,0,0}),
			Arguments.of(new int [] {1,2,3}, new int [] {6,3,2}),
			Arguments.of(new int [] {1,-2,3}, new int [] {-6,3,-2}),
			Arguments.of(new int [] {1,-2,-3}, new int [] {6,-3,-2})
		);
	}

}
