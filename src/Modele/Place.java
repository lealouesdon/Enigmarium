/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author etien
 */
public abstract class Place {
    private float res;

    public Place(float res) {
        this.res = res;
        
    }

    public float getRes() {
        return res;
    }
    
    public String afficher(){
        return String.valueOf(res);
    }
    
    
    
}
