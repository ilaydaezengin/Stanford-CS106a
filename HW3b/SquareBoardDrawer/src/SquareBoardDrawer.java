/*
 * File: SquareBoardDrawer.java
 * --------------------
 * This program draws draws an empty square board 
 * that size is taken from the user
 * 
 * Class: SquareBoardDrawer.java
 * Score: (Medium)
 * Prerequisites: For Loops, ACM Task Force Graphics Commands
 */

import java.util.Scanner;

import acm.graphics.*;
import acm.program.*;

public class SquareBoardDrawer extends GraphicsProgram {

	public void run() {
		// Your code starts here
		
		Scanner myInput = new Scanner( System.in );
		System.out.print( "Please enter the size of the board: ");
		int pile = myInput.nextInt();
		double cx = (getWidth() - BLOCK_LENGTH * pile) / 2;
		double cy = (getHeight() - BLOCK_LENGTH * pile) / 2;
		for(int i = 0; i < pile; i ++){
			for(int j = 0; j < pile; j ++){
				add(new GRect(cx + BLOCK_LENGTH * i,cy + BLOCK_LENGTH * j,BLOCK_LENGTH,BLOCK_LENGTH));
			}
		}
		// Your code ends here	
		
	}

	//Global Variable Declarations
	private static final double BLOCK_LENGTH = 25;

}
