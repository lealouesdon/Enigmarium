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

    private String nom;
    private String fond;
    private Icone icone;
    private boolean retour;
    private ArrayList<Lieu> prerequis;
    
   

    public Lieu(Icone icone, String nom, String fond) {
        this.icone = icone;
        this.nom = nom;
        setFond(fond);
        this.retour = true;
        prerequis = new ArrayList();
    }

    public Lieu(Icone icone, String nom, String fond, boolean retour) {
        this.icone = icone;
        this.nom = nom;
        setFond(fond);
        this.retour = retour;
        prerequis = new ArrayList();

    }
 
    public void setFond(String fond) {
        this.fond = fond;
    }

    public String getFond() {
        return fond;
    }

    public String getNom() {
        return this.nom;
    }

    public Icone getIcone() {
        return icone;
    }

    public boolean getRetour() {
        return retour;
    }


    
}
