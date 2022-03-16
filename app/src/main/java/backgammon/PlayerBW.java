package backgammon;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class PlayerBW {

  private final String name;
  private final Color color;
  private final int direction;
  private final int outPoint;
  private final int barPoint;
  private int outCount;
  private int score;
  private boolean hasCube;


  public PlayerBW(String name, Color color, int direction, int outPoint, int bar) {
    this.name = name;
    this.color = color;
    this.direction = direction;
    this.outPoint = outPoint;
    this.barPoint = bar;
    outCount = 0;
    score = 0;
    hasCube = true;
  }


  public int addToScore(int roundScore) {
    return score += roundScore;
  }

  public void setCube(boolean cube) {
    hasCube = cube;
  }


  public boolean hasCube() {
    return hasCube;
  }


  public void bearOff() {
    outCount++;
  }


  public void resetOutCount() {
    outCount = 0;
  }


  public String getName() {
    return name;
  }


  public Color getColor() {
    return color;
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


  public Move selectMove(List<Move> moveList) {
    Random rnd = new Random();
    return moveList.get(rnd.nextInt(moveList.size()));
  }


  public boolean hasWon() {
    return outCount == 15;
  }
}
