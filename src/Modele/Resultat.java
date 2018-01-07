/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author Léa
 */
public class Resultat extends Element{
    private static float MIN = 0.1f;
    private static float MAX = 10f;
    private float x;
    
    public Resultat(String nom, Icone icone,float x) {
        super(nom, icone);
        this.x=x;
    }
    public Resultat(String nom, Icone icone,ArrayList resultat) {
        super(nom, icone);
        boolean existDeja =true;
        while(existDeja){
            existDeja=false;
           this.x = (int) (Math.random() * (MAX + 1 - MIN) + MIN);
           for(int i = 0;i<resultat.size();i++){
               if((float)resultat.get(i)==this.x){
                   existDeja=true;
               }
           }
        }
    }

    @Override
    public String affichage() {
        return String.valueOf(x);
    }
    
}
