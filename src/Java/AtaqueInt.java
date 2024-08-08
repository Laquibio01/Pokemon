package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AtaqueInt extends javax.swing.JFrame  {

    
    int Hp1, Hp2, contRever1 = 1, contRever2 = 3, contRever3 = 4, contRever4 = 5;
    
    private PeleaPokemon peleaPokemon;
    
    public void establecerVida(int vidaUno, int vidaDos){
        this.Hp1 = vidaUno;
        this.Hp2 = vidaDos;
    }

    public  AtaqueInt(PeleaPokemon peleaPokemon) {
        this.peleaPokemon = peleaPokemon;
        this.setUndecorated(true);
        initComponents();
        Attack1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contRever1 > 0){
                    contRever1--;
                peleaPokemon.iniciador = "Enemigo";
                peleaPokemon.afectar("resta", 50);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Te quedaste sin ese golpe");
                    Attack1.setEnabled(false);
                }
            }
        });
        
        Attack2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(contRever2 > 0){
                    contRever2--;
                peleaPokemon.iniciador = "Enemigo";
                peleaPokemon.afectar("resta", 40);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Te quedaste sin ese golpe");
                    Attack2.setEnabled(false);
                }
            }
        });
        
        Attack3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contRever3 > 0){
                    contRever3--;
                peleaPokemon.iniciador = "Enemigo";
                peleaPokemon.afectar("resta", 25);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Te quedaste sin ese golpe");
                    Attack3.setEnabled(false);
                }
            }
        });
        
        Attack4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(contRever4 > 0){
                    contRever4--;
                peleaPokemon.iniciador = "Enemigo";
                peleaPokemon.afectar("resta", 30);
                dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Te quedaste sin ese golpe");
                    Attack4.setEnabled(false);
                }
            }
        });
        
        AtaqueInt.this.setLocation(515, 465);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelAtaque = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AttackLabel = new javax.swing.JLabel();
        PPLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DamageLabel = new javax.swing.JLabel();
        Attack1 = new javax.swing.JButton();
        Attack3 = new javax.swing.JButton();
        Attack2 = new javax.swing.JButton();
        Attack4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, -1000));
        setResizable(false);

        PanelAtaque.setBackground(new java.awt.Color(204, 204, 204));
        PanelAtaque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));

        AttackLabel.setBackground(new java.awt.Color(153, 153, 153));
        AttackLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        AttackLabel.setText("Ataque");

        PPLabel.setBackground(new java.awt.Color(153, 153, 153));
        PPLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        PPLabel.setText("00/00");

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel4.setText("P / P :");

        DamageLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        DamageLabel.setText("50");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AttackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(PPLabel)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AttackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DamageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PPLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Attack1.setText("Ataque 1");

        Attack3.setText("Ataque 3");

        Attack2.setText("Ataque 2");

        Attack4.setText("Ataque 4");

        javax.swing.GroupLayout PanelAtaqueLayout = new javax.swing.GroupLayout(PanelAtaque);
        PanelAtaque.setLayout(PanelAtaqueLayout);
        PanelAtaqueLayout.setHorizontalGroup(
            PanelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAtaqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Attack1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(Attack3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Attack2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(Attack4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelAtaqueLayout.setVerticalGroup(
            PanelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAtaqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(PanelAtaqueLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(PanelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Attack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Attack2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAtaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Attack3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Attack4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelAtaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AtaqueInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtaqueInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtaqueInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtaqueInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Attack1;
    private javax.swing.JButton Attack2;
    private javax.swing.JButton Attack3;
    private javax.swing.JButton Attack4;
    private javax.swing.JLabel AttackLabel;
    private javax.swing.JLabel DamageLabel;
    private javax.swing.JLabel PPLabel;
    private javax.swing.JPanel PanelAtaque;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
