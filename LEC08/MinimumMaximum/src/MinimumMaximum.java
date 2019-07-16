/*
 * File: MinimumMaximum .java
 * ------------------------------
 * This program determines the maximum and
 * minimum of two integer values.
 */

import acm.program.*;

public class MinimumMaximum extends ConsoleProgram {

	public void run() {
		int n1 = readInt("Enter input 1 : ");
		int n2 = readInt("Enter input 2 : ");
		println("The Maximum is : " + getMax(n1,n2));
		println("The Minimum is : " + getMin(n1,n2));

	}

	/* Returns the maximum of two integers */
	private int getMax(int n1, int n2) {
		int max = 0;
		// Your code starts here
		if (n1 > n2){
			max = n1;
		} else {
			max = n2;
		}
		// Your code ends here
		return max;
	}

	/* Returns the minimum of two integers */
	private int getMin(int m1,int m2) {
		int min = 0;
		// Your code starts here
		if (m1 < m2){
			min = m1;
		} else {
			min = m2;
		}
		// Your code ends here
		return min;
	}
}