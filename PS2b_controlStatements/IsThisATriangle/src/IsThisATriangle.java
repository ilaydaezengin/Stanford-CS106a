import acm.program.*;

public class IsThisATriangle extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("Provide the edges of triangle");
		int side1 = readInt("Side 1: ");
		int side2 = readInt("Side 2: ");
		int side3 = readInt("Side 3: ");
		if((side1 < side2 + side3) && (side2 < side1 + side3) && (side3 < side2 + side1)){
			println("A triangle with edges (" + side1 + "," + side2 + "," + side3 + ") can exist.");
		}
		else{
			println("A triangle with edges (" + side1 + "," + side2 + "," + side3 + ") can not exist.");

		}
        // Your code ends here
	}
}
