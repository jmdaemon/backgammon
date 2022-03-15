package backgammon;

import java.util.Arrays;
import java.util.Random;

public class Die {
	
	
	private boolean dieDouble;

	//only stores 2 die
	private int die;	

	

	//returns the die array
	public int getRoll() {
		Random rand = new Random();
		die = rand.nextInt(6)+1 ;
		return die;
		
	}
	


	


}
