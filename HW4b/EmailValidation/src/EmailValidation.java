/*
 * File: EmailValidation.java
 * -----------------------
 * This program takes an email address as input and validates it.
 */

import acm.program.*;

public class EmailValidation extends ConsoleProgram {

	public void run() {
		println("This program takes an email address as input and validates it.");
		// Your code starts here
		while(true){
			String str = readLine("Enter an email adress: "); 
			if(str.length() == 0) break;
			if(isValid(str)){
				println("That email adress is valid.");
			} else {
				println("That email adress is not valid.");	
			}
		}
		// Your code ends here
	}

	/*
	 * It should not contain whitespace.---------
	 * It should contain a '@' character.---------
	 * It should contain a '.' character.------------
	 * '@' and '.' should not be at the first position.-------------
	 * There should be at least one character between '@' and '.'('.' should come after '@').
	 * There should be at least two characters after '.'. -----------
	 */
	/** Checks whether an email address is valid */
	private boolean isValid(String email) {
		// Your code starts here
		int at = email.indexOf("@");
		int dot = email.indexOf(".");
		if(email.contains(" ") || at < 1 || dot < 1 || dot - at < 2 || dot + 2 >= email.length()){
			return false;
		} else {
			// Your code ends here
		return true;	
	}
	}
}


