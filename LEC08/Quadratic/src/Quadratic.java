/*
 * File: Quadratic.java
 * --------------------
 * This program is a stub for the Quadratic problem, which finds the
 * roots of the quadratic equation.
 */

import acm.program.*;

public class Quadratic extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("Enter coeefficients for the quadratic equation: ");
		double a = readDouble("a: ");
		double b = readDouble("b: ");
		double c = readDouble("c: ");
		if((b*b - 4*a*c) < 0 ){
			println("There is no real solution!");
		} else {
			double root1 = (-b + Math.sqrt(b*b - 4*a*c)) / (2*a);
			double root2 = (-b - Math.sqrt(b*b - 4*a*c)) / (2*a);
			println("The first solution is: "+root1);
			println("The second solution is: "+root2);

		}
		// Your code ends here
	}

}

