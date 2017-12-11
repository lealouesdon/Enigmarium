/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.Composition;
import Modele.Element;
import Modele.EnigmeComposite;
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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Léa
 */
public class PanelEnigmeComposite extends JPanel {

    private String att1;
    private String att2;
    private Observateur observateur;
    private EnigmeComposite carte;
    private Message m;
    private ArrayList<JButton> att1s, att2s;
    private JPanel enonce;

    public PanelEnigmeComposite(EnigmeComposite e, int largeur, int hauteur) {
        this.carte = e;
        this.setSize(largeur, hauteur);
        m = new Message();
        m.setAtt1(null);
        m.setAtt2(null);
        m.setEtat("MessageComposite");
        att1 = null;
        att2 = null;
        att1s = new ArrayList<JButton>();
        att2s = new ArrayList<JButton>();
        this.setLayout(null);
        ///////////ENONCE///////////////////
        enonce = new JPanel();
        enonce.setSize(200, 100);
        enonce.setOpaque(false);
        enonce.setLocation((int) (this.getWidth() * 0.43), (int) (this.getHeight() * 0.65));
        enonce.setLayout(new BoxLayout(enonce, BoxLayout.Y_AXIS));
        creeEnonce();
        this.add(enonce);
        ///////////////////Compositions////////////////////////////
        initBoutons(e.getCompositions());
        //////////////////////////Indice///////////////////////////////
        indice();
        repaint();
        /////////////////////Retour//////////////////
        if (e.getRetour()) {
            boutonRetour();
        }

    }

    /////////////////////////////////////////////////////////////////////////////
    private void initBoutons(ArrayList<Composition> compositions) {
        // crée autant d'objet que dans la liste

        for (Composition composition : compositions) {
            //if (composition.getNom() != null) {
            if (composition.getElem1() != null) {
                JButton attribut1 = afficherElem(composition.getElem1());
                defBoutonAtt1(attribut1);
                this.add(attribut1);
            }
            if (composition.getElem2() != null) {
                JButton attribut2 = afficherElem(composition.getElem2());
                defBoutonAtt2(attribut2);
                this.add(attribut2);

            }
        }

    }

    private JButton afficherElem(Element elem) {
        JButton bouton = new JButton();
        //met le nom du bouton au nom de la carte
        bouton.setName(elem.getNom());
        //rend le bouton trensparent
        bouton.setBackground(Color.LIGHT_GRAY);
        //bouton.setOpaque(false);
        //bouton.setContentAreaFilled(false);
        bouton.setBorderPainted(false);
        //taille du bouton (a modifier avec des valeurs de icone)!!!
        bouton.setSize(elem.getIcone().getLargeur(), elem.getIcone().getHauteur());
        //si un icone est defini
        if (elem.getIcone().getImage() != null) {
            try {
                //ouvre l'image et la met dans le bouton
                Image img = ImageIO.read(getClass().getResource(elem.getIcone().getImage()));
                //redimensionement de l'image(taille a modifier en fonction des attributs de l'icone
                ImageIcon icon = new ImageIcon(getScaledImage(img, elem.getIcone().getLargeur(), elem.getIcone().getHauteur()));
                bouton.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(PanelNavigation.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //met la position du bouton en fonction des attributs de l'icone
        bouton.setLocation((int) (elem.getIcone().getX() * this.getWidth()), (int) (elem.getIcone().getY() * this.getHeight()));
        //met le text du bouton
        bouton.setVerticalTextPosition(SwingConstants.CENTER);
        bouton.setHorizontalTextPosition(SwingConstants.CENTER);
        bouton.setText(elem.affichage());
        bouton.setFont(new Font("Liberation Sans", 14, 14));

        return bouton;
    }

    private void defBoutonAtt1(JButton bouton) {
        att1s.add(bouton);
        //set l'action listener
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton b : att1s) {
                    if (b.getName() == att1) {
                        b.setBackground(Color.GRAY);
                    }
                }
                att1 = bouton.getName();

                //renvoyer le nom du bouton pas le texte
                m.setAtt1(bouton.getName());

                if (m.getAtt2() != null) {

                    observateur.notification(m);
                }
                bouton.setBackground(Color.BLUE);
            }
        }
        );
    }

    private void defBoutonAtt2(JButton bouton) {
        att2s.add(bouton);
        //set l'action listener
        bouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton b : att2s) {
                    if (b.getName() == att2) {
                        b.setBackground(Color.GRAY);
                    }
                }
                att2 = bouton.getName();

                //renvoyer le nom du bouton pas le texte
                m.setAtt2(bouton.getName());

                if (m.getAtt1() != null) {

                    observateur.notification(m);
                }
                bouton.setBackground(Color.BLUE);
            }
        }
        );
    }

    private void creeEnonce() {
        for (String ligne : carte.getDescription()) {
            JLabel label = new JLabel(ligne);
            enonce.add(label);
        }
    }

    public void boutonRetour() {
        //met en place tous les boutons sur le Jpanel
        JButton retour = new JButton("retour");
        //taille par défault du bouton
        retour.setSize(100, 100);
        //localisation par défaut du bouton
        retour.setLocation(0, 0);
        //action listener pour retourner "retour" a l'appuye du bouton
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
        
        retour.setFont(new Font("Liberation Sans", 14, 14));

        this.add(retour);
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
/////////////////////////////////////////////////////////////////////////////////////////////

    private void indice() {
        if (carte.getIndice() != null) {
            JButton indice = new JButton("indice");
            indice.setFont(new Font("Liberation Sans", 14, 14));

            indice.setSize(100, 100);
            indice.setLocation(this.getWidth() - 100, 0);
            indice.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    FenetreIndice ind = new FenetreIndice();
                    ind.setIndice(carte.getIndice());
                    ind.setVisible(true);
                }

            });
            this.add(indice);
        }
    }

    public void setObservateur(Observateur o) {
        this.observateur = o;
    }

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
}
