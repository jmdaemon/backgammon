package backgammon;

public class Point {

  private int chips;
  private Player player;


  public Point(int chips, Player player) {
    this.chips = chips;
    this.player = player;
  }


  public void setPoint(int chips, Player player) {
    this.chips = chips;
    this.player = player;
  }


  public int getChips() {
    return chips;
  }


  public Player getPlayer() {
    return player;
  }


  public void plus() {
    chips++;
  }


  public void minus() {
    chips--;
  }


  public boolean isBlot(Player p) {
    return this.player != p && getChips() == 1;
  }


  public boolean isOpen(Player p) {
    return chips <= 1 || player.equals(p);
  }

}

