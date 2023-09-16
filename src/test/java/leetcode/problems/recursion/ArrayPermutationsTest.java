package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ArrayPermutationsTest {

	private ArrayPermutations underTest = new ArrayPermutations();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] in, List<List<Integer>> expected){
		List<List<Integer>> actual = underTest.permute(in);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [] {1,2,3}, 
					Arrays.asList(
							Arrays.asList(1,2,3),
							Arrays.asList(1,3,2),
							Arrays.asList(2,1,3),
							Arrays.asList(2,3,1),
							Arrays.asList(3,1,2),
							Arrays.asList(3,2,1)
							))
		);
	}
	
}
