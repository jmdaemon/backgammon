package backgammon;

public class DoublingCubeTests {
  public static void main(String[] args){

    DoublingCube jim = new DoublingCube();

    System.out.println(jim.getCubeValue());

    jim.doubleCubeValue();
    jim.doubleCubeValue();

    System.out.println(jim.getCubeValue());

  }
}
