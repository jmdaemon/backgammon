package ui.swing;

import java.util.Random;

public class dice {

    Random randomDie = new Random();

    public int dice(){
        int die = randomDie.nextInt(6)+1;
        return die;
    }
}
