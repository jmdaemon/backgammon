package backgammon;
import java.util.List;
import java.util.Random;

public class Computer extends Player{

  @Override
  public int selectMove() {
    Random rnd = new Random();
    return rnd.nextInt(getMoveList().size());
  }
}

