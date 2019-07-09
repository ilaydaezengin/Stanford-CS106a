/*
 * File: DistanceConverter.java
 * -------------------------------------
 * This program converts a distance measured in inches
 * to the equivalent distance in centimeters.
 * 
 * Class: DistanceConverter
 * Difficulty: (Easy)
 * Prerequisites: Variables and Arithmetic, ConsoleProgram (readInt, println)
 */

import acm.program.*;

public class DistanceConverter extends ConsoleProgram {

	//Main System Function
	public void run() {
		// Your code starts here
		println("This program converts inches to centimeters.");
		int a = readInt("Enter number of inches: ");
		println(a + " in = " + a * CENTIMETERS_PER_INCH + " cm");
		// Your code ends here
	}
	
	//Variable Declaration
	private static final double CENTIMETERS_PER_INCH = 2.54;
}

