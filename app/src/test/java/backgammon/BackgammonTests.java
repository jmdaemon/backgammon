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

  @Test
  public void canCalculateMoveMixed() {
    int[] dice = {5, 3};
    //List<List<Integer>> diceOffsets = Backgammon.genMixed(dice);
    int pieceLocation = 25; // Our player's piece is on the bar
    int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    //int pieceLocation = 1; // Our player's piece is on the bar
    //List<String> result = Backgammon.calcMove(board, pieceLocation, dice);
    //List<String> result = Backgammon.calcMove(board, pieceLocation, diceOffsets);
    List<String> result = Backgammon.calcMove(board, pieceLocation, dice);
    List<String> expected = Arrays.asList("25-20");
    assertEquals(expected, result, "Should return only valid legal moves to be played.");
  }

  @Test
  public void canCalculateMoveDoubles() {
    int[] dice = {5, 5};
    //List<List<Integer>> diceOffsets = Backgammon.genDoubles(dice);
    int pieceLocation = 25; // Our player's piece is on the bar
    int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    //int pieceLocation = 1; // Our player's piece is on the bar
    //List<String> result = Backgammon.calcMove(board, pieceLocation, diceOffsets);
    List<String> result = Backgammon.calcMove(board, pieceLocation, dice);
    List<String> expected = Arrays.asList(
        "25-20",
        "25-20-15",
        "25-20-15-10",
        "25-20-15-10-5");
    assertEquals(expected, result, "Should return only valid legal moves to be played.");
  }


  //@Test
  //public void canCalculateAllMoves() {
    //int[] dice = {5, 3};
    //int[] board = {0,1, 0,0,0,0,0,0,    0,-3,0,0,0,5, 0,0,-2,0,-2,0, 0,0,0,0,0,0};
    //List<List<String>> result = Backgammon.calcAllMoves(board, dice);
    //List<List<String>> expected = Arrays.asList("25-20");
    //assertEquals(expected, result, "Should return only valid legal moves to be played.");
  //}
}
