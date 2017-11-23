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
import Modele.Lieu;
import Vue.FenetreIndice;
import Vue.FenetreIntro;
import Vue.FenetrePrincipale;
import Vue.FenetreResultat;
import java.util.Stack;

public class Controleur implements Observateur {

    //attributs
    private Stack<Lieu> cartes;
    private FenetreIndice fenetreIndice;
    private FenetrePrincipale fenetrePrincipale;
    private Enigme enigmeCoutante;

    //Constructeur
    public Controleur() {
        cartes = new Stack();
        InitialiserModel();
        InitialiserVue();
        fenetrePrincipale.creeVue((Carte) this.cartes.peek());
        FenetreIntro fIntro = new FenetreIntro();//pour la démo
        fenetrePrincipale.setVisible(true);//lance la vue pour pouveoir jouer
        fIntro.setVisible(true);
        fIntro.toFront();
    }
    //methodes

    private void InitialiserVue() {
        fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setObservateur(this);
    }

    private void InitialiserModel() {//initialise toute les carte du model
        Carte monde = new Carte(null, "Carte des mondes", "images/galaxy.jpg", false);

        cartes.push(monde);
        /////////////////////////////////MONDE///////////////////////////////////////
        Icone icone = new Icone((float) 0.20, (float) 0.2, "images/mondeCuisiniers.png", 350, 450);

        //tester une erreur d'ouveture...
        Carte mMedie = new Carte(icone, "carte medieval", "images/placeMarche.jpg");
        icone = new Icone((float) 0.5, (float) 0.1, "images/mondeArcheologue.png", 350, 400);
        Carte mArche = new Carte(icone, "carte archeologie", null);
        monde.addContien(mMedie);
        monde.addContien(mArche);
        ///////////////////////////////PERSONAGE ET ENIGMES/////////////////////////////////////
        //monde de la nouriture
        icone = new Icone((float) 0.38, (float) 0.30, null, 300, 200);
        EnigmeComposite pBoul = new EnigmeComposite(icone, "enigmeVolume", "images/vueJeu.png");
        mMedie.addContien(pBoul);
        Carte psoupe = new Carte(new Icone((float) 0.10, (float) 0.39, null, 200, 200), "perso soupe", null);
        mMedie.addContien(psoupe);
        //monde des archéologues
        //personnage a déveloper
        icone = new Icone((float) 0.38, (float) 0.30, "images/fond-bleu.jpg", 300, 200);
        EnigmeComposite perso = new EnigmeComposite(icone, "enigmeExpression", "images/enigme v2.jpg");
        mArche.addContien(perso);
        ///////////////////////////////ENIGMES/////////////////////////////////////

    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        if (m.getEtat() == "retour") {
            retourCarte();
        } else if (m.getMessage() == "enigmeVolume") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeVolume();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme volume et la met en enigme courante
            enigmeComposite();
        } else if (m.getMessage() == "enigmeExpression") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeExpression();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme volume et la met en enigme courante
            enigmeComposite();
        } else if (m.getEtat() == "carteChoisi") {
            this.carteChoisi(m.getMessage());
        } else if (m.getEtat() == "MessageComposite") {
            //doit etre fait dans l'énigme
            //utiliser enigmeCourante.proposition?
            //anayler comment lire la répose
            //faire un messageComposite?
            EnigmeComposite e = (EnigmeComposite) enigmeCoutante;
            e.proposition(m);
            if (e.getCompositions().size() == 0) {
                //ouvrir une fenetre resultat
                FenetreResultat f = new FenetreResultat();
                f.setPoints(String.valueOf(e.getPoints()));
                f.setVisible(true);
                retourCarte();
            } else {
                enigmeCoutante = e;
                enigmeComposite();
            }

        }

    }

    ////////////////////////////////////ACTION EN RÉPONSE À NOTIFICATION////////////////////////////////////
    public void carteChoisi(String titre) {//Attention ne marche pas pour les enigme pour l instant !!!!!!!
        Carte c = (Carte) ((Carte)this.cartes.peek()).getContiens().get(titre);
        this.addCarte(c);
        fenetrePrincipale.creeVue((Carte)this.cartes.peek());
    }

    public void retourCarte() {//Si l'utilisateur clique sur le bouton retour
        this.delCarte();
        fenetrePrincipale.creeVue((Carte)this.cartes.peek());
    }

    private void enigmeComposite() {

        fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
    }
    private void addCarte(Carte carte){
        this.cartes.push(carte);
    }
    private void delCarte(){
        this.cartes.pop();
    }
}
