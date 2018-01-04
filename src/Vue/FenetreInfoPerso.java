/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.MouseInfo;

/**
 *
 * @author Léa
 */
public class FenetreInfoPerso extends javax.swing.JFrame {

    /**
     * Creates new form FenetreInfoPerso
     */
    public FenetreInfoPerso(String nom,String desc) {
        //pour une fenetre avec le nom du personnage et sa description
        initComponents();
        this.nom.setText(nom);
        this.desc.setText(desc);
        this.setLocation(MouseInfo.getPointerInfo().getLocation());
        if(nom == "Grasvz'in"){
             this.setSize(200, 500);
        }
        else if( nom == "André le Boulanger"){
              this.setSize(200, 400);
        }
        
        else if( nom == "Ivan Le Paysant" || nom == "Bérengere la bergere" || nom == "Vo, Ame et Hune"){
              this.setSize(200, 300);
        }
        
        else{
             this.setSize(200, 200);
        }
       
        
    }
    
    public FenetreInfoPerso(String nom) {
        //pour une fenetre avec le nom du personnage
        initComponents();
        this.nom.setText(nom);
        this.desc.setText("");
        this.setSize(200, 100);
        this.setLocation(MouseInfo.getPointerInfo().getLocation());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nom = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        nom.setFont(new java.awt.Font("Balthazar", 0, 11)); // NOI18N
        nom.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nom.setText("jLabel1");

        desc.setFont(new java.awt.Font("Balthazar", 0, 11)); // NOI18N
        desc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(nom)
                .addGap(46, 46, 46)
                .addComponent(desc, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
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
            java.util.logging.Logger.getLogger(FenetreInfoPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreInfoPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreInfoPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreInfoPerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FenetreInfoPerso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel desc;
    private javax.swing.JLabel nom;
    // End of variables declaration//GEN-END:variables
}
