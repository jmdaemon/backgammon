package backgammon;

public class Dice {

	private int[] dice;

	Dice() {
		dice = new int[2];
	}

	// Getters
	public int getFirst() { return dice[0]; }
	public int getSecond() { return dice[1]; }
	public int[] getDice() { return dice; }

	public boolean isDoubles() {
		return (dice[0] == dice[1]) ? true : false;
	}
}
