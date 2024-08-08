package Java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class PeleaPokemon extends javax.swing.JFrame {
    
    
    DataB_Pokemons datosPokes = new DataB_Pokemons();
    
    int defensa1, ataque1, velocidad1, defensa2, ataque2, velocidad2;
    String nombre1, nombre2;
    int Hp1, Hp2, maxHp1, maxHp2;     
    String iniciador, eleccionEnemigo;      
    boolean primerTurno = true;
    
    public PeleaPokemon() {
        this.setResizable(false);
        initComponents();
        setImagePokes(playerImage, "/Imagenes/Pikachu.png");
        setImagePokes(enemyImage, "/Imagenes/Charmander.png");
        
        Pelear.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Pelear.setEnabled(false);
                AtaqueInt segundaInt = new AtaqueInt(PeleaPokemon.this);
                segundaInt.setVisible(true);
            }
    
    });
        
        obtenerDatos();
        BarraEnemigo.setMaximum(Hp2);
        BarraJugador.setMaximum(Hp1);
        BarraEnemigo.setMinimum(0);
        BarraJugador.setMinimum(0);
        BarraJugador.setValue(Hp1);
        BarraEnemigo.setValue(Hp2);
        modificarHp();
        pelea();
        
    }
    
    /*
    private void setImagePokes (JLabel LabelName, String  ImagenFondo){
        ImageIcon image = new ImageIcon(ImagenFondo);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(LabelName.getWidth(), LabelName.getHeight(), LabelName.getWidth()));
        LabelName.setIcon(icon);
        this.repaint();
    }
    */
    private void setImagePokes(JLabel LabelName, String ImagenFondo){
    java.net.URL imgURL = getClass().getResource(ImagenFondo);

    if (imgURL != null) {
        ImageIcon image = new ImageIcon(imgURL);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(LabelName.getWidth(), LabelName.getHeight(), java.awt.Image.SCALE_SMOOTH));
        LabelName.setIcon(icon);
    } else {
        System.err.println("No se pudo encontrar el archivo: " + ImagenFondo);
    }
    this.repaint();
}
    
    private void obtenerDatos(){
        if(primerTurno){
            datosPokes.consultaUnPokemon("JuegoPokemon", "TPokemones", 1);
            this.nombre1 = datosPokes.nombre;
            this.maxHp1 = datosPokes.health;
            this.defensa1 = datosPokes.defense;
            this.velocidad1 = datosPokes.velocity;
            this.ataque1 = datosPokes.atack;
            BarraEnemigo.setValue(Hp1);
            datosPokes.consultaUnPokemon("JuegoPokemon", "TPokemones", 2);
            this.nombre2 = datosPokes.nombre;
            this.maxHp2 = datosPokes.health;
            this.defensa2 = datosPokes.defense;
            this.velocidad2 = datosPokes.velocity;
            this.ataque2 = datosPokes.atack;
            BarraJugador.setValue(Hp2);
            pelea();
        } else {
            try{
                datosPokes.conexion().close();
            }catch(SQLException e){
                System.out.println("Error al cerrar a la base de datos: "+e.getMessage());
            }
        }
    }
    
    public void inicioTurno(){
        if(velocidad1 > velocidad2){
           iniciador = "Jugador";
        }else{
           iniciador = "Enemigo";
        }
    }
    
    public void modificarHp (){ //Para modificar la vida del label de HP
        enemyHp.setText(Integer.toString(Hp2));
        playerHp.setText(Integer.toString(Hp1));
    }
    
    private void pelea(){ 
        PokemonEnemyName.setText(nombre2);
        PokemonPlayerName.setText(nombre1);
        if((Hp1 <= 0 || Hp2 <= 0)&&primerTurno==false){
            JOptionPane.showMessageDialog(null, "La pelea terminó");
        }else{
        if(primerTurno){
            Hp1 = maxHp1;
            Hp2 = maxHp2;
        }
        if(primerTurno){
            primerTurno =  false;
            inicioTurno();
        }
        if(iniciador.equals("Enemigo")){
            Pelear.setEnabled(false);
            Curacion.setEnabled(false);
            pokemon.setEnabled(false);
            huir.setEnabled(false);
            eleccionEnemigo();
        }
        if(iniciador.equals("Jugador")){
            Pelear.setEnabled(true);
            Curacion.setEnabled(true);
            pokemon.setEnabled(true);
            huir.setEnabled(true);
        }
        }
    }
    
    public void eleccionEnemigo(){
        int eleccion, vida= 0;
        if(Hp2 < 20){
            eleccionEnemigo = "suma";
            vida = 40;
        }else{
            eleccionEnemigo = "restar";
            eleccion = (int) (Math.random() * 4);
            switch(eleccion){
                case 0 -> vida = 50;
                case 1 -> vida = 40;
                case 2 -> vida = 25;
                case 3 -> vida = 30;
                case 4 -> {
                    vida = 40;
                    eleccionEnemigo = "suma";
                }
            }
            
        }
        iniciador = "Jugador";
        afectarDeEnemigo(eleccionEnemigo, vida);
    }
    
    public void afectarDeEnemigo(String aff, int valor){
        if (aff.equals("suma")) {
            if (maxHp2 > (Hp2 + valor)) {
                this.Hp2 = this.Hp2 + valor;
            } else {
                this.Hp2 = maxHp2;
            }
            this.BarraEnemigo.setValue(Hp2);
        } else {
        if (Hp1 > valor) {
                this.Hp1 = this.Hp1 - valor;
            } else {
                this.Hp1 = 0;
                finCombate();
            }
        }
        this.BarraJugador.setValue(Hp1);
        System.out.println("El valor de vida del jugador es: " + Hp1);
        modificarHp();
        pelea();
    }
    
    public void afectar(String aff, int valor) {
        if (aff.equals("suma")) {
            if (maxHp1+1 > (Hp1 + valor)) {
                this.Hp1 = this.Hp1 + valor;
            } else {
                this.Hp1 = maxHp1;
            }
            iniciador = "Enemigo";
            this.BarraJugador.setValue(Hp1);
        } else {
            if (Hp2 > valor) {
                this.Hp2 = this.Hp2 - valor;
                finCombate();
            } else {
                this.Hp2 = 0;
                finCombate();
            }
        }
        this.BarraEnemigo.setValue(Hp2);
        System.out.println("El valor de vida del enemigo es: " + Hp2);
        modificarHp();
        pelea();
    }
    
    public void finCombate() {
        if (Hp1 <= 0) {
             iniciador = "";
            JOptionPane.showMessageDialog(null, "Lo siento has perdido");
            Pelear.setEnabled(false);
            Curacion.setEnabled(false);
            pokemon.setEnabled(false);
            huir.setEnabled(false);
        }
        if (Hp2 <= 0) {
             iniciador = "";
            JOptionPane.showMessageDialog(null, "El jugador ha Ganado!");
            Pelear.setEnabled(false);
            Curacion.setEnabled(false);
            pokemon.setEnabled(false);
            huir.setEnabled(false);
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fondoPelea = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        PokemonEnemyName = new javax.swing.JLabel();
        BarraEnemigo = new javax.swing.JProgressBar();
        labelEnemyHp = new javax.swing.JLabel();
        enemyHp = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        PokemonPlayerName = new javax.swing.JLabel();
        BarraJugador = new javax.swing.JProgressBar();
        labelPlayerHp = new javax.swing.JLabel();
        playerHp = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Pelear = new javax.swing.JButton();
        pokemon = new javax.swing.JButton();
        Curacion = new javax.swing.JButton();
        huir = new javax.swing.JButton();
        enemyImage = new javax.swing.JLabel();
        playerImage = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setText("\"Nombre pokemon\"");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoPelea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fondoPelea.setPreferredSize(new java.awt.Dimension(488, 132));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PokemonEnemyName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PokemonEnemyName.setText("Pokemon");

        BarraEnemigo.setBackground(new java.awt.Color(255, 255, 255));
        BarraEnemigo.setForeground(new java.awt.Color(0, 255, 51));

        labelEnemyHp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelEnemyHp.setText("HP");

        enemyHp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        enemyHp.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraEnemigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(PokemonEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelEnemyHp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemyHp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PokemonEnemyName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEnemyHp)
                    .addComponent(enemyHp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(BarraEnemigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PokemonPlayerName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PokemonPlayerName.setText("Pokemon");

        BarraJugador.setBackground(new java.awt.Color(255, 255, 255));
        BarraJugador.setForeground(new java.awt.Color(0, 255, 51));

        labelPlayerHp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPlayerHp.setText("HP");

        playerHp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        playerHp.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BarraJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(PokemonPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPlayerHp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerHp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PokemonPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlayerHp)
                    .addComponent(playerHp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BarraJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setText("Que hara el pokemon?");

        Pelear.setFont(new java.awt.Font("Microsoft Tai Le", 0, 12)); // NOI18N
        Pelear.setText("Pelear");

        pokemon.setText("Pokemon");

        Curacion.setText("Curar");
        Curacion.setMaximumSize(new java.awt.Dimension(45, 25));
        Curacion.setMinimumSize(new java.awt.Dimension(45, 25));
        Curacion.setPreferredSize(new java.awt.Dimension(45, 25));
        Curacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuracionActionPerformed(evt);
            }
        });

        huir.setText("Huir");
        huir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(huir, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Pelear, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Curacion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pelear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Curacion, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pokemon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(huir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout fondoPeleaLayout = new javax.swing.GroupLayout(fondoPelea);
        fondoPelea.setLayout(fondoPeleaLayout);
        fondoPeleaLayout.setHorizontalGroup(
            fondoPeleaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPeleaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(enemyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPeleaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoPeleaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(fondoPeleaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(playerImage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(448, 448, 448))
        );
        fondoPeleaLayout.setVerticalGroup(
            fondoPeleaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoPeleaLayout.createSequentialGroup()
                .addGroup(fondoPeleaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoPeleaLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoPeleaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(enemyImage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(fondoPeleaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playerImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoPelea, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fondoPelea, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void huirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huirActionPerformed
        dispose();
    }//GEN-LAST:event_huirActionPerformed

    private void CuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuracionActionPerformed
        // TODO add your handling code here:
        iniciador = "Enemigo";
        afectar("suma", 40);
        
    }//GEN-LAST:event_CuracionActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeleaPokemon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeleaPokemon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar BarraEnemigo;
    private javax.swing.JProgressBar BarraJugador;
    private javax.swing.JButton Curacion;
    private javax.swing.JButton Pelear;
    private javax.swing.JLabel PokemonEnemyName;
    private javax.swing.JLabel PokemonPlayerName;
    private javax.swing.JLabel enemyHp;
    private javax.swing.JLabel enemyImage;
    private javax.swing.JPanel fondoPelea;
    private javax.swing.JButton huir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel labelEnemyHp;
    private javax.swing.JLabel labelPlayerHp;
    private javax.swing.JLabel playerHp;
    private javax.swing.JLabel playerImage;
    private javax.swing.JButton pokemon;
    // End of variables declaration//GEN-END:variables
}
