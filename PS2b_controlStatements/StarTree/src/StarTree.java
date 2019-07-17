/*File: StarTree.java*/

import acm.program.ConsoleProgram;

public class StarTree extends ConsoleProgram{
	public void run() {
		//TODO you should fill this in
		int height = readInt("Enter the height of the tree: ");
		for(int i = 0; i < height; i++){
			for(int j = 0; j < 2 * height -1; j ++){
				if(j == height - 1 + i ||j == height - 1 - i){
					print("*");
				} else {
					print(" ");
				}
			}
			println();
			
			
		}
	}
}
