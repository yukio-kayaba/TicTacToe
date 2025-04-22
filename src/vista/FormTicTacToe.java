
package vista;

import java.awt.Color;
import javax.swing.JLabel;
import modelo.Imagen;
import modelo.Jugador;
import modelo.Tablero;

public class FormTicTacToe extends javax.swing.JFrame {
    
    private Jugador jugador1,jugador2;
    private Tablero tablero;
    public static Imagen imgJugadorEquis;
    public static Imagen imgJugadorCirculo;
    public static JLabel nombreJugadorEquis;
    public static JLabel nombreJugadorCirculo;
    public static JLabel puntajeEquis;
    public static JLabel puntajeCirculo;
    
    public FormTicTacToe(Jugador player1,Jugador player2) {
        this.jugador1 = player1;
        this.jugador2 = player2;
        init();
        imgJugadorEquis = this.jugadorx;
        imgJugadorCirculo = this.jugadorCirculo;
        nombreJugadorEquis =  this.lblnombreplayer1;
        nombreJugadorCirculo = this.lblnombreplayer2;
        puntajeEquis = this.lblpuntajevalor1;
        puntajeCirculo = this.lblpuntajevalor2;
    }
    public void init(){
        setUndecorated(true);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        
        this.panelFondo.setOpaque(false);
        this.setBackground(new Color(0,0,0,0));
        
        this.lblnombreplayer1.setText(this.jugador1.getNombre());
        this.lblnombreplayer2.setText(this.jugador2.getNombre());
        
        tablero = new Tablero();
        tablero.setJugador1(jugador1);
        tablero.setJugador2(jugador2);
        tablero.setAnchoCI(100);
        tablero.setAlturaCI(100);
        tablero.setMargen(5);
        tablero.setColorCI(new Color(14,19,43));
        tablero.setColorTablero(new Color(239,180,255));
        tablero.setLocation(40,150);
        tablero.crearTablero();
        tablero.setVisible(true);
        this.panelFondo.add(tablero);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new modelo.PanelRedondeado();
        lblcierre = new javax.swing.JLabel();
        jugadorCirculo = new modelo.Imagen();
        jugadorx = new modelo.Imagen();
        lblnombreplayer2 = new javax.swing.JLabel();
        lblnombreplayer1 = new javax.swing.JLabel();
        lblpuntajevalor2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblpuntajevalor1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(14, 19, 43));
        panelFondo.setForeground(new java.awt.Color(14, 19, 43));
        panelFondo.setPreferredSize(new java.awt.Dimension(400, 500));
        panelFondo.setLayout(null);

        lblcierre.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblcierre.setForeground(new java.awt.Color(240, 192, 255));
        lblcierre.setText("X");
        lblcierre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcierre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcierreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcierreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcierreMouseExited(evt);
            }
        });
        panelFondo.add(lblcierre);
        lblcierre.setBounds(370, 10, 20, 20);

        jugadorCirculo.setText("imagen1");
        jugadorCirculo.setRuta("/recursos/JugadorCirculo.png");
        panelFondo.add(jugadorCirculo);
        jugadorCirculo.setBounds(275, 50, 50, 50);

        jugadorx.setText("imagen1");
        jugadorx.setRuta("/recursos/JugadorEquis.png");
        panelFondo.add(jugadorx);
        jugadorx.setBounds(75, 50, 50, 50);

        lblnombreplayer2.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        lblnombreplayer2.setForeground(new java.awt.Color(180, 232, 255));
        lblnombreplayer2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombreplayer2.setText("NAME");
        panelFondo.add(lblnombreplayer2);
        lblnombreplayer2.setBounds(250, 100, 90, 30);

        lblnombreplayer1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        lblnombreplayer1.setForeground(new java.awt.Color(180, 232, 255));
        lblnombreplayer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnombreplayer1.setText("NAME");
        panelFondo.add(lblnombreplayer1);
        lblnombreplayer1.setBounds(55, 100, 90, 30);

        lblpuntajevalor2.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lblpuntajevalor2.setForeground(new java.awt.Color(255, 255, 255));
        lblpuntajevalor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpuntajevalor2.setText("0");
        panelFondo.add(lblpuntajevalor2);
        lblpuntajevalor2.setBounds(210, 50, 60, 60);

        jLabel4.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-");
        panelFondo.add(jLabel4);
        jLabel4.setBounds(170, 50, 60, 60);

        lblpuntajevalor1.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        lblpuntajevalor1.setForeground(new java.awt.Color(255, 255, 255));
        lblpuntajevalor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpuntajevalor1.setText("0");
        panelFondo.add(lblpuntajevalor1);
        lblpuntajevalor1.setBounds(130, 50, 60, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblcierreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblcierreMouseClicked

    private void lblcierreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseEntered
        this.lblcierre.setForeground(Color.red);
    }//GEN-LAST:event_lblcierreMouseEntered

    private void lblcierreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcierreMouseExited
        // TODO add your handling code here:
        this.lblcierre.setForeground(new Color(240,192,255));
    }//GEN-LAST:event_lblcierreMouseExited

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

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private modelo.Imagen jugadorCirculo;
    private modelo.Imagen jugadorx;
    private javax.swing.JLabel lblcierre;
    private javax.swing.JLabel lblnombreplayer1;
    private javax.swing.JLabel lblnombreplayer2;
    private javax.swing.JLabel lblpuntajevalor1;
    private javax.swing.JLabel lblpuntajevalor2;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
}
