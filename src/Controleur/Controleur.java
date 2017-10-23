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

public class Controleur implements Observateur {

    //attributs
    private Stack<Carte> cartes;
    private FenetreIndice fenetreIndice;
    private FenetreParametre fenetreParametre;
    private FenetrePrincipale fenetrePrincipale;

    //Constructeur
    public Controleur() {

        fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.setObservateur(this);
        cartes = new Stack();
        InitialiserModel();
        //InitialiserVue();
        fenetrePrincipale.creeVue(this.cartes.peek());
        fenetrePrincipale.setVisible(true);
    }
    //methodes

    private void InitialiserVue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void InitialiserModel() {
        Carte monde = new Carte(null, "Carte des mondes");
        cartes.push(monde);
        Carte mMedie = new Carte(new Icone(100, 10), "carte medieval");
        Carte mArche = new Carte(new Icone(50, 120), "carte archeologie");
        monde.addContien(mMedie);
        monde.addContien(mArche);

    }

    private void CarteChoisie(String carte) {
        //Carte cae= cartes.peek().getContiens().get(carte);

    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        System.out.print(m.getIndice());
    }


    public void carteChoisi(String titre){//Attention ne marche pas pour les enigme pour l instant !!!!!!!
        Carte c = (Carte) this.cartes.peek().getContiens().get(titre);
        fenetrePrincipale.creeVue(c);

    }
}
