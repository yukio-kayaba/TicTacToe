
package modelo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import modelo.Cuadro;
import vista.FormResultado;
import vista.FormTicTacToe;

public class Tablero extends JPanel{
    private int anchoCI,alturaCI;
    private int margen;
    private Color colorTablero,colorCI;
    private Jugador jugador1,jugador2;
    private TipoImagen jugActual;
    private int mapaTablero[][]; 
    
    private ArrayList<Cuadro> cuadros;
    private Cuadro cuadroFrontal;
    private TipoImagen ganador;
    
    public Tablero(){
        init();
    }
    private void init(){
        this.anchoCI = 80;
        this.alturaCI = 80;
        this.colorCI = Color.BLUE;
        this.colorTablero = Color.RED;
        this.margen = 6;
        this.jugador1 = new Jugador(1);
        this.jugador2 = new Jugador(4);
        this.cuadros = new ArrayList();
        this.jugActual = TipoImagen.EQUIS;
    }
    public void crearTablero(){
        this.setLayout(null);
        this.setSize(this.anchoCI * 3 + this.margen * 4 ,this.alturaCI * 3 + this.margen * 4);
        this.setBackground(this.colorTablero);
        this.mapaTablero = new int[3][3];
        this.cuadroFrontal = new Cuadro( this.getWidth(),this.getHeight(),Color.RED);
        this.cuadroFrontal.setLocation(0,0);
        this.cuadroFrontal.setOpaque(false);
        
        this.add(this.cuadroFrontal);
        
        
        crearCuadrosInternos();
        
        //this.iaEstado(jugador1);
        
    }
    
    private void iaEstado(Jugador player1){
        if(player1.isIA_ACTIVE()){
            
            Timer timer = new Timer();
            TimerTask tiempo = new TimerTask(){
                @Override
                public void run() {
                    int[] tablaAux = player1.respuestaIA(mapaTablero);
                    cambiarCuadroEstado(tablaAux[0], tablaAux[1] , player1);
                }
                
            };
            timer.schedule(tiempo, 300);
        }
    }
    
    private void cambiarCuadroEstado(int x,int y,Jugador jugador){
        for(Cuadro cuadro : this.cuadros){
            if(cuadro.getI() == x && cuadro.getJ() == y){
                cuadro.setTipoImagen( jugador.getTipoImagen());
                this.mapaTablero[ cuadro.getI()][cuadro.getJ()] = jugador.getNumeroRepresentado();
                cuadro.setEstado(true);
                cuadro.repaint();
                break;
            }
        }
    }
    private void crearCuadrosInternos(){
        int x = this.margen,y = this.margen;
        
        for(int i = 0;i < 3;i++){
            x = this.margen;
            for(int j = 0 ;j < 3;j++){
                Cuadro cuadro = new Cuadro(this.anchoCI,this.alturaCI,this.colorCI);
                cuadro.setCursor(new Cursor(Cursor.HAND_CURSOR));
                cuadro.setLocation(x,y);
                cuadro.setI(i);
                cuadro.setJ(j);
                cuadros.add(cuadro);
                crearEventoCuadros(cuadro);
                this.add(cuadro);
                x += ( this.anchoCI + this.margen);
            }
            y += ( this.alturaCI + this.margen);
        }
    }
    
