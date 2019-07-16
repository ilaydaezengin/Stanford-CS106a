
/*
 * File: PrimeNumer.java
 * ---------------------
 * This program displays the first 50 prime numbers
 */

import acm.program.*;

public class PrimeNumber extends ConsoleProgram {

	public void run() {

		println("The first 50 prime numbers are ");

		int number = 2; 
		int count = 0;
		while (count < NUMBER_OF_PRIMES) {

			boolean isPrime = true; 

			// Test if number is prime
			// Your code starts here
			int n = number;
			for (int i = 2; i <= n; i++) { 
				  
		        // If n is divisible by any number between 
		        // 2 and itself, it is not prime 
		        if (n % i == 0) { 
		            n++; 
		        } 
		        
			// Your code ends here

			// Print the prime number and increase the count
			if (isPrime) {
				count++; // Increase the count

				if (count % 10 == 0) {
					println(number);
				} else {
					print(number + " ");
				}
			}	
			number++;
		}
	}

	private static final int NUMBER_OF_PRIMES = 50;

}
