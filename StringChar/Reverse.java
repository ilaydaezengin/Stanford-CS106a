/*
 * File: Reverse.java
 * ------------------------
 * This program reverses a string.
 */

import acm.program.*;

/**
 * This class reverses the characters in a string.
 */

public class Reverse extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a string as input and reverses it.");
		// Your code starts here
		String in = readLine("Enter a string: ");
		println(in + " spelled backwards is " + reverse(in));
		// Your code ends here
	}

	/** This method reverses a string */
	private String reverse(String str) {
		String result = "";
		// Your code starts here
		for(int i = 0; i < str.length(); i ++){
			result += str.charAt(str.length()-1 -i);
			// or  result = str.charAt(i) + result;
		}
		// Your code ends here
		return result;
	}
}

