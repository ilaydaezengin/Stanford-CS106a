/*
 * (**) Using GArc, draw a double rainbow. Rainbow's colors in order are:
 * RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO and VIOLET. INDIGO and VIOLET
 * are not defined in Color (means that Color.INDIGO does not exist) so
 * instead use new Color(75, 0, 130) for INDIGO and new Color(238, 130,
 * 238) for VIOLET. Your output should look like the one in here, but not
 * necessarily be exactly same (differences in sizes are fine).
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class DoubleRainbow extends GraphicsProgram{
	
	public void run() {
		for (int i = 0; i < 7; i++)
		{
			// Your code starts here
			GOval newCircle = new GOval((i*10),(i*10), getWidth(), getHeight()*2);
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
				newCircle.setColor(Color.WHITE);
				newCircle.setFillColor(Color.WHITE);
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
