package backgammon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Game {

  //private Board board;
  private List<Player> players = new ArrayList<>();
  private List<Integer> dice = new ArrayList<>();
  private boolean isDoubles;

  public Game() {
    onStart();
  }


  //Just call onStart() again to generate a new game rather than creating a new instance
  public void onStart() {
    //this.board = new Board();
    players.add(new Player(this, Arrays.asList(6, 6, 6, 6, 6, 8, 8, 8, 13, 13, 13, 13, 13, 24, 24), Color.darkGray));
    players.add(new Player(this, Arrays.asList(6, 6, 6, 6, 6, 8, 8, 8, 13, 13, 13, 13, 13, 24, 24), Color.lightGray));

    players.get(0).setOpponent(players.get(1));
    players.get(1).setOpponent(players.get(0));

    roll();



    //Prompt each player to roll a die to determine order
  }


  public void roll() {
    Random rand = new Random();
    dice.add(rand.nextInt(6) + 1);
    dice.add(rand.nextInt(6) + 1);
    isDoubles = false;

    if (dice.get(0).equals(dice.get(1))) {
      dice.add(dice.get(0));
      dice.add(dice.get(0));
      isDoubles = true;
    }
  }


  public void gameLoop() {

    while (!hasEnded()) {


      for ( int i = 0; i < 2; i++) { //Swap between players
        //Player p = players.get(i); Then use p to generate the moves, etc

        //Roll dice

        //While there are dice remaining in the list && there are moves available {

        //Generate moves
        //If none, then break

        //Highlight chips
        //If the player selects a chip, highlight extended moves
        //If the player deselects a chip, then highlight the previous moves (either stored or generated again)


        //Drag and drop / click on the destination point will move the chip

        //remove the used dice from the dice list

        //}

        //Check if the game has ended, if it has, then break out of the loop

        //Prompt for end turn (might use i++)
      }


    }

  }


  public void onWin() {

  }


  public List<Integer> getDice() {
    return dice;
  }


  public int getDieOne() {
    return dice.get(0);
  }


  public int getDieTwo() {
    return dice.get(1);
  }


  public boolean isDoubles() {
    return isDoubles;
  }


  public boolean hasEnded() {
    return Collections.frequency(players.get(0).pieces(), 0) == 15 ||
      Collections.frequency(players.get(1).pieces(), 0) == 15;
  }


  public Player getWinner() {
    return (Collections.frequency(players.get(0).pieces(), 0) == 15) ? players.get(0) : players.get(1);
  }



}
