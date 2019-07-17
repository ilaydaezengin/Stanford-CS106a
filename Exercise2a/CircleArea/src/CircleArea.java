/*
 * File: CircleArea.java
 * ---------------------
 * This program computes the area of a circle.
 * 
 * 
 * Class: CircleArea.java
 * Score: (Simple)
 * Prerequisites: ACM Task Force Commands
 */

import acm.program.*;

public class CircleArea extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("This program calcýlates the area of the circle.");
		int radius = readInt("Enter the radius: ");
		println("Circle area is " + PI * radius * radius);
		// Your code ends here
	}

	/* Private constants */
	private static final double PI = 3.14159265358979323846;

}
