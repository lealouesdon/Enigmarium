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

    public Recipient(String nom, Icone icone, int rayon, int hauteur) {
        super(nom,icone);
        this.hauteur=hauteur;
        this.rayon=rayon;
    }

    public int getHauteur() {
        return hauteur;
    }
    

    public int getRayon() {
        return rayon;
    }

    @Override
    public String affichage() {
        return "<html>Hauteur : "+hauteur+ " <br /> "+"Rayon : "+rayon+"</html>";
    }
}
