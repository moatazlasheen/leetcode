package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaxLengthOfConcatenatedStringsTest {

	private MaxLengthOfConcatenatedStrings underTest = new MaxLengthOfConcatenatedStrings();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(List<String> arr, int expected) {
		int actual = underTest.maxLength(arr);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(Arrays.asList("un","iq","ue"), 4),
			Arguments.of(Arrays.asList("cha","r","act","ers"), 6),
			Arguments.of(Arrays.asList("abcdefghijklmnopqrstuvwxyz"), 26),
			Arguments.of(Arrays.asList("jnfbyktlrqumowxd","mvhgcpxnjzrdei"), 16),
			Arguments.of(Arrays.asList("abc","def","bp","dq","eg","fh"), 9)
		);
	}
}
