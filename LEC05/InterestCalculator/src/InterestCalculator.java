/*
 * File: InterestCalculator.java
 * -------------------------------------
 * This program calculates the interest added to an account
 * during each of ten years and prints the balance at each year.
 * 
 * Class: InterestCalculator
 * Difficulty: (Medium)
 * Prerequisites: For Loops, Variables and Arithmetic, ConsoleProgram (readDouble, println)
 */

import acm.program.*;

public class InterestCalculator extends ConsoleProgram {

	//Main System Function
	public void run() {
		// Your code starts here
		println("Interest calculation program");
		double stBalance = readDouble("Enter starting balance: ");
		int rate = readInt("Enter annual interest rate: ");
		double balance = stBalance;
		for(int i = 0; i < 10; i++){
			balance += balance * rate / 100;
			println("Balance after " + (i + 1) + " year = " + balance);
		}
		// Your code ends here
	}
	
}

