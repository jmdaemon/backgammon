import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Palette {

    Color Palette1, Palette2;


    public Palette(Color C1, Color C2, Graphics2D g){
        setColor(C1,C2);
        setPalette(g);
    }

    public void setColor(Color color1, Color color2){
        Palette1 = color1;
        Palette2 = color2;
    }

    public void setPalette(Graphics2D g){
        Ellipse2D.Double paletteT1 = new Ellipse2D.Double(200, 174, 40, 20);
        g.setColor(Palette1);
        g.fill(paletteT1);
    }


}
