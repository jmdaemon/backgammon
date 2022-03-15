package backgammon;

public class Dice {

	private int[] dice;

	Dice() {
		dice = new int[2];
	}

	//public int[] getRolls() {
		//Die local = new Die();
		//dice[0] = local.getRoll();
		//dice[1] = local.getRoll();
		//dieDouble = false;
		//if (dice[0] == dice[1]) {
			//dieDouble = true;
		//}
		//return dice;
	//}

	// Getters
	public int getFirst() { return dice[0]; }
	public int getSecond() { return dice[1]; }
	public int[] getDice() { return dice; }

	public boolean isDoubles() {
		return (dice[0] == dice[1]) ? true : false;
	}

}

//Below is another way if we use ArrayList rather than array
//
//	private List<Integer> dice2 = new ArrayList<>();
//
//	public List<Integer> getRolls2() {
//	Die local = new Die();
//
//	dice2.add(local.getRoll());
//	dice2.add(local.getRoll());
//	dieDouble = false;
//
//	if (dice2.get(0).equals(dice2.get(1))) {
//		dieDouble = true;
//	}
//	return dice2;
//}
