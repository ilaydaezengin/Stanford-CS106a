import acm.program.*;

import java.io.*;
import java.util.*;

public class SpellCheck extends ConsoleProgram {

    private final String dictionaryFile = "words";
    private HashMap<String,Boolean> dictionary;

    public void run() {
	println("Reading the dictionary file " + dictionaryFile);
	readDictionary();
	println("Read " + dictionary.size() + " words from the dictionary file.");
	while(true) {
	    String line = readLine("Please enter text: ");
	    if (line.equals("")) break;
	    spellCheck(line);
	}
	println("Bye.");
    }

    private void readDictionary() {
	dictionary = new HashMap<String, Boolean>();
	// put words from the dictionaryFile into the dictionary HashMap.
	// remember to surround file I/O with try and catch.

	// Your code starts here
	try {
		Scanner sc = new Scanner(new File(dictionaryFile));
		while(sc.hasNext()){
			dictionary.put(sc.nextLine(), true);
		}
		sc.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// Your code end here
    }

    private void spellCheck(String line) {
	StringTokenizer tokenizer = new StringTokenizer(line);
	// check each word and alert the user if it is not in the dictionary.

	// Your code starts here
	while(tokenizer.hasMoreTokens()){
		String token = tokenizer.nextToken();
		if(dictionary.get(token) == null){
			println(token + " is mispelled.");
		} else {
    		println(token + " is spelled correctly");
    }
	}
	// Your code ends here
    }
}
