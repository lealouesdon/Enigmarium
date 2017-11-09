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
public class Ingredient extends Element {

    private float volIngredient;

    public Ingredient(String nom, Icone icone, float volIngredient) {
        super(nom, icone);
        this.volIngredient = volIngredient;
    }

    public float getVolIngredient() {
        return volIngredient;
    }
    /*public void afficherIngre(){
        System.out.println(getVolIngredient()+"cm3 de"+getNom()+"dans un pot de "+getRayon()+"  "+getHauteur());   
    }*/

    @Override
    public String affichage() {
        return "";
    }

}
