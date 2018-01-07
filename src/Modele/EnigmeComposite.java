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
    private int points;
    private int nbCompositionsRestantes; //nombre de compositions pas encore trouvé


    public EnigmeComposite(Icone icone, String nom, String fond) {
        super(icone, nom, fond);
        compositions = new ArrayList<Composition>();
        enonce = new ArrayList<String>();
    }

    public void enigmeVolume() {
        compositions.clear();
        enonce.clear();
        points = 0;
        //defiition des attributs:
        //atributs 1 = recipients
        //attributs 2= ingredients

        //Création d'éléments et de compositions
        /////////////////////////////////////////////////////////
        Recipient r1 = new Recipient("Farine", new Icone((float) 0.19, (float) 0.13, "images/recipients/recipient22vide.png", 100, 100));
        Ingredient i1 = new Ingredient("Farine", new Icone((float) 0.19, (float) 0.37, "images/ingredients/pieuvre.png", 100, 100), r1.getHauteur(), r1.getRayon());
        Composition c1 = new Composition(r1, i1);
        //ajout de la compositio a la list
        compositions.add(c1);
        //ajout de la ligne de la recette a la description
        enonce.add(i1.getNom() + " : " + i1.getVolIngredient()+" cm3");
        //////////////////////////////////////////////////////////
        Recipient r2 = new Recipient("Lait", new Icone((float) 0.29, (float) 0.13, "images/recipients/recipients12Vide.png", 100, 100));
        Ingredient i2 = new Ingredient("Lait", new Icone((float) 0.29, (float) 0.37, "images/ingredients/lait.png", 50, 100), r2.getHauteur(), r2.getRayon());
        Composition c2 = new Composition(r2, i2);
        //ajout de la compositio a la list
        compositions.add(c2);
        //ajout de la ligne de la recette a la description
        enonce.add(i2.getNom() + " : " + i2.getVolIngredient()+" cm3");
        //////////////////////////////////////////////////////////
        Recipient r3 = new Recipient("Eau", new Icone((float) 0.39, (float) 0.13, "images/recipients/recipient22vide.png", 100, 100));
        Ingredient i3 = new Ingredient("Eau", new Icone((float) 0.39, (float) 0.37, "images/ingredients/eau.png", 100, 100), r3.getHauteur(), r3.getRayon());
        Composition c3 = new Composition(r3, i3);
        //ajout de la compositio a la list
        compositions.add(c3);
        //ajout de la ligne de la recette a la description
        enonce.add(i3.getNom() + " : " + i3.getVolIngredient()+" cm3");
        //////////////////////////////////////////////////////////
        Recipient r4 = new Recipient("Oeuf", new Icone((float) 0.49, (float) 0.13, "images/recipients/recipients12Vide.png", 100, 100));
        Ingredient i4 = new Ingredient("Oeuf", new Icone((float) 0.49, (float) 0.37, "images/ingredients/oeuf.png", 100, 100), r4.getHauteur(), r4.getRayon());
        Composition c4 = new Composition(r4, i4);
        //ajout de la compositio a la list
        compositions.add(c4);
        //ajout de la ligne de la recette a la description
        enonce.add(i4.getNom() + " : " + i4.getVolIngredient()+" cm3");
        //////////////////////////////////////////////////////////
        //indice
        super.setIndice("images/indices/indice1.png");
        melangeIconeConpositions(0.19f, 0.10f);
        //initialisation de nbCompositionsRestantes
        nbCompositionsRestantes=4;
        //regle
        super.setRegle("<html>Il vous faut asssocier le bon récipient au bonne ingrédients en suivant les quatité données sur le livre de recette.</html>");
    }

    //////////////////////////////////////////////////////////////////////////////
    public void enigmeExpression() {
        compositions.clear();
        enonce.clear();
        points = 0;
        //defiition des attributs:
        //atributs 1 = reponses
        //attributs 2= expression 

        //Création d'éléments et de compositions
        /////////////////////////////////////////////////////////
        Expression e1 = new Expression("e1", new Icone((float) 0.59, (float) 0.05, null, 300, 75));
        Resultat r1 = new Resultat("r1", new Icone((float) 0.65, (float) 0.55, null, 100, 100), e1.getX());
        Composition c1 = new Composition(r1, e1);
        //ajout de la compositio a la list
        compositions.add(c1);
        //ajout de la ligne de la recette a la description
        enonce.add("");
        /////////////////////////////////////////////////////
        Expression e2 = new Expression("e2", new Icone((float) 0.59, (float) 0.18, null, 300, 75));
        Resultat r2 = new Resultat("r2", new Icone((float) 0.55, (float) 0.55, null, 100, 100), e2.getX());
        Composition c2 = new Composition(r2, e2);
        //ajout de la compositio a la list
        compositions.add(c2);
        //ajout de la ligne de la recette a la description
        enonce.add("");
        ///////////////////////////////////
        Expression e3 = new Expression("e3", new Icone((float) 0.59, (float) 0.31, null, 300, 75));
        Resultat r3 = new Resultat("r3", new Icone((float) 0.70, (float) 0.55, null, 100, 100), e3.getX());
        Composition c3 = new Composition(r3, e3);
        //ajout de la compositio a la list
        compositions.add(c3);
        //ajout de la ligne de la recette a la description
        enonce.add("");
        ///////////////////////////////////////////////////
        Resultat r4 = new Resultat("r4", new Icone((float) 0.75, (float) 0.55, null, 100, 100));
        Composition c4 = new Composition(r4, null);
        //ajout de la compositio a la list
        compositions.add(c4);
        //ajout de la ligne de la recette a la description
        enonce.add("");
        //indice
        super.setIndice("images/indices/indice_equa.png");
        melangeIconeConpositions(0.58f, 0.08f);
        //initialisation de nbCompositionsRestantes
        nbCompositionsRestantes=3;
        //regle
        super.setRegle("<html>Pour ouvrir cette porte, il vous faut associer le bon résultat à l’équation correspondante ! </html>");
    }

    void melangeIconeConpositions(float valDepart, float ecartemment) {
        //metdode pour melanger la position des composition
        ArrayList<Float> valeurs = new ArrayList();
        float position = valDepart;
        for (int i = 0; i < compositions.size(); i++) {
            float valeur = position;
            valeurs.add(valeur);
            position = position + ecartemment;
        }
        Collections.shuffle(valeurs);
        for (int i = 0; i < compositions.size(); i++) {
            Composition c = compositions.get(i);
            Element e = c.getElem1();
            Icone ic = e.getIcone();
            ic.setX(valeurs.get(i));
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
    @Override
     public boolean proposition(Message message) {
        //vérifier que att1 et att2 soit une composition
        //check si fin de jeu ou pas
        boolean passe = false;

        for (Iterator<Composition> iterator = compositions.iterator(); iterator.hasNext();) {
            Composition c = iterator.next();
            if (c.getElem1() != null && c.getElem2() != null) {
                if (c.getElem1().getNom() == message.getAtt1()) {
                    if (c.getElem2().getNom() == message.getAtt2()) {
                        points = points + 200;
                        passe = true;
                        iterator.remove();
                        nbCompositionsRestantes=nbCompositionsRestantes-1;
                    }
                }
            }
        }

        if (passe == false) {
            points = points - 100;
            if (points < 0) {
                points = 0;
            }
        }
        return getNbCompositionsRestantes() == 0;
    }

    public ArrayList<Composition> getCompositions() {
        return compositions;
    }

    public ArrayList<String> getEnonce() {
        return enonce;
    }
    @Override 
    public int getPoints() {
        return points;
    }

    public int getNbCompositionsRestantes() {
        return nbCompositionsRestantes;
    }


    
    

}
