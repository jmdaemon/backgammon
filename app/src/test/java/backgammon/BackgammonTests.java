package backgammon;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BackgammonTests {

  //public void display(List<List<Integer>> moves) {
    //for (List<Integer> move : moves)
  //}

  @Test
  public void canGenerateDoubles() {
    int[] dice = {6, 6, 6, 6};
    List<List<Integer>> result = Backgammon.genDoubles(dice);
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(6),
        Arrays.asList(6, 12),
        Arrays.asList(6, 12, 18),
        Arrays.asList(6, 12, 18, 24));
    System.out.println(result);
    assertEquals(expected, result, "Should generate double offsets");
    //assertNotNull(result, "Should generate doubles");
    //assertNotNull(null, "Should generate doubles");
  }
}
