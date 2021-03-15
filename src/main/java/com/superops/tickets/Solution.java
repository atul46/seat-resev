package com.superops.tickets;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {
	
	

	public static void main(String[] args) {
            letterCasePermutation("a1b2");
	}

	public static List<String> letterCasePermutation(String S) {
	    final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
		int count = 0;
	    StringBuffer newStr = null;
		List<String> resultString = new ArrayList<String>();
		newStr = new StringBuffer();
		while (S.length() > 1 && !textPattern.matcher(newStr).matches()) {
			if (Character.isLowerCase(S.charAt(count))) {

				newStr.setCharAt(count, Character.toUpperCase(S.charAt(count)));
				System.out.println(newStr.toString());
				resultString.add(newStr.toString());
			}

		}
		return resultString;

	}
}
