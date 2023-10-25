package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EditDistanceTest {
	
private EditDistance underTest = new EditDistance();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String word1, String word2, int expected) {
		int actual = underTest.minDistance(word1, word2);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of("horse", "ros", 3),
			Arguments.of("intention", "execution", 5)
			
		);
	}

}
