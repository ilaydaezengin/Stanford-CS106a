/*
 * File: TenthPower.java
 * ---------------------
 * This program that takes an integer from the user and calculate and print 
 * its power to the 10.
 * 
 * Class: TentPower.java
 * Score: (Easy)
 * Prerequisites: For Loops, ACM Task Force Commands
 */

import acm.program.*;

public class TenthPower extends ConsoleProgram {

	public void run() {
		println("This program computes tenth power of an integer.");
		int a = readInt("Enter an integer for its tenth power: ");
		int pow = (int) Math.pow(a, 10);
		println("Tenth power of " + a + " is " + pow);
	}

}
