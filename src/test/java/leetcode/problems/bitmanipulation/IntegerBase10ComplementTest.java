package leetcode.problems.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IntegerBase10ComplementTest {
	
	private IntegerBase10Complement underTest = new IntegerBase10Complement();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int num, int expected) {
		int actual = underTest.bitwiseComplement(num);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(0, 1),
			Arguments.of(1, 0),
			Arguments.of(2, 1),
			Arguments.of(3, 0),
			Arguments.of(4, 3),
			Arguments.of(5, 2)
		);
	}
	

}
