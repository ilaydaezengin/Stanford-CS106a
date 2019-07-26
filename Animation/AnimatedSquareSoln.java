/*
 * File: AnimatedSquare.java
 * -------------------------
 * This program animates a square so that it moves from the
 * upper left corner of the window to the lower right corner.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class AnimatedSquareSoln extends GraphicsProgram {

	public void run() {
		// Your code starts here
		GRect square = new GRect(0, 0, SQUARE_SIZE, SQUARE_SIZE);
		square.setFilled(true);
		square.setFillColor(Color.RED);
		add(square);
		double dx = (getWidth() - SQUARE_SIZE) / N_STEPS;
		double dy = (getHeight() - SQUARE_SIZE) / N_STEPS;
		for (int i = 0; i < N_STEPS; i++) {
			square.move(dx, dy);
			pause(PAUSE_TIME);
		}
		// Your code ends here
	}


	/* Private constants */

	private static final double SQUARE_SIZE = 50;
	private static final int N_STEPS = 100;
	private static final double PAUSE_TIME = 20;
}
