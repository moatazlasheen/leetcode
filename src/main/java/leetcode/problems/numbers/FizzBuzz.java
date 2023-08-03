package leetcode.problems.numbers;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public List<String> solve(int input) {
		List<String> result = new ArrayList<>();
		
		for ( int i=1; i<=input; i++ )  {
			if ( i%3 == 0 && i%5 == 0 ) {
				result.add("FizzBuzz");
			} else if ( i%3 == 0 ) {
				result.add("Fizz");
			} else if ( i%5 == 0 ) {
				result.add("Buzz");
			} else {
				result.add(String.valueOf(i));
			}
		}
		
		return result;
	}

}
