/*
 * File: FibonacciKarel.java
 * ---------------------
 * Karel starts at (2, 1) facing East and puts 
 * a number of beepers while moving along a street.
 * The number is determined by Fibonacci sequence.
 */

import stanford.karel.SuperKarel;

public class FibonacciKarel extends SuperKarel {

	public void run() {
		// Your code starts here
		while(frontIsClear()){
			while(beepersPresent()){
				carryBeepertoNorth();
				goEast();
				putBeeper();
				goWest();
			}
			goWest();
			
			while(beepersPresent()){
				carryBeepertoNorth();
				goEast();
				goEast();
				putBeeper();
				goWest();
				goWest();
			}
			carryBeeperstoSouth();
			goEast();
			carryBeeperstoSouth();
			goEast();
			
		}
			
		
			
		}
		
		// Your code ends here

	private void carryBeeperstoSouth() {
		// TODO Auto-generated method stub
		goNorth();
		while(beepersPresent()){
			pickBeeper();
			goSouth();
			putBeeper();
			goNorth();
		}
		goSouth();
	}

	/** Helper methods */

	// Your code starts here
	private void carryBeepertoNorth(){
		pickBeeper();
		goNorth();
		putBeeper();
		goSouth();
		
		
	}
	// Your code ends here

	private void goSouth() {
		// TODO Auto-generated method stub
		faceSouth();
		move();
	}

	private void goNorth() {
		// TODO Auto-generated method stub
		faceNorth();
		move();
		}
	
	private void goWest() {
		// TODO Auto-generated method stub
		faceWest();
		move();
		}
	private void goEast() {
		// TODO Auto-generated method stub
		faceEast();
		move();
		}

	private void faceNorth() {
		// TODO Auto-generated method stub
		while(notFacingNorth()){
			turnLeft();
		}
	}
		private void faceEast() {
			// TODO Auto-generated method stub
			while(notFacingEast()){
				turnLeft();
			}
		}
			private void faceWest() {
				// TODO Auto-generated method stub
				while(notFacingWest()){
					turnLeft();
				}
	}
			private void faceSouth() {
				// TODO Auto-generated method stub
				while(notFacingSouth()){
					turnLeft();
				}
			}
}


