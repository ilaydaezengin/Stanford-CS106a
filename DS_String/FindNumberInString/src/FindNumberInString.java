import acm.program.ConsoleProgram;


public class FindNumberInString extends ConsoleProgram{
	public void run(){
		// Your code starts here
		int len = readInt("Specify the length of id number: ");
		while(true){
			String text = readLine("Input text where id will be searched: ");
			if(text.length() == 0) break;
			int val=0, numDigits=0;
			for(int ind=0;ind<text.length();ind++){
				char ch=text.charAt(ind);
				if(Character.isDigit(ch)){
					val=val*10+(ch-'0');
					numDigits++;
					if(numDigits==len){//check if read digits have length of len
						println("The following id-no is found:\t"+val);
						break;
					}
				}else{//either we have not arrived to a digit or we just finished reading digits
					if(numDigits==len){//check if read digits have length of len
						println("The following id-no is found:\t"+val);
						break;
					}else{
						val=0;numDigits=0;
					}

				}
			}
		}
		println("---END OF PROGRAM---");

			
			}
		// Your code ends here

	}

