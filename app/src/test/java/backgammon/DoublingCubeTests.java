package backgammon;



public class DoublingCubeTests {
//Yeah I know its ugly

  public static void main(String[] args){

    DoublingCube jim = new DoublingCube();

    System.out.println(jim.getCubeValue());
    jim.doubleCubeValue();
    jim.doubleCubeValue();
    System.out.println(jim.getCubeValue());

    /*
    TestPlayerDoublingCube guy = new TestPlayerDoublingCube(true);
    TestPlayerDoublingCube badGuy = new TestPlayerDoublingCube(false);
    jim.cubeCheck(guy.getCubeOwnership());
    jim.cubeCheck(badGuy.getCubeOwnership());

    jim.setCubeValue(64);

    jim.cubeCheck(guy.getCubeOwnership());
    */

    TestPlayerDoublingCube guy1 = new TestPlayerDoublingCube(true);
    TestPlayerDoublingCube guy2 = new TestPlayerDoublingCube(true);

    //Should be yes, no, yes, no
    if(jim.cubeCheck(guy1.getCubeOwnership())){
      jim.rollCube();
      guy1.setCubeOwnership(false);
    }
    else
      System.out.println("Didn't thing");

    if(jim.cubeCheck(guy1.getCubeOwnership())){
      jim.rollCube();
      guy1.setCubeOwnership(false);
    }
    else
      System.out.println("Didn't thing");

    guy2.setCubeOwnership(jim.rollCheck());

    if(jim.cubeCheck(guy2.getCubeOwnership())){
      jim.rollCube();
      guy1.setCubeOwnership(false);
    }
    else
      System.out.println("Didn't thing");

    guy2.setCubeOwnership(jim.rollCheck());
    guy1.setCubeOwnership(jim.rollCheck());

    if(jim.cubeCheck(guy1.getCubeOwnership())){
      jim.rollCube();
      guy1.setCubeOwnership(false);
    }
    else
      System.out.println("Didn't thing");
  }
}
