/*
 * Student Name: Ilayda Ezgi Zengin,50302
 * ------------------------
 * This program is a graphics program which creates flower patterns
 * by getting the flower size and pedal numbers from the user.
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.Color;
import java.io.Console;
import java.lang.Math;
import java.util.Scanner;

public class Comp130_HW3_Sum19 extends GraphicsProgram {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private static final int PAUSE_TIME = 100;
	private GCompound flower = null;
	double cx = 0;
	double cy = 0;
	
	public void run() {
		addBackground("grassBack1.jpeg");
		println("This program creates customer defined flower patterns.");
		Scanner myInput = new Scanner( System.in );
		while(true){
			System.out.print( "Please enter the number of pedals for a flower (enter a number between 4-10): " );
			int pedal = myInput.nextInt();
			if(pedal < 4 || pedal > 10){
				while(true){
					flower.rotate(60);
					pause(PAUSE_TIME);
				}
				//break;
			} else {
			System.out.print( "Please enter the radius of the flower (between 5-15): " );
			double rad = myInput.nextDouble();
			while(rad < 5 || rad > 15){
				System.out.print( "Please enter the radius of the flower (between 5-15): " );
				rad = myInput.nextDouble();
			}
			double rad2 = findAngle(pedal);
			cx = (4 * rad2 + 2 * rad) / 2;
			cy = (4 * rad2 + 2 * rad) / 2;
			flower = mycreateFlower(pedal,rad,cx,cy);
			double width = rgen.nextDouble(0, getWidth() -(4 * rad2 + 2 * rad));
			double height = rgen.nextDouble(getHeight() - flower.getHeight()- 100, 
											getHeight()- flower.getHeight() - 50);
			add(flower,width,height);
		}
		}
		/*
		System.out.print( "Please enter the number of pedals for a flower (enter a number between 4-10): " );
		int pedal = myInput.nextInt();
		while(4 <= pedal && pedal <= 10 ){
			System.out.print( "Please enter the radius of the flower (between 5-15): " );
			double rad = myInput.nextDouble();
			while(rad < 5 || rad > 15){
				System.out.print( "Please enter the radius of the flower (between 5-15): " );
				rad = myInput.nextDouble();
			}
			double rad2 = findAngle(pedal);
			double cx = (4 * rad2 + 2 * rad) / 2;
			double cy = (4 * rad2 + 2 * rad) / 2;
			GCompound flower = mycreateFlower(pedal,rad,cx,cy);
			double width = rgen.nextDouble(0, getWidth() -(4 * rad2 + 2 * rad));
			double height = rgen.nextDouble(getHeight() - flower.getHeight()- 100, 
											getHeight()- flower.getHeight() - 50);
			add(flower,width,height);
			System.out.print( "Please enter the number of pedals for a flower (enter a number between 4-10): " );
			pedal = myInput.nextInt();
		}
		*/
		}
		
		
		
		
		// your code ends here
	
	//this method adds background with given boundaries
	private void addBackground(String imgName){
		GImage background = new GImage(imgName);
		background.setBounds(0, 0, getWidth(), getHeight());
		add(background);
	}
	
	
	/**
	 * This method is used to create a compound consisting of flower pedals
	 * and inner circle of the flower
	 * @param pedalNumber
	 * @param cx
	 * @param cy
	 * @return
*/
	
	private GCompound mycreateFlower(int pedalNumber,double r, double cx,double cy){
		GCompound flower = new GCompound();
		double a = findAngle(pedalNumber);
		double r2 =find_radius(Math.toRadians(a), r);
		GRect stem = createStem(cx, cy, r,r2);
		flower.add(stem);
		GOval circ = createInnerCircle(r, cx, cy);
		flower.add(circ);
		Color color = rgen.nextColor();
		for(int i = 0; i < pedalNumber; i ++){
			GCompound pedal = createSinglePedal(a * i,r,r2,cx,cy,color);
			flower.add(pedal);
		}		
		
		return flower;
	}
	
	private GOval createInnerCircle(double r, double cx,double cy){
		GOval circ = new GOval(cx - r, cy - r, 2 * r,2 * r);
		circ.setFilled(true);
		circ.setColor(Color.YELLOW);
		return circ;
	}
	
	/**
	 * This method creates a single pedal of a flower
	 * @param angle
	 * @param radius1
	 * @param radius2
	 * @param cx
	 * @param cy
	 * @param color
	 * @return
	 */
	private GCompound createSinglePedal(double angle,double radius1,double radius2,double cx,double cy, Color color) {
		
		GCompound a_compound=new GCompound();
		// your code starts here
		double r = radius1 + radius2;
		GOval circ = new GOval(cx - radius2,cy - radius2,2 * radius2, 2 * radius2);
		circ.setFilled(true);
		circ.setColor(color);
		circ.movePolar(r, 2 * angle);
		a_compound.add(circ);
		
		
		
		// your code ends here
		return a_compound;
	}
	/**
	 * This method calculates the radius of the pedals
	 * @param angle
	 * @param radius
	 * @return
	 */
	private double find_radius(double angle,double radius) {
		double answer = 0;
		// your code starts here
		answer = Math.sin(angle) * radius / (1 - Math.sin(angle));
		// your code ends here
		return answer;
	}
	
	private double findAngle(int pedal){
		int a = 360 / (2 * pedal);
		return a;
	}
	/**
	 * This method create a single stem for a flower
	 * @param cx
	 * @param cy
	 * @param radius
	 * @param outherRadius
	 */
	private GRect createStem(double cx, double cy, double radius, double outerRadius) {
		// your code starts here
		double width = 0;
		double height = 0;
		if(radius < outerRadius){
			width = outerRadius * 1 / 4;
			height = 6 * outerRadius;
		} else {
			width = radius * 1 / 4;
			height = 6 * radius;			
		}
		GRect stem = new GRect(cx -width /2,cy,width,height);
		stem.setFilled(true);
		stem.setFillColor(Color.BLACK);
		return stem;
		
		// your code ends here
	}	
	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new Comp130_HW3_Sum19().start(args);
	}
}



