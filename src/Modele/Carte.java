/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Léa
 */
public class Carte extends Lieu{
    //Atribut
    private boolean retour;
    private HashMap<String,Lieu> contiens;
    private String fond;

   
    public Carte(Icone icone,String nom) {
        super(icone,nom);
        this.retour=true;
        this.contiens=new HashMap(); 
    }
    public Carte(Icone icone,String nom,boolean retour) {
        super(icone,nom);
        this.retour=retour;
        this.contiens=new HashMap(); 
    }
    
    public void addContien(Lieu lieu){
        this.contiens.put(lieu.getNom(),lieu);
    }

    public HashMap getContiens() {
        return this.contiens;
    }
    public boolean getRetour(){
        return retour;
    }
    public void setFond(String fond) {
        this.fond = fond;
    }

    public String getFond() {
        return fond;
    }
    
}
