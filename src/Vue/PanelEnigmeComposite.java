/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.Carte;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class PanelEnigmeComposite extends JPanel{
    private JButton boite1;
    private JButton boite2;
    private Observateur observateur;
    private Carte carte;
    private Message m;
    
    public PanelEnigmeComposite(HashMap<String, Carte> cartes) {
        
        creeBoites();
    }
    /////////////////////////////////////////////////////////////////////////////
    private void initBoutons(ArrayList<Ingredient>) {
        // crée autant d'objet que dans la liste
        for (String string : cartes.keySet()) {
            JButton bouton = new JButton(string);
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
                    Logger.getLogger(PanelJeu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //met la position du bouton en fonction des attributs de l'icone
            bouton.setLocation(cartes.get(string).getIcone().getX(), cartes.get(string).getIcone().getY());
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
    ///////////////////////////////////////////////////////////////////////////////////////
    private void creeBoites(){
        boite1=new JButton("boite1");
        boite1.setLocation(this.getWidth()-50, 0);
        boite1.setSize(50, 50);
        this.add(boite1);
        boite2=new JButton("boite2");
        boite2.setLocation(this.getWidth()-50, 100);
        boite2.setSize(50, 50);
        this.add(boite2);
    }
    
}
