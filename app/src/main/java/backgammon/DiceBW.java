package backgammon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceBW {

  private List<Integer> dice = new ArrayList<>();
  private boolean isDoubles;


  public DiceBW() {
    roll();
  }


  public void roll() {
    dice.clear();

    Random rand = new Random();
    dice.add(rand.nextInt(6) + 1);
    dice.add(rand.nextInt(6) + 1);
    isDoubles = false;

    if (dice.get(0).equals(dice.get(1))) {
      dice.add(dice.get(0));
      dice.add(dice.get(0));
      isDoubles = true;
    }
  }


  public List<Integer> getDice() {
    return dice;
  }


  public boolean isDoubles() {
    return isDoubles;
  }


  public void remove(List<Integer> usedDice) {
    for (Integer die : usedDice) dice.remove(die);
  }

}
