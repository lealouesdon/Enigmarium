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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import static javax.sound.sampled.Clip.LOOP_CONTINUOUSLY;
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
    private Carte carte;
    private Message m;
    private String son;

    /////////////////////////////////////////////////////////////////
    //constructeur
    public PanelNavigation(Carte carte, int largeur, int hauteur) {
        this.setLayout(null);
        this.setSize(largeur, hauteur);
        this.carte=carte;
        setFond();
        //cree les boutons
        this.repaint();
        initBoutons(carte.getContiens());
        //son=carte.getSon();
        //if (son!=null){
        //File sonDeFond= new File(son);
        //PlaySound(sonDeFond);
        
    }
//////////////////////////////////////////////////////////////////////////////

    private void initBoutons(HashMap<String, Lieu> cartes) {
        // crée autant d'objet que dans la liste
        for (String string : cartes.keySet()) {
            JButton bouton = new JButton();
            //met le nom du bouton au nom de la carte
            bouton.setName(string);
            //rend le bouton trensparent
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
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    m = new Message();
                    //renvoyer le nom du bouton pas le texte
                    m.setMessage(cartes.get(string).getNom());
                    m.setEtat("carteChoisi");
                    observateur.notification(m);
                    //System.out.println("Message envoyé");
                }

            }
            );
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

        //localisation par défaut du bouton
        retour.setLocation(0, 0);
        //action listener pour retourner "retour" a l'appuye du bouton

        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/retour.jpg"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img,100, 100));
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
    ///////////////////////////////////////////////////////
    static void PlaySound(File sound){
        try{
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            clip.loop(LOOP_CONTINUOUSLY);
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
