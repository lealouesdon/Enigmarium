/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

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

    public FenetreScenario(String scenario, ArrayList<String> personnages) {
        this.scenario = scenario;
        initComponents();

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
        suivant.setOpaque(false);
        suivant.setContentAreaFilled(false);
        suivant.setBorderPainted(false);

        ArrayList<JLabel> persos = new ArrayList<JLabel>();
        persos.add(perso1);
        persos.add(perso2);
        persos.add(perso3);

        for (int i = 0; i < personnages.size(); i++) {
            switch (personnages.get(i)) {
                case "Fille":
                    try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource("images/pf_tete.jpg"));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
                        perso1.setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
                case "Garçon":
                    try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource("images/pm_tete.jpg"));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
                        perso1.setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "Merlin":
                     try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource("images/merlin.jpg"));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
                        perso1.setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "André":
                     try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource("images/AndréTete.jpg"));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, 250, 50));
                        perso1.setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
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
        champScenario = new javax.swing.JLabel();
        suivant = new javax.swing.JButton();
        perso1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        perso2 = new javax.swing.JLabel();
        perso3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        champScenario.setText("<html>  Le grincement du vieux plancher de ma cabane me sorti de ma somnolence. Je n’étais pas seul. J’entrouvris les yeux pour observer discrètement qui venait me rendre visite : un vieil homme ce tenais la, versant du thé fumant dans deux de mes tasses en céramiques. Une longue cape grise couvrait ses épaules et sa longue barbe grisonnante descendait jusqu’à son poitrail. Un grand bâton, surmonté d’un cristal bleu glace était posé sur l’encadrement de la fenêtre et un grimoire reposait sur mon coffre, au pied de mon lit. S’apercevant que je l’observais, le vieil homme se tourna vers moi : <br> -\tJe me suis permis de faire du thé, dit-il en souriant. <br> -\tEuh… Merci, je suppose. <br> -\tSais-tu qui je suis ? <br> -\tMerlin, c’est ça ? Je l’avais déjà aperçu sur la place du marché, discutant avec André, notre pâtissier. <br> -\tEn effet, et connais-tu mon rôle ? <br> -\tAndré est resté vague à ce-sujet répondis-je, l’esprit encore embrumé. <br> -\tJ’espère que tu ne lui en voudras pas, je sais que vous êtes très proche mais c’est aussi un vieil ami. Et je ne tiens pas à ce que tout le monde soit au courant de ma situation. Ainsi, je tiens à ce que toi aussi tu puisses tenir ta langue, peux-tu faire ça pour moi ? <br>   Je me lève, tire une chaise à moi et m’assis. Je ne reconnais pas l’odeur du thé, Merlin a dû l’apporter. Je trempe mes lèvres et repose la tasse aussitôt, le thé était encore brulant. <br> -\tJe ne suis pas du genre à divulguer les secrets des autres Merlin, Je vous écoute. <br> -\tUne bonne chose. <br> Il marque une pause, sont regard dirigé sur les vastes champs et collines que l’on apercevait par la fenêtre. <br> </html>");
        getContentPane().add(champScenario, java.awt.BorderLayout.CENTER);

        suivant.setFont(new java.awt.Font("Balthazar", 0, 24)); // NOI18N
        suivant.setText("Suivant");
        getContentPane().add(suivant, java.awt.BorderLayout.PAGE_END);

        perso1.setText("jLabel1");
        getContentPane().add(perso1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        perso2.setText("jLabel1");
        jPanel2.add(perso2, new java.awt.GridBagConstraints());

        perso3.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel perso1;
    private javax.swing.JLabel perso2;
    private javax.swing.JLabel perso3;
    private javax.swing.JButton suivant;
    // End of variables declaration//GEN-END:variables
}
