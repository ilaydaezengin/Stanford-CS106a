import java.io.*;
import java.util.Scanner;

import acm.program.*;

public class LongestLine extends  ConsoleProgram{
	public void run(){
		// Your code starts here
		try {
			int maxLength = 0;
			Scanner sc = new Scanner(new File("file.txt"));
			while(sc.hasNext()) {
				String line = sc.nextLine();
				maxLength = Math.max(maxLength, line.length());
			}
			// Your code ends here
			println("Longest line has length of: " + maxLength);
		} catch (IOException e) {
			println("provide a different file name");
		}
	}
}


