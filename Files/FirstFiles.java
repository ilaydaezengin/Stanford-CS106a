/*
 * File: 
 * ===============================================================
 * A program to open and print a file
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class FirstFiles extends ConsoleProgram {	
	public void run() {
		try {
			Scanner sc = new Scanner(new File("holdup.txt"));
			while(sc.hasNext()) {
				String line = sc.nextLine();
				println(line);
			}
			sc.close();
		} catch(IOException e) {
			println("Opps the file didn't open");
		}
	}
}
