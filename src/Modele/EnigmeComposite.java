/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Message;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Iterator;

/**
 *
 * @author Léa
 */
public class EnigmeComposite extends Enigme {

    private ArrayList<Composition> compositions;
    private ArrayList<String> enonce;  //équivalent de la recette pour enigmeVolume

    public EnigmeComposite(Icone icone, String nom, String fond) {
        super(icone, nom, fond);
        compositions=new ArrayList<Composition>();
        enonce = new ArrayList<String>();
    }

    public void enigmeVolume() {
        compositions.clear();
        enonce.clear();
        //defiition des attributs:
        //atributs 1 = recipients
        //attributs 2= ingredients
        
        //Création d'éléments et de compositions
        //mettre des positions aléatoires?
        /////////////////////////////////////////////////////////
        Recipient r1 = new Recipient("farine", new Icone((float) 0.19, (float) 0.13, "images/recipient22vide.png", 100, 100));
        Ingredient i1 = new Ingredient("farine",new Icone((float) 0.19, (float) 0.37, "images/pieuvre.png", 100, 100),r1.getHauteur() ,r1.getRayon());
        Composition c1=new Composition(r1,i1);
        //ajout de la compositio a la list
        compositions.add(c1);
        //ajout de la ligne de la recette a la description
        enonce.add(i1.getNom()+" : "+i1.getVolIngredient());
        //////////////////////////////////////////////////////////
        Recipient r2 = new Recipient("lait", new Icone((float) 0.29, (float) 0.13, "images/recipients12Vide.png", 100, 100));
        Ingredient i2 = new Ingredient("lait",new Icone((float) 0.29, (float) 0.37, "images/lait.png", 50, 100),r2.getHauteur() ,r2.getRayon());
        Composition c2=new Composition(r2,i2);
        //ajout de la compositio a la list
        compositions.add(c2);
        //ajout de la ligne de la recette a la description
        enonce.add(i2.getNom()+" : "+i2.getVolIngredient());
        //////////////////////////////////////////////////////////
        Recipient r3 = new Recipient("eau", new Icone((float) 0.39, (float) 0.13, "images/recipient22vide.png", 100, 100));
        Ingredient i3 = new Ingredient("eau",new Icone((float) 0.39, (float) 0.37, "images/eau.png", 100, 100),r3.getHauteur() ,r3.getRayon());
        Composition c3=new Composition(r3,i3);
        //ajout de la compositio a la list
        compositions.add(c3);
        //ajout de la ligne de la recette a la description
        enonce.add(i3.getNom()+" : "+i3.getVolIngredient());
        //////////////////////////////////////////////////////////
        Recipient r4 = new Recipient("oeuf", new Icone((float) 0.49, (float) 0.13, "images/recipients12Vide.png", 100, 100));
        Ingredient i4 = new Ingredient("oeuf",new Icone((float) 0.49, (float) 0.37, "images/oeuf.png", 100, 100),r4.getHauteur() ,r4.getRayon());
        Composition c4=new Composition(r4,i4);
        //ajout de la compositio a la list
        compositions.add(c4);
        //ajout de la ligne de la recette a la description
        enonce.add(i4.getNom()+" : "+i4.getVolIngredient());
        //////////////////////////////////////////////////////////
        //indice
        super.setIndice("images/indice.png");
        //melangeIconeConpositions(0.19f,0.10f);
    }
    
    void melangeIconeConpositions(float valDepart,float ecartemment){
        ArrayList<Float> valeurs = new ArrayList();
        float position=valDepart;
        for(int i=0;i<compositions.size();i++){
            float valeur=position;
            position=position+ecartemment;            
        }
         Collections.shuffle(valeurs);
         for(int i=0;i<compositions.size();i++){
              compositions.get(i).getElem1().getIcone().setX(valeurs.get(i));
         }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void proposition(Message message) {
        //vérifier que att1 et att2 soit une composition
        //check si fin de jeu ou pas
        for (Iterator<Composition> iterator = compositions.iterator(); iterator.hasNext();) {
            Composition c=iterator.next();
            if(c.getElem1().getNom()==message.getAtt1()){
                if(c.getElem2().getNom()==message.getAtt2()){
                    iterator.remove();
                }                
            }
        }
    }
    public ArrayList<Composition> getCompositions() {
        return compositions;
    }
    
    public ArrayList<String> getDescription(){
        return enonce;
    }

    

}
