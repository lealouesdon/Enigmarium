/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Léa
 */
public class Enigme extends Lieu {

    private ArrayList<Ingredient> ingredients;
    public Enigme() {
        super(null, null);
        this.ingredients=new ArrayList();
        this.ingredients.add(new Ingredient(" lait "));
        this.ingredients.add(new Ingredient(" oeuf "));
        this.ingredients.add(new Ingredient(" eau "));
        this.ingredients.add(new Ingredient(" pieuvre "));
        melangeIngre();
    }

    private void melangeIngre() {
      //  PriorityQueue<Ingredient> =new PriorityQueue();
        
    }
    
}
