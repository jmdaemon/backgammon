package backgammon;

import java.awt.*;

public class Player {

  private final String name;
  private final Color color;
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
}
