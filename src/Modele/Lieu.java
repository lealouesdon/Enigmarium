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
    //Atribut
    private Icone icone;
    private ArrayList<Lieu> prerequis;
    //Constructeur
    public Lieu(Icone icone){
        this.icone=icone;
        prerequis=new ArrayList();
    }

    public Icone getIcone() {
        return icone;
    }

    public void setIcone(Icone icone) {
        this.icone = icone;
    }
     
}

