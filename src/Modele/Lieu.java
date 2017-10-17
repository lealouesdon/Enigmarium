/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
/**
 *
 * @author Léa
 */
public abstract class Lieu {
    //Atribut
    private Icone icone;
    private ArrayList<Lieu> prerequis;
    private String nom; 
    //Constructeur
    public Lieu(Icone icone,String nom){
        this.icone=icone;
        this.nom=nom;
        prerequis=new ArrayList();
    }

    public Icone getIcone() {
        return icone;
    }

    public String getNom() {
        return nom;
    }
    

    public void setIcone(Icone icone) {
        this.icone = icone;
    }

    
     
}

