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
import javax.swing.JFrame;

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
        fenetrePrincipale.creeVue(this.cartes.peek());
        fenetrePrincipale.setVisible(true);//lance la vue pour pouveoir jouer
    }
    //methodes

    private void InitialiserVue() {
        fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setObservateur(this);
    }

    private void InitialiserModel() {//initialise toute les carte du model
        Carte monde = new Carte(null, "Carte des mondes");
        cartes.push(monde);
        /////////////////////////////////MONDE///////////////////////////////////////
        Carte mMedie = new Carte(new Icone(100, 10), "carte medieval");
        Carte mArche = new Carte(new Icone(50, 120), "carte archeologie");
        monde.addContien(mMedie);
        monde.addContien(mArche);
        ///////////////////////////////PERSONAGE/////////////////////////////////////
        Carte pBoul =new Carte(new Icone(100, 10), "perso boulager");
        mMedie.addContien(pBoul);
        Carte psoupe =new Carte(new Icone(100, 10), "perso soupe");
        mMedie.addContien(psoupe);
        

    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        if (m.getEtat()=="retour"){
            retourCarte();
        }
        else if(m.getEtat()=="carteChoisi"){
        this.carteChoisi(m.getIndice());
        }
        
    }

    ////////////////////////////////////ACTION EN REPONSSE A NOTIFICATION////////////////////////////////////
    public void carteChoisi(String titre){//Attention ne marche pas pour les enigme pour l instant !!!!!!!
        Carte c = (Carte) this.cartes.peek().getContiens().get(titre);
        this.cartes.push(c);
        fenetrePrincipale.creeVue(this.cartes.peek());

    }
    
    public void retourCarte(){//Si l'utilisateur clique sur le bouton retour
        this.cartes.pop();
        fenetrePrincipale.creeVue(this.cartes.peek());
    }
}
