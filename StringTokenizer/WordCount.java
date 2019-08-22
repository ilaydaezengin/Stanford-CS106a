/*
 * File: WordCount.java
 * ----------------------------
 * Read input.txt and print each line preceded by its word count.
 */

import acm.program.*;
import java.io.*;
import java.util.*;

public class WordCount extends ConsoleProgram {

	private static final String fileName = "input.txt";

	public void run() {
		// Your code starts here
		Scanner sc = null;
		try {
			sc = new Scanner(new File(fileName));
			while(sc.hasNext()){
				String str = sc.nextLine();
				int num = countWords(str);
				println(num + " " + str);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Your code ends here
	}

	/** countWords(str) returns the number of words in the string str. */
	/* Hint: use StringTokenizer */
	private int countWords(String str) {
		int answer = 0;
		// Your code starts here
		StringTokenizer st = new StringTokenizer(str," ");
		while(st.hasMoreTokens()){
			st.nextToken();
			answer++;
		}
		// Your code ends here
		return answer;
	}
}

