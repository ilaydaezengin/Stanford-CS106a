/*
 * File: Combinations.java
 * -----------------------
 * This program computes the mathematical combinations function
 * C(n, k), which is the number of ways of selecting k objects
 * from a set of n distinct objects.
 */

import acm.program.*;

public class Combinations extends ConsoleProgram {

	public void run() {
		int n = readInt("Enter number of objects in the set (n): ");
		int k = readInt("Enter number to be chosen (k): ");
		println("C(" + n + ", " + k + ") = " + combinations(n, k));
	}

	/*
	 * Returns the mathematical combinations function C(n, k),
	 * which is the number of ways of selecting k objects
	 * from a set of n distinct objects.
	 */
	private int combinations(int n, int k) {
		int answer = 0;
		// Your code starts here
		answer = factorial(n) / (factorial(n - k) * factorial(k));
        // Your code ends here
		return answer;
	}

	/*
	 * Returns the factorial of m, which is defined as the
	 * product of all integers from 1 up to m.
	 */
	private int factorial(int m) {
		int result = 1;
		for (int i = 1; i <= m; i++) {
			result *= i;
		}
		return result;
	}

}
