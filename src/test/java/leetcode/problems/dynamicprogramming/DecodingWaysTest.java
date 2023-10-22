package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DecodingWaysTest {
	
	private DecodingWays underTest = new DecodingWays();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String in, int expected) {
		int actual = underTest.numDecodings(in);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of("12", 2),
			Arguments.of("226", 3),
			Arguments.of("06", 0),
			Arguments.of("10", 1)
		);
	}
}
