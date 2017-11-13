/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Léa
 */
public class Resultat extends Element{

    private float x;
    
    public Resultat(String nom, Icone icone,float x) {
        super(nom, icone);
        this.x=x;
    }

    @Override
    public String affichage() {
        return String.valueOf(x);
    }
    
}
