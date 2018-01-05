/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author Léa
 */
public class FenetreIntro extends javax.swing.JFrame {

    /**
     * Creates new form FenetreIntro
     */
    
    private Observateur observateur;
    
    public FenetreIntro() {
        initComponents();  
        //bouton crée une nouvelle partie
        //start.setEnabled(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenetrePerso fenetre = new FenetrePerso();
                fenetre.setVisible(true);
                fenetre.setObservateur(observateur);
                dispose();
            }
        });
        //bouton charger une partie
        partie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //lancer directement la partie du joueur
                Message m = new Message();
                m.setEtat("start");
                observateur.notification(m);
                dispose();
            }

        });
        //bouton para
        para.setEnabled(false);
        para.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pour une fenetre parametre quand utile
            }

        });
        //bouton credits
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ouvrir la fenetre des crédits
                FenetreCredits fenetreCredits = new FenetreCredits();
                fenetreCredits.setVisible(true);
                
            }

        });
        //bouton quitter
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        //pour mettre la fenetre en grand
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        /////////////////////////////////////////
        //partie esthétique
        //logo
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/logo_transparent.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 350, 350));
            logo.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //start
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            start.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        start.setVerticalTextPosition(SwingConstants.CENTER);
        start.setHorizontalTextPosition(SwingConstants.CENTER);
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        //partie
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            partie.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        partie.setVerticalTextPosition(SwingConstants.CENTER);
        partie.setHorizontalTextPosition(SwingConstants.CENTER);
        partie.setOpaque(false);
        partie.setContentAreaFilled(false);
        partie.setBorderPainted(false);
        //para
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            para.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        para.setVerticalTextPosition(SwingConstants.CENTER);
        para.setHorizontalTextPosition(SwingConstants.CENTER);
        para.setOpaque(false);
        para.setContentAreaFilled(false);
        para.setBorderPainted(false);
        //credits
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            credits.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        credits.setVerticalTextPosition(SwingConstants.CENTER);
        credits.setHorizontalTextPosition(SwingConstants.CENTER);
        credits.setOpaque(false);
        credits.setContentAreaFilled(false);
        credits.setBorderPainted(false);
        //quitter
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            quitter.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        quitter.setVerticalTextPosition(SwingConstants.CENTER);
        quitter.setHorizontalTextPosition(SwingConstants.CENTER);
        quitter.setOpaque(false);
        quitter.setContentAreaFilled(false);
        quitter.setBorderPainted(false);
    }
    
    //methode pour ajouter l'observateur
    public void setObservateur(Observateur o) {
        this.observateur = o;
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

        partie = new javax.swing.JButton();
        para = new javax.swing.JButton();
        start = new javax.swing.JButton();
        credits = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        layout.rowHeights = new int[] {0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0, 20, 0};
        getContentPane().setLayout(layout);

        partie.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        partie.setForeground(new java.awt.Color(51, 204, 0));
        partie.setText("Charger Partie");
        partie.setPreferredSize(new java.awt.Dimension(150, 50));
        partie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partieActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(partie, gridBagConstraints);

        para.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        para.setForeground(new java.awt.Color(153, 153, 153));
        para.setText("Parametres");
        para.setPreferredSize(new java.awt.Dimension(150, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(para, gridBagConstraints);

        start.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        start.setForeground(new java.awt.Color(0, 51, 255));
        start.setText("Nouvelle Partie");
        start.setPreferredSize(new java.awt.Dimension(150, 50));
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(start, gridBagConstraints);

        credits.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        credits.setForeground(new java.awt.Color(102, 102, 102));
        credits.setText("Credits");
        credits.setPreferredSize(new java.awt.Dimension(75, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(credits, gridBagConstraints);

        quitter.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        quitter.setForeground(new java.awt.Color(255, 0, 0));
        quitter.setText("Quitter");
        quitter.setPreferredSize(new java.awt.Dimension(73, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(quitter, gridBagConstraints);

        logo.setBackground(new java.awt.Color(153, 153, 153));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/images/logo.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 7;
        getContentPane().add(logo, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Chiller", 3, 78)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Enigmarium");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        getContentPane().add(jLabel2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void partieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_partieActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startActionPerformed

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
            java.util.logging.Logger.getLogger(FenetreIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreIntro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreIntro().setVisible(true);
            }
        });
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton credits;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton para;
    private javax.swing.JButton partie;
    private javax.swing.JButton quitter;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}
