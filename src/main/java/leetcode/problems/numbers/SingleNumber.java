package leetcode.problems.numbers;

public class SingleNumber {

	public int findSingleNumber(int[] input) {
		if ( input.length == 1 ) {
			return input[0];
		}
		
		int result = input[0];
		for ( int i=1; i<input.length; i++) {
			result ^= input[i];
			System.out.println(result);
		}
		
		return result;
	}

}
