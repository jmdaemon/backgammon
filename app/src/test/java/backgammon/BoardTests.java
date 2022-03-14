package backgammon;

import java.util.List;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTests {
  int barLocation;
  Board board;

  @BeforeEach
  public void setUp() {
    barLocation = 25; // Our player's piece is on the bar which is defined as being from 26-25
  }

  // Displays the result and also checks the result
  public void checkResult(List<String> expected, List<String> result, String message) {
    System.out.println(result);
    assertEquals(expected, result, message);
  }

  @Test
  public void canCalculateMoveMixed() {
    int[] dice = {4, 2};
    board = new Board(new int [] {0,0, 0,0,-2,-2,0,0,  0,0,0,0,0,0,  0,1,1,0,0,0,   0,0,0,0,0,0});
    int pieceLocation = 11;
    List<String> result = board.calcMixed(pieceLocation, dice);
    List<String> expected = Arrays.asList("11-7", "11-7-5", "11-9", "11-9-5");
    checkResult(expected, result, "Should return only valid legal moves to be played.");
  }

  @Test
  public void canCalculateMoveDoubles() {
    int[] dice = {5, 5};
    board = new Board(new int [] {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0});
    List<String> result = board.calcDouble(barLocation, dice);
    List<String> expected = Arrays.asList(
        "25-20",
        "25-20-15",
        "25-20-15-10",
        "25-20-15-10-5");
    checkResult(expected, result, "Should calculate all possible move combinations with doubles.");
  }

  @Test
  public void canCalculateBearOffMove() {
    int[] dice = {4, 3};
    board = new Board(new int[] {-1,0, 0,0,0,0,0,0,    0,0,0,0,0,0,  0,0,0,0,0,0,   0,0,1,1,0,1});
    List<String> result = board.calcBearOff(dice);
    List<String> expected = Arrays.asList("4-0", "3-0");
    checkResult(expected, result, "Should calculate a move to bear off");
  }

  @Test
  public void canCalculateBarMove() {
    int[] dice = {5, 3};
    board = new Board(new int[] {0,1, 0,0,0,0,0,0,   0,0,0,0,0,0,  0,0,-2,0,-2,0, 0,0,0,0,0,0});
    List<String> result = board.calcBarMove(barLocation, dice);
    List<String> expected = Arrays.asList("25-20-17");
    checkResult(expected, result, "Should return only valid legal moves to be played.");
  }

  //@Test
  //public void canCalculateAllMoves() {
    //int[] dice = {4, 3};
    ////int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    //int[] board = {-1,0, 0,0,0,0,0,0,    0,0,0,0,0,0,  0,0,0,0,0,0,   0,0,1,1,0,1};
    //List<List<String>> result = board.calcAllMoves(board, dice);
    //List<List<String>> expected = Arrays.asList(
        //Arrays.asList("4-0,3-0"),
        //Arrays.asList("4-1,3-0"));
    //assertEquals(expected, result, "Should return only valid legal moves to be played.");
  //}
}
