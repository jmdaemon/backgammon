package backgammon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class GameBW {

  private Board board;
  private List<Player> players = new ArrayList<>();
  private DoublingCube dc = new DoublingCube();
  private Dice dice = new Dice();
  private int currentRound;
  private int numOfRounds;

  public GameBW(int numOfRounds) {
    players.add(new Player("Bob", Color.darkGray, 1, 25, 0));

    //GUI will prompt to create either a Player or a Computer
    players.add(new Player("Tom", Color.lightGray, -1, 0, 25));

    this.numOfRounds = numOfRounds;
    currentRound = 1;
    onStart();
  }


  //Just call onStart() again to generate a new game rather than creating a new instance
  public void onStart() {
    Player p1 = players.get(0);
    Player p2 = players.get(1);

    List<Integer> sp = new ArrayList<>(Arrays.asList( 0, 2, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 5, 5, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 2, 0 ));
    List<Player> sp2 = new ArrayList<>(Arrays.asList( p1, p1, null, null, null, null, p2, null, p2, null, null, null, p1,
      p2, null, null, null, p1, null, p1, null, null, null, null, p2, p2 ));

    board = new Board(sp, sp2, dice);

    gameLoop(dice.firstToMove());
  }


  //Score stuff isn't implemented aside from the doubling cube
  public void gameLoop(int playerToStart) {
    boolean firstTime = true;
    int i;

    //Check happens at the beginning of each loop, so it checks the i for the previous
    //player to determine if they won in the previous round, if not, then 1 - i ensures
    //the loop will continue until someone wins or the exit button is clicked.
    for (i = playerToStart; i <= 1 && !players.get(1 - i).hasWon(); i += 1 - i) {
      Player p = players.get(i);

      if (!firstTime) {
        if (p.hasCube() && dc.cubeCheck()) {
          //Enable the doubling cube button, would perform:
          dc.rollCube();
          p.setCube(false);
          players.get(1 - i).setCube(true);
        }

        //Prompt with GUI button to roll dice - actions:
        //disable the doubling cube button
        // dice.roll();
      }

      while (dice.getDice().size() > 0) {

        List<Move> possibleMoves = board.generateMoves(p, p.getDirection());
        if (possibleMoves.size() == 0)
          break;

        if (p.getClass().getSimpleName().equals("Player")) {
          //Hand the list of possible moves to whatever class is generating the buttons
          //Extract the origin points of all the moves form the list and add them to a set
          //Generate a hashmap(int, Set<Integer>)
          // --The keys corresponds to the first set of buttons (from positions) that are enabled immediately
          // --The values correspond to the next buttons to enable
          //When a "from" button is pressed, it enables the buttons corresponding to the values in that key
          //If the first button is deselected, then highlight all the keys from the hashmap again
          //Alternatively, we can make some sort of clear button that deselects everything
          //If a move is selected, either return the move or call a method to find the move using "from" and "to" and return that
          //Game will take that and call board to perform a move
          //Board's move method removes the used dice from the list (and potentially requests a repaint)
        } else
          board.move(p, p.selectMove(possibleMoves));
      }

      //GUI button will confirm the end of the turn
      firstTime = false;
    }

    //Assuming we're including score, then we have multiple rounds so, we'll call these two lines
    //Otherwise we just close the window or give them a splash screen "Player x has won!"
    players.get(1 - i).addToScore(board.getWinModifier(players.get(1 - i), players.get(i)) * dc.getCubeValue());


    //Guess there should be a splash screen for the win regardless that displays
    //for 2 or 3 seconds then enables a button you can use to start the next round -> onWin();
    onWin();


  }


  public void onWin() {
    //currentRound++;
    //dc.resetCube();
    //players.get(0).resetOutCount();
    //players.get(1).resetOutCount();

    //if (currentRound <= maxRound)
    //onStart();

    //Display final credits with the player scores & overall winner or just System.exit(0);
  }


  //This is for generating the integers for the GUI to display, but it may need to be changed
  public void test() {
    Player p = players.get(0);
    List<Move> possibleMoves = board.generateMoves(p, p.getDirection());
    System.out.println(possibleMoves);
    Set<Integer> origins = new HashSet<>();
    Set<Integer> list;
    Set<Move> list2;

    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<Integer, Set<Move>> map2 = new HashMap<>();

    for (Move move : possibleMoves)
      origins.add(move.getFrom());

    for (Integer n : origins) {
      list = new HashSet<>();
      list2 = new HashSet<>();
      for (Move move : possibleMoves) {
        if (move.getFrom() == n) {
          list.add(move.getTo());
          list2.add(move);
        }
      }
      map.put(n, list);
      map2.put(n, list2);
    }

    System.out.println(map);
    System.out.println(map2);
    origins.clear();

  }



}
