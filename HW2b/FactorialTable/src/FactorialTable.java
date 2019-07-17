/*
 * File: FactorialTable.java
 * -------------------------
 * This file generates a table of factorials.
 */

import acm.program.*;

public class FactorialTable extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("This program generates a table of factorials.");
		for(int i = 1; i <= 10; i ++){
			println("Factorial of " + i +" is " + factorial(i));
		}
		// Your code ends here
	}

	/*
	 * Returns the factorial of n, which is defined as the
	 * product of all integers from 1 up to n.
	 */
	private int factorial(int n) {
		int result = 1;
		// Your code starts here
		if (n == 1){
			return result;
		} else {
			return result = n * factorial(n - 1);
		}
		// Your code ends here
	}

	/* Private constants */
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 10;

}
