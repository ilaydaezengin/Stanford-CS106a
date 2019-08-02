/*
 * File: NoVowels.java
 * ---------------------
 * This program takes a string as input and removes vowels in it.
 */

import acm.program.*;

/**
 * This class takes string as input and removes vowels in it.
 */

public class NoVowelsSoln extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a string as input and removes vowels in it.");
		// Your code starts here
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) break;
			for (int i = 0; i < vowels.length(); i++) {			
				str = str.replace(vowels.charAt(i), '\000');
				/*An alternative way of doing this:
				str = str.replace(""+vowels.charAt(i), "");
				*/
				
				/*Yet another alternative is writing your own replace method implementation*/
			}
			println("The string without vowels: " + str);
		}
		// Your code ends here
	}

	private static final String vowels = "aeiouAEIOU";
}

