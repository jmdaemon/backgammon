package ui.swing;

public class computer extends dice{

    computer(){
        nextRound();
    }

    public void nextRound(){

        int dice[] = new int[2];

        dice[0] = dice();
        dice[1] = dice();
    }
}
