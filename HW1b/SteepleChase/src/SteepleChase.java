/*
 * File: SteepleChase.java
 * -----------------------
 * Karel runs a steeple chase that is 9 avenues long.
 * Hurdles are of arbitrary height and placement.
 */

import stanford.karel.*;

public class SteepleChase extends SuperKarel {
	/*
	 * To run a race that is 9 avenues long, we need to move
	 * forward or jump hurdles 8 times.
	 */
	public void run() {
		// Your code starts here
		for(int i = 0; i < 8; i ++){
			if(frontIsClear()){
				move();
			} else {
				jump();
					}
			
		// Your code ends here
	}

	/** Helper methods */
	}
	// Your code starts here
	//This method does everything without any other helper methods
	private void jump2(){
		turnLeft();
		while(true){
			while(frontIsClear() && rightIsBlocked()){
				move();
			}
			if(frontIsBlocked() && rightIsBlocked()){
				turnLeft();
				break;
			}
			turnRight();
			move();
			turnRight();
			move();
			
			
			}
		}
	
	//more robust jump,has helper methods and easier to understand
	private void jump(){
		climb();
		move();
		goDown();
	}
	private void climb(){
		turnLeft();
		while(rightIsBlocked()){
			move();
		}
		turnRight();
	}
	
	private void goDown(){
		turnRight();
		while(frontIsClear()){
			move();
		}
		turnLeft();
	}
	}
	
	// Your code ends here
