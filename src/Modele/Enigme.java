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
public class Enigme extends Carte {

    private ArrayList<Ingredient> ingredients;
    private static String DESCRIPTION="description de l'enigme lalalalalalalalalala";
    public Enigme(Icone icone,String nom) {
       super(icone,nom);
       enigme1();
    }

    private void melangeIngre() {
      //  PriorityQueue<Ingredient> =new PriorityQueue();
        
    }
    public void enigme1(){
        this.ingredients=new ArrayList();
        this.ingredients.add(new Ingredient(" lait ",new Icone(100,100,null,200,200)));
        this.ingredients.add(new Ingredient(" oeuf ",new Icone(100,150,null,200,200)));
        this.ingredients.add(new Ingredient(" eau ",new Icone(100,200,null,200,200)));
        this.ingredients.add(new Ingredient(" pieuvre ",new Icone(100,250,null,200,200)));
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    
    
    
}
