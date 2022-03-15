package backgammon;

import java.util.List;

public class Player {

  // Black == 1; White == 2
  private int color;
  private String name;
  private List<String> moveList;

  public Player() {
    color = 0;
    name = null;
    moveList = null;
  }

  public Player(int color, String name, List<String> moveList) {
    this.color = color;
    this.name = name;
    this.moveList = moveList;
  }

  public List<String> getMoveList(){return moveList;}

  public void setMoveList(List<String> moveList){this.moveList = moveList;}

  public int getColor() {return color;}

  public void setColor(int color) {this.color = color;}

  public String getName() {return name;}

  public void setName(String name) {
    this.name = name;
  }

  public String getMove(int index){ return moveList.get(index); }

  //public int selectMove() {
    //getting number that the move starts at so we can select the chip at this place
    //char charChip = (moveList.get(moveChoice)).charAt(0);
    //int chip = Character.getNumericValue(charChip);

    //returns the index of the selected chips placement on the board
    //return (board.length - chip);
  //}

  //Finalizes move to be played and updates the board
  public int[] playMove(int[] board, int moveChoice) {

    //gets the move (String) selected from getMove by the index
    String move = this.getMove(moveChoice);

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

