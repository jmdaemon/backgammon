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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movelet movelet = (Movelet) o;
    return from == movelet.from() && to == movelet.to();
  }



  @Override
  public String toString() {
    return "-" + to;
  }

}

