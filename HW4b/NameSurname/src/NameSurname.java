/*
 * File: NameSurname.java
 * ---------------------
 * This class takes name and surname and fixes it.
 */

import acm.program.*;

/**
 * This class takes name and surname and fixes it.
 */

public class NameSurname extends ConsoleProgram {

	/** Runs the program */
	public void run() {
		// Your code starts here
		while(true){
			String str = readLine("Enter name and surname: ");
			if(str.length() == 0 || !str.contains(" ")){
				println("Not a valid format.");
				break;
			}
			if(!Character.isUpperCase(str.charAt(0))){
				str = str.substring(0,1).toUpperCase() + str.substring(1);
			}
			for(int i = 1; i < str.length(); i++){
				if(str.charAt(i) != ' ') {
					str = str.substring(0,1)+ str.substring(1).toLowerCase();
				}
			}
			int index = str.indexOf(" ");
			str = str.substring(0,index+1) + Character.toUpperCase(str.charAt(index + 1)) + str.substring(index+2);
			println(str);
		}
		
		// Your code ends here
	}
}

