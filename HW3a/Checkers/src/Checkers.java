/*
 * File: Checkers.java
 * -------------------
 * This program expands on the Checkerboard program from
 * the text so that it centers the checkerboard in the
 * window and adds red and black checkers in the appropriate
 * starting configuration.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Checkers extends GraphicsProgram {

	public void run() {
		// Your code starts here
		double sqSize = (double) getHeight() / NROWS;
		double x0 = (getWidth() - NCOLUMNS * sqSize) / 2;
		double d = sqSize * CHECKER_FRACTION;
		double delta = (sqSize - d) / 2;
		for (int i = 0; i < NROWS; i++) {
			for (int j = 0; j < NCOLUMNS; j++) {
				double x = x0 + j * sqSize;
				double y = i * sqSize;
				GRect sq = new GRect(x, y, sqSize, sqSize);
				if ((i + j) % 2 != 0) {
					sq.setFilled(true);
					sq.setFillColor(Color.GRAY);
					add(sq);
					switch (i) {
					case 0: case 1: case 2:
						GOval redChecker = new GOval(x + delta, y + delta, d, d);
						redChecker.setFilled(true);
						redChecker.setFillColor(Color.RED);
						add(redChecker);
						break;
					case 5: case 6: case 7:
						GOval blackChecker = new GOval(x + delta, y + delta, d, d);
						blackChecker.setFilled(true);
						add(blackChecker);
						break;
					}
				} else {
					add(sq);
				}
			}
		}

		// Your code ends here
	}

	/* Private constants */
	private static final int NROWS = 8;
	private static final int NCOLUMNS = 8;
	private static final double CHECKER_FRACTION = 0.8;

}
