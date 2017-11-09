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
public abstract class Element {
    private String nom;
    private Icone icone;
    private String affichage;
    Element(String nom, Icone icone){
        this.nom=nom;
        this.icone=icone;
    }

    public String getNom() {
        return nom;
    }

    public Icone getIcone() {
        return icone;
    }
    
    public abstract String affichage();
}
