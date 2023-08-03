package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.numbers.FactorialTrailingZeros;

class FactorialTrailingZerosTest {
	
	private FactorialTrailingZeros factorialTrailingZeros = new FactorialTrailingZeros();
	
	
	@ParameterizedTest
//	@MethodSource("provideArgumnets")
	@CsvSource({"9,1", "14,2", "25,6"})
	void testWithProvidedParameters ( int input, int expectedResult) {
		int actualResult = factorialTrailingZeros.getFactorialTrailingZeros(input);
		assertEquals(expectedResult, actualResult);
		
	}
	
	private static Stream<Arguments> provideArgumnets() {
		return Stream.of(
				Arguments.of(9,1),
				Arguments.of(14,2),
				Arguments.of(25,6)
		);
	}

}
