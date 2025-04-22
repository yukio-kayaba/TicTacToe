
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Cuadro extends JPanel{
    private int ancho,altura;
    private Color color;
    private TipoImagen tipoImagen;
    private boolean estado = false;
    private int i,j;
    
    public Cuadro(int ancho,int altura,Color color){
        this.ancho = ancho;
        this.altura = altura;
        this.color = color;
        init();
    }
    public Cuadro(){}
    private void init(){
        this.setSize(this.ancho,this.altura);
        this.setBackground(this.color);
    }
    
    @Override
    protected void paintComponent(Graphics gg){
        super.paintComponent(gg);
        Graphics2D g = ( Graphics2D) gg;
        ImageIcon imagen = new ImageIcon();
        
        if(tipoImagen == TipoImagen.CIRCULO){
            imagen = new ImageIcon( this.getClass().getResource( Ruta.Circulo ) );
        }else if( tipoImagen == TipoImagen.EQUIS ){
            imagen = new ImageIcon( this.getClass().getResource( Ruta.Equis ));
        }else if(tipoImagen == TipoImagen.LINEA1){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA1));
        }else if(tipoImagen == TipoImagen.LINEA2){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA2));
        }else if( tipoImagen == TipoImagen.LINEA3 ){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA3));
        }else if(tipoImagen == TipoImagen.LINEA4){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA4));
        }else if(tipoImagen == TipoImagen.LINEA5){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA5));
        }else if(tipoImagen == TipoImagen.LINEA6){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA1));
        }else if(tipoImagen == TipoImagen.LINEA7){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA7));
        }else if(tipoImagen == TipoImagen.LINEA8){
            imagen = new ImageIcon( this.getClass().getResource(Ruta.LINEA8));
        }
        
        g.drawImage( imagen.getImage(),0,0,this.getWidth(), this.getHeight(),null);
    }
    
    public void pausarEstado(int cantIteraciones){
        try {
            Thread.sleep(cantIteraciones);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void animacionPintar(Color color1,int tiempomilli){
        Cuadro auxCuadro = this;
        Timer tiempo = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
               auxCuadro.setBackground(color1);
            }
        };
        
        tiempo.schedule(tarea,tiempomilli);
        this.setBackground(this.color);
    }
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public TipoImagen getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(TipoImagen tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
}
