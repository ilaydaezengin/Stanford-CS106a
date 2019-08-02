
import acm.program.ConsoleProgram;

public class StringIntValue extends ConsoleProgram{

	public void run(){
	
		println(0); // print 0
		println("0");  //print 0
		println((char) 0); // print ?
		println((char) '0');  //print 0
		println((int) '0'); // print 48
		println((int) 'A'); // print 65
		println((int) 0); // print 0
		
		println("____String operation___");
		println((char)(0) +1); // print 1
		println((char)0 +55); // print 55
		println((char) (0+1)); // print ?
		println((char) (60+5)); // print ?
		println((char) ('A'+1)); // print b or 66
		println(0+1); // print 1
		println('A'+1); // print 66
		println((int)'A'+1); //print 66
		println((int)0+1); // print 1
		
		println("End of program");
	}
	
}
