/*
 * File: BlockPiler.java
 * --------------------
 * This program draws piles of blocks like a half square that 
 * width of the pile is taken from user
 * 
 * Class: BlockPiler.java
 * Score: (Medium)
 * Prerequisites: For Loops, ACM Task Force Commands
 */

import java.util.Scanner;

import acm.graphics.*;
import acm.program.*;

public class BlockPiler extends GraphicsProgram {

	
	public void run() {
		// Your code starts here		
		Scanner myInput = new Scanner( System.in );
		System.out.print( "Please enter the width of the pile: ");
		int pile = myInput.nextInt();
		double x = (getWidth() - pile * BLOCK_WIDTH)/2;
		double y = (getHeight() + pile * BLOCK_HEIGHT) / 2;
		for(int a = 0; a <= pile; a++) {	//Draw a block column
			for(int b = 0; b < a; b++) {			//Draw blocks for current column
				add(new GRect(x  + (BLOCK_WIDTH*a), y - (BLOCK_HEIGHT*b), BLOCK_WIDTH, BLOCK_HEIGHT));	//Draw a block
			}
		}

		// Your code ends here
	}

	//Global Variable Declarations
	private static final double BLOCK_WIDTH = 25;
	private static final double BLOCK_HEIGHT = 25;
}
