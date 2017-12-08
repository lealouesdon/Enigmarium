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
import java.util.Collections;
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
        this.setSize(largeur, hauteur);
        this.setLayout(null);
        etape = 1;
        this.hauteur = hauteur;
        this.largeur = largeur;
        etapes = new ArrayList();
        enigme = e;
        initEtapes();
        initBoutons();
        affichage();
        selectionnerBouton();
        boutonRetour();
        
    }

    
    private void initBoutons(){
        
        int i;
        for (Trajet trajet : enigme.getTrajets().values()) {
            i = enigme.getNbEtapes();
            
            for (Place place : trajet.getPlaces().values()) {
                JButton bouton = new JButton(((Fraction) place).getFraction());
                
                bouton.setSize(100, 100);
                bouton.setName(String.valueOf(place.getRes()));
                
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
                
                etapes.get(i - 1).add(bouton);
                i--;
                
            }
            
            
        }
    }
    private void affichage(){
        float x = 0.25f;
        float y = 0.25f;
        for (ArrayList<JButton> places : etapes){
            Collections.shuffle(places);
            y = 0.25f;
            for (JButton bouton : places){
                bouton.setLocation((int) (x * largeur), (int) (y * hauteur));
                this.add(bouton);
                y = y + 0.2f;
            }
            x = x + 0.1f;


        }
    }
    private void initEtapes() {
        for (int i = 0; i < enigme.getNbEtapes(); i++) {
            ArrayList<JButton> etape = new ArrayList<JButton>();
            etapes.add(etape);
        }
    }
    
    public void boutonRetour() {
        //met en place tous les boutons sur le Jpanel
        JButton retour = new JButton("retour");
        //taille par défault du bouton
        retour.setSize(70, 70);
        //localisation par défaut du bouton
        retour.setLocation(0, 0);
        //action listener pour retourner "retour" a l'appuye du bouton
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                //renvoyer le nom du bouton pas le texte
                m.setEtat("retour");
                observateur.notification(m);
            }
        }
        );
        //ajouter une image pour le bouton retour!!!
        this.add(retour);
    }

    
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
