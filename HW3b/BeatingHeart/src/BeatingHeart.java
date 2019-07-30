/*
 * File: BeatingHeart.java
 * -------------------------
 * Write a program that draws a ball (whichever colour you want) 
 * centered in the applet screen with an initial radius of 10. 
 * Then, continuously enlarge your ball�s radius until it reaches 
 * the walls (bounds) of your screen. Once it touches the walls, 
 * then, continuously shrink your ball to the original size. 
 * Continue to do so infinitely.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BeatingHeart extends GraphicsProgram {
	public void run() {
		// Your code starts here
		GOval circ = new GOval((this.getWidth()/2- r0), (this.getHeight()/2- r0), 2 * r0, 2 * r0);
		circ.setFillColor(Color.red);
		circ.setFilled(true);
		add(circ);
		double r1 = r0;
		while(true){
		while(r1 <= this.getWidth() / 2 && r1 <= this.getHeight() / 2){
			r1 = r1 * 2;
			circ.setBounds(this.getWidth()/2 - r1,this.getHeight()/2 - r1, 2 *r1, 2 * r1);
			pause(PAUSE_TIME);
		}
		while(r1 > 10){
			r1 = r1 / 2;
			circ.setBounds(this.getWidth()/2 - r1,this.getHeight()/2 - r1, 2 *r1, 2 * r1);
			pause(PAUSE_TIME);
		}
		}
		// Your code ends here
	}


	/* Private constants */
	private static final int PAUSE_TIME = 100;
	private static final double r0 = 10;

}
