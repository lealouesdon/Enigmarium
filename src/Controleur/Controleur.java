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
import Modele.Enigme;
import Modele.Icone;
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
        Carte monde = new Carte(null, "Carte des mondes",false);
        monde.setFond("images/galaxy.jpg");
        cartes.push(monde);
        /////////////////////////////////MONDE///////////////////////////////////////
        Icone icone =new Icone(200, 100,"images/mondeCuisiniers.png",350,400);
        
        //tester une erreur d'ouveture...
        Carte mMedie = new Carte(icone, "carte medieval");
        mMedie.setFond("images/placeMarcheSansCouleur.jpg");
        icone =new Icone(500, 50,"images/mondeArcheologue.png",350,400);
        Carte mArche = new Carte(icone, "carte archeologie");
        monde.addContien(mMedie);
        monde.addContien(mArche);
        ///////////////////////////////PERSONAGE/////////////////////////////////////
        icone =new Icone(600, 250,null,200,200);
        Carte pBoul =new Carte(icone, "perso boulager");
        mMedie.addContien(pBoul);
        Carte psoupe =new Carte(new Icone(200, 300,null,200,200), "perso soupe");
        mMedie.addContien(psoupe);
        Enigme enigmeTest= new Enigme(new Icone(120,100,null,200,300),"enigmeTest");
        mMedie.addContien(enigmeTest);
         

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
