/** DrawCross.java:
 * Draw a red cross (using GPolygon) in the middle of the window.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.Color;


public class DrawCrossSoln extends GraphicsProgram{

	public void run() {
		GPolygon cross = createCross(100);
		cross.setFilled(true);
		cross.setColor(Color.RED);
		add(cross, getWidth() / 2, getHeight() / 2);
	}

	private GPolygon createCross(double size) {
		GPolygon p = new GPolygon();
		// Your code starts here
		double edge = size / 3;
		p.addVertex(-size / 2, -edge / 2);
		p.addEdge(edge, 0);
		p.addEdge(0, -edge);
		p.addEdge(edge, 0);
		p.addEdge(0, edge);
		p.addEdge(edge, 0);
		p.addEdge(0, edge);
		p.addEdge(-edge, 0);
		p.addEdge(0, edge);
		p.addEdge(-edge, 0);
		p.addEdge(0, -edge);
		p.addEdge(-edge, 0);
		p.addEdge(0, -edge);
		// Your code ends here
		return p;
	}
}