package backgammon;

import java.util.List;

public class Player {

  // Black == 1; White == 2
  private int color;
  private String name;

  public Player() {
    color = 0;
    name = null;
  }

  public Player(int color, String name) {
    this.color = color;
    this.name = name;
  }

  public int getColor() {
    return color;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public String getName() { return name; }

  public void setName(String name) {
    this.name = name;
  }

  //Finalizes move to be played and updates the board
  public int[] playMove(int[] board, List<String> moveList, int moveChoice) {
    //Splits String from moveChoice into an array of landing points
    String move = moveList.get(moveChoice);
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

