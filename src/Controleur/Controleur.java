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
import Modele.EnigmeChampsDeTexte;
import Modele.EnigmeChemin;
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
        Icone icone = new Icone((float) 0.05, (float) 0.2, "images/mondeCuisiniers.png", 300, 450);
        Carte mMedie = new Carte(icone, "carte medieval", "images/placeMarche.jpg");
        icone = new Icone((float) 0.3, (float) 0.1, "images/mondeArcheologue.png", 350, 400);
        Carte mArche = new Carte(icone, "carte archeologie", "images/mondeA.jpg");
        icone = new Icone((float) 0.6, (float) 0.3, "images/mondeLasVegas.png", 350, 400);
        Carte mLasVegas = new Carte(icone, "carte lasVegas", "images/mondeLasVegas.jpg");
        monde.addContien(mMedie);
        monde.addContien(mArche);
        monde.addContien(mLasVegas);
        ///////////////////////////////PERSONAGE ET ENIGMES/////////////////////////////////////
        //monde de la nouriture
        icone = new Icone((float) 0.38, (float) 0.30, null, 300, 200);
        EnigmeComposite pBoul = new EnigmeComposite(icone, "enigmeVolume", "images/vueJeu.png");
        mMedie.addContien(pBoul);
        EnigmeChemin psoupe = new EnigmeChemin(new Icone((float) 0.10, (float) 0.39, null, 200, 200), "enigmeChemin", null,2,3,1);
        mMedie.addContien(psoupe);
        //monde des archéologues
        //personnage a déveloper
        icone = new Icone((float) 0.38, (float) 0.30, null, 300, 200);
        EnigmeComposite perso = new EnigmeComposite(icone, "enigmeExpression", "images/enigme v2.jpg");
        mArche.addContien(perso);
        ///////////////////////////////ENIGMES/////////////////////////////////////
        icone = new Icone((float)0.75, (float) 0.35, null, 300, 200);
        EnigmeChampsDeTexte persojesaispluscommentilsapelleducoutjimprovise =new EnigmeChampsDeTexte(icone,"enigmeChampsDeTextes",null);
        mMedie.addContien(persojesaispluscommentilsapelleducoutjimprovise);
    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        if (m.getEtat() == "retour") {
            retourCarte();
        } ////////////////////////Initialisation d'énigme//////////////////////////////////////////////
        else if (m.getMessage() == "enigmeVolume") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeVolume();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme volume et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
        } else if (m.getMessage() == "enigmeExpression") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeExpression();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme expression et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
        }else if(m.getMessage() == "enigmeChemin"){
            EnigmeChemin e = (EnigmeChemin) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.initialiserEnigme();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme expression et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeChemin((EnigmeChemin) enigmeCoutante);
        } else if (m.getMessage() == "enigmeChampsDeTextes") {
            EnigmeChampsDeTexte e = (EnigmeChampsDeTexte) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.initialiseEnigme1();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme volume et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeChampsDeTexte((EnigmeChampsDeTexte) enigmeCoutante);
        }
        ////////////////////////////Navigation///////////////////// ////////////
        else if (m.getEtat() == "carteChoisi") {
            this.carteChoisi(m.getMessage());
        } //////////////////////////Traitement Message énigme///////////////////////////////
        else if (m.getEtat() == "MessageComposite") {
            //anayler comment lire la répose
            EnigmeComposite e = (EnigmeComposite) enigmeCoutante;
            boolean fini = e.proposition(m);
            if (fini) {
                //ouvrir une fenetre resultat
                FenetreResultat f = new FenetreResultat();
                f.setPoints(String.valueOf(e.getPoints()));
                f.setVisible(true);
                retourCarte();
            } else {
                fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
            }

        } else if (m.getEtat() == "MessageChampsDeTexte") {
            EnigmeChampsDeTexte e = (EnigmeChampsDeTexte) enigmeCoutante;
            boolean juste;
            juste = e.proposition(m);
            if (juste) {
                FenetreResultat f = new FenetreResultat();
                //f.setPoints(String.valueOf(e.getPoints()));
                f.setVisible(true);
                retourCarte();
            } else {
                fenetrePrincipale.creeVueEnigmeChampsDeTexte((EnigmeChampsDeTexte) enigmeCoutante);
            }
            
        }else if(m.getEtat() == "MessageChemin"){
            EnigmeChemin e = (EnigmeChemin) enigmeCoutante;
            if (e.proposition(m)) {
                FenetreResultat f = new FenetreResultat();
                //f.setPoints(String.valueOf(e.getPoints()));
                f.setVisible(true);
                retourCarte();
            } else {
                fenetrePrincipale.creeVueEnigmeChemin((EnigmeChemin) enigmeCoutante);
            }
        }

    }

    ////////////////////////////////////ACTION EN RÉPONSE À NOTIFICATION////////////////////////////////////
    public void carteChoisi(String titre) {//Attention ne marche pas pour les enigme pour l instant !!!!!!!
        Carte c = (Carte) ((Carte) this.cartes.peek()).getContiens().get(titre);
        this.addCarte(c);
        fenetrePrincipale.creeVue((Carte) this.cartes.peek());
    }

    public void retourCarte() {//Si l'utilisateur clique sur le bouton retour
        this.delCarte();
        fenetrePrincipale.creeVue((Carte) this.cartes.peek());
    }

    private void addCarte(Carte carte) {
        this.cartes.push(carte);
    }

    private void delCarte() {
        this.cartes.pop();
    }
}
