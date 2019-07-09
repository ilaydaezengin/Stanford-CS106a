/* /*
 * File: EarthquakeRepairKarel.java
 * --------------------------
 * Karel repairs damage done in 
 * in the earthquake
 */
import stanford.karel.*;

public class EarthquakeRepair extends SuperKarel {

	public void run() {
		while(true){
			buildWall();
		// Your code starts here
			while(frontIsClear()){
			for(int i = 0; i < 4; i++){
				move();
			}
			buildWall();
		} 
			break;
		}
		// Your code ends here
	}
	

	/** Helper methods */

	// Your code starts here
	private void buildWall(){
		turnLeft();
		while(frontIsClear()){
			if(noBeepersPresent()){
				putBeeper();
			}
			move();
		}
		if(noBeepersPresent()){
			putBeeper();
		}
		turnAround();
		
		while(frontIsClear()){
			move();
		}
		turnLeft();
	// Your code ends here
}
}
