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

  //doubles the cube value
  public void doubleCubeValue(){
    this.cubeValue = this.cubeValue * 2;
  }

  //checks if a player is eligible to use the doubling cube (right now prints yay or nay)
  public void cubeCheck(Boolean player){
    if(player && this.cubeValue < 64)
      System.out.println("yay");
    else
      System.out.println("nay");

  }

}

