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
import static Controleur.ConnectionDB.ConnecterDB;
import Modele.Carte;
import Modele.Enigme;
import Modele.EnigmeChampsDeTexte;
import Modele.EnigmeChemin;
import Modele.EnigmeComposite;
import Modele.Icone;
import Modele.Lieu;
import Modele.Personnage;
import Vue.FenetreIndice;
import Vue.FenetreIntro;
import Vue.FenetrePrincipale;
import Vue.FenetreResultat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class Controleur implements Observateur {

    //attributs
    private Stack<Lieu> cartes;
    private FenetreIndice fenetreIndice;
    private FenetrePrincipale fenetrePrincipale;
    private Enigme enigmeCoutante;

    //Constructeur
    public Controleur() throws SQLException {

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

    private void InitialiserModel() throws SQLException {//initialise toute les carte du model
        Carte monde = new Carte(null, "Carte des mondes", "images/galaxy.jpg", false);

        cartes.push(monde);
        ///////////////////////////////BASE DE DONNES////////////////////////////////
        /*Connection conn = ConnecterDB();
        Statement state = conn.createStatement();
        ResultSet res = state.executeQuery("Select nomM from Monde;");
        ResultSetMetaData resFin = res.getMetaData();
        res.close();
        state.close();*/
        
        
        /////////////////////////////////MONDE///////////////////////////////////////
        Icone icone = new Icone((float) 0.05, (float) 0.2, "images/mondeCuisiniers.png", 300, 450);
        Carte mondeMedievale = new Carte(icone, "Monde des Cuisiniers", "images/placeMarche.jpg");
        icone = new Icone((float) 0.3, (float) 0.1, "images/mondeArcheologue.png", 350, 400);
        Carte mondeArcheologue = new Carte(icone, "Monde des Archeologue", "images/mondeA.jpg");
        icone = new Icone((float) 0.6, (float) 0.3, "images/mondeLasVegas.png", 350, 400);
        Carte MondeLasVegas = new Carte(icone, "Monde de Las Vegas", "images/mondeLasVegas.jpg");
        monde.addContien(mondeMedievale);
        monde.addContien(mondeArcheologue);
        monde.addContien(MondeLasVegas);
        ///////////////////////////////PERSONAGE ET ENIGMES/////////////////////////////////////
        //monde de la nouriture
        icone = new Icone((float) 0.38, (float) 0.30, null, 300, 200);
        EnigmeComposite andreLePatissier = new EnigmeComposite(icone, "Hervé le Boulanger", "images/vueJeu.png");  
        mondeMedievale.addContien(andreLePatissier);
        Carte ivanLePaysan = new Carte(new Icone((float) 0.75, (float) 0.35, null, 300, 200),"IvanLePaysant",null);
        ivanLePaysan.setDescriptif("Ivan le paysant");
         mondeMedievale.addContien(ivanLePaysan);
        //EnigmeChemin psoupe = new EnigmeChemin(new Icone((float) 0.10, (float) 0.39, null, 200, 200), "Les Machines a sous", null,2,3,1);
        //mMedie.addContien(psoupe);
        EnigmeChampsDeTexte berengereLaBergere =new EnigmeChampsDeTexte(new Icone((float) 0.10, (float) 0.39, null, 200, 200),"Bérengere la bergere","images/prés_final.jpg");
        berengereLaBergere.setDescriptif("kkzkzkzkzkzkzkzkzk");
        mondeMedievale.addContien(berengereLaBergere);
        //monde des archéologues
        icone = new Icone((float) 0.40, (float) 0.35, null, 300, 200);
        EnigmeComposite porteDeLaPyramide = new EnigmeComposite(icone, "La Porte de La Pyramide", "images/enigme 1.jpg");
        mondeArcheologue.addContien(porteDeLaPyramide);
        
        //les fouilles
        Carte lesFuilles = new Carte(new Icone((float) 0.05, (float) 0.55, null, 300, 200),"lesFouilles",null);
        mondeArcheologue.addContien(lesFuilles);
        //la grotte
        Carte laGrotte = new Carte(new Icone((float) 0.75, (float) 0.50, null, 300, 200),"laGrotte",null);
        mondeArcheologue.addContien(laGrotte);
        //Monde de LasVegas
        
        EnigmeChemin machines = new EnigmeChemin(new Icone((float) 0.0, (float) 0.2, null, 300, 600), "Les Machines a sous", "images/jeuMachines.jpg",3,3,1);
        MondeLasVegas.addContien(machines);
        //le poulpe
        Carte lePoulpe = new Carte(new Icone((float) 0.30, (float) 0.15, null, 300, 200),"LePoulpe",null);
        MondeLasVegas.addContien(lePoulpe);
        ///////////////////////////////ENIGMES/////////////////////////////////////
        
    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        if (m.getEtat() == "retour") {
            retourCarte();
        } ////////////////////////Initialisation d'énigme//////////////////////////////////////////////
        else if (m.getMessage() == "Hervé le Boulanger") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeVolume();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme volume et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
        } else if (m.getMessage() == "La Porte de La Pyramide") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeExpression();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme expression et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
        }else if(m.getMessage() == "Les Machines a sous"){
            EnigmeChemin e = (EnigmeChemin) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.initialiserEnigme();
            this.cartes.push(enigmeCoutante);
            //trouve la carte énigme expression et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeChemin((EnigmeChemin) enigmeCoutante);
        } else if (m.getMessage() == "Bérengere la bergere") {
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
