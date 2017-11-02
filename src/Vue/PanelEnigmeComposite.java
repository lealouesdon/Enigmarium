/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.Carte;
import Modele.Enigme;
import Modele.Ingredient;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Léa
 */
public class PanelEnigmeComposite extends JPanel {

    private String att1;
    private String att2;
    private Observateur observateur;
    private Enigme carte;
    private Message m;
    private ArrayList<JButton> att1s, att2s;
    private JPanel recette;

    public PanelEnigmeComposite(ArrayList<Ingredient> ingredients,int largeur, int hauteur) {
        this.setSize(largeur, hauteur);
        m = new Message();
        m.setAtt1(null);
        m.setAtt2(null);
        m.setEtat("IngredientChoisi");
        att1 = null;
        att2 = null;
        att1s = new ArrayList<JButton>();
        att2s = new ArrayList<JButton>();
        this.setLayout(null);
        recette = new JPanel();
        recette.setSize(200, 100);
        recette.setOpaque(false);
        recette.setLocation((int) (this.getWidth() * 0.43),(int) (this.getHeight()* 0.65));
        recette.setLayout(new BoxLayout(recette,BoxLayout.Y_AXIS));
        initBoutons(ingredients);
        melange(att1s);
        this.add(recette);
    }

    /////////////////////////////////////////////////////////////////////////////
    private void initBoutons(ArrayList<Ingredient> ingredients) {
        // crée autant d'objet que dans la liste
        
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getNom() != null) {
                JButton bouton = new JButton(ingredient.getNom());
                //met le nom du bouton au nom de la carte
                bouton.setName(ingredient.getNom());
                //rend le bouton trensparent
                //bouton.setOpaque(false);
                //bouton.setContentAreaFilled(false);
                bouton.setBorderPainted(false);
                //taille du bouton (a modifier avec des valeurs de icone)!!!
                bouton.setSize(ingredient.getIcone().getLargeur(), ingredient.getIcone().getHauteur());
                //si un icone est defini
                if (ingredient.getIcone().getImage() != null) {
                    try {
                        //ouvre l'image et la met dans le bouton
                        Image img = ImageIO.read(getClass().getResource(ingredient.getIcone().getImage()));
                        //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                        ImageIcon icon = new ImageIcon(getScaledImage(img, ingredient.getIcone().getLargeur(), ingredient.getIcone().getHauteur()));
                        bouton.setIcon(icon);
                    } catch (IOException ex) {
                        Logger.getLogger(PanelJeu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                //met la position du bouton en fonction des attributs de l'icone
                bouton.setLocation((int) (ingredient.getIcone().getX() * this.getWidth()), (int)(ingredient.getIcone().getY() * this.getHeight()));
                
                att2s.add(bouton);
                //set l'action listener
                bouton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (att2 != null) {
                            for (JButton b : att2s) {
                                if (b.getName() == att2) {
                                    b.setBackground(Color.GRAY);
                                }
                            }
                        }

                        att2 = bouton.getName();

                        //renvoyer le nom du bouton pas le texte
                        m.setAtt2(ingredient.getNom());

                        if (m.getAtt1() != null) {
                            System.out.println(m.getAtt1());
                            System.out.println(m.getAtt2());
                            System.out.println("envoyé");
                            observateur.notification(m);
                        }
                        bouton.setBackground(Color.BLUE);
                        //System.out.println("Message envoyé");
                    }
                }
                );
                this.add(bouton);
                // l'ecriture de bouton est sa hauteur suivie de son rayon
                JButton pot = new JButton(String.valueOf(ingredient.getHauteur()) + " - " + String.valueOf(ingredient.getRayon()));
                //son nom est le nom de son ingredient
                pot.setName(ingredient.getNom());
                pot.setSize(100, 100);
                
                att1s.add(pot);
                pot.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       

                            for (JButton b : att1s) {
                                if (b.getName() == att1) {
                                    b.setBackground(Color.GRAY);
                                }
                            
                        }
                         att1 = bouton.getName();
                        
                        m.setAtt1(ingredient.getNom());
                        if (m.getAtt2() != null) {
                            System.out.println(m.getAtt1());
                            System.out.println(m.getAtt2());
                            System.out.println("envoyé");
                            observateur.notification(m);
                        }
                        pot.setBackground(Color.BLUE);
                    }

                });
                
                

            }
            if (ingredient.getNom()!=null){
            JLabel ligne = new JLabel(ingredient.getNom()+" : "+ingredient.getVolIngredient()+" cm3");
            recette.add(ligne);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    private void melange(ArrayList<JButton> boutons){
        Collections.shuffle(boutons);
        float x =(float)0.19;
        for (JButton bouton : boutons){
            bouton.setLocation((int)(this.getWidth()*x),(int) (this.getHeight()*0.15));
            x=x+(float)0.10;
            this.add(bouton);
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

    public void setObservateur(Observateur o) {
        this.observateur = o;
    }

    public void setFond(Enigme e) {
        //met le fond du JPanel
        //met la carte utilisé pour le fond en attribut
        this.carte = e;
        //redessine le jpanel
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        //si l'image est rentrée l'afficher
        if (carte.getFond() != null) {
            try {
                //affiche l'image de la carte
                Image img = ImageIO.read(getClass().getResource(carte.getFond()));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), Color.white, this);
            } catch (IOException ex) {
                Logger.getLogger(PanelJeu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
