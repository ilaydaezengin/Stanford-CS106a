/*
 * File: BouncingBall.java
 * -------------------------
 * This program animates a bouncing ball.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BouncingBallSoln extends GraphicsProgram {

	public void run() {

		GOval circle = new GOval(40, 410, RADIUS, RADIUS);
		circle.setFilled(true);
		circle.setFillColor(Color.red);
		add(circle);
		double dx = 10;
		double dy = 20;
		while(true) {
			// Check the boundaries and change movement parameters
			// Your code starts here
			if(getWidth() <= circle.getX()+RADIUS || circle.getX()<=0){
				dx = -dx;
			}
			if(getHeight() <= circle.getY()+RADIUS || circle.getY()<=0){
				dy = -dy;
			}
			// Your code ends here
			circle.move(dx, dy);
			pause(PAUSE_TIME);
		}
	}


	/* Private constants */
	private static final int PAUSE_TIME = 30;
	private static final double RADIUS = 50;

}
