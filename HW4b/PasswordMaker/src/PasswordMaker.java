/*
 * File: PasswordMaker.java
 * ---------------------
 * This program generates a password for the user.
 */

import acm.program.*;

/**
 * This class takes user's name and age and generates a password.
 */

public class PasswordMaker extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		println("This program takes user's name and age and generates a password.");

		// Your code starts here
		String fname = readLine("Enter your first name: ");
		String lname = readLine("Enter your last name: ");
		String age = readLine("Enter your age: ");
		String password;
		fname = fname.toLowerCase();
		lname = lname.toLowerCase();
		password = fname.substring(0,2) + lname.substring(0,2) + age;
		println("your password is: " + password);
		// Your code ends here
	}
}

