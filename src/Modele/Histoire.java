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
public class Histoire {
    private Lieu lieu;
    private String senario;
    private ArrayList<String> personnages;
    
    public Histoire(Lieu lieu, String senario, ArrayList<String> personnages) {
        this.lieu = lieu;
        this.senario=senario;
        this.personnages = personnages;
    }
    
    /*public boolean suivant(){
           return this.nbPointPourSuivant > 3;
    }  */

    public Lieu getLieu() {
        return lieu;
    }

    public String getSenario() {
        return senario;
    }

    public ArrayList<String> getPersonnages() {
        return personnages;
    }
    
    
    
}
/*private ArrayList<Chapitre> chapitres;

    public Histoire(ArrayList<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public ArrayList<Chapitre> getChapitres() {
        return chapitres;
    }*/