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
import Modele.EnigmeComposite;
import Modele.Icone;
import Vue.FenetreIndice;
import Vue.FenetreParametre;
import Vue.FenetrePrincipale;
import java.util.Stack;
import javax.swing.JFrame;

public class Controleur implements Observateur {

    //attributs
    private Stack<Carte> cartes;
    private FenetreIndice fenetreIndice;
    private FenetreParametre fenetreParametre;
    private FenetrePrincipale fenetrePrincipale;
    private Enigme enigmeCoutante;

    //Constructeur
    public Controleur() {
        cartes = new Stack();
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
        Carte monde = new Carte(null, "Carte des mondes","images/galaxy.jpg" ,false);
        
        cartes.push(monde);
        /////////////////////////////////MONDE///////////////////////////////////////
        Icone icone = new Icone((float)0.20,(float) 0.2, "images/mondeCuisiniers.png", 350, 450);

        //tester une erreur d'ouveture...
        Carte mMedie = new Carte(icone, "carte medieval","images/placeMarche.jpg");
        icone = new Icone((float)0.5,(float)0.1, "images/mondeArcheologue.png", 350, 400);
        Carte mArche = new Carte(icone, "carte archeologie",null);
        monde.addContien(mMedie);
        monde.addContien(mArche);
        ///////////////////////////////PERSONAGE/////////////////////////////////////
        icone = new Icone((float)0.38, (float)0.30, null, 300, 200);
        Carte pBoul = new Carte(icone, "perso boulager",null);
        mMedie.addContien(pBoul);
        Carte psoupe = new Carte(new Icone((float)0.10, (float)0.39, null, 200, 200), "perso soupe",null);
        mMedie.addContien(psoupe);
        //Enigme enigmeTest = new Enigme(new Icone(120, 100, null, 200, 300), "enigmeTest");
        //mMedie.addContien(enigmeTest);
        ///////////////////////////////ENIGMES/////////////////////////////////////
        EnigmeComposite enigme = new EnigmeComposite(new Icone((float)0.38, (float)0.30, "images/vueJeu.png", 200, 200), "enigmeVolume","images/vueJeu.png");
        enigme.enigmeVolume();
        pBoul.addContien(enigme);
    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        System.out.println(m.getEtat());
        if (m.getEtat() == "retour") {
            retourCarte();
        } else if (m.getMessage() == "enigmeVolume") {
            System.out.println("passe");
            EnigmeComposite e = (EnigmeComposite) this.cartes.peek().getContiens().get(m.getMessage());
            enigmeCoutante = e;
            
            //trouve la carte énigme volume et la met en enigme courante
            enigmeComposite();
        } else if (m.getEtat() == "carteChoisi") {
            System.out.println("passe");
            this.carteChoisi(m.getMessage());
        } else if (m.getEtat() == "MessageComposite") {
            //doit etre fait dans l'énigme
            //utiliser enigmeCourante.proposition?
            //anayler comment lire la répose
            //faire un messageComposite?
            EnigmeComposite e = (EnigmeComposite)enigmeCoutante;
            e.proposition(m);
            enigmeCoutante=e;
            enigmeComposite();
        }

    }

    ////////////////////////////////////ACTION EN REPONSSE A NOTIFICATION////////////////////////////////////
    public void carteChoisi(String titre) {//Attention ne marche pas pour les enigme pour l instant !!!!!!!
        Carte c = (Carte) this.cartes.peek().getContiens().get(titre);
        this.cartes.push(c);
        fenetrePrincipale.creeVue(this.cartes.peek());
    }

    public void retourCarte() {//Si l'utilisateur clique sur le bouton retour
        this.cartes.pop();
        fenetrePrincipale.creeVue(this.cartes.peek());
    }

    private void enigmeComposite() {
        this.cartes.push(enigmeCoutante);
        fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite)enigmeCoutante);
    }
}
