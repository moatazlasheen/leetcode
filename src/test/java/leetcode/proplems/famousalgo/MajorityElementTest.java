package leetcode.proplems.famousalgo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.famousalgo.MajorityElement;

class MajorityElementTest {

	
	private MajorityElement underTest = new MajorityElement();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] in, int expected ) {
		int actual = underTest.majorityElement(in);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {3,2,3}, 3),
			Arguments.of(new int [] {2,2,1,1,1,2,2}, 2),
			Arguments.of(new int [] {6,5,5}, 5)
		);
	}
}
