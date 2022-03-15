package backgammon;

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

  // Setters
  public void setMoveList(List<String> moveList){this.moveList = moveList;}
  public void setColor(int color) {this.color = color;}
  public void setName(String name) {this.name = name;}

  /**
   * gets a move from the moveList at an entered index
   *
   * @param index index of move choice in moveList
   * @return move as a string
   */
  public String getMove(int index){ return moveList.get(index); }

  /**
   *
   * @return
   */
  public int selectMove() {
    return 0;
  }


  /**
   *  Finalizes move to be played and updates the board
   *
   * @param board the array of the board layout
   * @return the updated board array after the move is applied to it
   */
  public int[] playMove(int[] board) {

    //gets the move (String) selected from getMove by the index
    String move = this.getMove(this.selectMove());

    //Splits String from above selected move into an array of landing points
    String [] points = move.split("-");

    //Number that the chip moves from
    int startPoint = Integer.parseInt(points[0]);

    //Index of the first point that the chip is moving from
    int startIndex = board.length - startPoint;

    //Number that the chip moves to
    int endPoint = Integer.parseInt(points[points.length - 1]);

    //Index of the point the chip moves to
    int endIndex = board.length - endPoint;

    if(endPoint == 0)
      board[startIndex] = (board[startIndex] - 1);
    else {
      board[startIndex] = (board[startIndex] - 1);
      board[endIndex] = (board[endIndex] + 1);
    }
    return board;
  }
}
