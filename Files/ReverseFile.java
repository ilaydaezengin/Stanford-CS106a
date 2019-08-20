/*
 * File: ReverseFile.java
 * ----------------------
 * This program reverses the lines in a file by reading them into a
 * String array, and then printing the lines of the array in reverse order.
 */
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;


/** This program reverses the lines in a file */
public class ReverseFile extends ConsoleProgram {

	public void run() {	
		println("This program reverses the lines in a file.");
		ArrayList<String> result = readLineArray2();
		for (int i =result.size()-1; i>=0; i--) {
			println(result.get(i));
		}
	}

	/**
	 * Reads all available lines from the specified reader and returns an array
	 * containing those lines.  This method closes the reader at the end of the file.
	 */
	private String[] readLineArray() {
		String[] result = new String[1000];
		String[] returnArray;
		int count =0;
		// Your code starts here
		try {
			Scanner input = new Scanner (new File("reverse.txt"));
			while (input.hasNext()) {
				String line = input.nextLine();
				result[count] = line;
				count++;
			}
		}catch (IOException e) {
			println("sorry cannot open the file");
		}
		returnArray = new String[count];
		for (int i= 0; i< count; i++) {
			returnArray[i]=result[i];
		}
		// Your code ends here
		return returnArray;
	}

	private ArrayList<String> readLineArray2() {
		
		ArrayList<String> result = new ArrayList<String>();
		
		// Your code starts here
		try {
			Scanner input = new Scanner (new File("reverse.txt"));
			while (input.hasNext()) {
				String line = input.nextLine();
				result.add(line);
			}
		}catch (IOException e) {
			println("sorry cannot open the file");
		}
		
		// Your code ends here
		return result;
	}
}
