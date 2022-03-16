package backgammon;

public class DoublingCube {

  private int cubeValue;

  public DoublingCube() {
    cubeValue = 1;
  }


  //Needed for score calculation if it's going to be added.
  public int getCubeValue() {
    return cubeValue;
  }


  public boolean cubeCheck() {
    return(cubeValue < 64);
  }


  public void rollCube() {
    cubeValue *= 2;
  }

}
