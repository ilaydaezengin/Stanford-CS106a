import acm.program.*;

public class RightAlignedStars extends ConsoleProgram{
	public void run(){
		int height = readInt("Enter the level height: ");
		for(int i = 0; i < height; i ++){
			for(int j = 0; j < height; j ++){
				if((j + i) < height - 1){
					print(" ");
				} else {
					print("*");
				}
			}
			println();
			
		}
	}
}
