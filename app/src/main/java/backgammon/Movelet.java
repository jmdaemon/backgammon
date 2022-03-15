package backgammon;

public record Movelet(int from, int to, int die) {

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
  public String toString() {
    return "-" + to;
  }
}
