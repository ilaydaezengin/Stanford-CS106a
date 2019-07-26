/** DrawDiamond.java:
 * Draw a filled diamond shape (using GPolygon) at the center of the window.
 * Try to do it with both addVertex and addEdge.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;


public class DrawDiamond extends GraphicsProgram{

	public void run() {
		GPolygon diamond = createDiamond(100, 75);
		diamond.setFilled(true);
		diamond.setFillColor(Color.MAGENTA);
		add(diamond, getWidth() / 2, getHeight() / 2);
	}

	private GPolygon createDiamond(double width, double height) {
		GPolygon diamond = new GPolygon();
		// Your code starts here
		diamond.addVertex(0, -height/2);
		diamond.addVertex(-width/2, 0);
		diamond.addVertex(0, height/2);
		diamond.addVertex(width/2, 0);
		
		// Your code ends here
		return diamond;
	}
}
