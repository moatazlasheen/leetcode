package leetcode.problems.numbers;

public class NthRoot {
	
	
	/**
	 * implement the nth root calculation
	 * 
	 * 
	 * 
	 * @param num positive double
	 * @param root positive int
	 * @return
	 */
	public double findNthRoot ( double num, int root ) {
		double allowedError = 0.001;
		double left = 1.0;
		double right = num;
		double medium = (left + right) / 2 ;
		
		double lastPotentialResult = calculatePotentialResult(medium, root);
		
		while ( Math.abs( lastPotentialResult - num ) > allowedError ) {
			if ( lastPotentialResult > num ) {
				right = medium;
				
			} else {
				left = medium;
			}
			medium = (left + right) / 2 ;
			lastPotentialResult = calculatePotentialResult(medium, root);
		}
		
		
		return medium;
		
	}

	private double calculatePotentialResult(double medium, int root) {
		double powerResult = 1;
		for ( int i=1; i<=root; i++ ) {
			powerResult *= medium;
		}
		return powerResult;
//		return Math.pow(medium, (double)root);
	}

}
