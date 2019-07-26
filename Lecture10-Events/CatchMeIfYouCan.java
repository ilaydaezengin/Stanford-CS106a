/*
 * File: CatchMeIfYouCan.java
 * -----------------------------
 * Makes a program with one magic blue square and many
 * distractors. The user tries (in vain) to touch the
 * blue square with her mouse.
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class CatchMeIfYouCan extends GraphicsProgram {

	private static final int DISTRACTOR_SIZE = 40;
	private static final int SQ_SIZE = 45;
	private static final int N_DISTRACTORS = 50;
	
	// A new type of variable that can make random numbers
	private RandomGenerator rg = new RandomGenerator();
	private GRect blueSq = null;
	
	public void run() {
		addBlueSquare();
		addMouseListeners();
		addDistractors();
	}
	
	private void addBlueSquare() {
		blueSq = new GRect(SQ_SIZE,SQ_SIZE);
		blueSq.setFilled(true);
		blueSq.setFillColor(Color.BLUE);
		int x = getRandomX(SQ_SIZE);
		int y = getRandomY(SQ_SIZE);
		add(blueSq,x,y);
		
		
	}
	public void mouseMoved(MouseEvent e){
		GObject a = getElementAt(e.getX(),e.getY());
		if(a == blueSq){
			blueSq.setLocation(getRandomX(SQ_SIZE), getRandomY(SQ_SIZE));
		}
	}
	private void addDistractors() {
		for(int i = 0; i < N_DISTRACTORS; i++) {
			addDistractor();
		}
	}

	// Adds a single distractor at a random location.
	private void addDistractor() {
		GRect r = new GRect(DISTRACTOR_SIZE, DISTRACTOR_SIZE);
		r.setFilled(true);
		
		// Get a random number between 0 and maxX - 1
		int maxX = getWidth() - DISTRACTOR_SIZE;
		int x = rg.nextInt(maxX);
		
		// Get a random number between 0 and maxY - 1
		int maxY = getHeight() - DISTRACTOR_SIZE;
		int y = rg.nextInt(maxY);
		
		add(r, x, y);
	}
	
	private int getRandomX(int size){
		return rg.nextInt(getWidth()- size);
	}
	
	private int getRandomY(int size){
		return rg.nextInt(getHeight()- size);
	}
	
}
