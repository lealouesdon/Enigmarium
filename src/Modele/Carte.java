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
public class Carte {
    //Atribut
    private boolean retour;
    private HashMap<String,Carte> contiens;
    private String fond;
    private Icone icone;
    private ArrayList<Carte> prerequis;
    private String nom; 

   
    public Carte(Icone icone,String nom,String fond) {
        this.retour=true;
        this.contiens=new HashMap(); 
        this.icone=icone;
        this.nom=nom;
        setFond(fond);
        prerequis=new ArrayList();
    }
    public Carte(Icone icone,String nom,String fond,boolean retour) {
        this.retour=retour;
        this.contiens=new HashMap(); 
        this.icone=icone;
        this.nom=nom;
        setFond(fond);
        prerequis=new ArrayList();
    }
    
    public void addContien(Carte carte){
        this.contiens.put(carte.getNom(),carte);
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
    public String getNom(){
        return this.nom;
    }

    public Icone getIcone() {
        return icone;
    }
    
    
}
