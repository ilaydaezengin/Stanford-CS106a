/*
 * File: BouncingBallWithHoles.java
 * -------------------------
 * This program animates a bouncing ball where two holes will be created.
 * When the ball passes from one hole, it will disappear and re-appear in the other hole
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class BouncingBallWithHoles extends GraphicsProgram {

	public void run() {

		GOval circle = new GOval(40, 410, DIAMETER, DIAMETER);
		circle.setFilled(true);
		circle.setFillColor(Color.red);
		add(circle);
		
		//The text to be written on screen at the end
		GLabel text=new GLabel("Game over!",200,200);
		text.setFont(textFontStyle);
		
		// Your code starts here(Create the wall and the holes here)
		GLine wall = new GLine(getWidth()/2,0,getWidth()/2,getHeight());
		add(wall);
		
		GRect hole1=new GRect(0,0,DIAMETER,DIAMETER);
		hole1.setFilled(true);
		add(hole1);
		GRect hole2=new GRect(0,getHeight()-DIAMETER,DIAMETER,DIAMETER);
		hole2.setFilled(true);
		add(hole2);
		GRect hole3=new GRect(getWidth()-DIAMETER,0,DIAMETER,DIAMETER);
		hole3.setFilled(true);
		add(hole3);
		GRect hole4=new GRect(getWidth()-DIAMETER,getHeight()-DIAMETER,DIAMETER,DIAMETER);
		hole4.setFilled(true);
		add(hole4);
		
		
		// Your code ends here
		
		double dx = 5;
		double dy = 5;
		while(true) {
			// Check the boundaries and change movement parameters
			if(getWidth() <= circle.getX()+DIAMETER || circle.getX()<=0){
				dx = -dx;
			}
			if(getHeight() <= circle.getY()+DIAMETER || circle.getY()<=0){
				dy = -dy;
			}
			// Your code starts here
			// Check if ball passes the wall here
			// Check if the ball falls in the hole here
			if(circle.getX() <= getWidth()/2 && !circle.isFilled()){
				circle.setFilled(true);
			} else if(circle.getX()>getWidth()/2 && circle.isFilled()){
				circle.setFilled(false);
			}
			if(circle.getX()<= DIAMETER/2 && circle.getY() <= DIAMETER/2){
				remove(circle);
				add(text);
				break;
				
			}
			if(circle.getX()<=DIAMETER/2 && circle.getY()>=getHeight()-DIAMETER){
				remove(circle);
				add(text); 
				break;
			}
			if(circle.getX()>=getWidth()-DIAMETER && circle.getY()<=DIAMETER/2){
				remove(circle);
				add(text); 
				break;
			}
			if(circle.getX()>=getWidth()-DIAMETER && circle.getY()>=getHeight()-DIAMETER){
				remove(circle);
				add(text); 
				break;
			}
			
			// Your code ends here
			circle.move(dx, dy);
			pause(PAUSE_TIME);
		}
	}

	/* Private constants */
	private static final int PAUSE_TIME = 10;
	private static final double DIAMETER = 30;
	private static final String textFontStyle="arial-BOLD-24";

}
