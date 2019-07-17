/*
 * File: RectangleArea.java
 * ---------------------
 * This program computes the area of a rectangle.
 * 
 * Class: RectangleArea.java
 * Score: (Simple)
 * Prerequisites: ACM Task Force Commands
 */

import acm.program.*;

public class RectangleArea extends ConsoleProgram {

	public void run() {
		println("This program computes the area of rectangle.");
		int height = readInt("Enter the height of rectangle: ");
		int width = readInt("Enter the width of rectangle: ");
		int area = height * width;
		println("Rectangle area: " + area);
	}

}
