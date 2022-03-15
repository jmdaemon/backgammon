package backgammon;

public class DoublingCube {

  private int cubeValue;

  public DoublingCube(){
    cubeValue = 1;
  }


  public int getCubeValue(){
    return cubeValue;
  }

  public void setCubeValue(int x){
    this.cubeValue = x;
  }

  public void doubleCubeValue(){
    this.cubeValue = this.cubeValue * 2;
  }


}

