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
public class Icone {
    //Atribut
    private float x;
    private float y;
    String image;
    int largeur;
    int hauteur;

    public String getImage() {
        return image;
    }
    //Constructeur
    public Icone(float x, float y,String image, int largeur, int hauteur){
        setImage(image);
        this.x=x;
        this.y=y;
        this.hauteur=hauteur;
        this.largeur=largeur;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    private void setImage(String image) {
        this.image = image;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
    
    
    
    
    
}
