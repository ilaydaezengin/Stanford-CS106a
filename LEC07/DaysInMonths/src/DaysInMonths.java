/*File: DaysInMonths.java*/

import acm.program.*;

public class DaysInMonths extends ConsoleProgram{
	public void run() {
		// Your code starts here
		println("This program shows the season of a month in a year.");
		int month = readInt("Enter numeric month (Jan=1): ");
		switch(month){
		case 1: case 2: case 12:
			println("winter");
			break;
		case 3: case 4: case 5:
			println("spring");
			break;
		case 6: case 7: case 8: 
			println("summer");
			break;
		case 9: case 10: case 11:
			println("autumn");
			break;
		default:
			println("Illegal month number");
			break;
			
			
		}
		// Your code ends here
	}
}
