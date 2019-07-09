/*
 * File: DoubleBeepers.java
 * ------------------------
 * Karel doubles the number of beepers on the corner directly
 * in front of him in the world.  He then returns to his
 * original position/orientation.
 */

import stanford.karel.SuperKarel;

public class DoubleBeepers extends SuperKarel {

	public void run() {
		move();
		// Your code starts here
		while(beepersPresent()){
			doubleToNextCorner();
		}
		// Your code ends here
		carryPileBack();
		turnAround();
		while(frontIsClear()){
			move();
		}
		turnAround();
	}

	/** Helper methods */

	// Your code starts here
	private void doubleToNextCorner(){
		pickBeeper();
		move();
		putBeeper();
		putBeeper();
		doMoonWalk();
	}
	// Your code ends here
	private void doMoonWalk(){
		turnAround();
		move();
		turnAround();
	}
	private void carryPileBack(){
		move();
		while(beepersPresent()){
			moveOneBeeperBack();
		}
		}

	private void moveOneBeeperBack() {
		pickBeeper();
		turnAround();
		move();
		putBeeper();
		turnAround();
		move();
	}
	}
