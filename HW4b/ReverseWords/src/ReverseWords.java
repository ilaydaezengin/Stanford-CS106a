/*
 * File: ReverseWords.java
 * ---------------------
 * This program takes a sentence as input and reverses its word order.
 */

import acm.program.*;

/**
 * This class takes a sentence as input and reverses its word order.
 */

public class ReverseWords extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a sentence as input and reverses its word order.");
		// Your code starts here
		while(true){
			String str = readLine("Enter a sentence: ");
			if(str.length() == 0) break;
			println("'" +str + "' with reverse word order is '" + reverseWords(str)+ "'");
		}
	
		// Your code ends here
	}

	/** This method reverses words in a string */
	private String reverseWords(String str) {
		String result = "";
		// Your code starts here
		while(str.lastIndexOf(" ") != -1) {
			int a = str.lastIndexOf(" ");
			result += str.substring(a + 1)+" ";
			str = str.substring(0,a);
			// Your code ends here
		}
		result += str;
		return result;
}
}