    public void crearEventoCuadros( Cuadro cuadro ){
        
       MouseListener evento = new MouseListener() {
           @Override
           public void mouseClicked(MouseEvent e) {
           }

           @Override
           public void mousePressed(MouseEvent e) {
               if( cuadro.isEstado()) return;
               
               Jugador playerIA = jugador1;
               
               if( jugActual == TipoImagen.EQUIS){
                   cuadro.setTipoImagen(TipoImagen.EQUIS );
                   jugActual = TipoImagen.CIRCULO;
                   mapaTablero[cuadro.getI()][cuadro.getJ()] = jugador1.getNumeroRepresentado();
                   jugador1.IncrementarMovimiento();
                   playerIA = jugador2;
               }else if(jugActual == TipoImagen.CIRCULO){
                  cuadro.setTipoImagen(TipoImagen.CIRCULO);
                  jugActual = TipoImagen.EQUIS;
                  mapaTablero[cuadro.getI()][cuadro.getJ()] = jugador2.getNumeroRepresentado();
                  jugador2.IncrementarMovimiento();
                  playerIA = jugador1;
               }
               cambiarEstilo( jugActual);
               cuadro.setEstado(true);
               
               int resultado = analizadorTablero();
               if(resultado != 0){
                   GenerateGanador( valoresImagen(resultado),ganador);
               }
               
               //iaEstado(playerIA);
               
               repaint();
               for(int i = 0;i < 3;i++){
                    for(int j = 0;j < 3;j++){
                        System.out.print(""+mapaTablero[i][j]);
                    }
                    System.out.println("");
                }
                System.out.println("cant jug1: "+jugador1.getCantMovi()+" - cant jug2 : "+jugador2.getCantMovi());
               
               System.out.println("resultado : "+resultado);
           }

           @Override
           public void mouseReleased(MouseEvent e) {
           }

           @Override
           public void mouseEntered(MouseEvent e) {
               if( cuadro.isEstado()) return;
               cuadro.setBackground(new Color(17,26,73));
               //cuadro.repaint();
           }

           @Override
           public void mouseExited(MouseEvent e) {
               if( cuadro.isEstado()) return;
               cuadro.setBackground(new Color(14,19,43));
           }
       } ;
       
       cuadro.addMouseListener(evento);
       
    }
    public void cambiarEstilo(TipoImagen jugadorAct){
        if(jugadorAct == TipoImagen.CIRCULO){
            FormTicTacToe.imgJugadorEquis.setRuta(Ruta.JugadorAuxiliar);
            FormTicTacToe.imgJugadorEquis.repaint();
            new Thread(()->{
                for(int i  = 5;i >= 0;i--){
                    final int alpha  = 25 * i;
                    javax.swing.SwingUtilities.invokeLater(()->{
                        FormTicTacToe.nombreJugadorEquis.setForeground(new Color(187,187,187,alpha));
                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            
            
            FormTicTacToe.imgJugadorCirculo.setRuta(Ruta.JugadorCirculo);
            FormTicTacToe.imgJugadorCirculo.repaint();
            FormTicTacToe.nombreJugadorCirculo.setForeground(new Color(255,200,255));
        }else if(jugadorAct == TipoImagen.EQUIS){
            FormTicTacToe.imgJugadorCirculo.setRuta(Ruta.JugadorAuxiliar);
            FormTicTacToe.imgJugadorCirculo.repaint();
            new Thread(()->{
                for(int i  =5;i >= 0;i--){
                    final int alpha  = 25 * i;
                    javax.swing.SwingUtilities.invokeLater(()->{
                        FormTicTacToe.nombreJugadorCirculo.setForeground(new Color(255,200,255,alpha));

                    });
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            FormTicTacToe.imgJugadorEquis.setRuta(Ruta.JugadorEquis);
            FormTicTacToe.imgJugadorEquis.repaint();
            FormTicTacToe.nombreJugadorEquis.setForeground(new Color(187,187,187));
        }
            
    }
    
    public void desactivarCuadros(boolean valor){
        for(Cuadro cuadro : this.cuadros){
            cuadro.setEstado(valor);
        }
    }
    
    
    public int getAnchoCI() {
        return anchoCI;
    }

    public void setAnchoCI(int anchoCI) {
        this.anchoCI = anchoCI;
    }

    public int getAlturaCI() {
        return alturaCI;
    }

    public void setAlturaCI(int alturaCI) {
        this.alturaCI = alturaCI;
    }

    public int getMargen() {
        return margen;
    }

    public void setMargen(int margen) {
        this.margen = margen;
    }

    public Color getColorTablero() {
        return colorTablero;
    }

    public void setColorTablero(Color colorTablero) {
        this.colorTablero = colorTablero;
    }

    public Color getColorCI() {
        return colorCI;
    }

    public void setColorCI(Color colorCI) {
        this.colorCI = colorCI;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public ArrayList<Cuadro> getCuadros() {
        return cuadros;
    }

    public void setCuadros(ArrayList<Cuadro> cuadros) {
        this.cuadros = cuadros;
    }

    public TipoImagen getJugActual() {
        return jugActual;
    }

    public void setJugActual(TipoImagen jugActual) {
        this.jugActual = jugActual;
    }
    
    public int analizadorTablero(){
        
        int cantX = 0;
        int cantY = 0;
        System.out.println("jug1: "+jugador1.getNumeroRepresentado()+"jug2 : " + jugador2.getNumeroRepresentado());
        for(int i = 0;i < 3;i++){
            cantX = 0;
            cantY = 0;
            for(int j = 0;j < 3;j++){
                cantX += this.mapaTablero[i][j];
                cantY += this.mapaTablero[j][i];
            }
            
            if(cantX == jugador1.getNumeroRepresentado() * 3) return i + 1;
            if(cantY == jugador1.getNumeroRepresentado() * 3 ) return 3 + i + 1;
            if(cantX == jugador2.getNumeroRepresentado() * 3 ) return i + 1;
            if(cantY == jugador2.getNumeroRepresentado() * 3 ) return i + 4;
        }
        if(this.mapaTablero[1][1] == jugador1.getNumeroRepresentado() && this.mapaTablero [2][2] == jugador1.getNumeroRepresentado() && this.mapaTablero[0][0] == jugador1.getNumeroRepresentado() ) return 8;
        if(this.mapaTablero[0][2] == jugador1.getNumeroRepresentado() && this.mapaTablero[1][1] == jugador1.getNumeroRepresentado() && this.mapaTablero[2][0] == jugador1.getNumeroRepresentado() ) return 7;
        if(this.mapaTablero[1][1] == jugador2.getNumeroRepresentado() && this.mapaTablero [2][2] == jugador2.getNumeroRepresentado() && this.mapaTablero[0][0] == jugador2.getNumeroRepresentado() ) return 8;
        if(this.mapaTablero[0][2] == jugador2.getNumeroRepresentado() && this.mapaTablero[1][1] == jugador2.getNumeroRepresentado() && this.mapaTablero[2][0] == jugador2.getNumeroRepresentado() ) return 7;
        
        int contador = this.jugador1.getCantMovi() + this.jugador2.getCantMovi() ;
        
        if(contador >= 9){
            return 10;
        }
        
        return 0;
    }
    
    public void ReiniciarTablero(TipoImagen ganador ){
        ganador = this.ganador;
        desactivarCuadros(false);
        this.cuadroFrontal.setTipoImagen(null);
        this.limpiarTablero();
        this.jugador1.setCantMovi(0);
        this.jugador2.setCantMovi(0);
        
        if(ganador == TipoImagen.CIRCULO){
            int puntajeCirculo = Integer.parseInt(FormTicTacToe.puntajeCirculo.getText()) + 1;
            FormTicTacToe.puntajeCirculo.setText(""+puntajeCirculo);
            
        }
        
        if( ganador == TipoImagen.EQUIS){
            int puntajaeEquis = Integer.parseInt( FormTicTacToe.puntajeEquis.getText()) + 1;
            FormTicTacToe.puntajeEquis.setText(""+puntajaeEquis);
        }
        repaint();
        this.animacionCuadros();
    }
    public void limpiarTablero(){
        for(Cuadro cuadro : this.cuadros){
            cuadro.setEstado(false);
            cuadro.setTipoImagen(null);
        }
        for(int i  = 0;i < 3;i++ ){
            for(int j = 0;j < 3;j++){
                this.mapaTablero[i][j] = 0;
            }
        }
    }
    public void GenerateGanador(TipoImagen imagen,TipoImagen jugadorWin ){
        if( imagen != TipoImagen.EMPATE ){
            Ruta.cambiarRutas(jugadorWin);
            this.desactivarCuadros(true);
            this.cuadroFrontal.setTipoImagen(imagen);
            this.ganador = jugadorWin; //(jugadorWin == TipoImagen.CIRCULO)? TipoImagen.EQUIS : jugadorWin;
        }
        //FormResultado formResultado = new FormResultado(imagen,this.jugador1.getNombre(),this);
        //formResultado.setVisible(true);
        Jugador ganadorPlayer = (jugadorWin == TipoImagen.EQUIS)? jugador1:jugador2;  
        Timer timer = new Timer();
        Tablero tableroAux = this;
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                FormResultado formResultado = new FormResultado(imagen,ganadorPlayer.getNombre(),tableroAux);
                formResultado.setVisible(true);
            }
        };
        timer.schedule(tarea, 800);
        
    }
    
    public TipoImagen valoresImagen(int imagen){
        switch (imagen) {
            case 1: return TipoImagen.LINEA1;
            case 2: return TipoImagen.LINEA2;
            case 3: return TipoImagen.LINEA3;
            case 4: return TipoImagen.LINEA4;
            case 5: return TipoImagen.LINEA5;
            case 6: return TipoImagen.LINEA6;
            case 7: return TipoImagen.LINEA7;
            case 8: return TipoImagen.LINEA8;
            case 10:return TipoImagen.EMPATE;
            default:
                return null;
        }
    }
    
    public void animacionCuadros(){
        for(Cuadro cuadro : this.cuadros){
            cuadro.animacionPintar(new Color(17,26,73), 800);
        }
    }
    
}
