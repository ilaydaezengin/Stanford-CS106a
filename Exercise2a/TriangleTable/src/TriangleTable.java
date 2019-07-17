import acm.program.*;

public class TriangleTable extends ConsoleProgram {

	public void run() {
		// Your code starts here
		int sum = 1;
		String nums = "1";
		println(nums + " = " + sum);
		for(int i = 2; i <= MAX_VALUE; i ++){
			sum += i;
			nums += " + " + i;
			println(nums + " = " + sum);
		}
		// Your code ends here
	}

	/* Private constants */
	private static final int MAX_VALUE = 10;

}
