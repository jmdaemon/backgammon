package backgammon;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Utility {

  // Displays the result and also checks the result
  public static <T> void checkResult(List<T> expected, List<T> result, String message) {
    System.out.println(result);
    assertEquals(expected, result, message);
  }

}
