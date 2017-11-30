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
public abstract class Personnage extends Lieu{
    private String nomPersonnage;
    private String sexe;

    public Personnage(Icone icone, String nom, String fond, String nomPersonnage, String sexe) {
        super(icone, nom, fond);
        this.nomPersonnage = nomPersonnage;
        this.sexe = sexe;
    }

    
    
    

   
    
}
