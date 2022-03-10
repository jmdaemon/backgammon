package backgammon;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BackgammonTests {
  int barLocation;

  @BeforeEach
  public void setUp() {
    barLocation = 25; // Our player's piece is on the bar which is defined as being from 26-25
  }

  @Test
  public void canCalculateMoveMixed() {
    int[] dice = {4, 2};
    int[] board = {0,0, 0,0,-2,-2,0,0,  0,0,0,0,0,0,  0,1,1,0,0,0,   0,0,0,0,0,0};
    int pieceLocation = 11;
    List<String> result = Backgammon.calcMixed(board, pieceLocation, dice);
    List<String> expected = Arrays.asList("11-7", "11-7-5", "11-9", "11-9-5");
    System.out.println(result);
    assertEquals(expected, result, "Should return only valid legal moves to be played.");
  }

  @Test
  public void canCalculateMoveDoubles() {
    int[] dice = {5, 5};
    int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    List<String> result = Backgammon.calcDouble(board, barLocation, dice);
    List<String> expected = Arrays.asList(
        "25-20",
        "25-20-15",
        "25-20-15-10",
        "25-20-15-10-5");
    System.out.println(result);
    assertEquals(expected, result, "Should calculate all possible move combinations with doubles.");
  }

  @Test
  public void canCalculateBearOffMove() {
    int[] dice = {4, 3};
    int[] board = {-1,0, 0,0,0,0,0,0,    0,0,0,0,0,0,  0,0,0,0,0,0,   0,0,1,1,0,1};
    List<String> result = Backgammon.calcBearOff(board, dice);
    List<String> expected = Arrays.asList("4-0", "3-0");
    System.out.println(result);
    assertEquals(expected, result, "Should calculate a move to bear off");
  }

  @Test
  public void canCalculateBarMove() {
    int[] dice = {5, 3};
    int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    //List<String> result = Backgammon.calcMove(board, barLocation, dice);
    List<String> result = Backgammon.calcBarMove(board, barLocation, dice);
    List<String> expected = Arrays.asList("25-20");
    System.out.println(result);
    assertEquals(expected, result, "Should return only valid legal moves to be played.");
  }


  //@Test
  //public void canCalculateAllMoves() {
    //int[] dice = {4, 3};
    ////int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    //int[] board = {-1,0, 0,0,0,0,0,0,    0,0,0,0,0,0,  0,0,0,0,0,0,   0,0,1,1,0,1};
    //List<List<String>> result = Backgammon.calcAllMoves(board, dice);
    //List<List<String>> expected = Arrays.asList(
        //Arrays.asList("4-0,3-0"),
        //Arrays.asList("4-1,3-0"));
    //assertEquals(expected, result, "Should return only valid legal moves to be played.");
  //}
}
