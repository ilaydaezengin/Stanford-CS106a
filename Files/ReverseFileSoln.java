/*
 * File: ReverseFile.java
 * ----------------------
 * This program reverses the lines in a file by reading them into a
 * String array, and then printing the lines of the array in reverse order.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** This program reverses the lines in a file */
public class ReverseFileSoln extends ConsoleProgram {

	public void run() {	
		println("This program reverses the lines in a file.");
		
		String[] lines = readLineArray();
		for (int i = lines.length - 1; i >= 0; i--) {
			println(lines[i]);
		}
	}

	/**
	 * Reads all available lines from the specified reader and returns an array
	 * containing those lines.  This method closes the reader at the end of the file.
	 */
	private String[] readLineArray() {
		// Your code starts here
		
		String[] result;
		String[] lineTemp = new String[1000];
		ArrayList<String> list = new ArrayList<String>();
		int count = 0;
		try {
			Scanner sc = new Scanner(new File("reverse.txt"));
			
			while(sc.hasNext()) {
				String line = sc.nextLine();
				lineTemp[count] = line;
				count++;
			}
		} catch (Exception ex) {
			throw new ErrorException(ex);
		}
		
		result = new String[count];
		for (int i = 0; i < count; i++) {
			result[i] = lineTemp[i];
		}
		// Your code ends here
		return result;
	}

}
