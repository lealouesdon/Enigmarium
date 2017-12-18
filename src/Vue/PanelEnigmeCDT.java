/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.Message;
import Controleur.Observateur;
import Modele.EnigmeChampsDeTexte;
import java.awt.Font;
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
import javax.swing.JButton;
/**
 *
 * @author Léa
 */
public class PanelEnigmeCDT extends javax.swing.JPanel {

    /**
     * Creates new form PanelEnigmeCDT
     */
    private Observateur observateur;
    private EnigmeChampsDeTexte enigme;
    
    public PanelEnigmeCDT(EnigmeChampsDeTexte e, int largeur, int hauteur) {
        initComponents();
        enigme = e;
        this.setSize(largeur, hauteur);
        question.setText(e.getQuestion());
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setEtat("MessageChampsDeTexte");
                m.setAtt1(reponse.getText());
                observateur.notification(m);
            }
            
        });
        boutonRetour();
        indice();
    }
    
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }
    
    public void boutonRetour() {
        //met en place tous les boutons sur le Jpanel
        JButton retour = new JButton("retour");
        //taille par défault du bouton
        retour.setSize(100, 100);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);

        //localisation par défaut du bouton
        retour.setLocation(0, 0);
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/retour.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img,100, 100));
            retour.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //action listener pour retourner "retour" a l'appuye du bouton
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                //renvoyer le nom du bouton pas le texte
                m.setEtat("retour");
                observateur.notification(m);
            }
        }
        );
        //ajouter une image pour le bouton retour!!!
        this.add(retour);
    }
    
    private void indice() {
        if (enigme.getIndice() != null) {
            JButton indice = new JButton("indice");
            indice.setFont(new Font("Liberation Sans", 14, 14));

            indice.setSize(100, 100);
            indice.setLocation(this.getWidth() - 100, 0);
            indice.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FenetreIndice ind = new FenetreIndice();
                    ind.setIndice(enigme.getIndice());
                    ind.setVisible(true);
                }

            });
            this.add(indice);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////
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

        valider = new javax.swing.JButton();
        reponse = new javax.swing.JTextField();
        question = new javax.swing.JLabel();

        setLayout(null);

        valider.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        valider.setText("Valider");
        add(valider);
        valider.setBounds(150, 120, 90, 40);

        reponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reponseActionPerformed(evt);
            }
        });
        add(reponse);
        reponse.setBounds(126, 80, 159, 20);

        question.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("---");
        add(question);
        question.setBounds(0, 32, 388, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void reponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reponseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reponseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel question;
    private javax.swing.JTextField reponse;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
