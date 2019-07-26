
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;

public class ChangingTrafficLights extends GraphicsProgram {

	public void run() {
		double centerX = getWidth() / 2;
		double centerY = getHeight() / 2;
		double frameX = centerX - FRAME_WIDTH / 2;
		double frameY = centerY - FRAME_HEIGHT / 2;
		double distBetwCircles = FRAME_HEIGHT / 4 + LAMP_RADIUS / 2;
		GRect frame = new GRect(frameX, frameY, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setFilled(true);
		frame.setColor(Color.GRAY);
		
		GOval redLight = createFilledCircle(centerX, centerY - distBetwCircles, LAMP_RADIUS, Color.RED);
		GOval yellowLight = createFilledCircle(centerX, centerY, LAMP_RADIUS, Color.YELLOW);
		GOval greenLight = createFilledCircle(centerX, centerY + distBetwCircles, LAMP_RADIUS, Color.GREEN);
		
		add(frame);
		add(redLight);
		add(yellowLight);
		add(greenLight);
		
		// Your code starts here
		
		// Your code ends here
	}

	private GOval createFilledCircle(double x, double y, double r, Color color) {
		GOval circle = new GOval(x - r, y - r, 2 * r, 2 * r);
        
        // Your code starts here
		
        
        // Your code ends here
		return circle;
	}

	/* Private constants */
	private static final double FRAME_WIDTH = 100;
	private static final double FRAME_HEIGHT = 200;
	private static final double LAMP_RADIUS = 20;
	private static final double LIGHT_UP_TIME = 200;
	private static final double NUM_OF_RED_REQUIRED = 3;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
