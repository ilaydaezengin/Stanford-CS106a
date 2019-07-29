
import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Question2 extends GraphicsProgram {
	
	public void run() {
		// Your code starts here
		GCompound bird = createBird();
		add(bird,  0, this.getHeight() - bird.getHeight());
		jump(bird);
		// Your code ends here
	}
	
	
	
	private void jump(GCompound bird) {
		for(int i = - Dy_MAX; i <= Dy_MAX  ; i ++){
			bird.move(Dx, i);
			pause(PAUSE_TIME);
			
		}
		
	}
	// Your code starts here
	private GCompound createBird(){
		GCompound bird = new GCompound();
		GPolygon beak = createBeak();
		bird.add(beak);
		GCompound eye = createEye();
		bird.add(eye);
		return bird;
		
	}
	
	private GPolygon createBeak(){
		GPolygon beak = new GPolygon();
		beak.addVertex(0,0);
		beak.addEdge(0, 60);
		beak.addEdge(80, 0);
		beak.setFillColor(Color.RED);
		beak.setFilled(true);
		return beak;
		
	}
	private GCompound createEye(){
		GCompound eye = new GCompound();
		GOval outerEye = new GOval(0,0,20,20);
		outerEye.setFillColor(Color.WHITE);
		outerEye.setFilled(true);
		GOval inEye = new GOval(0,0,10,10);
		inEye.setFillColor(Color.BLACK);
		inEye.setFilled(true);
		eye.add(outerEye);
		eye.add(inEye);
		return eye;
		
	}
	// Your code ends here
	
	/* Private constants */
	private static final int PAUSE_TIME = 100;
	private static final int Dy_MAX = 20;
	private static final int Dx = 5;
	private static final int GRASS_HEIGHT = 20;
	
	/* 
	 * Provides the environment.
	 * Do not change.
	*/
	public void init() {
		setSize(500, 500);
		this.setBackground(Color.BLUE);
		GOval sun = new GOval(50,50);
		sun.setFillColor(Color.ORANGE);
		sun.setFilled(true);
		add(sun, this.getWidth()-sun.getWidth()-10, 10);
		GRect grass = new GRect(getWidth(),GRASS_HEIGHT);
		grass.setFillColor(Color.GREEN);
		grass.setFilled(true);
		add(grass, 0,this.getHeight()-grass.getHeight());
		GLine rope = new GLine(0,
				getHeight()-grass.getHeight()-Dy_MAX*(Dy_MAX+1)/2,
				getWidth(),
				getHeight()-grass.getHeight()-Dy_MAX*(Dy_MAX+1)/2);
		add(rope);
	}
}
