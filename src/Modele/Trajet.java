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
public class Trajet {
    private float resultat;
    private ArrayList<Place> places; 
    public Trajet(float resultat, int nbEtapes, int typeEnigme) {
       this.resultat=resultat;
       this.places=new ArrayList();
       initialyserTrajet(nbEtapes,typeEnigme);
    }

    private void initialyserTrajet(int nbEtapes, int typeEnigme) {
        if(typeEnigme==1){//si on a afair a l'enigme des fraction de lasVegas
            //cree le bon nombre le trajet avec le bon nombre d'etape 
            //en repartissant le resultat de facon a sse que les fraction soit bonne
            float resMa=resultat;
            float interval=((int)((resMa/nbEtapes)*100))/100f;
            float resMi=interval/2;
            int i=0;
            for(;i<nbEtapes-1;i++){
                float nouv=(float)(Math.random() * ( interval*100+ 1 -resMi*100 ) + resMi*100);
                int nouv2=(int) nouv;
                nouv= (float)(nouv2/100f);
                resMa=resMa-nouv;
                places.add(new Fraction(nouv));
            }
            float derniere = (int)(resMa*100)/100f;
            places.add(new Fraction(derniere));
        }
    }
 
    public ArrayList<Place> getPlaces() {
        return places;
    }
    
}
