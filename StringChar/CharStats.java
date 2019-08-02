/*
 * File: CharStats.java
 * ---------------------
 * This program takes a string as input and counts uppercase and lowercase letters.
 */

import acm.program.*;

/**
 * This class takes a string as input and counts uppercase and lowercase letters.
 */

public class CharStats extends ConsoleProgram {
	/** Runs the program */
	public void run() {
		
		println("This program takes a string as input and counts uppercase and lowercase letters.");
		while(true){
			String in = readLine("Enter a string: ");
			if (in.length() == 0) break;
			int low_case = 0,up_case = 0, non_char = 0;
			for(int i = 0; i < in.length(); i ++){
				char c = in.charAt(i);
				if(Character.isUpperCase(c)){
					up_case ++;
				} else if (Character.isLowerCase(c)){
					low_case ++;
				} else {
					non_char ++;
				}
		}
			println("THat string contains " + up_case + " uppercase, " + low_case +
					" lowercase and " + non_char + " non-alphabetic characters.");
		// Your code starts here
		
		}
		
			
		// Your code ends here
	}

}