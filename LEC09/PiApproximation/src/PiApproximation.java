/*
 * File: PiApproximation.java
 * --------------------------
 * This progam computes an approximation to pi by simulating
 * a dart board, as described in the handout.  The general
 * technique is called Monte Carlo integration.
 */

import acm.program.*;
import acm.util.*;

public class PiApproximation extends ConsoleProgram {

	public void run() {
		double pi = 0;
		int intheDart = 0 ;
		// Your code starts here
		for(int i = 0; i < NDARTS; i ++){
		double x = rgen.nextDouble(0, 1);
		double y = rgen.nextDouble(0, 1);
		if(Math.sqrt((x * x) + (y * y)) <= 1){
			intheDart ++;
		} 
		}
		pi = 4.0 * intheDart / NDARTS;
		// Your code ends here
		println("Pi is approximately " + pi);
	}

	/* Private constants */
	private static final int NDARTS = 10000;  /* Number of darts to throw */

	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
