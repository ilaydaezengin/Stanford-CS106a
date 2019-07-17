import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;
//Ilayda Ezgi Zengin, 50302

public class Comp130_HW2_Sum19 extends ConsoleProgram {
	// Instance variables for you to use
	int currentKUchefID = 1;
	int totalPointOfKUchef1 = 0;
	int totalPointOfKUchef2 = 0;
	int totalPointOfKUchef3 = 0;
	int totalPointOfKUchef4 = 0;
	private final int NUMCONTESTANTS = 4;
	static RandomGenerator rgen = new RandomGenerator();
	
	//Additional Variables and Constants You Might Need//
	// your code starts here
	int firstID, secondID, thirdID = 0;
	int firstPoint, secondPoint, thirdPoint = 0;
	// your code end here
	public void run() {
		// your code starts here
		int maxPoint = 0;
		for(int i = 1; i < 5; i++){
			
			currentKUchefID = i;
			println("NEW CONTESTANT:");
			double abilityPoint = askAbility();
			int knowPoint = askKnowledge();
			int dish = askSpecialDish();
			boolean hasBook = hasBook();
			int totalPoint = pointCalculator(abilityPoint, knowPoint, dish, hasBook);
			assignPoint(totalPoint,i);
			println("");
			println("KUchef# " + currentKUchefID + "has reached " + totalPoint + " points.");
			currentKUchefID ++ ;
			println("");
			println("-------------------------------");
		}
		comparator();
		// your code end here
		
	}

	// Methods you should implement///
	/**
	 * This method asks the knife and cooking skills of the chef. It calculated and returns
	 * the ability point of a chef.
	 * @return - ability points of the chef.
	 */
	private double askAbility(){
		double abilityPoint = 0;
		while(true){
		int kSkill = readInt("Knife skill of KUchef#-" + currentKUchefID + "(between 3-7): " );
		int cSkill = readInt("Cooking skill of KUchef#-" + currentKUchefID + "(between 4-15): " );
		if(3 <= kSkill && kSkill <= 7 && 4 <= cSkill && cSkill <= 15){
			abilityPoint = calculateAbility(kSkill,cSkill);
			break;
		}
		}
		return abilityPoint;
		
	}
	private double calculateAbility(int ks, int cs) {
		// your code starts here
		double AbilityPoint = Math.pow(((ks + cs) / 10) , ks - 1) + fibonacci(cs);
		// your code end here
		return AbilityPoint;
	}
	
	private int fibonacci(int num){
	    if (num <= 1){ 
	       return num; 
	    } else {
	    	return fibonacci(num-1) + fibonacci(num-2); 
	    } 
	}

	
	//////////////////////////////////////////////
	// Calculates knowledge
	/**
	 * This method asks the education year and number of cuisine of the chef. 
	 * It calculated and returns the knowledge points of a chef.
	 * @return - knowledge points of the chef.
	 */
	private int askKnowledge() {
		int knowPoint = 0;
		while(true){
		int years = readInt("Years of education of KUchef#-" + currentKUchefID + "(between 2-6): " );
		int cuis = readInt("Number of cuisibes of KUchef#-" + currentKUchefID + "(between 5-20): " );
		if(2 <= years && years <= 6 && 5 <= cuis && cuis <= 20){
			knowPoint = calculateKnowledge(years,cuis);
			break;
		}
		}
		return knowPoint;
		
	}
	
	private int calculateKnowledge(int e, int c) {
		// your code starts here
		int knowPoint = c * factorial(e);
		// your code end here
		return knowPoint;

	}

	private int factorial(int e) {
		if(e == 1){
			return 1;
		}else{
			 return e * factorial(e - 1);	
			}
	}

	/**
	 * This method asks number of special dishes and return number of special dishes
	 * @return - number of special dishes of  the chef.
	 */
	private int askSpecialDish() {
		// your code starts here
		int dishes = 0;
		while(true){
			dishes = readInt("Number of KUchef#-" + currentKUchefID + "'s specials (between 3-8): " );
			if(3 <= dishes && dishes <= 8 ){
				break;
			}
			}
		return dishes;
	}

