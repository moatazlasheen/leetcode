package leetcode.problems.numbers;

public class FactorialTrailingZeros {

	public int getFactorialTrailingZeros(int input) {
		int coutOfTrailingZeros = 0;
		for ( int i=5; i<=input; i=i*5 ) {
			coutOfTrailingZeros += input/i;
		}
		return coutOfTrailingZeros;
	}

}
