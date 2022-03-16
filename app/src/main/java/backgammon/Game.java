package backgammon;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Game {

  private Board board;
  private List<Player> players = new ArrayList<>();
  private Dice dice = new Dice();
  private DoublingCube dc;

  public Game() {
    players.add(new Player("Bob", Color.darkGray, 1, 25, 0));

    //GUI buttons determine whether to create a Player or Computer for player 2
    players.add(new Player("Tom", Color.lightGray, -1, 0, 25));

    onStart();
  }


  //Just call onStart() again to generate a new game rather than creating a new instance
  public void onStart() {
    Player p1 = players.get(0);
    Player p2 = players.get(1);

    List<Integer> sp = new ArrayList<>(Arrays.asList( 0, 2, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 5, 5, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, 2, 0 ));
    List<Player> sp2 = new ArrayList<>(Arrays.asList( p1, p1, null, null, null, null, p2, null, p2, null, null, null, p1,
      p2, null, null, null, p1, null, p1, null, null, null, null, p2, p2 ));

//      List<Integer> sp = new ArrayList<>(Arrays.asList( 0, 2, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, 5, 5, 0, 0, 0, 3, 0, 5, 1, 0, 2, 0, 2, 0 ));
//      List<Player> sp2 = new ArrayList<>(Arrays.asList( p1, p2, null, null, null, null, p2, null, p2, null, null, null, p2,
//                                                        p2, null, null, null, p2, null, p2, p1, null, p1, null, p1, p2 ));


    board = new Board(sp, sp2, dice);
//      System.out.println(dice.getDice());
//      System.out.println(board.generateMoves(p1, p1.getDirection()));

    dc = new DoublingCube();


    //Prompt each player to roll a die to determine order
    //gameLoop();
  }


  //Score stuff isn't implemented aside from the doubling cube
  public void gameLoop() {

    for (int i = 0; i <= 1 && !players.get(1 - i).hasWon(); i += players.get(i).getDirection()) {
      Player p = players.get(i);

      if (p.hasCube() && dc.cubeCheck()) {
        //Enable the doubling cube button
          //Pressing the button will perform the folling actions
            dc.rollCube();
            p.setCube(false);
            players.get(1 - i).setCube(true);
      }

      dice.roll();

      //disable the doubling cube button

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
          //When a button is pressed, it enables the buttons corresponding to the values in that key
          //If the first button is deselected, then highlight all the keys from the hashmap again
          //If a move is selected, either return the move or call a method to find the move using "from" and "to" and return that
          //Game will take that and call board to perform a move
          //Board's move method removes the used dice from the list (and potentially requests a repaint)
        }
        else
          board.move(p, p.selectMove(possibleMoves));
      }

      //GUI button will confirm the end of the turn
    }

  }


  public void onWin() {

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



  /*
  Hand the list of possible moves to whatever class is generating the buttons
      Extract the origin points of all the moves form the list and add them to a set
      Generate a hashmap(int, List<Move>) with the key corresponding to the origin point of the Move and highlight the points
          When a button is pressed, generate a set of all the "to" positions from the movelets of each move in the hashmap at that key (point)
              Enable the button corresponding to each integer in the set and highlight
                  If the first button is deselected, then highlight the all the keys from the hashmap again
                  If a move is selected, then play the move


   */



}
