package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.JumpGame3;

class JumpGame3Test {
	
	private JumpGame3 underTest = new JumpGame3();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int index, boolean expected ) {
		boolean actual = underTest.canReach(nums, index);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {4,2,3,0,3,1,2}, 5, true),
			Arguments.of(new int [] {4,2,3,0,3,1,2}, 0, true),
			Arguments.of(new int [] {3,0,2,1,2}, 2, false)
		);
	}

}
