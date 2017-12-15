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
public class Personnage extends Lieu{
    private Enigme enigme;
    private String sexe;

    public Personnage(Icone icone, String nom, String fond, String sexe,Enigme enigme) {
        super(icone, nom, fond);
        this.sexe = sexe;
        this.enigme=enigme;
    }

    
    
    

   
    
}
