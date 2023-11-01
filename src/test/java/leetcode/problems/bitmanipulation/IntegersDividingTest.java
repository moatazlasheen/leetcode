package leetcode.problems.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntegersDividingTest {
	
	private IntegersDividing underTest = new IntegersDividing();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int num1, int num2, int expected) {
		int actual = underTest.divide(num1, num2);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(2, 1, 2),
			Arguments.of(10, 3, 3),
			Arguments.of(18, 6, 3),
			Arguments.of(-25, 5, -5),
			Arguments.of(-32, -8, 4),
			Arguments.of(-2147483648, -1, 2147483647)
		);
	}
	

}
