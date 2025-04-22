package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import modelo.Jugador;
import modelo.Ruta;
import modelo.Tablero;
import modelo.TipoImagen;

public class FormResultado extends javax.swing.JFrame {
    private Tablero tablero;
    public FormResultado(TipoImagen jugadorGanador,String nombreJugador,Tablero tablero) {
        init();
        this.lblNombre.setText("- "+nombreJugador+"-");
        if( jugadorGanador == TipoImagen.EQUIS){
            this.logoPersonaje.setRuta(Ruta.JugadorEquis );
        }else if( jugadorGanador == TipoImagen.CIRCULO ){
            this.logoPersonaje.setRuta(Ruta.JugadorCirculo );
        }else if( jugadorGanador == TipoImagen.EMPATE){
             this.tituloJLabel.setText("EMPATE");
             this.lblNombre.setText("No hay Ganador");
        }
        this.tablero = tablero;
        
        this.logoPersonaje.repaint();
    }
    public void init(){
        setUndecorated(true);
        initComponents();
        setResizable(false);
        setBackground(new Color(0,0,0,0));
        setLocationRelativeTo(null);
        this.PanelFondo.requestFocus();
        this.PanelFondo.setOpaque(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new modelo.PanelRedondeado();
        tituloJLabel = new javax.swing.JLabel();
        imagen1 = new modelo.Imagen();
        imagen3 = new modelo.Imagen();
        imagen4 = new modelo.Imagen();
        lblNombre = new javax.swing.JLabel();
        imagen6 = new modelo.Imagen();
        logoPersonaje = new modelo.Imagen();
        jPanel1 = new javax.swing.JPanel();
        imagen5 = new modelo.Imagen();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelFondo.setBackground(new java.awt.Color(14, 19, 49));
        PanelFondo.setPreferredSize(new java.awt.Dimension(416, 315));
        PanelFondo.setLayout(null);

        tituloJLabel.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        tituloJLabel.setForeground(new java.awt.Color(230, 251, 255));
        tituloJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloJLabel.setText("VICTORIA");
        PanelFondo.add(tituloJLabel);
        tituloJLabel.setBounds(0, 40, 420, 45);

        imagen1.setText("imagen1");
        imagen1.setRuta("/recursos/Equis.png");
        PanelFondo.add(imagen1);
        imagen1.setBounds(340, 100, 40, 40);

        imagen3.setText("imagen1");
        imagen3.setRuta("/recursos/Circulo.png");
        PanelFondo.add(imagen3);
        imagen3.setBounds(340, 100, 40, 40);

        imagen4.setBackground(new java.awt.Color(17, 54, 79));
        imagen4.setForeground(new java.awt.Color(5, 10, 138));
        imagen4.setText("imagen1");
        imagen4.setRuta("/recursos/homeCanva.png");
        imagen4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagen4MouseClicked(evt);
            }
        });
        PanelFondo.add(imagen4);
        imagen4.setBounds(10, 10, 30, 30);

        lblNombre.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(241, 227, 252));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("INICIAR");
        lblNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(lblNombre);
        lblNombre.setBounds(110, 100, 210, 50);

        imagen6.setText("imagen1");
        imagen6.setRuta("/recursos/exitCanva.png");
        imagen6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imagen6MouseClicked(evt);
            }
        });
        PanelFondo.add(imagen6);
        imagen6.setBounds(370, 10, 30, 30);

        logoPersonaje.setText("imagen1");
        logoPersonaje.setRuta("/recursos/JugadorCirculo.png");
        PanelFondo.add(logoPersonaje);
        logoPersonaje.setBounds(40, 100, 50, 50);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        imagen5.setText("imagen1");
        imagen5.setRuta("/recursos/retryCanva.png");

        jLabel2.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("RETRY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(imagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PanelFondo.add(jPanel1);
        jPanel1.setBounds(60, 160, 290, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imagen6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagen6MouseClicked
         System.exit(0);
    }//GEN-LAST:event_imagen6MouseClicked

    private void imagen4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagen4MouseClicked
        this.dispose();
        FormInicio tablaNueva = new  FormInicio();
        tablaNueva.setVisible(true);
    }//GEN-LAST:event_imagen4MouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        this.dispose();
        this.tablero.ReiniciarTablero( TipoImagen.CIRCULO);
    }//GEN-LAST:event_jPanel1MouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelFondo;
    private modelo.Imagen imagen1;
    private modelo.Imagen imagen3;
    private modelo.Imagen imagen4;
    private modelo.Imagen imagen5;
    private modelo.Imagen imagen6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombre;
    private modelo.Imagen logoPersonaje;
    private javax.swing.JLabel tituloJLabel;
    // End of variables declaration//GEN-END:variables
}
