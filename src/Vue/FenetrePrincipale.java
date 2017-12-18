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
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
        boutonMenu();
        //bouton fermer
        boutonFermer();
        //bouton inventaire
        boutonInventaire();
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
        PanelNavigation panel = new PanelNavigation(c, this.getWidth(), this.getHeight());

        if (c.getRetour()) {
            panel.boutonRetour();
        }
        //donne le nom de la carte au panel
        panel.setName(c.getNom());
        panel.setObservateur(this);
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

    //////////////////////////////////////////////
    private void boutonMenu() {
        JButton menu = new JButton();
        /*menu.setLocation(largeur - 100, 0);
        menu.setSize(50, 70);
        menu.setOpaque(false);
        menu.setContentAreaFilled(false);
        menu.setBorderPainted(false);*/
        //menu.setContentAreaFilled(false);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FenetreIntro f = new FenetreIntro();
                f.setVisible(true);
            }

        });
        menu.setFont(new Font("Liberation Sans", 14, 14));

        

        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/menu.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img, 70, 50));
            menu.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelHaut.add(menu, BorderLayout.WEST);
    }

    private void boutonInventaire() {
        JButton inventaire = new JButton();
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/inventaire.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img,70, 70));
            inventaire.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }

    private void boutonFermer() {
        JButton fermer = new JButton();
        fermer.setLocation(0, 0);
        fermer.setSize(100, 100);
        try {
            //ouvre l'image et la met dans le bouton
            Image img = ImageIO.read(getClass().getResource("images/fermer.png"));
            //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
            ImageIcon icon = new ImageIcon(getScaledImage(img,70, 70));
            fermer.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
        }
        fermer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
        fermer.setFont(new Font("Liberation Sans", 14, 14));
        panelHaut.add(fermer, BorderLayout.EAST);
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        //pour redimensionner une image pour un bouton
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
}
