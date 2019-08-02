/*
 * File: Palindrome.java
 * ---------------------
 * This program tests to see whether a string is a palindrome, which
 * is defined to be a string that reads the same forwards and backwards.
 */

import acm.program.*;

/**
 * This class tests to see whether a string is a palindrome.
 * This version tests the characters individually.
 */

public class Palindrome extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program tests whether a string is a palindrome.");
		// Your code starts here
		while (true) {
			String str = readLine("enter a string ");
			if(str.length() == 0) break;
			if (isPalindrome(str)) {
				println("that string " + str + " is a palindrome");
				
			} else {
				println("that string " + str + " is NOT a palindrome");
			}
		}
		// Your code ends here
	}

	/** Checks whether a string is a palindrome */
	private boolean isPalindrome(String str) {
		boolean answer = false;
		// Your code starts here
		String nS = reverse(str);
		// compare Strings
		if (nS.equals(str)) {
			answer = true;
		}
		// Your code ends here
		return answer;
	}
	private String reverse(String str) {
		String result = "";
		for (int i =0; i< str.length(); i++) {
			result = str.charAt(i) + result;
		}
		println("reversed string is " + result);
		return result;
	}

}

