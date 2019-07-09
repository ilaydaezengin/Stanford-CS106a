/*
 * File: MazeSolving.java
 * ---------------------------
 * This program extends Karel so that it can solve a maze
 * using the right-hand rule.
 */

import stanford.karel.SuperKarel;

public class MazeSolving extends SuperKarel {

	public void run() {
		// Your code starts here
		while(true){
			while(rightIsBlocked() && frontIsClear() && noBeepersPresent()){
				move();
			}
			if (beepersPresent()){
				break;
			}
			else if(rightIsClear()){
				turnRight();
				move();
			
			}
			else if(frontIsBlocked()){
				turnLeft();
				
			}
		}
		// Your code ends here
	}
}
