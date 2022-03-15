package backgammon;

import java.util.List;
import java.awt.*;

public class Player {
  private String name;
  private Color color;
  private List<String> moveList;

  /**
   * @param color Color of the player's pieces
   * @param name Player's name
   * @param moveList The possible moves available for the player
   */
  public Player(Color color, String name, List<String> moveList) {
    this.color = color;
    this.name = name;
    this.moveList = moveList;
  }

  public Player() {
    color = null;
    name = null;
    moveList = null;
  }

  // Getters
  public List<String> getMoveList(){return moveList;}
  public String getName() {return name;}
  public Color getColor() { return color; }
  public String getMove(int index){ return moveList.get(index); }

  // Setters
  public void setMoveList(List<String> moveList){this.moveList = moveList;}
  public void setColor(Color color) {this.color = color;}
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

  private final int direction;
  private final int outPoint;
  private final int barPoint;
  private int outCount;


  public Player(String name, Color color, int direction, int outPoint, int bar) {
    this.name = name;
    this.color = color;
    this.direction = direction;
    this.outPoint = outPoint;
    this.barPoint = bar;
    this.outCount = 0;
  }


  public void bearOff() {
    outCount++;
  }

  public int getDirection() {
    return direction;
  }


  public int getOutPoint() {
    return outPoint;
  }


  public int getBarPoint() {
    return barPoint;
  }


  public int getOutCount() {
    return outCount;
  }
}
