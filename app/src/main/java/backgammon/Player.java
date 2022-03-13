package backgammon;

import java.util.List;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {
  private int color;
  private String name;
  private List<String> moveList;

  /**
   * @param color Color of the player's pieces
   * @param name Player's name
   * @param moveList The possible moves available for the player
   */
  public Player(int color, String name, List<String> moveList) {
    this.color = color;
    this.name = name;
    this.moveList = moveList;
  }

  public Player() {
    color = 0;
    name = null;
    moveList = null;
  }

  // Getters
  public List<String> getMoveList(){return moveList;}
  public int getColor() {return color;}
  public String getName() {return name;}
  public String getMove(int index){ return moveList.get(index); }

  // Setters
  public void setMoveList(List<String> moveList){this.moveList = moveList;}
  public void setColor(int color) {this.color = color;}
  public void setName(String name) {this.name = name;}

  /**
   * Obtains the index of the selected move from the player
   * This will be a callback function that the GUI uses to
   * determine the current move selected in the movesList.
   * @return
   */
  public int selectMove() { return 0; }

  /**
   *  Finalizes move to be played and updates the board
   *
   * @param board the array of the board layout
   * @return the updated board array after the move is applied to it
   */
  public int[] playMove(int[] board) {
    String move = this.getMove(this.selectMove());
    String [] points = move.split("-");

    int startPoint = Integer.parseInt(points[0]); // Current position of piece
    int startIndex = board.length - startPoint;   // Position of piece as board index
    int endPoint = Integer.parseInt(points[points.length - 1]); // Final destination of piece
    int endIndex = board.length - endPoint; // Final destination of piece as board index

    if (endPoint == 0)
      board[startIndex] = (board[startIndex] - 1);
    else {
      board[startIndex] = (board[startIndex] - 1);
      board[endIndex] = (board[endIndex] + 1);
    }
    return board;
  }

  private static Game game;
  private Player opponent;
  private List<Integer> pieces;
  private Color color;

  public Player(Game game, List<Integer> pieces, Color color) {
    Player.game = game;
    this.pieces = pieces;
    this.color = color;
  }


  public void move(Move move) {

    for (int i = 0; i < move.getNumOfMovelets(); i++) {
      Movelet let = move.getMovelets().get(i);

      if (let.to() != 0 && opponent.pieces().contains(25 - let.to())) {
        opponent.pieces().remove(25 - let.to());
        pieces.remove(let.from());
        pieces.add(let.to());
        opponent.pieces().add(25);
      }

      else {
        pieces.remove(let.from());
        pieces.add(let.to());
      }

    }
  }



  public List<Move> generateMoves() {

    List<Move> possibleMoves = new ArrayList<>();
    List<Integer> dice = new ArrayList<>(game.getDice());
    List<Integer> usedDice = new ArrayList<>();

    for (int i = 0;i < pieces.size(); i++) {

      if (i == 0 || !pieces.get(i).equals(pieces.get(i - 1))) {

        int origin = pieces.get(i);

        if (game.isDoubles()) {
          int die = dice.get(0);

          for (int n = 0; n < 4 && isValid(origin - die * n, origin - die * (n + 1), die); n++) {
            usedDice.add(die);
            Move move = new Move(origin, origin - die * n, usedDice, true);
            possibleMoves.add(move);
          }
          usedDice.clear();
        }

        else {
          for (int n = 0; n < 2; n++) {

            int die = dice.get(n);
            int die2 = dice.get(1 - n);

            if (isValid(origin, origin - die, die)) {
              usedDice.add(die);
              Move move = new Move(origin, Math.max(origin - die, 0), usedDice, false);
              possibleMoves.add(move);

              if (n == 0 && Collections.frequency(opponent.pieces(), 25 - (origin + dice.get(1))) == 1)
                continue;

              if (dice.size() == 2 && isValid(origin - die, origin - die - die2, die + die2)) {
                usedDice.add(die2);
                Move move2 = new Move(origin, origin - die - die2, usedDice, false);
                possibleMoves.add(move2);
                usedDice.remove(1);
              }
              usedDice.remove(0);
            }
          }
        }
      }
    }

    return possibleMoves;
  }


  public boolean isValid(int from, int to, int die) {
    if (from <= 0 || isLocked(to)) return false;                                        //Eliminates obvious invalids
    if (pieces.contains(25))                                                            //Bar moves
      return to + die == 25 && (isMaxDie(die) || !isMaxValid(from));                  //Bar moves
    return to > 0 || areAllOnHome() && (to >= 0 || isFurthest(from));                   //Bearing off moves
  }


  private boolean isMaxDie(int die) {
    if (game.getDice().size() < 2) return false;
    int max = Integer.max(game.getDieOne(), game.getDieTwo());
    return die >= max;
  }


  private boolean isMaxValid(int origin) {
    if (game.getDice().size() < 2) return false;
    int max = Integer.max(game.getDieOne(), game.getDieTwo());
    return !isLocked(origin - max);
  }


  private boolean isLocked(int to) {
    return Collections.frequency(opponent.pieces(), 25 - to) >= 2;
  }


  public boolean areAllOnHome() {
    for (int i = 25; i > 6; i--)
      if (pieces.contains(i))
        return false;
    return true;
  }


  public boolean isFurthest(int origin) {
    for (int i = origin + 1; i <= 25; i++)
      if (pieces.contains(i))
        return false;
    return true;
  }


  public void setOpponent(Player opponent) {
    this.opponent = opponent;
  }


  public List<Integer> pieces() {
    return pieces;
  }

}

//25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10,  9,  8,  7,  6,  5,  4,  3,  2,  1,  0    Player
// 0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25    Opponent

class test {

  public static void main(String[] args) {
    Game g = new Game();
    Player p = new Player(g, Arrays.asList(6, 6, 6, 6, 6, 8, 8, 8, 13, 13, 13, 13, 13, 24, 24), Color.lightGray);
    Player p2 = new Player(g, Arrays.asList(6, 6, 6, 6, 6, 8, 8, 8, 13, 13, 13, 13, 13, 24, 24), Color.darkGray);
    p.setOpponent(p2);

    System.out.println(g.getDice());
    System.out.println(p.generateMoves());
  }
}
