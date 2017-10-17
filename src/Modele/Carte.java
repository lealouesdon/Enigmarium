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
public class Carte extends Lieu{
    //Atribut
    private Icone icone;
    private ArrayList<Lieu> prerequis;
    private ArrayList<Lieu> contiens;
    private String titreCarte;

    public Carte(Icone icone, String titre) {
        super(icone);
        this.titreCarte=titre;
        this.contiens=new ArrayList(); 
    }
    
}
