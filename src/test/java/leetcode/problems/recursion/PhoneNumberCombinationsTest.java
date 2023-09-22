package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PhoneNumberCombinationsTest {
	
	private PhoneNumberCombinations underTest = new PhoneNumberCombinations();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String in, List<String> expected) {
		List<String> actual = underTest.letterCombinations(in);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of("", new ArrayList<>()),
			Arguments.of("2", Arrays.asList("a", "b", "c")),
			Arguments.of("23", Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
		);
	}

}
