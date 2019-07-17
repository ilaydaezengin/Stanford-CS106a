/*
 * File: factorialSeries.java
 * ----------------------
 * This program calculates the factorial series.
 */

import acm.program.*;

public class factorialSeries extends ConsoleProgram {

	public void run() {
		println("This program calculates the factorial series.");
		double sum = 1.0;
		for(int i = SERIES_START; i <= SERIES_END; i ++){
			sum += 1.0 / factorial(i); 
		}
		println("The factorial series for " + SERIES_END + " terms is : " + sum);
	}

 
/*
 * Returns the factorial of n, which is defined as the
 * product of all integers from 1 up to n.
 */private int factorial(int n){
	 if(n <= 1){
		 return 1;
	 } else {
		return n * factorial(n - 1);
	 }
 }



/* Private constants */
	private static final int SERIES_START = 1;
	private static final int SERIES_END = 10;

}
