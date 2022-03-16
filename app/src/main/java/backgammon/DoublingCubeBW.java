package backgammon;

public class DoublingCubeBW {

  private int cubeValue;

  public DoublingCubeBW() {
    cubeValue = 1;
  }


  public void resetCube() {
    cubeValue = 1;
  }


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
