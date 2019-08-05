/*
 * File: IBAN.java
 * -----------------------
 * This program takes an IBAN and extracts information from it.
 */

import acm.program.*;

public class IBAN extends ConsoleProgram {

    public void run() {
	// Your code starts here
		while(true){
			String text = readLine("Enter an IBAN: ");
			if(text.length() != 26) break;
			String country = text.substring(0, 2);
			String control = text.substring(2, 4);
			String b_code = text.substring(4, 9);
			String b_account = text.substring(10);
			println("Country code: " + country);
			println("Control code: " + control);
			println("Bank code: " + b_code);
			println("Account Number: " + b_account);
    // Your code ends here
	}
    }
}
