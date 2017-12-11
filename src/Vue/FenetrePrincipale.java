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
import Modele.EnigmeChampsDeTexte;
import Modele.EnigmeChemin;
import Modele.EnigmeComposite;
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
    int hauteur, largeur;
    private CardLayout cardLayout = new CardLayout();

    public FenetrePrincipale() {
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
        panelHaut.setBackground(Color.WHITE);
        panelHaut.setLayout(new BorderLayout());
        //bouton menu
        JButton menu = new JButton("menu");
        menu.setLocation(largeur - 100, 0);
        menu.setSize(100, 100);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenetreIntro f = new FenetreIntro();
                f.setVisible(true);
            }

        });
        menu.setFont(new Font("Liberation Sans", 14, 14));

        panelHaut.add(menu, BorderLayout.WEST);
        //bouton fermer
        JButton fermer = new JButton("fermer");
        fermer.setLocation(0, 0);
        fermer.setSize(100, 100);
        fermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        fermer.setFont(new Font("Liberation Sans", 14, 14));
        panelHaut.add(fermer, BorderLayout.EAST);
        //bouton inventaire
        JButton inventaire = new JButton("Inventaire");
        inventaire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ouvre une fenetre inventaire
                FenetreInventaire fenetre = new FenetreInventaire();
                fenetre.setVisible(true);
            }

        });
        inventaire.setFont(new Font("Liberation Sans", 14, 14));

        panelHaut.add(inventaire, BorderLayout.CENTER);
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
        PanelNavigation panel = new PanelNavigation(c.getContiens(), this.getWidth(), this.getHeight());

        if (c.getRetour()) {
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
    public void creeVueEnigmeComposite(EnigmeComposite e) {
        PanelEnigmeComposite panel = new PanelEnigmeComposite(e, this.getWidth(), this.getHeight());

        //donne le nom de la carte au panel
        panel.setName(e.getNom());
        panel.setObservateur(this);
        //ajoute et montre le panel
        cardPanel.add(panel, e.getNom());
        cardLayout.show(cardPanel, e.getNom());
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    public void creeVueEnigmeChampsDeTexte(EnigmeChampsDeTexte e) {
        PanelEnigmeCDT panel = new PanelEnigmeCDT(e, this.getWidth(), this.getHeight());

        //donne le nom de la carte au panel
        panel.setName(e.getNom());
        panel.setObservateur(this);
        //ajoute et montre le panel
        cardPanel.add(panel, e.getNom());
        cardLayout.show(cardPanel, e.getNom());
    }

    //////////////////////////////////////////////////////////////////////////////////
    public void creeVueEnigmeChemin(EnigmeChemin e) {
        PanelEnigmeChemin panel = new PanelEnigmeChemin(e, this.getWidth(), this.getHeight());
        //donne le nom de la carte au panel
        panel.setName(e.getNom());
        panel.setObservateur(this);
        //ajoute et montre le panel
        cardPanel.add(panel, e.getNom());
        cardLayout.show(cardPanel, e.getNom());
    }

    ////////////////////////////////////////////////////////////////////////
    public void modifierMessage(String message) {
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
