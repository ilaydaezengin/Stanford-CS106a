/*
 * File: StreetPainter.java
 * ---------------------
 * Karel starts at (1, 1) facing East and paints
 * all street blue.
 */

import stanford.karel.SuperKarel;

public class StreetPainter extends SuperKarel {

	public void run() {
		// Your code starts here
		while(true){
			paintCorner(BLUE);
			if(frontIsClear()){
			move();
		} else {
			break;
		}
		// Your code ends here
	}
	}
	}

