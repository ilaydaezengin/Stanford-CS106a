/*
 * File: NoVowels.java
 * ---------------------
 * This program takes a sing as input and removes vowels in it.
 */

import acm.program.*;

/**
 * This class takes sing as input and removes vowels in it.
 */

public class NoVowels extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes a sing as input and removes vowels in it.");
		
		// Your code starts here
		while(true){
			String s =readLine("Enter a sing: ");
			if(s.length()== 0) break;
			for(int i = 0; i < s.length(); i ++){
				if(s.charAt(i) == 'a'|| s.charAt(i) == 'e'|| s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				s = s.replace(s.charAt(i),' ');
				}
			}
			println("The string without vowels: " + s);
		}
		// Your code ends here
	}

	private static final String vowels = "aeiouAEIOU";
}

