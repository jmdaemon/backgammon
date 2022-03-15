package backgammon;

public class TestPlayerDoublingCube {
  private boolean cubeOwnership;

  public TestPlayerDoublingCube(boolean x){
    cubeOwnership = x;
  }

  public boolean getCubeOwnership(){return this.cubeOwnership;}
  public void setCubeOwnership(boolean x){this.cubeOwnership = x;}
}
