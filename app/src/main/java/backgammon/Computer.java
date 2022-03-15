package backgammon;

import java.util.Random;

public class Computer extends Player {

  /**
   * Randomly selects a move in the moveList
   */
  @Override
  public int selectMove() {
    Random rnd = new Random();
    return rnd.nextInt(getMoveList().size());
  }
}
