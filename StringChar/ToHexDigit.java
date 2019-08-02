
import acm.program.ConsoleProgram;

public class ToHexDigit extends ConsoleProgram{
	public void run(){
		int digit=readInt("Input a hex-digit value:");
		// your code starts here
		while (digit < 16) {
			char c = toHex (digit);
			println("here is the hex digit : " + c);
			println("convert back again" );
			toDigit(c);
			digit=readInt("Input a hex-digit value:");
			
		}
		// your code ends here
		
		
		println("End of program");
	}
	private char toHex(int digit){
		if(digit >= 0 && digit <= 9){
			return (char) ('0' + digit);
		}else if(digit>9 && digit<16){
			return (char)('A'+digit-10);
		}else{
			return '?';
		}
	}
	private void toDigit(char a){
		int int_a = (int) a;
		if(a >= '0' && a <= '9'){
			println(int_a - (int) '0');
		} else if (a >= 'A' && a <= 'F'){
			println(int_a - (int) 'A' + 10);
		} else {
			println('?');
			}
	}
}
