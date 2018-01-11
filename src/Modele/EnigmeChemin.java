/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Message;
import java.util.ArrayList;

/**
 *
 * @author etien
 */
public class EnigmeChemin extends Enigme {
    private static float resultat=1f;
    private int nbChemins;
    private int nbEtapes;
    private ArrayList<Trajet> trajets;
    private int typeEnigme;
    private String enonce;
    
    public EnigmeChemin(Icone icone, String nom, String fond,int nbChemins, int nbEtapes,int typeEnigme) {
        super(icone, nom, fond);
        this.nbChemins=nbChemins;
        this.nbEtapes=nbEtapes;
        enonce = "La probabilité a avoir est : "+String.valueOf(resultat);
        this.typeEnigme=typeEnigme;
        this.trajets=new ArrayList();
    }

    public void initialiserEnigme() {
        
        this.trajets.clear();
        for(int i=0;i<this.getNbChemins();i++){
            trajets.add(new Trajet(this.getResultat(),this.getNbEtapes(),this.getTypeEnigme()));
        }
        //indice
        super.setIndice("images/indices/indice_proba.png");
        super.setRegle("<html>Vous devez trouver le chemin qui vous mènera à la plus grande probabilité de gagner.</html>");
        
    }
    @Override
    //La vue envoie un message composé d'un arrayList de place
    //proposition doit donc verifier que la somme des place est 
    //egale a resultat.
    public boolean proposition(Message message){
        //message.fractions
        float res=0;
        for (int i=0;i<message.getFractions().size();i++ ){
            res=res+message.getFractions().get(i);
        }
        if(!(res==this.resultat)){
            super.calculPoints();
        }
        return res==this.resultat;
        
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

    public String getEnonce() {
        return enonce;
    }
    
    
}
