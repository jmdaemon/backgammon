package backgammon;

import java.util.ArrayList;
import java.util.List;

public class Dice extends Die {

	private int[] dice;
	private boolean dieDouble;

	public int[] getRolls() {
		Die local = new Die();
		// had to initialize the array or else it spits out a nullPointerException
		dice = new int[2];
		dice[0] = local.getRoll();
		dice[1] = local.getRoll();
		dieDouble = false;
		if (dice[0] == dice[1]) {
			dieDouble = true;
		}
		return dice;
	}

	public int getFirstRoll() {
		return dice[0];
	}

	public int getSecondRoll() {
		return dice[1];
	}

	public boolean isDoubles() {
		return dieDouble;
	}

}

//Below is another way if we use ArrayList rather than array
//private List<Integer> dice2 = new ArrayList<>();
//
//public int[] getRolls2() {
//	Die local = new Die();
//
//	dice2.add(local.getRoll());
//	dice2.add(local.getRoll());
//	dieDouble = false;
//
//	if (dice2.get(0).equals(dice2.get(1))) {
//		dieDouble = true;
//	}
//	return dice;
//}