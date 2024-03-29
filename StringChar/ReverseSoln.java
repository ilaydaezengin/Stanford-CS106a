/*
 * File: Reverse.java
 * ------------------------
 * This program reverses a string.
 */

import acm.program.*;

/**
 * This class reverses the characters in a string.
 */

public class ReverseSoln extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a string as input and reverses it.");
		// Your code starts here
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) break;
			String rev = reverse2(str);
			println("The reverse of \""+str+"\" is \""+rev+"\".");
		}
		// Your code ends here
	}

	/** This method reverses a string */
	private String reverse(String str) {
		String result = "";
		// Your code starts here
		for (int i = 0; i < str.length(); i++) {
			result = str.charAt(i) + result;
		}
		// Your code ends here
		return result;
	}
	/** This method reverses a string */
	private String reverse2(String str) {
		String result = "";
		// Your code starts here
		for (int i = str.length()-1; i >=0 ; i--) {
			result = result + str.charAt(i) ;
		}
		// Your code ends here
		return result;
	}
}

