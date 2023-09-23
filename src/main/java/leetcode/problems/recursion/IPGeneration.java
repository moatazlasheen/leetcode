package leetcode.problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class IPGeneration {
	
	List<String> restoreIpAddresses(String input) {
		List<String> result = new ArrayList<>();
		if (input != null && input.length()>3 && input.length()<13) {
			restoreIpAddresses(input, result, new StringBuilder(), 0, 0);
		}
		
		return result;
	}

	private void restoreIpAddresses(String input, List<String> result, StringBuilder path, int segments, int startIndex) {
		if (segments == 4 && startIndex == input.length()) {
			result.add(path.toString());
			return;
		}
		if (segments > 4) {
			return;
		}
		
		for (int i = startIndex; i<input.length() && i<startIndex+3; i++) {
			String potentialSegment = input.substring(startIndex, i+1);
			if(isValidSegment(potentialSegment)) {
				if (path.length() > 0) {
					path.append(".");
				}
				restoreIpAddresses(input, result, path.append(potentialSegment), segments+1, i+1);
				if (path.lastIndexOf(".") > -1) {
					path.delete(path.lastIndexOf("."), path.length());
				} else {
					path.delete(0, path.length());
				}
			}
		}
	}

	private boolean isValidSegment(String potentialSegment) {
		if (
				potentialSegment == null ||
				potentialSegment.length() < 1 ||
				potentialSegment.length() > 3 || 
				(potentialSegment.length() > 1 && potentialSegment.charAt(0) == '0') ||
				Integer.parseInt(potentialSegment) > 255
			) {
			
			return false;
		}
		
		return true;
	}

//	List<String> restoreIpAddresses(String input) {
//		List<String> ips = new ArrayList<>();
//		if (input.length()<4) {
//			return new ArrayList<>();
//		}
//		
//		restoreIpAddresses(input, ips, "", 4, 0);
//		
//		return ips;
//		
//	}
//
//	private void restoreIpAddresses(String input, List<String> ips, String currentIP, int tokensToBeCreated, int startIndex) {
//		if (tokensToBeCreated == 0 && startIndex == input.length()) {
//			ips.add(currentIP.substring(0, currentIP.length()-1));
//			return;
//		}
//		
//		if (startIndex>input.length()-1 || tokensToBeCreated<0) {
//			return;
//		}
//		
//		if ((input.length()-startIndex) < tokensToBeCreated)
//			return;
//		
//		if ((input.length()-startIndex) > (tokensToBeCreated*3))
//			return;
//		
//		
//		int currentDigit = Character.getNumericValue(input.charAt(startIndex));
//		// current token will be only one digit
//		restoreIpAddresses(input, ips, currentIP + currentDigit + ".", tokensToBeCreated-1, startIndex+1);
//		
//		if (currentDigit != 0 && startIndex < input.length()-1) {
//			int nextDigit = Character.getNumericValue(input.charAt(startIndex+1));
//			// current token will be two digits
//			restoreIpAddresses(input, ips, currentIP + currentDigit + nextDigit + ".", tokensToBeCreated-1, startIndex+2);
//			
//			if ((currentDigit == 1 || currentDigit == 2) && startIndex < input.length()-2) {
//				int aferNextDigit = Character.getNumericValue(input.charAt(startIndex+2));
//				if (currentDigit == 1 || ( currentDigit == 2 && nextDigit < 5 ) || (currentDigit == 2 && nextDigit == 5 && aferNextDigit < 6)) {
//					restoreIpAddresses(input, ips, currentIP + currentDigit + nextDigit + aferNextDigit + ".", tokensToBeCreated-1, startIndex+3);
//				}
//				
//			}
//		}
//	}
	
}
