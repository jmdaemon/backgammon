/**
 * This file is part of a solution to
 * 	CPSC 101 Backgammon Project Winter 2022
 *
 * Computer class extended from Player to be used in Backgammon game
 *
 * @author Gabriel Atwood
 * Student Number: 230150434
 * @version 1
 */

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

