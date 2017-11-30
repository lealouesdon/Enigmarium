/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author etien
 */
public class EnigmeChemin extends Enigme {
    
    private float resultat;
    private int nbChemins;
    private int nbEtapes;
    private ArrayList<Trajet> trajets;
    private int typeEnigme;
    
    public EnigmeChemin(Icone icone, String nom, String fond,float resultat,int nbChemins, int nbEtapes,int typeEnigme) {
        super(icone, nom, fond);
        this.nbChemins=nbChemins;
        this.nbEtapes=nbEtapes;
        this.resultat=resultat;
        this.typeEnigme=typeEnigme;
        this.trajets=new ArrayList<>();
        initialiserEnigme();
    }

    private void initialiserEnigme() {
        for(int i=0;i<this.getNbChemins();i++){
            trajets.add(new Trajet(this.getResultat(),this.getNbEtapes(),this.getTypeEnigme()));
        }
    }

    public int getNbEtapes() {
        return nbEtapes;
    }

    public int getNbChemins() {
        return nbChemins;
    }

    public int getTypeEnigme() {
        return typeEnigme;
    }

    public float getResultat() {
        return resultat;
    }

    public ArrayList<Trajet> getTrajets() {
        return trajets;
    }
    
    
}
