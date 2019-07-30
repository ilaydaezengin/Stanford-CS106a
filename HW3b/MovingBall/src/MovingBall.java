
import java.awt.Color;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;


public class MovingBall extends GraphicsProgram {
	
	public void run() {
		setSize(500, 500);
		
		// Your code starts here
		createCircle();
		// Your code ends here
	}
	
	private GOval createCircle() {
		// Your code starts here
		double x = rgen.nextInt(0,500);
		double y = rgen.nextInt(0,500);
		double x1 = rgen.nextInt(0,500);
		double y1 = rgen.nextInt(0,500);
		GLine line = new GLine(x,y,x1,y1);
		add(line);
		GOval c = new GOval(x - CIRCLE_RADIUS, y - CIRCLE_RADIUS, 2 * CIRCLE_RADIUS, 2 * CIRCLE_RADIUS );
		c.setFilled(true);
		c.setFillColor(CIRCLE_COLOR);
		add(c);
		double dx =(x1 - x) / NUM_OF_STEPS;
		double dy =(y1 - y) / NUM_OF_STEPS;
		for(int i = 0; i < NUM_OF_STEPS; i ++){
			c.move(dx, dy);
			pause(PAUSE_TIME);
		}
		return c;
		// Your code ends here
	}
	
	/* Private constants */
	private static final Color CIRCLE_COLOR = Color.RED;
	private static final int CIRCLE_RADIUS = 15;
	private static final double NUM_OF_STEPS = 100;
	private static final double PAUSE_TIME = 10;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
