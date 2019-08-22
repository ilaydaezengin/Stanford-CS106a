import java.util.*;
import java.io.*;
import acm.program.*;
import acm.util.RandomGenerator;

public class RandomFileRead extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();
	private final String fileName = "BestPictures.txt";

	public void run() {
		// Your code starts here
		String[] files = new String[10000];
		
		int count = 0;
			try {
				Scanner sc = new Scanner(new File(fileName));
				int num = rgen.nextInt(0,10);
				while(sc.hasNext()){
					files[count++] = sc.nextLine();
				}
				sc.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				println("Cannot open file");
			}
			
			String[] result = new String[count];
			for(int i = 0; i < result.length; i ++){
				result[i] = files[i];
			}
			
			for(int i = 0; i < 10; i++){
				int num = rgen.nextInt(0, 10);
				println(i + ": " + result[i]);
			}
			
		}
		// Your code ends here
	}

