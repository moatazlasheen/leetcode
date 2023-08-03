package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.FlowerBed;

class FlowerBedTest {
	
	private FlowerBed underTest = new FlowerBed();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] flowerBed, int target, boolean expected ) {
		boolean actual = underTest.canPlaceFlowers(flowerBed, target);
		
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of( 
			Arguments.of(new int [] {0}, 1, true),
			Arguments.of(new int [] {1}, 1, false),
			Arguments.of(new int [] {0, 1}, 1, false),
			Arguments.of(new int [] {0, 0}, 1, true),
			Arguments.of(new int [] {0, 0}, 2, false),
			Arguments.of(new int [] {0, 0, 0}, 2, true),
			Arguments.of(new int [] {0, 1, 0}, 1, false),
			Arguments.of(new int [] {0, 1, 0, 1, 0, 1, 0, 0}, 1, true),
			Arguments.of(new int [] {1, 0, 0, 0, 0, 1}, 2, false)
		);
	}

}
