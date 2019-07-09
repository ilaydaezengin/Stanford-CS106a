/*
 * File: BanishingWinter.java
 * -----------------------
 * Karel decorates barren tree trunks with flowers.
 * Trunks are of arbitrary height and placement.
 */

import stanford.karel.*;

public class BanishingWinter extends SuperKarel {

	public void run() {
		// Your code starts here
		while(true){
			if(beepersInBag()){
				if(frontIsBlocked()){
					turnLeft();
				} else if(rightIsBlocked()){
					move();
				} else {
					buildTree();
				}
			} else {
				while(frontIsClear()){
				move();
			}
			turnLeft();
			break;
		}
		}
		}
		
		// Your code ends here
	

	/** Helper methods. */

	// Your code starts here
	private void buildTree(){
		putBeeper();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		turnRight();
		move();
		putBeeper();
		move();
		
	}
	// Your code ends here
}