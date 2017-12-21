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
public class Chapitre {
    private ArrayList<String> parties;
    private int nbQuetes;
    private String description;

    public Chapitre(ArrayList<String> parties, int nbQuetes, String description) {
        this.parties = parties;
        this.nbQuetes = nbQuetes;
        this.description = description;
    }

    public ArrayList<String> getParties() {
        return parties;
    }

    public String getDescription() {
        return description;
    }
    
    
    
    
}
