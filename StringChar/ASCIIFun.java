/*
 * File: ASCIIFun.java
 * ---------------------
 * This program takes a string as input and prints ASCII code for each character.
 */

import acm.program.*;

/**
 * This class takes a string as input and prints ASCII code for each character.
 */

public class ASCIIFun extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a string as input and prints ASCII code for each character.");
		// Your code starts here
		while(true){
		String inp = readLine("Enter a string: ");
		if (inp.length() == 0) break;
		for(int i = 0; i < inp.length(); i++){
			println("'"+inp.charAt(i)+"'" + " = " + (int)inp.charAt(i));
		}
		}
		// Your code ends here
	}
}

