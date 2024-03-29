import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

import acm.graphics.*;

public class SnowSoln extends GraphicsProgram {

	private static final int SNOW_SIZE = 20;
	private RandomGenerator rg = new RandomGenerator();

	private ArrayList<GOval> snowList = new ArrayList<GOval>();

	public void run() {

		while(true) {
			// update world
			makeNewSnow();
			moveSnow();

			// pause
			pause(10);
		}

	}

	private void moveSnow() {
		for(GOval nextFlake : snowList) {
			if(nextFlake.getY() + SNOW_SIZE < getHeight()) {
				nextFlake.move(0, 1);
			}
		}
	}

	private void makeNewSnow() {
		// make a new snowflake with 5% probability
		if(rg.nextBoolean(0.05)) {
			double x = rg.nextInt(getWidth() - SNOW_SIZE);
			GOval flake = new GOval(SNOW_SIZE, SNOW_SIZE);
			flake.setFilled(true);
			add(flake, x, -SNOW_SIZE);
			snowList.add(flake);
		}

	}
}
