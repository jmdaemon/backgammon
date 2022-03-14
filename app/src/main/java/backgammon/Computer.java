package backgammon;
import java.util.List;
import java.util.Random;

public class Computer extends Player{

  //Selects chip from moveList given
  public int selectChip(int[] board, List<String> moveList) {
    //getting number that the move starts at so we can select the chip at this place
    char charChip = (this.selectMove(board,  moveList)).charAt(0);
    int chip = Character.getNumericValue(charChip);

    //returns the index of the selected chips placement on the board
    return (board.length - chip);
  }

  public String selectMove(int[] board, List<String> moveList) {
    Random rnd = new Random();
    int choice = rnd.nextInt(moveList.size());
    return moveList.get(choice);
  }

  //Finalizes move to be played and updates the board
  public int[] playMove(int[] board, List<String> moveList) {
    //Splits String from random moveChoice into an array of landing points
    String move = this.selectMove(board, moveList);
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

