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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public PanelJeu(HashMap<String,Lieu> cartes) {
        boutons = new ArrayList<JButton>();
        Dimension dim = this.getSize();
        fond.setSize(dim);
        
        initBoutons(cartes);
        //methode a évolué avec les images
        
        //setFond();
    }

    private void initBoutons(HashMap<String,Lieu> cartes) {
        // crée autant d'objet que dans la liste

        for (String string : cartes.keySet()) {
            JButton bouton = new JButton(string);
            //set le nom du bouton au nom de la carte
            bouton.setName(string);
            //met l'icone de la carte dans le bouton et rend le bouton trensparent
            bouton.setOpaque(false);
            bouton.setContentAreaFilled(false);
            bouton.setBorderPainted(false);
            /*
            try {
                Image img = ImageIO.read(getClass().getResource("images/mondeCuisiniersIcone.png"));
                
                bouton.setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                Logger.getLogger(PanelJeu.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            //set la position du bouton
            //set l'action listener
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    //renvoyer le nom du bouton pas le texte
                    m.setIndice(bouton.getName());
                    observateur.notification(m);
                    System.out.println("Message envoyé");
                }

            }
            );
            boutons.add(bouton);
            fond.add(bouton);

        }

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
    public void setFond(String image){
        //permet de mettre un fond d'écrant
        /*Random rand = new Random();
        // Java 'Color' class takes 3 floats, from 0 to 1.
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        this.setBackground(randomColor);*/
        fond.setIcon(new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(fond.getWidth(), fond.getHeight(), Image.SCALE_DEFAULT)));
        
    }
    //////////////////////////////////////////////
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }
}
