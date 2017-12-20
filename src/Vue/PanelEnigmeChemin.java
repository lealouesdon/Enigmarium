/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.EnigmeChemin;
import Modele.Place;
import java.util.ArrayList;
import javax.swing.JPanel;
import Modele.Trajet;
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
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Léa
 */
public class PanelEnigmeChemin extends JPanel {

    private Observateur observateur;
    private ArrayList<ArrayList<JButton>> etapes;
    private EnigmeChemin enigme;
    private int largeur;
    private int hauteur;
    private int etape;
    private Message message;

    public PanelEnigmeChemin(EnigmeChemin e, int largeur, int hauteur) {
        message = new Message();
        message.setEtat("MessageChemin");
        this.setSize(largeur, hauteur);
        this.setLayout(null);
        etape = 1;
        this.hauteur = hauteur;
        this.largeur = largeur;
        etapes = new ArrayList();
        enigme = e;
        initEtapes();
        initBoutons();
        affichage();
        selectionnerBouton();
        afficherResultat();
        boutonRetour();
        indice();

    }
////////////////////////////////////////////////////////////////
    private void initBoutons() {
        //initialise les boutons de la vue
        int i;
        for (Trajet trajet : enigme.getTrajets().values()) {
            i = enigme.getNbEtapes();

            for (Place place : trajet.getPlaces().values()) {
                JButton bouton = new JButton(place.afficher());
                bouton.setBorderPainted(false);
                bouton.setSize(150, 75);
                bouton.setName(String.valueOf(place.getRes()));
                bouton.setFont(new Font("Liberation Sans", 14, 14));

                bouton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        message.addFraction(Float.parseFloat(bouton.getName()));
                        if (etape == enigme.getNbEtapes()) {
                            observateur.notification(message);

                        } else {
                            etape++;
                            selectionnerBouton();
                        }
                    }
                });

                etapes.get(i - 1).add(bouton);
                i--;

            }

        }
    }
//////////////////////////////////////////////////////////////
    private void affichage() {
        //affiche les boutons de la vue aléatoirement
        float x = 0.50f;
        int i = 1;
        float y = 0.65f;
        for (ArrayList<JButton> places : etapes) {
            Collections.shuffle(places);
            if (i==1){
                x = 0.72f;
            }else {
                x = 0.60f;
            }
            
            for (JButton bouton : places) {
                bouton.setLocation((int) (x * largeur), (int) (y * hauteur));
                this.add(bouton);
                x = x - 0.28f;
            }
            y = y - 0.2f;
            if (i==1){
                i=2;
            }else {
                i=1;
            }

        }
    }
///////////////////////////////////////////////////////////////////
    private void initEtapes() {
        //initialise les arraylist en fonction du nombre d'étapes
        for (int i = 0; i < enigme.getNbEtapes(); i++) {
            ArrayList<JButton> etape = new ArrayList<JButton>();
            etapes.add(etape);
        }
    }
/////////////////////////////////////////////////////////////////
    private void afficherResultat() {
        //affiche l'énoncé de l'énigme
        JLabel enonce = new JLabel(enigme.getEnonce());
        enonce.setSize(250, 100);
        enonce.setLocation((int) (0.4 * largeur), (int) (0 * hauteur));
        enonce.setFont(new Font("Liberation Sans", 14, 14));
        this.add(enonce);
    }
/////////////////////////////////////////////////////////////////////////
    public void boutonRetour() {
        //affiche le bouton retour du jeu
        //met en place tous les boutons sur le Jpanel
        JButton retour = new JButton("retour");
        //taille par défault du bouton
        retour.setSize(100, 100);
        retour.setContentAreaFilled(false);
        retour.setBorderPainted(false);
        retour.setFont(new Font("Liberation Sans", 14, 14));
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/retour.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img,100, 100));
            retour.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        //localisation par défaut du bouton
        retour.setLocation(0, 0);
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
//////////////////////////////////////////////////////
    private void selectionnerBouton() {
        //permet de séléctionner l'étape courante
        //selectionner et deselectionner les boutons en fonction de l'étape
        for (ArrayList<JButton> places : etapes) {
            for (JButton bouton : places) {
                bouton.setEnabled(false);
            }
        }
        //selectionne le bon : 
        for (JButton bouton : etapes.get(etape - 1)) {
            bouton.setEnabled(true);
        }

    }
//////////////////////////////////////////////////////////////
    private void indice() {
        //permet d'afficher l'indice, si il y en a un
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
//////////////////////////////////////////////////////////////////////
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
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

}
