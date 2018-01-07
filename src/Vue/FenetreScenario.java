/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Léa
 */
public class FenetreScenario extends javax.swing.JFrame {

    /**
     * Creates new form Fenetre
     */
    private String scenario;
    private String personnages;
    private String sexe;

    public FenetreScenario(String scenario, ArrayList<String> personnages, String sexe) {
        this.scenario = scenario;
        this.sexe = sexe;
        initComponents();
        this.setAlwaysOnTop(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        suivant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        //suivant
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
            suivant.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        suivant.setVerticalTextPosition(SwingConstants.CENTER);
        suivant.setHorizontalTextPosition(SwingConstants.CENTER);
        suivant.setOpaque(true);
        suivant.setContentAreaFilled(true);
        suivant.setBorderPainted(false);

        ArrayList<JLabel> persos = new ArrayList<JLabel>();
        persos.add(perso2);
        persos.add(perso3);

        //champScenario.setSize(panelSenario.getSize());

        if (this.sexe == "fille") {

            try {
                //ouvre l'image et la met dans le bouton
                Image img = ImageIO.read(getClass().getResource("images/pf_tete.png"));
                //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 250));
                perso1.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                //ouvre l'image et la met dans le bouton
                Image img = ImageIO.read(getClass().getResource("images/pm_tete.png"));
                //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 250));
                perso1.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        for (int i = 0; i < personnages.size(); i++) {
            switch (personnages.get(i)) {
                case "Merlin":
                    try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource("images/Merlin.png"));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 250));
                        persos.get(i).setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "André":
                    try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource("images/AndréTete.jpg"));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 250));
                        persos.get(i).setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
        champScenario.setText(scenario);
        Font font = new Font("FreeSans", Font.BOLD, 16);
        champScenario.setFont(font);
        //champScenario.setSize(panelSenario.getSize());

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

        champScenario = new javax.swing.JLabel();
        suivant = new javax.swing.JButton();
        perso1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        perso2 = new javax.swing.JLabel();
        perso3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        champScenario.setBackground(new java.awt.Color(255, 255, 255));
        champScenario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        champScenario.setMaximumSize(new java.awt.Dimension(200, 200));
        champScenario.setMinimumSize(new java.awt.Dimension(100, 100));
        getContentPane().add(champScenario, java.awt.BorderLayout.CENTER);

        suivant.setBackground(new java.awt.Color(255, 255, 255));
        suivant.setFont(new java.awt.Font("Balthazar", 0, 24)); // NOI18N
        suivant.setText("Suivant");
        getContentPane().add(suivant, java.awt.BorderLayout.PAGE_END);

        perso1.setBackground(new java.awt.Color(255, 255, 255));
        perso1.setOpaque(true);
        getContentPane().add(perso1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0, 20, 0, 20, 0, 20, 0};
        jPanel2.setLayout(jPanel2Layout);

        perso2.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel2.add(perso2, gridBagConstraints);

        perso3.setBackground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel2.add(perso3, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

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
            java.util.logging.Logger.getLogger(FenetreScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreScenario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
 /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreScenario().setVisible(true);
            }
        });*/
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel champScenario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel perso1;
    private javax.swing.JLabel perso2;
    private javax.swing.JLabel perso3;
    private javax.swing.JButton suivant;
    // End of variables declaration//GEN-END:variables
}
