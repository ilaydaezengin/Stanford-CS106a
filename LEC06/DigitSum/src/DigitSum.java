import acm.program.*;

public class DigitSum extends ConsoleProgram{
	public void run() {
		// Your code starts here
		println("This program sums the digits in an integer. ");
		int sum = 0;
		int num = readInt("Enter a positive integer: ");
		while (num > 0){
			int a = num % 10;
			sum += a;
			num = num / 10;
		}
		println("The sum of the digits is " + sum);
		// Your code ends here
	}

}
