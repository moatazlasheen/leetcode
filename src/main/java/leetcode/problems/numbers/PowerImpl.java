package leetcode.problems.numbers;

public class PowerImpl {
	
	/**
	 * needed time complexity is O(log(n))
	 * @param base
	 * @param power
	 * @return
	 */
	public double calculatePower( double base, int power ) {
		double result = 1;
		int absolutePower = power;
		if ( power < 0 ) {
			absolutePower = power * -1;
		}
		
		while (absolutePower > 0 ) {
			if ( absolutePower % 2 == 0 ) {
				base = base * base;
				absolutePower /= 2;
			} else {
				result *= base;
				absolutePower-=1;
				
			}
		}
		
		if ( power < 0 ) {
			result = 1/result;
		}
		
		return result;
	}
//	public double calculatePower( double base, int power ) {
//		double result;
//		if ( power == 0 ) {
//			result = 1;
//		} 
//		else if ( power == 1 ) {
//			result = base;
//		}
//		else if ( power == -1 ) {
//			result = 1/base;
//		}
//		else {
//			boolean isNegativePower = false;
//			if ( power < 0 ) {
//				power *= -1;
//				isNegativePower = true;
//			}
//			
//			if ( power % 2 == 0 ) {
//				result = calculatePower(base*base, power/2);
//			} else {
//				result = base * calculatePower(base, power-1);
//			}
//			
//			if ( isNegativePower ) {
//				result = 1/result;
//			}
//		
//		}
//		
//		return result;
//	}
}
