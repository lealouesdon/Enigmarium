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
    private static float MIN = 0.1f;
    private static float MAX = 10f;
    private float x;
    
    public Resultat(String nom, Icone icone,float x) {
        super(nom, icone);
        this.x=x;
    }
    public Resultat(String nom, Icone icone) {
        super(nom, icone);
        this.x=(int)(Math.random() * (MAX + 1 - MIN) + MIN);
    }

    @Override
    public String affichage() {
        return String.valueOf(x);
    }
    
}
