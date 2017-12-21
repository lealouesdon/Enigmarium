/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author lorentzr
 */
public abstract class PNJ extends Personnage{
    
    private String description;

    public PNJ(Icone icone, String nom, String fond, String nomPersonnage, String sexe, String description) {
        super(icone, nom, fond, nomPersonnage, sexe);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

  
    
}
