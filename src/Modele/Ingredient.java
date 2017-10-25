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
public class Ingredient {
    private static int MINRAY=1;
    private static int MAXRAY=7;
    private static int MINHAU=4;
    private static int MAXHAU=15;
    private float volIngredient;
    private String nom;
    private int rayon;
    private int hauteur;
    
    public Ingredient(String nom){
        this.rayon=(int)(Math.random()*(MAXRAY+1-MINRAY) + MINRAY);
        this.nom=nom;
        this.hauteur=(int)(Math.random()*(MAXHAU+1-MINHAU) + MINHAU);
        this.volIngredient=3.14f*(getHauteur()*getRayon()*getRayon());
        afficherIngre();
    }

    public String getNom() {
        return nom;
    }

    public int getHauteur() {
        return hauteur;
    }
    

    public int getRayon() {
        return rayon;
    }

    public float getVolIngredient() {
        return volIngredient;
    }
    public void afficherIngre(){
        System.out.println(getVolIngredient()+"cm3 de"+getNom()+"dans un pot de "+getRayon()+"  "+getHauteur());
        
        
    }
}
