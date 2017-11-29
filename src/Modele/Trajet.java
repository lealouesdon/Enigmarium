/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author etien
 */
class Trajet {
    private float resultat;
    private ArrayList<Place> places; 
    Trajet(float resultat, int nbEtapes, int typeEnigme) {
       this.resultat=resultat;
       initialyserTrajet(nbEtapes,typeEnigme);
    }

    private void initialyserTrajet(int nbEtapes, int typeEnigme) {
        if(typeEnigme==1){
            
            for(int i=0;i<nbEtapes;i++){
                places.add(e);
            }
        }
    }
    
}
