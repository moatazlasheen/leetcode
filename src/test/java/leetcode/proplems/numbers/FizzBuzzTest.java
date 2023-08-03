package leetcode.proplems.numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.numbers.FizzBuzz;

class FizzBuzzTest {
	
	private FizzBuzz underTest = new FizzBuzz();
	
	@ParameterizedTest
	@MethodSource("provideArgumentsForFizzBuzz")
	void testFizzBuzz ( int input, List<String> expectedResult ) {
		
		List<String> actualResult = underTest.solve(input);
		
		assertEquals(expectedResult, actualResult);
	}
	
	private static Stream<Arguments> provideArgumentsForFizzBuzz() {
		return Stream.of(
			Arguments.of(4, Arrays.asList("1", "2", "Fizz", "4")),
			Arguments.of(5, Arrays.asList("1", "2", "Fizz", "4", "Buzz")),
			Arguments.of(15, Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", 
					"7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"))
		);
	}
}
