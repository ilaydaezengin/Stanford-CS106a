/* Student Name:Ilayda Ezgi Zengin,50302
 * File: Karel the Calculator
 * ---------------------
 * Karel can start anywhere west of a mountain of stairs
 * facing East. 
 * 
 * Karel collects beepers on the left and right side of the mountain 
 * of steps and drops all of them at the top of the stairs.
 * Karel randomly colors into RED or YELLOW
 * If color is RED, Karel adds the beepers at
 * left and right side of the mountain and put the result at 
 * north of the colored corner.
 * If color is YELLOW, Karel subtracts the beepers at
 * left and right side of the mountain and put the result at 
 * north of the colored corner.
 */

import stanford.karel.SuperKarel;

public class Comp130_HW1_Q1_Sum19 extends SuperKarel {
	public void run() {
		//Q1_part1
		while(!facingEast()){
			turnLeft();
			}
		while(frontIsClear()){
			move();
		}
		climb();
		//After collecting all beepers on the
		//way up,, Karel puts collected beepers
		//top of the stairs on the lefthand side
		while(beepersInBag()){
			putBeeper();
		}
		//Q1_part1 ends
		//Q1_part2
		while(rightIsBlocked()){
			move();
		}
		goDown();
		turnAround();
		move();
		climbOppositely();
		
		while(beepersInBag()){
			putBeeper();
		}
		//Q1_part2 ends
		move();
		turnAround();
		
		//Q1_part3
		if(random()) {
			doSubtraction();
		} else {
			doAddition();
		}
		//Q1_part3 ends
	}
	/** Helper methods */
	
	
	private void doSubtraction() {
		//after painting the middle corner to Yellow
		// Karel picks beepers from left-hand side 
		// as the number of beepers on the right-hand side
		//remaining beepers on the left is the result of substraction
		// so she picks remaining beepers on the left-hand side and 
		//put them to the north
		//after this process she goes to the desired position
		paintCorner(YELLOW);
		move();
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			move();
			pickBeeper();	
			turnAround();
			move();
			move();
		}
		
		turnAround();
		move();
		move();
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			turnLeft();
			move();
			putBeeper();
			turnAround();
			move();
			turnRight();
			move();
		}
		turnAround();
		move();
	}
	
	private void doAddition() {
		//after painting the corner to Red,
		//Karel picks all beepers on left and right hand side
		//keeps them in her bag then put all of them to the
		//North, at the end she comes to the desired position.
		paintCorner(RED);
		move();
		while(beepersPresent()){
		pickBeeper();
		}
		turnAround();
		move();
		move();
		while(beepersPresent()){
			pickBeeper();
			}
		turnAround();
		move();
		turnLeft();
		move();
		while(beepersInBag()){
			putBeeper();
		}
		turnAround();
		move();
		turnLeft();
		//Your code ends here
	}

	/**Addition Helper methods */
	//This method helps Karel to climb up she
		//picks beepers if they exist on the way up.
		private void climb(){
			while(frontIsBlocked()){
				while(beepersPresent()){
					pickBeeper();
				}
				turnLeft();
				move();
				turnRight();
				move();
			}
		}
		//Karel climbs the mountain when 
		//she is upside down
		private void climbOppositely(){
			while(frontIsBlocked()){
				turnRight();
				move();
				turnLeft();
				move();
				}
		}
		
		//This method helps Karel to go down and pick
		//beepers on the way
		private void goDown(){
				while(rightIsClear()){
				turnRight();
				move();
					while(beepersPresent()){
						pickBeeper();
					}
				turnLeft();
				move();
				}
		}
}

