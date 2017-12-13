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
public class Carte extends Lieu {

    //Atribut
    private HashMap<String, Lieu> contiens;

    public Carte(Icone icone, String nom, String fond,String son) {
        super(icone, nom, fond, son);
        this.contiens = new HashMap();
 
    }

    public Carte(Icone icone, String nom, String fond) {
        super(icone, nom, fond);
        this.contiens = new HashMap();
 
    }

    public Carte(Icone icone, String nom, String fond, boolean retour) {
        super(icone, nom, fond, retour);
        this.contiens = new HashMap();
    }

    public void addContien(Lieu carte) {
        this.contiens.put(carte.getNom(), carte);
    }

    public HashMap getContiens() {
        return this.contiens;
    }

}
