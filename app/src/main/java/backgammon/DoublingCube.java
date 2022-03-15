package backgammon;

public class DoublingCube {

  private int cubeValue;
  private boolean justRolled;

  public DoublingCube(){
    cubeValue = 1;
    justRolled = false;
  }

  public int getCubeValue(){
    return cubeValue;
  }
  public void setCubeValue(int x){
    this.cubeValue = x;
  }

  /**
   * doubles cube value
   */
  public void doubleCubeValue(){
    this.cubeValue = this.cubeValue * 2;
  }

  /**
   * checks if a player is eligible to use the doubling cube
   */
  public boolean cubeCheck(Boolean player){
    return(player && this.cubeValue < 64);

    /*
      System.out.println("yay");
    else
      System.out.println("nay");
    */
  }

  /**
   *checks if the cube was just rolled for swapping ownership.
   *(will NOT return false)
   */
  public boolean rollCheck(){
    if(this.justRolled) {
      this.justRolled = false;
      return true;
    }
    return false;
  }

  /**
   * Doubles the cube value
   * sets justRolled to true for ownership swapping
   */
  public void rollCube(){
      this.doubleCubeValue();
      this.justRolled = true;
      System.out.println("Did thing");
  }
}

