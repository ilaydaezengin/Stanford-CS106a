import acm.program.ConsoleProgram;


public class KeepMyBalance extends ConsoleProgram {
	public void run(){
		//Your code starts here
		//k500: number of workers receiving 500units/month
		//k100: number of workers receiving 100units/month
		//k5: number of workers receiving 5units/month
		
		for(int k500 = 1; k500 <= 100; k500 ++){
			for(int k100 = 1; k100 <= 100; k100 ++){
				for(int k5 = 1; k5 <= 100; k5 ++){
					int sum = k500 * 500 + k100 * 100 + k5 * 5;
					int numWorkers = k500 + k100 + k5;
					if(sum == 10000 && numWorkers == 100){
						println(k500+" workers receive 500 units/month");
						println(k100+" workers receive 100 units/month");
						println(k5+" workers receive 5 units/month");
						println("total number of workers: "+numWorkers);
	
					}
				}
			}
		}
		//Your code ends here
	}

}
