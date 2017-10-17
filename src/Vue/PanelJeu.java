/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Léa
 */
public class PanelJeu extends JPanel {

    //attributs
    private Observateur observateur;
    private ArrayList<JButton> boutons;

    /////////////////////////////////////////////////////////////////
    //constructeur
    public PanelJeu(ArrayList<String> s) {
        boutons = new ArrayList<JButton>();
        initBoutons(s);
        setEnvoyerMessage();
        Random rand = new Random();
        // Java 'Color' class takes 3 floats, from 0 to 1.
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        this.setBackground(randomColor);
    }

    private void initBoutons(ArrayList<String> s) {
        // en foction de i la methode crée le nobre de boutons demandé.
        for (String string : s) {
            JButton bouton = new JButton(string);
            boutons.add(bouton);
            this.add(bouton);

        }

    }

    private void setEnvoyerMessage() {
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
    }

    //////////////////////////////////////////////
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }
}
