/*
 * File: MonthName.java
 * --------------------
 * This program tests the monthName method.
 */

import acm.program.*;

public class MonthName extends ConsoleProgram {

	public void run() {
		int month = readInt("Enter month : ");
		int day = readInt("Enter day : ");
		int year = readInt("Enter year : ");
		println(monthName(month) + " " + day + ", " + year);
	}

	/* Translates a numeric month into a string */
	private String monthName(int month) {
		String name = null;
		// Your code starts here
		switch(month){
		case 1: 
			name = "January";
			break;
		case 2: 
			name = "February";
			break;
		case 3: 
			name = "March";
			break;
		case 4: 
			name = "April";
			break;
		case 5: 
			name = "May";
			break;
		case 6: 
			name = "June";
			break;
		case 7: 
			name = "July";
			break;
		case 8: 
			name = "August";
			break;
		case 9: 
			name = "September";
			break;
		case 10: 
			name = "October";
			break;
		case 11: 
			name = "November";
			break;
		case 12: 
			name = "December";
			break;
		default:
			name = "invalid name!";
			break;
		}
		
		
		// Your code ends here
		return name;
	}

}
