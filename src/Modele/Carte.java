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
    private Icone icone;
    private ArrayList<Lieu> prerequis;
    private HashMap<String,Lieu> contiens;
    private String titreCarte;
    private String nom;

    public Carte(Icone icone,String nom) {
        super(icone,nom);
        this.contiens=new HashMap(); 
    }
    
    public void addContien(Lieu lieu){
        this.contiens.put(lieu.getNom(),lieu);
    }
    
}
