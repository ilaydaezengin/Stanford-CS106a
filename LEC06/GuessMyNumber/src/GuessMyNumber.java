
import acm.program.*;

public class GuessMyNumber extends ConsoleProgram {

	public void run() {	
		// you guys can see terminal in lecture
		setFont("Courier-24");
		int answer = getHeight() % 100;
		println("I am thinking of a number between 0 and 99...");
		
		int guess = readInt("Enter a guess: ");
		
		// your code starts here
		while(guess != answer){
			if(guess < answer){
				println("Your guess is too low");
			} else{
				println("Your guess is too high");
			}
			println("");
			guess = readInt("Enter a new number: ");
		}
		// your code ends here
		println("Congrats!");

	}

}
