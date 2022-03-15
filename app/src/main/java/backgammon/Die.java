package backgammon;

import java.util.Arrays;
import java.util.Random;

public class Die {
	
	
	private boolean dieDouble = false;

	//only stores 2 die
	private int[] die = new int[2];
	
	//assuming we set it so that the HUMAN player calls roll 
	public void roll() {
		Random rand = new Random();
		die[0] = rand.nextInt(6)+1 ;
		die[1] = rand.nextInt(6)+1 ;
		
		if (die[1] == (die[0]) ) {
			dieDouble = true;
		}
	}
	

	//returns the die array
	public int[] getRoll() {
		return die;
		
	}
	
	public int getFirstDie() {
		return die[0];
	}

	public int getSecondDie() {
		return die[1];
	}
	
	public boolean isDoubles() {
		return dieDouble;
	}
	

	
	//Just to test 
	public static void main(String[] args) {
		Die x = new Die();
		x.roll();
		System.out.println(x.getFirstDie());
		System.out.println(x.getSecondDie());
		System.out.println(Arrays.toString(x.getRoll()));
		System.out.println(x.isDoubles());
		
	}
	


}
