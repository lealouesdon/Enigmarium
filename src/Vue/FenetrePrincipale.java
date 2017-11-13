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
import Modele.Enigme;
import Modele.EnigmeComposite;
import Modele.Lieu;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetrePrincipale extends JFrame implements Observateur {
    private Observateur observateur;//observateur de la fenetre est controleur
    private JPanel cardPanel, panelHaut;
    //pour le panel haut
    JLabel mascotte, message;
    //attributs pour la taille de l'écrant
    int hauteur,largeur;
    private CardLayout cardLayout = new CardLayout();

    public FenetrePrincipale() {
        setTitle("Enigmarium");
        setResizable(false);
        //initialise la taille de l'écrant
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        largeur = gd.getDisplayMode().getWidth();
        hauteur = gd.getDisplayMode().getHeight();
        setSize(largeur, hauteur);
        //////////////////////////////////////////////
        //panel de cards, situer au centre
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        //positionnement du cardPanel
        add(cardPanel, BorderLayout.CENTER);
        ////////////////////////////////////////////////
        //Panel du haut 
        panelHaut = new JPanel();
        mascotte = new JLabel("masotte");
        mascotte.setBorder(BorderFactory.createLineBorder(Color.black));
        panelHaut.add(mascotte, BorderLayout.WEST);
        message = new JLabel("/////////////////message a modifier//////////////////////");
        message.setBorder(BorderFactory.createLineBorder(Color.black));
        panelHaut.add(message, BorderLayout.CENTER);
        //bouton menu
        JButton menu = new JButton("menu");
        menu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //crée et ouvre une fenetre menu
            }
            
        });
        panelHaut.add(menu);
        JButton fermer = new JButton("fermer");
        fermer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
        panelHaut.add(fermer);
        //positionnement du panelHaut
        add(panelHaut, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);

    }

    ////////////////////////////////////////////////////////////////////////////////////
    public void creeVue(Carte c) {
        //crée un panel a partir d'une carte et l'affiche
        //cree le PanelNavigation avec l'arrayList de cartes de la carte donnée
        PanelNavigation panel = new PanelNavigation(c.getContiens(),this.getWidth(),this.getHeight());
        
        if (c.getRetour()){
            panel.boutonRetour();
        }
        //donne le nom de la carte au panel
        panel.setName(c.getNom());
        panel.setObservateur(this);
        //mettre le fond 
        panel.setFond(c);
        //ajoute et montre le panel
        cardPanel.add(panel, c.getNom());
        cardLayout.show(cardPanel, c.getNom());
    }
    ////////////////////////////////////////////////////////////////////////////////////////
    public void creeVueEnigmeComposite(EnigmeComposite e){
        PanelEnigmeComposite panel = new PanelEnigmeComposite(e,this.getWidth(),this.getHeight());
        
        //donne le nom de la carte au panel
        panel.setName(e.getNom());
        panel.setObservateur(this);     
        //ajoute et montre le panel
        cardPanel.add(panel, e.getNom());
        cardLayout.show(cardPanel, e.getNom());
    }
    /////////////////////////////////////////////////////////////////////////////////////////
    public void modifierMessage(String message){
        //methode pour modifier ce que dit la mascotte
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //methode pour ajuter l'observateur
    public void setObservateur(Observateur o) {
        this.observateur = o;
    }

    //methode de l'observateur
    @Override
    public void notification(Message m) {
        //envoyer le message au controleur
        observateur.notification(m);
    } 
}

