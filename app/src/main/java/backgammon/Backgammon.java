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

  // Gets the location of the furthest point away from home for the player
  public static int getFurthestFromHome(int board[]) {
    int[] home = new int [6];
    for (int i = home.length; i > 0; i--) {
      home[i] = board[board.length - i];
    }
    for (int i = 0; i < home.length; i++) {
      if (i > 0) return board.length - i;
    }
    return 0;
  }

  //public static boolean canBearOff(int board[]) {
    //return false;
  //}

  public static List<String> calcDouble(int[] board, int src, int[] dice) {
    List<String> moves = new ArrayList<>();
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

  public static List<String> calcMixed(int[] board, int src, int[] dice) {
    List<String> moves = new ArrayList<>();
    // First case: 5
    //int dest = src - dice[0];
    int dest = src + dice[0];
    String move = null;
    //if (!(board[dest] >= 2) && board[dest] >= 0) {
    if (dest < board.length - 1) {
      if (!(board[dest] >= 2) && board[dest] >= 0) {
          move = src + "-" + dest;
          move += (board[dest] == 1) ? "x" : "";
          moves.add(move);
          src = dest; // Update src
          // Check combined
          // Second case: 4
          //dest = src - dice[1];
          dest = src + dice[1];
          if (!(board[dest] >= 2) && board[dest] >= 0) {
              //move = src + "-" + dest;
              move = move + "-" + dest;
              move += (board[dest] == 1) ? "x" : "";
              moves.add(move);
          }

      }
    }

    // Second Case 4:
    //dest = src - dice[1];
    if (dest < board.length - 1) {
      dest = src + dice[1];
      if ((dest < board.length) && !(board[dest] >= 2) && board[dest] >= 0) {
          move = src + "-" + dest;
          move += (board[dest] == 1) ? "x" : "";
          moves.add(move);
          src = dest; // Update src
          // Check combined
          // case: 5
          //dest = src - dice[0];
          dest = src + dice[0];
          if (!(board[dest] >= 2) && board[dest] >= 0) {
              //move = src + "-" + dest;
              move = move + "-" + dest;
              move += (board[dest] == 1) ? "x" : "";
              moves.add(move);
          }
      }
    }
    return moves;
  }

  public static List<String> calcMove(int[] board, int src, int[] dice) {
    List<String> moves = new ArrayList<>();

    // Mixed
    List<List<Integer>> diceOffsets = genMixed(dice);
    for (int i = 0; i < diceOffsets.size() - 1; i++) {
      List<Integer> offsets = diceOffsets.get(i);
      for (int j = 0; j < i; j++) {
        //int dest = src - offsets.get(j);
        int dest = src - offsets.get(j);
        String move = null;
        // Bearing off
        if (dest == 0) {
          move = src + "-" + dest;
          move += (board[dest] == 1) ? "x" : "";
          moves.add(move);
        } else if (dest < 0) {
          // Rule: If the roll will overshoot piece from home, but it is on the
          // farthest point away from home, it can bear off
          int furthestPoint = getFurthestFromHome(board);
          if (src == furthestPoint) {
            move = src + "-" + dest;
            move += (board[dest] == 1) ? "x" : "";
            moves.add(move);
          }
          //move = src + "-" + dest;
        }
        // Moving
        if (board[dest] >= 2) {
          break;
        } else {
          move = src + "-" + dest;
          move += (board[dest] == 1) ? "x" : "";
          moves.add(move);
        }
        //src = dest;
        }
    }
    moves = moves.stream()
      .distinct() // Filter duplicates
      .collect(Collectors.toList());

    // If we are given two choices: [25-22, 25-20]
    // We can only pick the highest choice.
    //if ((moves.size() > 1) && notDoubles(diceOffsets)) {
    if (moves.size() > 1) {
      // Since our sets are ordered properly, this will
      // remove the lower choice from our set for bar moves
      moves.remove(0);
    }
    return moves;
  }

  // Array are stored:
  // index 0, 1, 2, 3 .. 25
  // 0: Leftmost, 25: Rightmost
  public static List<List<String>> calcAllMoves(int[] board, int[] dice) {
    List<List<String>> moves = new ArrayList<>();
    // Note that if this doesn't work, split the loop in two to cover both the bar, and the points
    //for (int point = 25; point > 0; point--) {
    for (int point = 0; point < board.length; point++) {
      int piecesAt = board[point];
      // Assume we're calculating the moves for the user player
      if (piecesAt > 0) {
        // Doubles
        List<String> move = new ArrayList<>();
        if (dice[0] == dice[1]) {
          move = Backgammon.calcDouble(board, point, dice);
        }
        //move = calcMove(board, point, dice);
        move = calcMixed(board, point, dice);
        moves.add(move);
      }
    }
    return moves;
  }
}
