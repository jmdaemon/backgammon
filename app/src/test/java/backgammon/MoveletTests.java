package backgammon;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

class MoveletTests {

  @Test
  public void canConstructMoveletsForMixed() {
    List<Integer> dice = Arrays.asList(3, 5);
    Move m = new Move(2, 10, 1, dice, false);
    List<Movelet> result = m.getMovelets();
    List<Movelet> expected = Arrays.asList(
        new Movelet(2, 5, 3),
        new Movelet(5, 10, 5));
    backgammon.Utility.checkResult(expected, result, "Should create movelets for mixed moves");
  }

  @Test
  public void canConstructMoveletsForDoubles() {
    List<Integer> dice = Arrays.asList(2, 2, 2, 2);
    Move m = new Move(2, 10, 1, dice, true);
    List<Movelet> result = m.getMovelets();
    List<Movelet> expected = Arrays.asList(
        new Movelet(2, 4, 2),
        new Movelet(4, 6, 2),
        new Movelet(6, 8, 2),
        new Movelet(8, 10, 2));
    backgammon.Utility.checkResult(expected, result, "Should create movelets for doubles");
  }
}
