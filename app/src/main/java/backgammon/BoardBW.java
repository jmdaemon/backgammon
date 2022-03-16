package backgammon;

import java.util.*;

public class BoardBW {

  private final Point[] board = new Point[26];  //p1 bar is 0, p2 bar is 25
  private final Dice dice;


  public BoardBW(List<Integer> startPoints, List<Player> startPlayers, Dice dice) {
    this.dice = dice;

    for (int i = 0; i < board.length; i++)
      board[i] = new Point(startPoints.get(i), startPlayers.get(i));
  }


  //Doesn't currently support playing moves in reverse (undo's not implemented)
  public void move(Player p, Move move) {

    for (int i = 0; i < move.getNumOfMovelets(); i++) {
      Movelet let = move.getMovelets().get(i);

      if (!p.equals(board[let.to()].getPlayer())) {
        if (board[let.to()].getPlayer() != null)
          board[p.getOutPoint()].plus();          //Adds to bar
        board[let.to()].setPoint(0, p);      //Sets player
      }

      //If the destination is the outPoint, then outCount++, otherwise point++
      if (let.to() == p.getOutPoint())
        p.bearOff();                              //Adds to home
      else
        board[let.to()].plus();

      board[let.from()].minus();                  //Removes from bar/regular point

      if (let.from() != 0 && let.from() != 25 && board[let.from()].getChips() == 0)
        board[let.from()].setPoint(0, null); //removes player from empty points
    }

    dice.remove(move.getDice());
    //Repaint

  }


  public List<Move> generateMoves(Player p, int dir) {
    List<Move> possibleMoves = new ArrayList<>();

    for (int i = 0; i <= 25; i++) {
      if (p.equals(board[i].getPlayer()) && board[i].getChips() > 0 && i != p.getOutPoint()) {
        if (dice.isDoubles())
          possibleMoves.addAll(generateDoubles(p, dice.getDice(), dir, i));
        else
          possibleMoves.addAll(generateMixed(p, dice.getDice(), dir, i));
      }
    }

    return possibleMoves;
  }


  private List<Move> generateDoubles(Player p, List<Integer> dice, int dir, int point) {
    List<Move> possibleMoves = new ArrayList<>();
    List<Integer> usedDice = new ArrayList<>();
    int die = dice.get(0);

    for (int n = 1; n <= dice.size(); n++) {
      int from = point + dir * (die * (n - 1));
      int to = point + dir * (die * n);

      if (isValid(p, from, to, die * n, dir)) {
        usedDice.add(die);
        Move move = new Move(point, to, dir, usedDice, true);
        possibleMoves.add(move);
      }
    }

    return possibleMoves;
  }


  private List<Move> generateMixed(Player p, List<Integer> dice, int dir, int point) {
    List<Move> possibleMoves = new ArrayList<>();

    for (int n = 0; n < dice.size(); n++) {
      List<Integer> usedDice = new ArrayList<>();
      int die = dice.get(n);

      if (isValid(p, point, point + dir * die, die, dir)) {
        if (n == 0 || isNotADuplicateOnHome(p, point, dir, die, dice.get(0))) {
          usedDice.add(die);
          Move move = new Move(point, point + dir * die, dir, usedDice, false);
          possibleMoves.add(move);

          if (dice.size() == 2) {
            int die2 = dice.get(1 - n);

            if (isValid(p, point + dir * die, point + dir * (die + die2), die + die2, dir)) {
              if (n == 0 && !board[point + die2].isBlot(p) || n == 1 && board[point + die].isBlot(p)) {
                usedDice.add(die2);
                Move move2 = new Move(point, point + dir * (die + die2), dir, usedDice, false);
                possibleMoves.add(move2);
              }
            }
          }
        }
      }
    }

    return possibleMoves;
  }

  //Eliminate moves in the second round in mixed generation that
  // would generate a home move that would be a duplicate of the first round
  //A very specific bug only for home moves where dice [3, 4] might give two 22-25 move options
  //when the distance between the out point and the furthest point is less than both dice.
  private boolean isNotADuplicateOnHome(Player p, int point, int dir, int die, int die2) {
    if (p.getOutPoint() == 25)
      return ( point + dir * die < 25 || (point + dir * die >= 25 && (point + dir * die2 < 25 || !canBearOff(p, point, point + dir * die2))));
    return (point + dir * die > 0 || (point + dir * die <= 0 && (point + dir * die2 > 0 || !canBearOff(p, point, point + dir * die2))));
  }


  private boolean isOpenPoint(Player p, int to) {
    return to > 0 && to < 25 && !board[to].isOpen(p);
  }


  public boolean isValid(Player p, int from, int to, int die, int dir) {
    if (from < 0 || from > 25 || isOpenPoint(p, to)) return false;
    if (hasChipsOnBar(p))
      return to - dir * die == p.getBarPoint();// && isMaximumDie(p, from, die);
    return isNormalMove(p, to) || canBearOff(p, from, to);
  }


  private boolean hasChipsOnBar(Player p) {
    return (p.getBarPoint() == 0) ? board[0].getChips() > 0 : board[25].getChips() > 0;
  }


  private boolean isNormalMove(Player p, int to) {
    return (p.getOutPoint() == 25) ? to < p.getOutPoint() : to > p.getOutPoint();
  }


  private boolean canBearOff(Player p, int from, int to) {
    if (!areAllOnHome(p)) return false;
    return (p.getOutPoint() == 25) ? (to <= 25 || isFurthest(p, from)) : (to >= 0 || isFurthest(p, from));
  }


//  private boolean isMaximumDie(Player p, int from, int die) {
//    if (dice.size() < 2) return true;
//    int max = Integer.max(dice.get(0), dice.get(1));
//    return die >= max || !board[from + (p.getDirection() * max)].isOpen(p);
//  }


  public boolean areAllOnHome(Player p) {
    if (p.getOutPoint() == 25) //Player 1
      for (int i = 1; i < 19; i++)
        if (p.equals(board[i].getPlayer()))
          return false;

    if (p.getOutPoint() == 0)  //Player 2/Computer
      for (int i = 24; i > 6; i--)
        if (p.equals(board[i].getPlayer()))
          return false;

    return true;
  }


  public boolean isFurthest(Player p, int from) {
    if (p.getOutPoint() == 25) //Player 1
      for (int i = 19; i <= 24; i++)
        if (p.equals(board[i].getPlayer()))
          return i == from;

    if (p.getOutPoint() == 0)  //Player 2/Computer
      for (int i = 6; i >= 1; i--)
        if (p.equals(board[i].getPlayer()))
          return i == from;

    return true;
  }


  //Would construct the version of rhe board
  //that would match Pridi's board in GUI
  public int[] getBoard() {
    int[] board = new int[26];
    for (int i = 0; i < board.length; i++) {
      board[i] = this.board[i].getChips();
      if (this.board[i].getPlayer() != null)
        board[i] *= this.board[i].getPlayer().getDirection();
    }
    return board;
  }

}
