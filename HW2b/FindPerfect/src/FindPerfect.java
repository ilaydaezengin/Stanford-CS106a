/*
 * File: FindPerfect.java
 * ----------------------
 * This program finds all perfect numbers between the constants
 * LOWER_BOUND and UPPER_BOUND.
 */

import acm.program.*;

public class FindPerfect extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("This program find the perfect numbers between " + LOWER_BOUND + " and " + UPPER_BOUND);
		for(int i = LOWER_BOUND; i < UPPER_BOUND; i++){
			if(isPerfect(i)){
				println(i);
			}
		}
		// Your code ends here
	}

	/* Returns true if its argument is a perfect number */
	private boolean isPerfect(int n) {
		boolean perfect = false;
		// Your code starts here
		if(n == sumOfProperDivisors(n)){
			perfect = true;
		}
		// Your code ends here
		return perfect;
	}

	/* Returns the sum of the proper divisors of n */
	private int sumOfProperDivisors(int n) {
		int sum = 0;
		// Your code starts here
		for(int i = 1 ; i < n; i++){
			if(n % i == 0){
				sum += i;
			}
		}
		// Your code ends here
		return sum;
	}

	/* Private constants */
	private static final int LOWER_BOUND = 1;
	private static final int UPPER_BOUND = 10000;

}
