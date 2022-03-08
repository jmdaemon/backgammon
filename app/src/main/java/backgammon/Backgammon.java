package backgammon;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class Backgammon {
  // The game board is laid out according to the following:
  // Bar1   Bar2    Points [6,      6,      6,    6]    BearOffPoint
  // 26     25              24-18   18-12   12-6  6-1   0

  // Arrays are stored from zero-index:
  // index 0, 1, 2, 3 .. 25
  // 0: Leftmost, 25: Rightmost
  // *Note* that these are the inverse of each other
  // *Note* that the highest array index is one less than the
  // total number of points (26 including both Bar and born off point).

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
    int[] home = new int[6];
    for (int i = home.length - 1; i > 0; i--) {
      home[i] = board[board.length - i];
    }
    for (int i = 0; i < home.length; i++) {
      if (i > 0)
        return board.length - i;
    }
    return 0;
  }

  public static boolean canBearOff(int board[]) {
    for (int i = 0; i < board.length; i++) {
      if (i > 0)
        return false;
      if (i == 18) // Start of home
        return true;
    }
    return false;
  }

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

  public static int[] swap(int[] pair, int i, int j) {
    // Swap pair[i] with pair[j]
    int temp = pair[i];
    pair[i] = pair[j];
    pair[j] = temp;
    return pair;
  }

  public static List<String> calcMixed(int[] board, int src, int[] dice) {
    // Assume we start with dice: 4, 2
    List<String> moves = new ArrayList<>();
    int temp = src;
    for (int i = 0; i < dice.length; i++) {
      int dest = src - dice[0];
      int boardDest = board.length - src;
      String move = null;

      // Assume that there are no mixed to be born off.
      if (dest < board.length - 1) {
        // If the opponent isn't blocking the player at the destination
        if (!(board[boardDest] <= -2) && board[boardDest] >= 0) {
          // Add the move
          move = src + "-" + dest;
          move += (board[boardDest] == -1) ? "x" : ""; // If there is a blot
          moves.add(move);

          // Now check for the combined play
          src = dest; // Assume we have made the play and are now at the dest.
          boardDest = board.length - src;
          dice = swap(dice, 0, 1); // Swap 4 with 2
          dest = src - dice[0];
          if (!(board[boardDest] <= -2) && board[boardDest] >= 0) {
            move = move + "-" + dest;
            move += (board[boardDest] == -1) ? "x" : "";
            moves.add(move);
          }
        }
      }
      src = temp; // Reset src back to the initial position
    }
    return moves;
  }

  public static List<String> calcBearOff(int[] board, int[] dice) {
    List<String> moves = new ArrayList<>();
    final int bearOffAt = 0;
    final int homeStart = 19;
    final int numPoints = 24;
    // Assume the player is bearing off
    for (int index = homeStart; index < board.length; index++) {
      int src = numPoints - index;
      for (int j = 0; j < dice.length; j++) {
        int die = dice[j];
        int dest = src - die;

        String move = null;
        if (dest == bearOffAt) {
          move = src + "-" + dest;
          move += (board[dest] == 1) ? "x" : "";
          moves.add(move);
        } else if (dest < bearOffAt) {
          // Rule: If the roll will overshoot piece from home, but it is on the
          // farthest point away from home, it can bear off
          int furthestPoint = getFurthestFromHome(board);
          if (src == furthestPoint) {
            move = src + "-" + dest;
            move += (board[dest] == 1) ? "x" : "";
            moves.add(move);
          }
        }
      }
    }
    return moves;
  }

  public static List<String> calcBarMove(int[] board, int src, int[] dice) {
    List<String> moves = new ArrayList<>();
    //int temp = src;
    for (int i = 0; i < dice.length; i++) {
      int dest = src - dice[i];
      int boardDest = board.length - src;
      String move = null;
      if (!(board[boardDest] <= -2) && board[boardDest] >= 0) {
        // Add the move
        move = src + "-" + dest;
        move += (board[boardDest] == -1) ? "x" : ""; // If there is a blot
        moves.add(move);
      }
    }

    if (dice[0] > dice[1]) {
      // Return the higher roll
      moves.remove(1);
    } else if (dice[1] > dice[0]) {
      moves.remove(0);
    } else if (dice.length == 2) {
      // Doubles
      moves.remove(0);
    }
    // Now we must find the greatest difference between the initial and fist positions of either list
    //for (int i = 0; i < moves.size(); i++) {
    //}


      // Assume that there are no mixed to be born off.
      //if (dest < board.length - 1) {
        //// If the opponent isn't blocking the player at the destination
        //if (!(board[boardDest] <= -2) && board[boardDest] >= 0) {
          //// Add the move
          //move = src + "-" + dest;
          //move += (board[boardDest] == -1) ? "x" : ""; // If there is a blot
          //moves.add(move);

          //// Now check for the combined play
          //src = dest; // Assume we have made the play and are now at the dest.
          //boardDest = board.length - src;
          //dice = swap(dice, 0, 1); // Swap 4 with 2
          //dest = src - dice[0];
          //if (!(board[boardDest] <= -2) && board[boardDest] >= 0) {
            //move = move + "-" + dest;
            //move += (board[boardDest] == -1) ? "x" : "";
            //moves.add(move);
          //}
        //}
      //}
      //src = temp; // Reset src back to the initial position
    //}

    //for (int i = 0; i < dice.length; i++) {
      //int die = dice[i];
      ////int dest = src - offsets.get(j);
      //int dest = src - die;
      //int boardDest = board.length - src;
      //String move = null;

      //// Bearing off
      //if (dest == 0) {
        //move = src + "-" + dest;
        //move += (board[boardDest] == -1) ? "x" : "";
        //moves.add(move);
      //} else if (dest < 0) {
        //// Rule: If the roll will overshoot piece from home, but it is on the
        //// farthest point away from home, it can bear off
        //int furthestPoint = getFurthestFromHome(board);
        //if (src == furthestPoint) {
          //move = src + "-" + dest;
          //move += (board[boardDest] == -1) ? "x" : "";
          //moves.add(move);
        //}
      //}
      //// Moving
      //if (board[boardDest] >= -2) {
        //break;
      //} else {
        //move = src + "-" + dest;
        //move += (board[boardDest] == -1) ? "x" : "";
        //moves.add(move);
      //}
    //}
    return moves;
  }

  public static List<String> calcMove(int[] board, int src, int[] dice) {
    List<String> moves = new ArrayList<>();

    // Mixed
    List<List<Integer>> diceOffsets = genMixed(dice);
    for (int i = 0; i < diceOffsets.size() - 1; i++) {
      List<Integer> offsets = diceOffsets.get(i);
      for (int j = 0; j < i; j++) {
        // int dest = src - offsets.get(j);
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
          // move = src + "-" + dest;
        }
        // Moving
        if (board[dest] >= 2) {
          break;
        } else {
          move = src + "-" + dest;
          move += (board[dest] == 1) ? "x" : "";
          moves.add(move);
        }
        // src = dest;
      }
    }
    moves = moves.stream()
        .distinct() // Filter duplicates
        .collect(Collectors.toList());

    // If we are given two choices: [25-22, 25-20]
    // We can only pick the highest choice.
    // if ((moves.size() > 1) && notDoubles(diceOffsets)) {
    if (moves.size() > 1) {
      // Since our sets are ordered properly, this will
      // remove the lower choice from our set for bar moves
      moves.remove(0);
    }
    return moves;
  }

  public static List<List<String>> calcAllMoves(int[] board, int[] dice) {
    List<List<String>> moves = new ArrayList<>();
    // Note that if this doesn't work, split the loop in two to cover both the bar,
    // and the points
    // for (int point = 25; point > 0; point--) {
    for (int point = 0; point < board.length; point++) {
      int piecesAt = board[point];
      // Assume we're calculating the moves for the user player
      if (piecesAt > 0) {
        // Prompt for a new move
        List<String> move = new ArrayList<>();

        // Bearing Off
        if (canBearOff(board)) {
          // move = Backgammon.calcBearOff(board, point, dice);
          move = Backgammon.calcBearOff(board, dice);
          moves.add(move);
        }

        // Doubles
        if (dice[0] == dice[1]) {
          move = Backgammon.calcDouble(board, point, dice);
          moves.add(move);
        }
        // Mixed
        move = calcMixed(board, point, dice);
        moves.add(move);
      }
    }
    return moves;
  }
}
