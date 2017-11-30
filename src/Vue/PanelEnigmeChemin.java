/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Observateur;
import Modele.EnigmeChemin;
import Modele.Place;
import java.util.ArrayList;
import javax.swing.JPanel;
import Modele.Trajet;

/**
 *
 * @author Léa
 */
public class PanelEnigmeChemin extends JPanel {

    private Observateur observateur;
    private ArrayList<ArrayList<Place>> etapes;
    private EnigmeChemin enigme;

    public PanelEnigmeChemin(EnigmeChemin e, int largeur, int hauteur) {
        this.setSize(largeur, hauteur);
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
        int x;
        int y;
        for (Trajet trajet : enigme.getTrajets()) {
            for(int i=0; i<enigme.getNbEtapes();i++){
                
            }
        }
    }

    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }

}
