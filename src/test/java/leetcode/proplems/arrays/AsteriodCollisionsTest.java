package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.AsteroidCollisions;

public class AsteriodCollisionsTest {
	
	private AsteroidCollisions underTest = new AsteroidCollisions();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] input, int [] expected) {
		int [] actual = underTest.asteroidCollision(input);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [] {5, 10,-5}, new int []{5, 10}),
			Arguments.of(new int [] {8, -8}, new int []{}),
			Arguments.of(new int [] {10, 2, -5}, new int []{10}),
			Arguments.of(new int [] {-2,-2,1,-2}, new int []{-2,-2,-2}),
			Arguments.of(new int [] {-2,-2,1,-1}, new int []{-2,-2})
		);
	}

}
