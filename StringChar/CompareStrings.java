/*
 * File: Acronym.java
 * -------------------
 * Example from the textbook section 8.4
 * This program prints the acronym for a text read from the user.
 */

import acm.program.ConsoleProgram;

public class CompareStrings extends ConsoleProgram{
	public void run(){

		String str1 = "String method tutorial";        
		String str2 = "compareTo method example";        
		String str3 = "String method tutorial";         
		int var1 = str1.compareTo( str2 );        
		println("str1 & str2 comparison: "+var1);        
		int var2 = str1.compareTo( str3 );        
		println("str1 & str3 comparison: "+var2);         
		int var3 = str2.compareTo("compareTo method example");        
		println("str2 & string argument comparison: "+var3);

	}

}
