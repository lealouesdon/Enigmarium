/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Observateur;
import Controleur.Message;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Léa
 */
public class FenetrePerso extends javax.swing.JFrame {

    /**
     * Creates new form FenetrePerso
     */
    private String perso;
    private Observateur observateur;
    private Message message;

    public FenetrePerso() {
        initComponents();
        //variables pour connaitre le choix de l'utilsateur
        fille.setName("fille");
        garcon.setName("garçon");
        //possibilité de validé que en cas de selection du personnages
        valider.setEnabled(false);
        //bouton valider
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //mise à jour de la sauvegarde
                message = new Message();
                message.setAtt2(pseudo.getText());
                message.setAtt1(perso);
                message.setEtat("start");
                message.setMessage("new");
                observateur.notification(message);
                dispose();


            }

        });
        //bouton retour
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setEtat("menu");
                observateur.notification(m);
                dispose();
            }

        });
        //bouton perso fille
        fille.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                garcon.setBackground(Color.LIGHT_GRAY);
                fille.setBackground(Color.red);
                perso = fille.getName();
                if(!(pseudo.getText().isEmpty())){
                    valider.setEnabled(true);
                }
            }

        });
        //bouton perso garçon
        garcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fille.setBackground(Color.LIGHT_GRAY);
                garcon.setBackground(Color.red);
                perso = garcon.getName();
                if(!(pseudo.getText().isEmpty())){
                    valider.setEnabled(true);
                }
            }

        });

        
        //champs de texte du pseudo
        pseudo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                    if(perso == fille.getName() || perso == garcon.getName()){
                        valider.setEnabled(true);
                    }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (pseudo.getText().isEmpty() || !(perso != garcon.getText() && perso != garcon.getText())) {
                    valider.setEnabled(false);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }

        });
        //pour mettre la fenetre sur tout l'écran
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            retour.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        retour.setVerticalTextPosition(SwingConstants.CENTER);
        retour.setHorizontalTextPosition(SwingConstants.CENTER);
        retour.setOpaque(false);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);
        //valider
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            valider.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        valider.setVerticalTextPosition(SwingConstants.CENTER);
        valider.setHorizontalTextPosition(SwingConstants.CENTER);
        valider.setOpaque(false);
        valider.setContentAreaFilled(false);
        valider.setBorderPainted(false);
    }

    //methode pour ajouter l'observateur
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        //pour redimensionner une image pour un bouton
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        valider = new javax.swing.JButton();
        pseudo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        garcon = new javax.swing.JButton();
        fille = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 20, 0, 20, 0, 20, 0, 20, 0};
        jPanel1.setLayout(jPanel1Layout);

        valider.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        valider.setText("Valider");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(valider, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 136;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(pseudo, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Balthazar", 1, 18)); // NOI18N
        jLabel1.setText("Choisir son personnage :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel1.add(jLabel1, gridBagConstraints);

        garcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/images/perso_masculin.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(garcon, gridBagConstraints);

        fille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/images/perso_feminin.png"))); // NOI18N
        fille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(fille, gridBagConstraints);

        retour.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        retour.setText("Retour");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(retour, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Balthazar", 1, 18)); // NOI18N
        jLabel2.setText("Choisir son pseudo :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filleActionPerformed

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
            java.util.logging.Logger.getLogger(FenetrePerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePerso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePerso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fille;
    private javax.swing.JButton garcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pseudo;
    private javax.swing.JButton retour;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
