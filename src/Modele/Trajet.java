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
    public Trajet(float resultat, int nbEtapes, int typeEnigme) {
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
                float nouv=(float)(Math.random()* (resMa +1f - resMi )+resMi);
                resMa=resMa-nouv;
                places.put(i,new Fraction(nouv));
                System.out.println("ipi");
            }
            places.put(i,new Fraction(resMa));
            System.out.println("ipi");
        }
        for(int i=0;i<2;i++){
            
            System.out.println("valeur "+i+" "+this.getPlaces().get(i).getRes());
        }
    }

    public HashMap<Integer,Place> getPlaces() {
        return places;
    }
    
}
//(int) (Math.random() * (MAXHAU + 1 - MINHAU) + MINHAU)
