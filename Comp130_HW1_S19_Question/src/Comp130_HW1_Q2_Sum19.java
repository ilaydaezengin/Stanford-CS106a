/* Student Name:Ilayda Ezgi Zengin,50302
 * File: UnitedNationsKarel.java
 * ----------------------------
 * The UnitedNationsKarel program builds houses at corners
 * marked by rubble.
 */

import stanford.karel.*;

public class Comp130_HW1_Q2_Sum19 extends SuperKarel {

	public void run() {
		// Your code starts here
		while(true){
			if(rightIsClear()){
				turnRight();
				if(frontIsClear()){
					if(cornerColorIs(RED)){
						break;
					} else {
						move();
					}
			}
			} else {
				
				if(frontIsClear()){
					if(cornerColorIs(RED)){
						break;
					} else {
						move();
					}
				} else {
					turnLeft();
				}
			}
		}
		
		//Your code ends here
	}

	//** Helper methods */
	

}

