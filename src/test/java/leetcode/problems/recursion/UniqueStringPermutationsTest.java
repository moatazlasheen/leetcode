package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UniqueStringPermutationsTest {

	private UniqueStringPermutations underTest = new UniqueStringPermutations();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String input, List<String> expected) {
		List<String> actual = underTest.findPermutations(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of("ABC", Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")),
			Arguments.of("CAB", Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")),
			Arguments.of("CAB", Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA")),
			Arguments.of("ABA", Arrays.asList("AAB", "ABA", "BAA"))
		);
	}
	
}
