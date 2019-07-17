/*
 * File: BottlesOfBeer.java
 * ------------------------
 * This program prints out the lyrics to the song
 * "99 Bottles of Beer on the Wall."  For testing
 * purposes, the constant should be reduced to a
 * smaller value.
 */

import acm.program.*;

public class BottlesOfBeer extends ConsoleProgram {

	public void run() {
		// Your code starts here
		int bottles = MAX_BOTTLES;
		for(int i = MAX_BOTTLES; i >= 1; i --){
			println( i + " bottles of beer on the wall.");
			println( i + " bottles of beer.");
			println( "You take one down, pass it around. ");
			switch(bottles){
			case 4:
				println("3 bottles of beer on the wall.");
				println("");
				println("");
				bottles --;
				break;
			case 3:
				println("2 bottles of beer on the wall.");
				println("");
				println("");
				bottles --;
				break;
			case 2: 
				println("Only one bottle of the beer on the wall.");
				println("");
				println("");
				bottles --;
				break;
			default:
				println("No more bottles of the beer on the wall.");
				println("");
				println("");
				break;
					
			}
		}
			
		// Your code ends here
	}

	/* Private constants */
	private static final int MAX_BOTTLES = 4;

}
