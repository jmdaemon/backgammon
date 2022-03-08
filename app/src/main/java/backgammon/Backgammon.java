package backgammon;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class Backgammon {
  public static List<List<Integer>> genDoubles(int[] dice) {
    List<List<Integer>> doubles = new ArrayList<>();
    int die = dice[0];
    // Creates a nested jagged array:e.g [[6], [6,12], [6,12,18], [6,12,18,24]]
    Integer[][] intDoubles = new Integer[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j <= i; j++) {
        intDoubles[i][j] = die + (die * j);
      }
    }
    // Converts the jagged array to a list
    for (int i = 0; i < 4; i++) {
      List<Integer> offset = Arrays.asList(intDoubles[i]);
      offset = offset.stream()
        .filter(x -> x != null)
        .collect(Collectors.toList());
      doubles.add(offset);
    }
    return doubles;
  }

  public static List<List<Integer>> genMixed(int[] dice) {
    // Enumerate all possibilities
    List<List<Integer>> mixed = Arrays.asList(
        Arrays.asList(dice[0]),
        Arrays.asList(dice[1]),
        Arrays.asList(dice[0], dice[1]),
        Arrays.asList(dice[1], dice[0]));
    return mixed;
  }

  public static boolean notDoubles(List<List<Integer>> diceOffsets) {
    List<Integer> firstOffset = diceOffsets.get(0);
    List<Integer> secondOffset = diceOffsets.get(1);
    return ((firstOffset.get(0) != secondOffset.get(0)) ? true : false);
  }

  //public static List<String> calcMove(int[] board, int src, int[] diceOffsets) {
  //public static List<String> calcMove(int[] board, int src, List<List<Integer>> diceOffsets) {
  public static List<String> calcMove(int[] board, int src, int[] dice) {
    List<String> moves = new ArrayList<>();

    // Doubles
    if (dice[0] == dice[1]) {
      int die = dice[0];
      String move = null;
      for (int i = 0; i < 4; i++) {
        int dest = src - die;
        if (board[dest] >= 2)
          break;
        if (move != null)
          move = move + "-" + dest;
        else
          move = src + "-" + dest;

        move += (board[dest] == 1) ? "x" : "";
        moves.add(move);
        src = dest;
      }
      return moves;
    }
    // Mixed
    List<List<Integer>> diceOffsets = genMixed(dice);
    for (int i = 0; i < diceOffsets.size() - 1; i++) {
      List<Integer> offsets = diceOffsets.get(i);
      for (int j = 0; j < i; j++) {
        int dest = src - offsets.get(j);
        String move = null;
        if (board[dest] >= 2) {
          break;
        }
        move = src + "-" + dest;
        move += (board[dest] == 1) ? "x" : "";
        moves.add(move);
        }
    }
    moves = moves.stream()
      .distinct() // Filter duplicates
      .collect(Collectors.toList());

    // If we are given two choices: [25-22, 25-20]
    // We can only pick the highest choice.
    if ((moves.size() > 1) && notDoubles(diceOffsets)) {
      // Since our sets are ordered properly, this will
      // remove the lower choice from our set for bar moves
      moves.remove(0);
    }
    return moves;
  }
}
