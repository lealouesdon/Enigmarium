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
    private String dialogue;
    private String senario;
    
    public Histoire(Lieu lieu, String senario) {
        this.lieu = lieu;
        this.dialogue = dialogue;
        this.senario=senario;
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
    
    
}
/*private ArrayList<Chapitre> chapitres;

    public Histoire(ArrayList<Chapitre> chapitres) {
        this.chapitres = chapitres;
    }

    public ArrayList<Chapitre> getChapitres() {
        return chapitres;
    }*/