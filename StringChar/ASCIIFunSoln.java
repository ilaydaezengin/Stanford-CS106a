/*
 * File: ASCIIFun.java
 * ---------------------
 * This program takes a string as input and prints ASCII code for each character.
 */

import acm.program.*;

/**
 * This class takes a string as input and prints ASCII code for each character.
 */

public class ASCIIFunSoln extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a string as input and prints ASCII code for each character.");
		// Your code starts here
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) break;
			for( int i = 0; i < str.length(); i++ ) {
				char c = str.charAt(i);
				//println((int)c);
				int n = (int)c;
				println("'"+c+"' : "+n);
			}
		}
		// Your code ends here
	}
}

