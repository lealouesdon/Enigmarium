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
public class Quete {
    private String nom;
    private ArrayList<Enigme> enigmeAFaire;
    
    public Quete(ArrayList<Enigme> enigmeAFaire) {
        this.enigmeAFaire = enigmeAFaire;
    }
    
    
}
