/*
 * File: AverageGrades.java
 * ---------------------
 * This program asks for the midterm grades of students 
 * from the user until he/she enters a negative value then calculate the class average
 * 
 * Class: AverageGrades.java
 * Score: (Medium)
 * Prerequisites: While Loops, If-Else Statements, ACM Task Force Commands
 */

import acm.program.*;

public class AverageGrades extends ConsoleProgram {

	public void run() {
		println("This program computes average of exam grades ");
		int grade = readInt("Enter new grade (Negative value if finished): ");
		
		if(grade < 0){
			println("You have not entered any grade! ");
		}else {
		calculateAvg(grade);
		
		
		
	}
	}
	private void calculateAvg(int grade){
		double avg = 0,total = 0;
		int count = 1;
		while(grade >= 0){
			total += grade;
			avg = total / count;
			grade = readInt("Enter new grade (Negative value if finished): ");
			count++;
		}
		println("Average Grade of the class is " + avg);
	}


}
