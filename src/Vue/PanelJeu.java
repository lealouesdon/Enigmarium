/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.Lieu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Léa
 */
public class PanelJeu extends JPanel {

    //attributs
    private Observateur observateur;
    private ArrayList<JButton> boutons;
    private JLabel fond;

    /////////////////////////////////////////////////////////////////
    //constructeur
    public PanelJeu(HashMap<String, Lieu> cartes) {
        this.setLayout(null);
        boutons = new ArrayList<JButton>();
        Dimension dim = this.getSize();
        fond = new JLabel();
        fond.setSize(dim);
        initBoutons(cartes);
        
        //methode a évolué avec les images

        //setFond();
    }

    private void initBoutons(HashMap<String, Lieu> cartes) {
        // crée autant d'objet que dans la liste

        for (String string : cartes.keySet()) {
            JButton bouton = new JButton(string);
            //set le nom du bouton au nom de la carte
            bouton.setName(string);
            //met l'icone de la carte dans le bouton et rend le bouton trensparent
            bouton.setOpaque(false);
            bouton.setContentAreaFilled(false);
            bouton.setBorderPainted(false);
            bouton.setSize(350, 400);
            
            //si u icone est set
            if (cartes.get(string).getIcone().getImage()!=null){
                try {
                    //ouvre l'image et la met dans le bouton
                Image img = ImageIO.read(getClass().getResource(cartes.get(string).getIcone().getImage()));
                ImageIcon icon=new ImageIcon(getScaledImage(img,350,400));
                
                bouton.setIcon(icon);
                } catch (IOException ex) {
                Logger.getLogger(PanelJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //set la position du bouton
            bouton.setLocation(cartes.get(string).getIcone().getX(),cartes.get(string).getIcone().getY());
            //set l'action listener
            //bouton.setIcon(new ImageIcon(new ImageIcon("images/mondeCuisiniersIcone.png").getImage().getScaledInstance(bouton.getWidth(), bouton.getHeight(), Image.SCALE_DEFAULT)));
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    //renvoyer le nom du bouton pas le texte
                    m.setIndice(cartes.get(string).getNom());
                    m.setEtat("carteChoisi");
                    observateur.notification(m);
                    //System.out.println("Message envoyé");
                }

            }
            );
            boutons.add(bouton);
            this.add(bouton);

        }
        

    }
    public void boutonRetour(){
        
        JButton retour = new JButton("retour");
        retour.setSize(70, 70);
        retour.setLocation(0, 0);
        retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    //renvoyer le nom du bouton pas le texte
                    m.setEtat("retour");
                    observateur.notification(m);
                    //System.out.println("Message envoyé");
                }

            }
            );
        //manque la position et l'image du bouton
        this.add(retour);
    }
    //methode inutile car faite dans initBoutons
    /*private void setEnvoyerMessage() {
        //avec le vecteur de boutons initialisé permet de faire les action listener et envoyer le message a l'observateur
        for (JButton bouton : boutons) {
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.setIndice(bouton.getText());
                    observateur.notification(m);
                    System.out.println("Message envoyé");
                }

            }
            );
        }
    }*/
    //////////////////////////////////////////////7
    public void setFond() {
        //permet de mettre un fond d'écrant
        Random rand = new Random();
        // Java 'Color' class takes 3 floats, from 0 to 1.
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        this.setBackground(randomColor);
        //fond.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(fond.getWidth(), fond.getHeight(), Image.SCALE_DEFAULT)));

    }

    //////////////////////////////////////////////
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }
    /////////////////////////////////////////////
    private Image getScaledImage(Image srcImg, int w, int h){
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();

    return resizedImg;
}
}
