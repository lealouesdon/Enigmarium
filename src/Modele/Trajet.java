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
            float resMa=resultat;
            float resMi=0;
            for(int i=0;i<nbEtapes-1;i++){
                float tier=(resMi+resMa)/(2/3);
                float nouv=(float)Math.random()* (tier +1f - resMi )+resMi;
                resMa=resMa-nouv;
                places.add(new Fraction(nouv));
            }
            places.add(new Fraction(resMa));
        }
    }
    
}
//(int) (Math.random() * (MAXHAU + 1 - MINHAU) + MINHAU)