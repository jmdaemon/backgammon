package backgammon;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

public class s2
{
    public static void main( String args[] )
    {
        JFrame frame = new JFrame( "Drawing 2D shapes" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("component", new ComponentSJP());
        tabbedPane.add("graphic", new GraphicSJP());
        frame.add( tabbedPane );
        frame.setSize( 400, 400 );
        frame.setLocation( 200, 200 );
        frame.setVisible( true );
    }
}

class ComponentSJP extends JPanel
{
    Rectangle2D.Float rect;
    JLabel label;

    public ComponentSJP()
    {
        rect = new Rectangle2D.Float();
        setLayout(null);
        label = new JLabel("rectangle");
        label.setForeground(Color.blue);
        add(label);
    }

    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // draw 2D ellipse filled with a blue-yellow gradient
        float x1 = w/8;
        float y1 = h/3;
        float x2 = x1 + w/4;
        float y2 = y1 + h/3;
        g2d.setPaint( new GradientPaint(x1, y1, Color.blue, x2, y2, Color.yellow));
        g2d.fill( new Ellipse2D.Double( w/8, h/3, w/4, h/3 ) );

        // draw 2D rectangle in red
        g2d.setPaint( Color.red );
        g2d.setStroke( new BasicStroke( 2.0f ) );
        rect.setFrame( w/2, h/3, w/4, h/3 );
        locateLabel();
        g2d.draw( new Rectangle2D.Double( w/2, h/3, w/4, h/3 ) );

        // draw 2D lines in green and yellow
        x1 = w*5/6;
        y1 = h/2;
        x2 = w*15/16;
        y2 = h/2;
        g2d.setPaint( new GradientPaint(x1, y1, Color.green.darker(),
                x2, y2, Color.yellow));
        g2d.draw( new Line2D.Double( x1, h*2/3, x2, h/3 ) );
    }

    private void locateLabel()
    {
        Dimension d = label.getPreferredSize();
        int x = (int)(rect.getCenterX() - d.width/2);
        int y = (int)(rect.getCenterY() - d.height/2);
        label.setBounds(x, y, d.width, d.height);
    }
}

class GraphicSJP extends JPanel
{
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // draw 2D ellipse filled with a blue-yellow gradient
        float x1 = w/8;
        float y1 = h/3;
        float x2 = x1 + w/4;
        float y2 = y1 + h/3;
        g2d.setPaint( new GradientPaint(x1, y1, Color.blue, x2, y2, Color.yellow));
        g2d.fill( new Ellipse2D.Double( w/8, h/3, w/4, h/3 ) );

        // draw 2D rectangle in red
        g2d.setPaint( Color.red );
        g2d.setStroke( new BasicStroke( 2.0f ) );
        g2d.draw( new Rectangle2D.Double( w/2, h/3, w/4, h/3 ) );

        // draw 2D lines in green and yellow
        x1 = w*5/6;
        y1 = h/2;
        x2 = w*15/16;
        y2 = h/2;
        g2d.setPaint( new GradientPaint(x1, y1, Color.green.darker(),
                x2, y2, Color.yellow));
        Line2D line = new Line2D.Double( x1, h*2/3, x2, h/3 );
        g2d.draw( line );

        // draw ellipse label
        g2d.setPaint(Color.blue);
        Font font = g2d.getFont().deriveFont(16f);
        g2d.setFont(font);
        FontRenderContext frc = g2d.getFontRenderContext();
        String s = "ellipse";
        float width = (float)font.getStringBounds(s, frc).getWidth();
        LineMetrics lm = font.getLineMetrics(s, frc);
        float sx = w/8 + (w/4 - width)/2;  // center under ellipse
        float sy = h*2/3 + 10 + lm.getAscent() - lm.getDescent();
        g2d.drawString(s, sx, sy);

        // draw line label
        double dy = line.getY2() - line.getY1();
        double dx = line.getX2() - line.getX1();
        double theta = Math.atan2(dy, dx);
        s = "line";
        width = (float)font.getStringBounds(s, frc).getWidth();
        float height = font.getLineMetrics(s, frc).getAscent();
        double cx = line.getX1() + dx/2;
        double cy = line.getY1() + dy/2;
        g2d.setPaint(Color.red);
        float PAD = 2f;
        sx = (float)(cx + (width/2)*Math.cos(theta+Math.PI)
                + (height+PAD)*Math.cos(theta+Math.PI/2));
        sy = (float)(cy + (height+PAD)*Math.sin(theta+Math.PI/2)
                + (width/2)*Math.sin(theta+Math.PI));
        AffineTransform at = AffineTransform.getRotateInstance(theta);
        Font lineFont = font.deriveFont(at);
        g2d.setFont(lineFont);
        g2d.drawString(s, sx, sy);
    }
}
