/*
 * File: WorldPainter.java
 * ---------------------
 * Karel starts at (1, 1) facing East and paints
 * all world blue.
 */

import stanford.karel.SuperKarel;

public class WorldPainter extends SuperKarel {

	public void run() {
		// Your code starts here
			paintRow();
			while(leftIsClear()){
				orientToWest();
				paintRow();
				if (rightIsClear()){
					orientToEast();
					paintRow();
				}
			
		}
			turnAround();
			while(frontIsClear()){
				move();
			}
			turnAround();
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	 private void paintRow(){
		 while(frontIsClear()){
			 paintCorner(BLUE);
			 move();
		 }
		 	paintCorner(BLUE);
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