	/**
	 * This method determines randomly whether the chef has a book or not.
	 * @return whether the chef has a book or not
	 */
	private boolean hasBook() {
		// your code starts here
		boolean hasBook = rgen.nextBoolean();
		return hasBook;
			
		// your code end here
	}

	/**
	 * This method calculates the total point of the chef.
	 * @param ability - ability point of the chef
	 * @param knowledge - knowledge point of the chef
	 * @param special - number of special dishes of the chef
	 * @param hasBook - whether the chef has a book or not
	 * @return Total points of the chef
	 */
	private int pointCalculator(double ability, int knowledge, int special, boolean hasBook) {
		// your code starts here
		if(hasBook){
			int totalPoint = (int) Math.round((Math.sqrt(ability * special) + (1.5 * knowledge)));
			return totalPoint;
		} else{
			int totalPoint = (int) Math.round((Math.sqrt(ability * special) + (1.2 * knowledge)));
			return totalPoint;
		}
		// your code end here
	}
	
	private int getPoints(int p) {
		switch(p){
		case 1: return totalPointOfKUchef1;
		case 2: return totalPointOfKUchef2;
		case 3:return totalPointOfKUchef3;
		default:return totalPointOfKUchef4;
	
		}
	}
	private void assignPoint(int p,int currentKUchefID){
		switch(currentKUchefID){
		case 1:
			totalPointOfKUchef1 = p;
			break;
		case 2:
			totalPointOfKUchef2 = p;
			break;
		case 3:
			totalPointOfKUchef3 = p;
			break;
		default:
			totalPointOfKUchef4 = p;
			break;
		}
	}
	
	private void comparator(){
		//finding the min and eliminating it
		int min = Math.min(Math.min(totalPointOfKUchef1, totalPointOfKUchef2),  Math.min(totalPointOfKUchef3, totalPointOfKUchef4));
		int fourthID =0;
		if(min == totalPointOfKUchef1){
			fourthID = 1;
			println("Then, KUchef 1 is eliminated.");
			println("");
		} else if (min == totalPointOfKUchef2){
			fourthID = 2;
			println("Then, KUchef 2 is eliminated.");
			println("");
		} else if(min == totalPointOfKUchef3){
			fourthID = 3;
			println("Then, KUchef 3 is eliminated.");
			println("");
		} else if(min == totalPointOfKUchef4){
			fourthID = 4;
			println("Then, KUchef 4 is eliminated.");
			println("");
		} 
		
		//finding max and second,third points,assigning IDs
		int max = Math.max(Math.max(totalPointOfKUchef1, totalPointOfKUchef2),  Math.max(totalPointOfKUchef3, totalPointOfKUchef4));
		 
		if(max == totalPointOfKUchef1){
			firstID = 1;
			firstPoint = max;
		} else if (max == totalPointOfKUchef2){
			firstID = 2;
			firstPoint = max;
		} else if(max == totalPointOfKUchef3){
			firstID = 3;
			firstPoint = max;
		} else if(max == totalPointOfKUchef4){
			firstID = 4;
			firstPoint = max;
		} 
		
		int temp = 0;
		for (int i=1; i<=4; i++){
			if(i != firstID && i != fourthID){
				if(getPoints(i) > secondPoint){
					secondPoint = getPoints(i);
					secondID = i;
				}
			}
		}
		
		for (int i = 1; i <= 4; i++){
			if(i != firstID && i != secondID && i != fourthID){
				thirdID = i;
				thirdPoint = getPoints(i);
			}
		}
		

		println("KUchef#" + firstID + " becomes #1 with " + firstPoint + " points.");
		println("KUchef#" + secondID + " becomes #2 with " + secondPoint + " points.");
		println("KUchef#" + thirdID + " becomes #3 with " + thirdPoint + " points.");
		println("");
		println("The KUisine Audition is now completed.");
		
	}

	
}