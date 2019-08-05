import acm.program.*;

public class Question1 extends ConsoleProgram {

	public void run() {
		// Your code starts here
		while(true){
			String s1 = readLine("s1> ");
			if(s1.contentEquals("exit")){
				println("Bye.");
				break;
			}
			String s2 = readLine("s2> ");
			
			isRotation(s1,s2);
		}
		// Your code ends here
	}
	// Your code starts here
	private void isRotation(String s1, String s2){
		String s = s1 + s1;
		println(s1);
		println(s2);
		if(s.contains(s2)){
				println("true");
		} else {
			println("false");
		}
		
		
	}
	// Your code ends here
}

