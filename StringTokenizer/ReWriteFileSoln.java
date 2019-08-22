/*
 * File: ReWriteFile.java
 * ----------------------
 * This program reads the copyme.txt file which consist a group of sentences separated by '-'.
 * What you are asked to implement is to create a new file named 'output.txt' and write these '-'
 * separated sentences line by line.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class ReWriteFileSoln extends ConsoleProgram {

	public void run() {
		println("This program opens the 'copyme.txt' file and recognizes each sentence " +
				"and writes them line by line to the 'output.txt' file.");

	
		Scanner sc = null;
		PrintWriter wr = null;
		ArrayList<String> sentences = null;
		// Your code starts here
		try {
			sc = new Scanner(new File("copyme.txt"));
			
		} catch(IOException e) {
			println("Opps the file didn't open");
		}
		
		sentences = readFiles(sc);
		try {
			wr = new PrintWriter(new FileWriter("output.txt"));
			for (int i = 0; i < sentences.size(); i++) {
				wr.println(sentences.get(i).trim());
			}
			wr.close();
		} catch (IOException e) {
			println("Can't create the output file.");
		}
		// Your code ends here
	}

	/**
	 * sc is a Scanner for the input file
	 * return a string ArrayList containing the sentences read from the reader
	 */
	private ArrayList<String>  readFiles(Scanner sc) {
		ArrayList<String>  sentences = new ArrayList<String>();
		// Your code starts here
		StringTokenizer st = null;
			
		String line = sc.nextLine();
		println(line);
		st = new StringTokenizer(line, "-");
				
		while(st.hasMoreTokens()){
			sentences.add(st.nextToken());
		}
			sc.close();
	
		// Your code ends here
		return sentences;
	}
}
