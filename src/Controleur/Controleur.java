/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author Léa
 */
import Modele.Carte;
import Modele.Icone;
import Modele.Lieu;
import Vue.FenetreIndice;
import Vue.FenetreParametre;
import Vue.FenetrePrincipale;
import java.util.Stack;

public class Controleur implements Observateur{
    
    //attributs
    private Stack<Carte> cartes;
    private FenetreIndice fenetreIndice;
    private FenetreParametre fenetreParametre;
    private FenetrePrincipale fenetrePrincipale;
    //Constructeur
    public Controleur(){
        cartes=new Stack();
        InitialiserModel();
        InitialiserVue();
       
    }
    //methodes

    private void InitialiserVue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void InitialiserModel() {
        Carte monde=new Carte(null,"Carte des mondes");
        cartes.push(monde);
        Carte mMedie=new Carte(new Icone(100,10),"carte medieval");
        Carte mArche=new Carte(new Icone(50,120),"carte archeologie");
        monde.addContien(mMedie);
        monde.addContien(mArche); 
    }
    private void CarteChoisi(String carte){
        //Carte cae= cartes.peek().getContiens().get(carte);
        
    }
    
    
    
    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 

    @Override
    public void notification(Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
