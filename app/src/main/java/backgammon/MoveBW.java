package backgammon;

import java.util.ArrayList;
import java.util.List;

public class MoveBW {

  private final int from;
  private final int to;
  private final List<Movelet> movelets = new ArrayList<>();


  public MoveBW(int from, int to, int dir, List<Integer> dice, boolean isDoubles) {
    this.from = from;

    to = Math.min(to, 25);
    if (to < 0)
      to = 0;

    this.to = to;

    int die = dice.get(0);

    for (int i = 0; i < dice.size() && isDoubles; i++)
      movelets.add(new Movelet(from + dir * die * i, from + dir * die * (i + 1), die ));

    if (!isDoubles) {
      movelets.add(new Movelet(from, from + dir * die, die ));
      if (dice.size() == 2)
        movelets.add(new Movelet(from + dir * die, from + dir * (die + dice.get(1)), dice.get(1)));
    }
  }


  public int getFrom() {
    return from;
  }


  public int getTo() {
    return to;
  }

  //Will need this to remove the dice from the list of dice in the game loop
  public List<Integer> getDice() {
    List<Integer> usedDice = new ArrayList<>();
    for (Movelet movelet : movelets)
      usedDice.add(movelet.getDie());
    return usedDice;
  }


  public List<Movelet> getMovelets() {
    return movelets;
  }


  public int getNumOfMovelets() {
    return movelets.size();
  }


}

