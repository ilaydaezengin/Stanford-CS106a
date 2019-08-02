
import acm.program.ConsoleProgram;

public class ToHexDigitSoln extends ConsoleProgram{
	public void run(){
		int digit=readInt("Input a hex-digit value:");
		// your code starts here
		
		
		while(digit<16){
			//convert to hex
			char a = toHex(digit);
			println("Here is the hex digit:"+ a);
			println("lets convert back again");
			toDigit(a);
			
			digit=readInt("Input a hex-digit value:");
			
		}

		// your code ends here
		println("End of program");
	}
	private char toHex(int digit){
		if(digit>=0 && digit<=9){
			return (char)('0'+digit);
		}else if(digit>9 && digit<16){
			return (char)('A'+digit-10);
		}else{
			return '?';
		}
	}
	private void toDigit(char a){
		int digitA = (int) a;
		if(a>='0' && a<='9'){
			int num = digitA- (int)'0';
			println(num);
		}else if(a>='A' && a<='F'){
			println((digitA-'A') +10);
		}else{
			println('?');
		}
	}
}
