package backgammon;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BackgammonTests {

  @Test
  public void canGenerateDoubles() {
    int[] dice = {6, 6, 6, 6};
    List<List<Integer>> result = Backgammon.genDoubles(dice);
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(6),
        Arrays.asList(6, 12),
        Arrays.asList(6, 12, 18),
        Arrays.asList(6, 12, 18, 24));
    System.out.println(result); // Always display the result
    assertEquals(expected, result, "Should generate double offsets");
  }

  @Test
  public void canGenerateMixed() {
    int[] dice = {5, 4};
    List<List<Integer>> result = Backgammon.genMixed(dice);
    List<List<Integer>> expected = Arrays.asList(
        Arrays.asList(5),
        Arrays.asList(4),
        Arrays.asList(5, 4),
        Arrays.asList(4, 5));
    assertEquals(expected, result, "Should generate mixed offsets");
  }
}
