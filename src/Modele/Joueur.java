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

    public Joueur(Icone icone, String nom, String fond, String nomPersonnage, String sexe) {
        super(icone, nom, fond, nomPersonnage, sexe);
    }

   
    
    
}
