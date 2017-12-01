/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author etien
 */
public class Trajet {
    private float resultat;
    private HashMap<Integer,Place> places; 
    Trajet(float resultat, int nbEtapes, int typeEnigme) {
       this.resultat=resultat;
       this.places=new HashMap();
       initialyserTrajet(nbEtapes,typeEnigme);
    }

    private void initialyserTrajet(int nbEtapes, int typeEnigme) {
        if(typeEnigme==1){
            float resMa=resultat;
            float resMi=0;
            int i=0;
            for(;i<nbEtapes-1;i++){
                float tier=(resMi+resMa)/(2/3);
                float nouv=(float)Math.random()* (tier +1f - resMi )+resMi;
                resMa=resMa-nouv;
                places.put(i,new Fraction(nouv));
            }
            places.put(i+1,new Fraction(resMa));
        }
    }

    public HashMap<Integer,Place> getPlaces() {
        return places;
    }
    
}
//(int) (Math.random() * (MAXHAU + 1 - MINHAU) + MINHAU)
