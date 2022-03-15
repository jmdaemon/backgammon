package backgammon;



public class DoublingCubeTests {
  public static void main(String[] args){

    DoublingCube jim = new DoublingCube();

    System.out.println(jim.getCubeValue());
    jim.doubleCubeValue();
    jim.doubleCubeValue();
    System.out.println(jim.getCubeValue());

    TestPlayerDoublingCube guy = new TestPlayerDoublingCube(true);
    TestPlayerDoublingCube badGuy = new TestPlayerDoublingCube(false);
    jim.cubeCheck(guy.getCubeOwnership());
    jim.cubeCheck(badGuy.getCubeOwnership());

    jim.setCubeValue(64);

    jim.cubeCheck(guy.getCubeOwnership());

  }
}
