/* STUDENT NAME: Ilayda Ezgi Zengin, 50302
 * File: ClearAllBeepersInLine.java
 * 
 * Karel clears all beepers on the way and goes back to her initial position.
 */

import stanford.karel.*;

public class ClearAllBeepersInLine extends Karel {

	public void run() {
		while(true){
		//Your code starts here
			while(beepersPresent()){
				pickBeeper();
			}
			if(frontIsClear() && noBeepersPresent()){
				move();
			}
			//when Karel reaches the right end of the line, it will turn
			//and go back to initial position
			else if(frontIsBlocked()){
				turnLeft();
				turnLeft();
				while(frontIsClear()){
					move();
				}
				turnLeft();
				turnLeft();
				break;
			}
			}
	}
}
		//Your code ends here
	
	//Your helper methods go here (if needed):
	//Your code starts here

	//Your code ends here
