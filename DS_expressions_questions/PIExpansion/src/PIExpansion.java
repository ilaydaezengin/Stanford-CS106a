import acm.program.*;

public class PIExpansion extends ConsoleProgram {

	public void run() {
		int nterm = readInt("Enter the number of desired terms: ");

		// Your code starts here
		double pi = 3.0;
		for (int i = 0; i < nterm; i++){
			println("Pi is " + pi);
			if(i%2 == 0){
				pi += ( 4.0 / ((2*i+2) * (2*i+3) * (2*i+4)));
			} else {
				pi -= ( 4.0 / ((2*i+2) * (2*i+3) * (2*i+4)));
			}
		}
		// Your code ends here
	}
}
