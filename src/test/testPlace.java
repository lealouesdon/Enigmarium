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
        Trajet trajet=new Trajet(1f,3,1);
        for(int i=0;i<2;i++){
            System.out.println("valeur "+i+" "+trajet.getPlaces().get(i).getRes());
        }
        /*Fraction place=new Fraction(1.26f);
        System.out.print(place.getFraction());*/
    }
    
}
