package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IPGenerationTest {

	private IPGeneration underTest = new IPGeneration();
	
	@ParameterizedTest
	@MethodSource
	void testWithParameters( String in, List<String> expected) {
		List<String> actual = underTest.restoreIpAddresses(in);
		Collections.sort(expected);
		Collections.sort(actual);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParameters() {
		return Stream.of(
			Arguments.of("1234", Arrays.asList("1.2.3.4")),
			Arguments.of("12340", Arrays.asList("1.2.3.40", "12.3.4.0", "1.23.4.0", "1.2.34.0")),
			Arguments.of("25525511135", Arrays.asList("255.255.11.135","255.255.111.35")),
			Arguments.of("172162541", Arrays.asList("17.216.25.41","17.216.254.1","172.16.25.41","172.16.254.1","172.162.5.41","172.162.54.1")),
			Arguments.of("255255255255", Arrays.asList("255.255.255.255"))
		);
	}
}
