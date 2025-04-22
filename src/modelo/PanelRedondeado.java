
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRedondeado extends JPanel {
    private double arcoAncho = 50;
    private double archoAltura = 50;
    private Color colorBorde = new Color(165,40,174);
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = ( Graphics2D ) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RoundRectangle2D.Double formaRedonda = new RoundRectangle2D.Double( 
            0,
            0,
            this.getWidth()-1,
            this.getHeight() - 1 ,
            this.arcoAncho,
            this.archoAltura
        );
        g2.setColor( this.getBackground() );
        g2.fill(formaRedonda);
        g2.setColor(colorBorde);
        g2.draw(formaRedonda);
        g2.dispose();
    }
}
