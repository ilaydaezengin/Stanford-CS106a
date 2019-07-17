/*
 * File: digitName.java
 * --------------------
 * This program takes a number between 0 and 9 as input
 * and prints its equivalent name.
 */

import acm.program.*;

public class digitName extends ConsoleProgram {

	public void run() {
		//Get input number and print its name.
		int digitValue = readInt("Enter a digit between 0 and 9: ");
		println(getDigitName(digitValue));
	}
//Implement the helper method getDigitName() here
/* Translates a number into its name */

	private String getDigitName(int digitValue) {
		switch(digitValue){
		case 0: return "Zero";
		case 1: return "One";
		case 2: return "Two";
		case 3: return "Three";
		case 4: return "Four";
		case 5: return "Five";
		case 6: return "Six";
		case 7: return "Seven";
		case 8: return "Eight";
		default: return "Nine";
	}
	}

}
