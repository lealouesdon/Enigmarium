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
            float interval=((int)((resMa/nbEtapes)*100))/100f;
            float resMi=interval/2;
            int i=0;
            for(;i<nbEtapes-1;i++){
                float nouv=(float)(Math.random() * ( interval*100+ 1 -resMi*100 ) + resMi*100);
                int nouv2=(int) nouv;
                nouv= (float)(nouv2/100f);

                resMa=resMa-nouv;
                
                places.put(i,new Fraction(nouv));
            }
            
            places.put(i,new Fraction(resMa));
        }
    }

    public HashMap<Integer,Place> getPlaces() {
        return places;
    }
    
}
//(int) (Math.random() * (MAXHAU + 1 - MINHAU) + MINHAU)
/*
if(typeEnigme==1){
            float resMa=resultat;
            float resMi=0;
            int i=0;
            for(;i<nbEtapes-1;i++){
                float nouv=(float)(Math.random()* (resMa +1f - resMi )+resMi);
                nouv=((int)(nouv*100))/100f;
                resMa=resMa-nouv;
                places.put(i,new Fraction(nouv));
            }
            places.put(i,new Fraction(resMa));
        }
    }
*/
//(float)(Math.random()* (interval +1f - interval/2f )+interval/2f)
//((int)((float)(Math.random()* (0.33 +1f - 0.33/2f )+0.33/2f)*10))/10f;