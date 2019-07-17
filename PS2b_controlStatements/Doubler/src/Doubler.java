/*
 * File: Doubler.java
 * -------------------------------------
 * Take an integer input from the user and ask twice of the 
 * answer every step until user gives wrong answer
 * 
 * Class: Doubler
 * Difficulty: (Medium)
 * Prerequisites: While Loops, ConsoleProgram (readInt, println)
 */

import acm.program.*;

public class Doubler extends ConsoleProgram {

	//Main System Function
	public void run() {
		// Your code starts here
		int num = readInt("Enter an integer to start doubler game: ");
		int twiceNum = readInt("Twice of " + num + "?: ");
		while(true){
		if(twiceNum == 2 * num){
			int num2 = readInt("True! Twice of " + twiceNum + "?: ");
			num = twiceNum;
			twiceNum = num2;	
		
		} else {
			println("Wrong Answer!");
			break;
		}
		// Your code ends here
	}
	}
}

