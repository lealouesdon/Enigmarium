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
public class Recipient extends Element {

    private int rayon;
    private int hauteur;
    private int MINRAY = 1;
    private int MAXRAY = 7;
    private int MINHAU = 4;
    private int MAXHAU = 15;

    public Recipient(String nom, Icone icone) {
        super(nom, icone);
        init();
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getRayon() {
        return rayon;
    }

    @Override
    public String affichage() {
        return "<html>Hauteur : " + hauteur + " <br /> " + "Rayon : " + rayon + "</html>";
    }
    
    private void init(){
        this.hauteur = (int) (Math.random() * (MAXHAU + 1 - MINHAU) + MINHAU);
        this.rayon = (int)(Math.random() * (MAXRAY + 1 - MINRAY) + MINRAY);
    }
}
