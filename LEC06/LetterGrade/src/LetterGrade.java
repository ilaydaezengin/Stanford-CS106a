/*
 * File: LetterGrade.java
 * -----------------------
 * This program gets a grade score between 0 and 100, and prints the letter grade.
 * You should use the limits 90=A, 80=B, 70=C, 60=D.
 */

import acm.program.*;

public class LetterGrade extends ConsoleProgram {
	public void run() {
		// Your code starts here
		println("This program decides your letter grade. ");
		int grade = readInt("Enter number grade: ");
		if(grade > 90){
			println("Your grade is A. ");
		}
		else if( grade > 75){
			println("Your grade is B. ");
		}
		else if( grade > 60){
		println("Your grade is C. ");
		}
		else if( grade > 45){
			println("Your grade is D. ");
			}
		else {
			println("Your grade is F. ");
			}
		}
        // Your code ends here
	}


