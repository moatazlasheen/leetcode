package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import leetcode.problems.arrays.BestTimeToBuyAndSellStock2;

class BestTimeToBuyAndSellStockTest2 {

	private BestTimeToBuyAndSellStock2 underTest = new BestTimeToBuyAndSellStock2();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] prices, int expectedProfit ) {
		int actualProfit = underTest.maxProfit(prices);
		assertEquals(expectedProfit, actualProfit);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [] {7,1,5,3,6,4}, 7),
			Arguments.of( new int [] {1,2,3,4,5}, 4),
			Arguments.of( new int [] {7,6,4,3,1}, 0),
			Arguments.of( new int [] {7,1,3,8,15,4}, 14)
		);
	}
}
