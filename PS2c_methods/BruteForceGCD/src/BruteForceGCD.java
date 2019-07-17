/*
 * File: BruteForceGCD.java
 * ------------------------
 * This program uses a brute force approach to compute the
 * greatest common divisor of two integers.
 */

import acm.program.*;

public class BruteForceGCD extends ConsoleProgram {

	public void run() {
		println("This program computes the gcd of x and y.");
		int x = readInt("Enter x: ");
		int y = readInt("Enter y: ");
		println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
	}

//Implement the helper method gcd() here
	private int gcd(int x,int y){
		int GCD = 0;
        for (int counter = 1; counter < (x + y); counter++) {
            if (x % counter == 0) {
                if (y % counter == 0) {
                    GCD = counter;
                }
            }
        }
        return GCD;
		
		
	}
}
