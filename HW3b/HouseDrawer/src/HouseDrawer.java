/*
 * File: HouseDrawer.java
 * --------------------
 * This program draws a simple frame house.  This version updates the
 * exercise from Chapter 2 so that it uses named constants to define
 * the parameters of the  picture.
 * 
 * Class: HouseDrawer.java
 * Score: (Easy)
 * Prerequisites: ACM Task Force Graphics Commands
 */

import acm.graphics.*;
import acm.program.*;

public class HouseDrawer extends GraphicsProgram {

	public void run() {
		// Your code starts here
		double cx = getWidth() / 2;
		double cy = getHeight() / 2;

		//Set House Width and Height
		double houseX = cx - HOUSE_WIDTH / 2;
		double houseY = cy + (HOUSE_HEIGHT + ROOF_HEIGHT) / 2 - HOUSE_HEIGHT;

		//Set Door Height and Width
		double doorX = cx - DOOR_WIDTH / 2;
		double doorY = houseY + HOUSE_HEIGHT - DOOR_HEIGHT;

		//Set Know Height and Width
		double knobX = doorX + DOOR_WIDTH * KNOB_X_FRACTION - KNOB_RADIUS;
		double knobY = doorY + DOOR_HEIGHT * KNOB_Y_FRACTION - KNOB_RADIUS;

		double windowMargin = (HOUSE_WIDTH - DOOR_WIDTH - 2 * WINDOW_SIZE) / 4;	//Set Margin of the window

		//Set Height and Width of the both windows
		double leftWindowX = houseX + windowMargin;
		double rightWindowX = houseX + HOUSE_WIDTH - windowMargin - WINDOW_SIZE;
		double windowY = houseY + HOUSE_HEIGHT * WINDOW_Y_FRACTION - WINDOW_SIZE / 2;

		//Draw all of the house parts
		add(new GRect(houseX, houseY, HOUSE_WIDTH, HOUSE_HEIGHT));
		add(new GLine(houseX, houseY, cx, houseY - ROOF_HEIGHT));
		add(new GLine(cx, houseY - ROOF_HEIGHT, houseX + HOUSE_WIDTH, houseY));
		add(new GRect(doorX, doorY, DOOR_WIDTH, DOOR_HEIGHT));
		add(new GOval(knobX, knobY, KNOB_RADIUS * 2, KNOB_RADIUS * 2));
		add(new GRect(leftWindowX, windowY, WINDOW_SIZE, WINDOW_SIZE));
		add(new GRect(rightWindowX, windowY, WINDOW_SIZE, WINDOW_SIZE));

		// Your code ends here
	}

	//Variable Declarations
	private static final double HOUSE_WIDTH = 150;
	private static final double HOUSE_HEIGHT = 75;
	private static final double ROOF_HEIGHT = 35;
	private static final double DOOR_WIDTH = 30;
	private static final double DOOR_HEIGHT = 50;
	private static final double WINDOW_SIZE = 30;
	private static final double WINDOW_Y_FRACTION = 0.35;
	private static final double KNOB_RADIUS = 2.5;
	private static final double KNOB_X_FRACTION = 0.8;
	private static final double KNOB_Y_FRACTION = 0.5;

}
