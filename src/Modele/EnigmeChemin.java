/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Message;
import java.util.HashMap;

/**
 *
 * @author etien
 */
public class EnigmeChemin extends Enigme {
    private float resultat;
    private int nbChemins;
    private int nbEtapes;
    private HashMap<Integer,Trajet> trajets;
    private int typeEnigme;
    private String enonce;
    
    public EnigmeChemin(Icone icone, String nom, String fond,int nbChemins, int nbEtapes,int typeEnigme) {
        super(icone, nom, fond);
        this.nbChemins=nbChemins;
        this.nbEtapes=nbEtapes;
        this.resultat=1f;
        enonce = "La probabilité a avoir est : "+String.valueOf(resultat);
        this.typeEnigme=typeEnigme;
        this.trajets=new HashMap();
    }

    public void initialiserEnigme() {
        this.trajets.clear();
        for(int i=0;i<this.getNbChemins();i++){
            trajets.put(i,new Trajet(this.getResultat(),this.getNbEtapes(),this.getTypeEnigme()));
        }
        
    }
    @Override
    public boolean proposition(Message message){
        //message.fractions
        float res=0;
        for (int i=0;i<message.getFractions().size();i++ ){
            res=res+message.getFractions().get(i);
        }
        System.out.print(res);
        System.out.print(this.resultat);
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

    public HashMap<Integer,Trajet> getTrajets() {
        return trajets;
    }

    public String getEnonce() {
        return enonce;
    }
    
    
}
