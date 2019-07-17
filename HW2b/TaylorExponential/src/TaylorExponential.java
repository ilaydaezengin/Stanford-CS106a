import acm.program.*;

public class TaylorExponential extends ConsoleProgram {

	private static final int N = 30;

	private double factorial(int n) {
		if (n <= 2) {
			if (n == 0) {
				return 1;
			} else {
				return n;
			}
		} else {
			double result = 1;
			for (int i = 2; i <= n; i++) {
				result *= i;
			}

			return result;

		}
	}

	private double pow(double x, int n) {
		double result = Math.pow(x, n);
		// Your code starts here

		// Your code ends here
		return result;
	}

	public void run() {
		double x = readDouble("x: ");

		double result = 1.0;

		// Your code starts here
		for(int i = 1; i < 9; i++ ){
			result += pow(x,i) / factorial(i); 
		}
		// Your code ends here

		println("e^" + x + ": " + result);

	}

}
