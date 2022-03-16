package backgammon;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class ComputerBW extends Player {

  public ComputerBW(String name, Color color, int direction, int outPoint, int bar) {
    super(name, color, direction, outPoint, bar);
  }

  @Override
  public Move selectMove(List<Move> moveList) {
    Random rnd = new Random();
    return moveList.get(rnd.nextInt(moveList.size()));
  }
}
