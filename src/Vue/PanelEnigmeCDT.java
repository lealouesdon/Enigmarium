/*//GEN-FIRST:event_validerActionPerformed
 * To change this license header, choose License Headers in Project Properties.//GEN-LAST:event_validerActionPerformed
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.Message;
import Controleur.Observateur;
import Modele.EnigmeChampsDeTexte;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.SwingConstants;
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
        question.setLocation((int)(largeur*0.83),(int)(hauteur*0.01));
        reponse.setLocation((int)(largeur*0.9),(int)(hauteur*0.4));
        valider.setLocation((int)(largeur*0.87),(int)(hauteur*0.85));
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
        regle();
        
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
            JButton indice = new JButton("Indice");
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
            try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                ImageIcon icon = new ImageIcon(getScaledImage(img, 100, 50));
                indice.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
            indice.setVerticalTextPosition(SwingConstants.CENTER);
            indice.setHorizontalTextPosition(SwingConstants.CENTER);
            indice.setOpaque(false);
            indice.setContentAreaFilled(false);
            indice.setBorderPainted(false);
            this.add(indice);
        }
    }
    
    private void regle() {
        if (enigme.getRegle() != null) {
            JButton regle = new JButton("Règles");
            regle.setFont(new Font("Liberation Sans", 14, 14));

            regle.setSize(100, 100);
            regle.setLocation(this.getWidth() - 200, 0);
            regle.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FenetreRegle reg = new FenetreRegle();
                    reg.setRegle(enigme.getRegle());
                    reg.setVisible(true);
                }
            });
            try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/bouton.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                ImageIcon icon = new ImageIcon(getScaledImage(img, 100, 50));
                regle.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
            regle.setVerticalTextPosition(SwingConstants.CENTER);
            regle.setHorizontalTextPosition(SwingConstants.CENTER);
            regle.setOpaque(false);
            regle.setContentAreaFilled(false);
            regle.setBorderPainted(false);
            this.add(regle);
            
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
        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        //si l'image est rentrée l'afficher
        if (enigme.getFond() != null) {
            try {
                //affiche l'image de la carte
                Image img = ImageIO.read(getClass().getResource(enigme.getFond()));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), Color.white, this);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        valider = new javax.swing.JButton();
        reponse = new javax.swing.JTextField();
        question = new javax.swing.JLabel();

        setLayout(null);

        valider.setFont(new java.awt.Font("Balthazar", 1, 14)); // NOI18N
        valider.setText("Valider");
        valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerActionPerformed(evt);
            }
        });
        add(valider);
        valider.setBounds(770, 500, 90, 40);

        reponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reponseActionPerformed(evt);
            }
        });
        add(reponse);
        reponse.setBounds(770, 460, 90, 20);

        question.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("---");
        add(question);
        question.setBounds(640, 60, 240, 270);
    }// </editor-fold>                        

    private void reponseActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       

    private void validerActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }                                       


    // Variables declaration - do not modify                     
    private javax.swing.JLabel question;
    private javax.swing.JTextField reponse;
    private javax.swing.JButton valider;
    // End of variables declaration                   
}
