package backgammon;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class MoveletTests {
  @Test
  public void canConstructMoveletsForNonDoubles() {
    List<Integer> dice = new ArrayList<>(Arrays.asList(3, 5));
    Move m = new Move(2, 10, 1, dice, false);
    List<Movelet> result = m.getMovelets();
    List<Movelet> expected = new ArrayList<>();
    expected.add(new Movelet(2, 5, 3));
    expected.add(new Movelet(5, 10, 5));
    //You'll need to add your checkResult thing
  }

  @Test
  public void canConstructMoveletsForDoubles() {
    List<Integer> dice = new ArrayList<>(Arrays.asList(2, 2, 2, 2));
    Move m = new Move(2, 10, 1, dice, true);
    List<Movelet> result = m.getMovelets();
    List<Movelet> expected = new ArrayList<>();
    expected.add(new Movelet(2, 4, 2));
    expected.add(new Movelet(4, 6, 2));
    expected.add(new Movelet(6, 8, 2));
    expected.add(new Movelet(8, 10, 2));
    //You'll need to add your checkResult thing x2
  }
}
