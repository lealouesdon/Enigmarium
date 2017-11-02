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
        this.ingredients.add(new Ingredient(" lait ",new Icone((float) 0.19,(float) 0.38,null,100,100)));
        this.ingredients.add(new Ingredient(" oeuf ",new Icone((float) 0.29,(float) 0.38,null,100,100)));
        this.ingredients.add(new Ingredient(" eau ",new Icone((float) 0.39,(float) 0.38,null,100,100)));
        this.ingredients.add(new Ingredient(" pieuvre ",new Icone((float) 0.49,(float) 0.38,null,100,100)));
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public void remove(String i){
        for(Ingredient ing : ingredients){
            if (ing.getNom()==i){
                ing.setNom(null);
            }
        }
    }
    
    
    
}
