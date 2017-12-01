/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

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
    private ArrayList<ArrayList<Place>> etapes;
    private EnigmeChemin enigme;
    private int largeur;
    private int hauteur;

    public PanelEnigmeChemin(EnigmeChemin e, int largeur, int hauteur) {
        this.setSize(largeur, hauteur);
        this.hauteur=hauteur;
        this.largeur=largeur;
        etapes = new ArrayList();
        enigme = e;
        initEtapes();
        initPanel();
    }

    private void initEtapes(){
        for(int i=0; i<enigme.getNbEtapes();i++){
            ArrayList<Place> etape = new ArrayList<Place>();
            etapes.add(etape);
        }
    }
    private void initPanel() {
        //pour le positionnement
        float x=0.25f;
        float y=0.25f;
        int i;
        for (Trajet trajet : enigme.getTrajets()) {
            i=enigme.getNbEtapes();
            for(Place place : trajet.getPlaces()){
                etapes.get(i-1).add(place);
                i--;
            }
        }
        for (ArrayList<Place> places : etapes){
            x=0.25f;
            for (Place place : places){
                JButton bouton = new JButton(((Fraction)place).getFraction());
                bouton.setLocation((int)x*largeur, (int)y*hauteur);
                bouton.setSize(100, 100);
                //bouton.setName();
                x=x+0.1f;
                bouton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                    
                });
                this.add(bouton);
            }
            y=y+0.2f;
        }
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }

}
