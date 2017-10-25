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
    private int x;
    private int y;
    String image;
    int largeur;
    int hauteur;

    public String getImage() {
        return image;
    }
    //Constructeur
    public Icone(int x, int y,String image, int largeur, int hauteur){
        setImage(image);
        this.x=x;
        this.y=y;
        this.hauteur=hauteur;
        this.largeur=largeur;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
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
