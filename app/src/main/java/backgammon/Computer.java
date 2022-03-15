package backgammon;

import java.util.List;
import java.util.Random;

public class Computer extends Player{

  /**
   * randomly selects an int as the index of a move in moveList
   *
   * @return random int to be the index for selected move in moveList
   */
  @Override
  public int selectMove() {
    Random rnd = new Random();
    return rnd.nextInt(getMoveList().size());
  }
}

