/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.Carte;
import Modele.Lieu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Léa
 */
public class PanelNavigation extends JPanel {

    //attributs
    private Observateur observateur;
    private Lieu carte;
    private Message m;
    private FenetreInfoPerso fInfo;

    /////////////////////////////////////////////////////////////////
    //constructeur
    public PanelNavigation(Carte carte, int largeur, int hauteur) {
        this.setLayout(null);
        this.setSize(largeur, hauteur);
        this.carte = carte;
        setFond();
        //cree les boutons
        this.repaint();
        initBoutons(carte.getContiens());
        if (carte.getRetour()) {
            boutonRetour();
        }

    }
//////////////////////////////////////////////////////////////////////////////

    private void initBoutons(HashMap<String, Lieu> cartes) {
        // crée autant d'objet que dans la liste
        for (String string : cartes.keySet()) {
            JButton bouton = new JButton();
            //met le nom du bouton au nom de la carte
            bouton.setName(string);
            //donne le bon aspect au bouton
            bouton.setOpaque(false);
            bouton.setContentAreaFilled(false);
            bouton.setBorderPainted(false);
            //taille du bouton (a modifier avec des valeurs de icone)!!!
            bouton.setSize(cartes.get(string).getIcone().getLargeur(), cartes.get(string).getIcone().getHauteur());
            //si un icone est defini
            if (cartes.get(string).getIcone().getImage() != null) {
                try {
                    //ouvre l'image et la met dans le bouton
                    Image img = ImageIO.read(getClass().getResource(cartes.get(string).getIcone().getImage()));
                    //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                    ImageIcon icon = new ImageIcon(getScaledImage(img, cartes.get(string).getIcone().getLargeur(), cartes.get(string).getIcone().getHauteur()));
                    bouton.setIcon(icon);
                } catch (IOException ex) {
                    Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //met la position du bouton en fonction des attributs de l'icone
            bouton.setLocation((int) (cartes.get(string).getIcone().getX() * this.getWidth()), (int) (cartes.get(string).getIcone().getY() * this.getHeight()));
            //set l'action listener
            //FenetreInfoPerso fInfo;
            String nom = cartes.get(string).getNom();
            bouton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    m = new Message();
                    //renvoyer le nom du bouton pas le texte
                    m.setMessage(cartes.get(string).getNom());
                    m.setEtat("carteChoisi");
                    observateur.notification(m);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (cartes.get(string).getDescriptif() != null) {
                        fInfo = new FenetreInfoPerso(nom, cartes.get(string).getDescriptif());
                        fInfo.setVisible(true);
                    } else {
                        fInfo = new FenetreInfoPerso(nom);
                        fInfo.setVisible(true);
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    fInfo.dispose();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    bouton.setBorderPainted(true);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    bouton.setBorderPainted(false);
                }

            });

            this.add(bouton);
        }
    }
//////////////////////////////////////////////////////////////////////////////////////////

    public void boutonRetour() {
        //met en place tous les boutons sur le Jpanel
        JButton retour = new JButton("retour");
        //taille par défault du bouton
        retour.setSize(100, 100);
        retour.setFont(new Font("Liberation Sans", 14, 14));
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);

        //localisation par défaut du bouton
        retour.setLocation(0, 0);
        //action listener pour retourner "retour" a l'appuye du bouton

        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/retour.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 100, 100));
            retour.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        retour.setLocation(0, 0);

        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m = new Message();
                //renvoyer le nom du bouton pas le texte
                m.setEtat("retour");
                observateur.notification(m);
            }
        }
        );
        //ajouter une image pour le bouton retour!!!
        this.add(retour);
    }

    //////////////////////////////////////////////7
    private void setFond() {
        //redessine le jpanel
        this.repaint();
    }

    //////////////////////////////////////////////
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }

    /////////////////////////////////////////////
    private Image getScaledImage(Image srcImg, int w, int h) {
        //pour redimensionner une image pour un bouton
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
/////////////////////////////////////////////////////////////

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        //si l'image est rentrée l'afficher
        String fond = carte.getFond();
        if (carte.getFond() != null) {
            try {
                //affiche l'image de la carte
                Image img = ImageIO.read(getClass().getResource(carte.getFond()));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), Color.white, this);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
