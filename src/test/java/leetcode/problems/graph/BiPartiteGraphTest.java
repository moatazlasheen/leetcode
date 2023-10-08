package leetcode.problems.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BiPartiteGraphTest {

	private BiPartiteGraph underTest = new BiPartiteGraph();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [][] graph, boolean expected) {
		boolean actual = underTest.isBipartite(graph);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		
		return Stream.of(
			Arguments.of(new int [][] {{1,2,3},{0,2},{0,1,3},{0,2}}, false),
			Arguments.of(new int [][] {{1,3},{0,2},{1,3},{0,2}}, true)
		);
	}
	
}
