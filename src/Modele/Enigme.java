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
    private static String DESCRIPTION="description de l'enigme lalalalalalalalalala";
    public Enigme() {
        super(null, null);
        enigme1();
        melangeIngre();
    }

    private void melangeIngre() {
      //  PriorityQueue<Ingredient> =new PriorityQueue();
        
    }
    public void enigme1(){
        this.ingredients=new ArrayList();
        this.ingredients.add(new Ingredient(" lait ",null));
        this.ingredients.add(new Ingredient(" oeuf ",null));
        this.ingredients.add(new Ingredient(" eau ",null));
        this.ingredients.add(new Ingredient(" pieuvre ",null));
    }
    
}
