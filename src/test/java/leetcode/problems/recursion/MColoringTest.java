package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MColoringTest {

	
	private MColoring underTest = new MColoring();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(boolean [][] graph, int m, boolean expected) {
		boolean actual = underTest.graphColoring(graph, m, graph.length);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new boolean [][] {{false, true, false, false}, 
				{true, false, true, false}, 
				{true, true, false, true}, 
				{true, false, true, false}}, 3, true),
			Arguments.of(new boolean [][] {{false, true, false, false}, 
				{true, false, true, false}, 
				{true, true, false, true}, 
				{true, false, true, false}}, 2, false)
		);
		
	}
}
