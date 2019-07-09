/*
 * File: CleaningUp.java
 * -----------------------
 * Karel starts at (1, 1) facing East and cleans up any
 * beepers scattered throughout his world.
 */
import stanford.karel.*;

public class CleaningUp extends SuperKarel {

	/* Cleans up a field of beepers, one row at a time */ 
	public void run() {
		// Your code starts here
		cleanRow();
		while(leftIsClear()){
			orientToWest();
			cleanRow();
			if(rightIsClear()){
				orientToEast();
				cleanRow();
			} else{
				turnAround();
			}
		}
		
		// Your code ends here
	}

	/** Helper methods. */

	// Your code starts here
	private void cleanRow(){
		while(frontIsClear()){
			if(beepersPresent()){
				pickBeeper();
			}
			move();
		}
		if(beepersPresent()){
			pickBeeper();
		}
	}
	
	private void orientToWest(){
		turnLeft();
		move();
		turnLeft();
		}
	
	
	private void orientToEast(){
		turnRight();
		move();
		turnRight();
		}
	// Your code ends here
}