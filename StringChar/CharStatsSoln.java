/*
 * File: CharStats.java
 * ---------------------
 * This program takes a string as input and counts uppercase and lowercase letters.
 */

import acm.program.*;

/**
 * This class takes a string as input and counts uppercase and lowercase letters.
 */

public class CharStatsSoln extends ConsoleProgram {

	/** Runs the program */
	public void run() {

		println("This program takes a string as input and counts uppercase and lowercase letters.");

		// Your code starts here
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) break;

			int upCount = 0;
			int lowCount = 0;
			int nonCount = 0;

			for( int i = 0; i < str.length(); i++ ) {
				char c = str.charAt(i);
				if( Character.isUpperCase(c) ) {
					upCount++;
				}
				else if( Character.isLowerCase(c) ) {
					lowCount++;
				}
				else {
					nonCount++;
				}	
			}
			println("That string contains "+upCount+" uppercase, "+lowCount+" lowercase and " +
					""+nonCount+" non-alphabetic characters.");
		}	
		// Your code ends here
	}

}