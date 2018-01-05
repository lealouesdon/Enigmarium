/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author lorentzr
 */
public class Joueur extends Personnage{
    
    private ArrayList<Enigme> enigmesFinies;
    private int nbEnigme;
    
    
    
    public Joueur(Icone icone, String nom, String fond, String nomPersonnage, String sexe) {
        super(icone, nom, fond, nomPersonnage, sexe);
        nbEnigme = 0;
    }
    
    

    public ArrayList<Enigme> getEnigmesFinies() {
        return enigmesFinies;
    }

        public int getNbEnigme() {
        return nbEnigme;
    }


    public void incrNbEnigme(){
        this.nbEnigme ++;
    }
    
    public void addEnigmeFinie(Enigme enigme){
        enigmesFinies.add(enigme);        
    }

    public void incrChapitreCourant(){
        switch (this.nbEnigme){
            case 0 :
                break;
            case 10 :
                break;
            case 20 :
                break;
            case 30 :
                break;
            case 40 :
                break;
            case 50 :
                break;
            case 60 :
                break;
            case 70 :
                break;
            case 80 :
                break;
            case 90 :
                break;
            case 100 :
                break;                   
        }
           
    }


   
    
    
}
