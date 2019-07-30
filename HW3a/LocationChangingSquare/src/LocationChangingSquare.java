/*
 * File: LocationChangingSquare.java
 * ------------------------------
 * This program puts up a square in the center of the window
 * and randomly changes its location every second.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class LocationChangingSquare extends GraphicsProgram {

	/** Runs the program */
	public void run() {
		// Your code starts here
		GRect r = new GRect((getWidth()- SQUARE_SIZE) / 2,(getHeight()- SQUARE_SIZE) / 2, SQUARE_SIZE,SQUARE_SIZE);
		r.setFilled(true);
		r.setFillColor(Color.CYAN);
		add(r);
		relocate(r);
		// Your code ends here
	}

	private void relocate(GRect square) {
		// Your code starts here
		while(true){
			double x = rgen.nextDouble(0,getWidth()- SQUARE_SIZE);
			double y = rgen.nextDouble(0, getHeight() - SQUARE_SIZE);
		square.setLocation(x, y);
		pause(PAUSE_TIME);
		}
		// Your code ends here
	}

	/** Size of the square in pixels */
	private static final int SQUARE_SIZE = 100;

	/** Pause time in milliseconds */
	private static final double PAUSE_TIME = 1000;

	/* Instance variables */

	private RandomGenerator rgen = new RandomGenerator();
}
