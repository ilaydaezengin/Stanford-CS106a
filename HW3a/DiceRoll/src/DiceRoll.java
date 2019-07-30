/*
 * File: DiceRoll.java
 * ---------------------------
 * This program performs a random experiment consisting of rolling a dice 
 * repeatedly until two consecutive observation of a desired number.
 */

import acm.program.*;
import acm.util.*;

public class DiceRoll extends ConsoleProgram {

	public void run() {
		// Your code starts here
		int count = 0;
		int count2 = 0;
		int temp = 0;
		println("The desired number is : " + DESIRED_NUMBER);
		while(count < NUMBER_REQUIRED){
			int num = rgen.nextInt(1, 6);
			println(num + " rolled");
			if(temp == num){
				println("It took " + count2 + " tosses to get " + NUMBER_REQUIRED + " consecutive " + DESIRED_NUMBER);
				break;
			}
			else {
				temp = 0;
				count = 0;
			}
			if(num == DESIRED_NUMBER){
				temp = num;
				count ++;
			}
			count2 ++;
		}
		// Your code ends here
	}


	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

	/* Private constants */
	private static final int NUMBER_REQUIRED = 2;  /* Number of consecutive successes required */
	private static final int DESIRED_NUMBER = 4;  /* The desired dice number */
}
