/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Modele.Fraction;
import Modele.Trajet;


/**
 *
 * @author etien
 */
public class testPlace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Trajet trajet=new Trajet(1f,3,1);
        for(int i=0;i<3;i++){
            System.out.println("valeur "+i+" "+trajet.getPlaces().get(i).getRes());
        }*/
        /*float i= ((int)((float)(Math.random()* (0.33 +1f - 0f )+0f)*10))/10f;
        Fraction place=new Fraction(i);
        System.out.println(i);
        System.out.println(place.getFraction());
        System.out.println(place.getRes());*/
        for(int i=0;i<10;i++){
            System.out.println(((int)((float)(Math.random()* (66f +1f - 33f )+33f)*10))/10f);
        }
    }
    
}
