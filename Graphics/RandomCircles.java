/*
 * File: RandomCircles.java
 * ------------------------
 * This program draws a set of 10 circles with different sizes,
 * positions, and colors.  Each circle has a randomly chosen
 * color, a randomly chosen radius within a specified range,
 * and a randomly chosen position on the canvas, subject to
 * the condition that the entire circle must fit inside the
 * canvas without extending past the edge.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {

	public void run() {
		for (int i = 0; i < N_CIRCLES; i++) {
			add(createRandomCircle());
		}
	}

	/*
	 * This method creates a circle with a randomly chosen radius,
	 * position, and color, subject to the conditions that the
	 * radius must fall between MIN_RADIUS and MAX_RADIUS and that
	 * the entire circle must be visible on the window.
	 */
	private GOval createRandomCircle() {
		GOval circle;
		// Your code starts here
		double r = rgen.nextDouble(MIN_RADIUS, MAX_RADIUS);
		double x = rgen.nextDouble(0, getWidth()-2*r);
		double y = rgen.nextDouble(0, getHeight()-2*r);
		circle = new GOval(x, y, 2*r,2*r);
		circle.setFilled(true);
		circle.setFillColor(rgen.nextColor());
		
		// Your code ends here
		return circle;
	}

	/* Private constants */
	private static final int N_CIRCLES = 10;
	private static final double MIN_RADIUS = 20;
	private static final double MAX_RADIUS = 125;

	/* Instance variable */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
