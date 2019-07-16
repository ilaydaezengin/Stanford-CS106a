
/*
 * File: PrimeNumer.java
 * ---------------------
 * This program displays the first 50 prime numbers
 */

import acm.program.*;

public class PrimeNumber extends ConsoleProgram {

	public void run() {

		println("The first 50 prime numbers are ");
		println("2"); 
		int isPrime = 1;
		int number = 3;
		for(int j = 2; j <= NUMBER_OF_PRIMES; j ++) {
			// Test if number is prime
			for (int i = 2; i <=Math.sqrt(number); i++) { 
				  
		        // If n is divisible by any number between 
		        // 2 and itself, it is not prime 
		            if (number % i == 0) { 
			        	isPrime = 0;
			        	break;
			          } 
		         			}
			if(isPrime != 0){
				println(number);
				j++; // Increase the count
				
			}
			isPrime = 1;
			number++;
			// Your code ends here
		}
		}
	
	private static final int NUMBER_OF_PRIMES = 50;
	}

