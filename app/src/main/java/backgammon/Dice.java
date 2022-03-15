package backgammon;

public class Dice extends Die {

	private int[] dice;
	private boolean dieDouble;

	public int[] getRolls() {
		Die local = new Die();
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
