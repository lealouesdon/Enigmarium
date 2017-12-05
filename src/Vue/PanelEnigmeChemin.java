/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observateur;
import Modele.EnigmeChemin;
import Modele.Fraction;
import Modele.Place;
import java.util.ArrayList;
import javax.swing.JPanel;
import Modele.Trajet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Léa
 */
public class PanelEnigmeChemin extends JPanel {

    private Observateur observateur;  
    private ArrayList<ArrayList<JButton>> etapes;
    private EnigmeChemin enigme;
    private int largeur;
    private int hauteur;
    private int etape;
    private Message message;

    public PanelEnigmeChemin(EnigmeChemin e, int largeur, int hauteur) {
        message = new Message();
        message.setEtat("MessageChemin");
        etape = 1;
        this.setSize(largeur, hauteur);
        this.hauteur = hauteur;
        this.largeur = largeur;
        etapes = new ArrayList();
        enigme = e;
        initEtapes();
        initBoutons();
        selectionnerBouton();
    }

    
    private void initBoutons(){
        float x = 0.25f;
        float y = 0.25f;
        int i;
        for (Trajet trajet : enigme.getTrajets().values()) {
            i = enigme.getNbEtapes();
            x = 0.25f;
            for (Place place : trajet.getPlaces().values()) {
                JButton bouton = new JButton(((Fraction) place).getFraction());
                bouton.setLocation((int) x * largeur, (int) y * hauteur);
                bouton.setSize(100, 100);
                bouton.setName(String.valueOf(place.getRes()));
                x = x + 0.1f;
                bouton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        message.addFraction(Float.parseFloat(bouton.getName()));    
                        if (etape == enigme.getNbEtapes()) {
                            observateur.notification(message);
                            
                        } else {
                            etape++;
                            selectionnerBouton();
                        }
                    }
                });
                this.add(bouton);
                etapes.get(i - 1).add(bouton);
                i--;
            }
            y = y + 0.2f;
        }
    }
    private void initEtapes() {
        for (int i = 0; i < enigme.getNbEtapes(); i++) {
            ArrayList<JButton> etape = new ArrayList<JButton>();
            etapes.add(etape);
        }
    }

    /*private void initPanel() {
        //pour le positionnement
        float x = 0.25f;
        float y = 0.25f;
        int i;
        
        for (ArrayList<Place> places : etapes) {
            x = 0.25f;
            for (Place place : places) {
                JButton bouton = new JButton(((Fraction) place).getFraction());
                bouton.setLocation((int) x * largeur, (int) y * hauteur);
                bouton.setSize(100, 100);
                bouton.setName(String.valueOf(place.getRes()));
                x = x + 0.1f;
                bouton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        message.addFraction(Float.parseFloat(bouton.getName()));
                        if (etape == enigme.getNbEtapes()) {
                            observateur.notification(message);
                        } else {
                            etape++;
                            selectionnerBouton();
                        }
                    }
                });
                this.add(bouton);
            }
            y = y + 0.2f;
        }
    }*/
    
    private void selectionnerBouton(){
        //selectionner et deselectionner les boutons en fonction de l'étape
        for (ArrayList<JButton> places : etapes){
            for (JButton bouton : places){
                bouton.setEnabled(false);
            }
        }
        //selectionne le bon : 
        for (JButton bouton : etapes.get(etape-1)){
            bouton.setEnabled(true);
        }
        
    }
    

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }

}
