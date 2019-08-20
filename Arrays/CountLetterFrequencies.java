/*
 * File: CountLetterFrequencies.java
 * ---------------------------------
 * This program counts the frequency of letters in user-entered text.
 */

import org.omg.CORBA.FREE_MEM;

import acm.program.*;

/**
 * This program creates a table of the letter frequencies in a 
 * paragraph of input text terminated by a blank line.
 */
public class CountLetterFrequencies extends ConsoleProgram {


	public void run() {
		println("This program counts letter frequencies.");
		int [] freqTable = initFrequencyTable();
		while(true){
		// make a frequency histogram which is initially empty
		
		String line = readLine("Enter a line: ");
		if(line.length() == 0) break;
		
		// make this histogram of characters in the string
		countLetterFrequencies(freqTable,line);
		
		// print out the histogram
		printFrequencyTable(freqTable);
	}
	}
	
	/* Counts the letter frequencies in a line of text */
	private void countLetterFrequencies(int[] freqTable, String line) {
		// TODO: this is your job.
		for(int i = 0; i < line.length(); i++){
			char ch = line.charAt(i);
			if(Character.isLetter(ch)){
				int index = Character.toUpperCase(ch) - 'A';
				freqTable[index]++;
			}
		}
	}

	/* Initializes the frequency table to contain zeros */
	private int[] initFrequencyTable() {
		// TODO
		int[] freqTable = new int[26];
		for(int i = 0; i < freqTable.length; i++){
			freqTable[i] = 0;
		}
		return freqTable;
	}

	/* Displays the frequency table */
	private void printFrequencyTable(int[] table) {
		// TODO
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			int index = ch - 'A';
			println(ch + ": " + table[index]);
		}
	}


}
