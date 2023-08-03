package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.JumpGame;

class JumpGameTest {
	
	private JumpGame underTest = new JumpGame();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, boolean expected ) {
		boolean actual = underTest.canJump(nums);
		
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {0}, true),
			Arguments.of(new int [] {1}, true),
			Arguments.of(new int [] {1,0}, true),
			Arguments.of(new int [] {2,0}, true),
			Arguments.of(new int [] {2,0,0}, true),
			Arguments.of(new int [] {2,1,0,0}, false),
			Arguments.of(new int [] {2,1,0,5}, false),
			Arguments.of(new int [] {1,0,3,1}, false),
			Arguments.of(new int [] {2,3,1,1,4}, true),
			Arguments.of(new int [] {3,2,1,0,4}, false),
			Arguments.of(new int [] {3,0,8,2,0,0,1},true)
		);
	}

}
