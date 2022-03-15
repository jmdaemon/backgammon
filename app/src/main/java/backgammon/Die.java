package backgammon;

import java.util.Random;

public class Die {

	private int die;

	public int getRoll() {
		Random rand = new Random();
		die = rand.nextInt(6) + 1;
		return die;
		
	}
}
