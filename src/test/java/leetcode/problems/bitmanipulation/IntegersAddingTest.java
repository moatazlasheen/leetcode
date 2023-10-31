package leetcode.problems.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class IntegersAddingTest {
	
private IntegersAdding underTest = new IntegersAdding();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int num1, int num2, int expected) {
		int actual = underTest.getSum(num1, num2);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(1, 1, 2),
			Arguments.of(5, 7, 12),
			Arguments.of(-1, 15, 14),
			Arguments.of(1, -15, -14),
			Arguments.of(-8, -3, -11)
		);
	}
	

}
