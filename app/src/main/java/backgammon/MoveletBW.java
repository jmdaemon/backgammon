package backgammon;

public class MoveletBW {

  private final int from;
  private final int to;
  private final int die;

  public MoveletBW(int from, int to, int die) {
    this.from = from;
    to = Math.min(to, 25);
    this.to = Math.max(to, 0);
    this.die = die;
  }

  public int from() {
    return from;
  }


  public int to() {
    return to;
  }


  public int getDie() {
    return die;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movelet movelet = (Movelet) o;
    return from == movelet.from() && to == movelet.to();
  }


}

