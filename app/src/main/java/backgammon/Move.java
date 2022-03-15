package backgammon;

import java.util.ArrayList;
import java.util.List;

public class Move {

  private final int from;
  private final int to;

  private List<Movelet> movelets = new ArrayList<>();

  public Move(int from, int to, int dir, List<Integer> dice, boolean isDoubles) {
    this.from = from;

    to = Math.min(to, 25);
    if (to < 0)
      to = 0;

    this.to = to;
    int die = dice.get(0);

    // Enumerate all the possible move combinations for doubles
    if (isDoubles) {
      for (int i = 0; i < dice.size(); i++) {
        int src = from + dir * die * i;
        int dest = from + dir * die * (i + 1);
        movelets.add(new Movelet(src, dest, die));
      }
    }

    // Enumerate all the possible move combinations for mixed
    if (!isDoubles) {
      movelets.add(new Movelet(from, from + dir * die, die ));
      if (dice.size() == 2)
        movelets.add(new Movelet(from + dir * die, from + dir * (die + dice.get(1)), dice.get(1)));
    }
  }

  //Will need this to remove the dice from the list of dice in the game loop
  public List<Integer> getDice(List<Integer> dice) {
    for (Movelet movelet : movelets)
      dice.add(movelet.getDie());
    return dice;
  }

  public List<Movelet> getMovelets() {
    return movelets;
  }

  public int getNumOfMovelets() {
    return movelets.size();
  }

  //This and the one in movelet are just there to see which moves are being found
  @Override
  public String toString() {
    String moveString = String.valueOf(from);

    for (Movelet movelet : movelets)
      moveString += movelet;

    return moveString;
  }
}
