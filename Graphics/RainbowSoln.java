/*
 * File: Rainbow.java
 * ------------------
 * This program is a stub for the Rainbow problem, which displays
 * a rainbow by adding consecutively smaller circles to the canvas.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class RainbowSoln extends GraphicsProgram {

	public void run() { 
		GRect background = new GRect(0,0,getWidth(), getHeight());
		background.setColor(Color.CYAN);
		background.setFillColor(Color.CYAN);
		background.setFilled(true);
		add(background);

		for (int i = 0; i < 7; i++)
		{
			// Your code starts here
			GOval newCircle = new GOval(-getWidth()/2,10+(i*10), getWidth()*2, getHeight()*2);
			switch (i) {
			case 0:
				newCircle.setColor(Color.RED);
				newCircle.setFillColor(Color.RED);
				break;
			case 1:
				newCircle.setColor(Color.ORANGE);
				newCircle.setFillColor(Color.ORANGE);
				break;
			case 2:
				newCircle.setColor(Color.YELLOW);
				newCircle.setFillColor(Color.YELLOW);
				break;
			case 3:
				newCircle.setColor(Color.GREEN);
				newCircle.setFillColor(Color.GREEN);
				break;
			case 4:
				newCircle.setColor(Color.BLUE);
				newCircle.setFillColor(Color.BLUE);
				break;
			case 5:
				newCircle.setColor(Color.MAGENTA);
				newCircle.setFillColor(Color.MAGENTA);
				break;
			case 6:
				newCircle.setColor(Color.CYAN);
				newCircle.setFillColor(Color.CYAN);
				break;
			default:
				break;
			}
			newCircle.setFilled(true);
			add(newCircle);
			// Your code ends here
		}
	}
}