/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author Léa
 */
import Controleur.Message;
import Controleur.Observateur;
import Modele.Carte;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javafx.scene.layout.Border;
import javax.swing.*;

public class FenetrePrincipale extends JFrame implements Observateur {

    //modifier les attributs!!
    private Observateur observateur;//observateur de la fenetre est controleur
    private static final long serialVersionUID = 1L;
    private JPanel cardPanel, panelHaut;
    //faire un vecteur de PanelJeu
    private PanelJeu jp1, jp2;
    //pour le panel haut
    JLabel mascotte, message;
    //attributs pour la taille de l'écrant
    int hauteur,largeur;
    private CardLayout cardLayout = new CardLayout();

    public FenetrePrincipale() {
        setTitle("Enigmarium");
        //initialise la taille de l'écrant
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        largeur = gd.getDisplayMode().getWidth();
        hauteur = gd.getDisplayMode().getHeight();
        setSize(largeur, hauteur);

        //////////////////////////////////////////////
        //panel de cards, situer au centre
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        //panel 1
        //exemple d'utilisation
        //arrayList qui sera replacé par une carte et l'appel de la fonction creeVue
        ArrayList<String> noms = new ArrayList<String>();
        noms.add("Univers");
        noms.add("Monde1");
        jp1 = new PanelJeu(noms);
        jp1.setObservateur(this);
        //panel 2
        jp2 = new PanelJeu(noms);
        jp2.setObservateur(this);
        //ajout de la carte 1 au panel
        cardPanel.add(jp1, "Univers");
        //ajout de la cartye 2 au panel
        cardPanel.add(jp2, "Monde1");
        //positionnement du cardPanel
        add(cardPanel, BorderLayout.CENTER);
        ////////////////////////////////////////////////
        //Panel du haut //faire une nouvelle classe?
        panelHaut = new JPanel();
        mascotte = new JLabel("masotte");
        mascotte.setBorder(BorderFactory.createLineBorder(Color.black));
        panelHaut.add(mascotte, BorderLayout.WEST);
        message = new JLabel("message a modifier");
        message.setBorder(BorderFactory.createLineBorder(Color.black));
        panelHaut.add(message, BorderLayout.CENTER);

        //positionnement du panelHaut
        add(panelHaut, BorderLayout.NORTH);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public void creeVue(Carte c) {
        //crée un panel a partir d'une carte et l'affiche
        
        //cree le PanelJeu avec l'arrayList de cartes de la carte donnée
        //mettre le fond 
        //setFond
        
        
        
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void message(String message){
        //methode pour modifier ce que dit la mascotte
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //main pour les test
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                FenetrePrincipale frame = new FenetrePrincipale();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //methode pour ajuter l'observateur
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }

    //methode de l'observateur
    @Override
    public void notification(Message m) {
        String s = m.getIndice();
        cardLayout.show(cardPanel, s);
    }

}




//elle est observé par controleur et elle observe ses panels
