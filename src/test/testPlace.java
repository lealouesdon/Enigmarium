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
        for(int i=0;i<10;i++){
            System.out.println(((int)((float)(Math.random()* (66f +1f - 33f )+33f)*10))/10f);
        }
    }
    
}
