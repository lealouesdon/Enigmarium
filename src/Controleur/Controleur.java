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
import Modele.Histoire;
import Modele.Icone;
import Modele.Lieu;
import Modele.Personnage;
import Vue.FenetreDialogue;
import Vue.FenetreIndice;
import Vue.FenetreIntro;
import Vue.FenetrePrincipale;
import Vue.FenetreResultat;
import Vue.FenetreScenario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Stack;

public class Controleur implements Observateur {

    //attributs
    private Stack<Lieu> cartes;
    private FenetreIndice fenetreIndice;
    private FenetrePrincipale fenetrePrincipale;
    private Enigme enigmeCoutante;
    private ArrayList<Histoire> histoire;
    private int iterHistoire;

    //Constructeur
    public Controleur() throws SQLException {
        this.histoire=new ArrayList<Histoire>();
        this.iterHistoire=0;
        cartes = new Stack();
        InitialiserModel();
        InitialiserVue();
        fenetrePrincipale.creeVue((Carte) this.cartes.peek());
        FenetreIntro fIntro = new FenetreIntro();//pour la démo
        fenetrePrincipale.setVisible(true);//lance la vue pour pouveoir jouer
        fIntro.setVisible(true);
        fIntro.toFront();
        this.checkHistoire();
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
        state.close();
        */
        /////////////////////////////////MONDE///////////////////////////////////////
        Icone icone = new Icone((float) 0.05, (float) 0.2, "images/mondeCuisiniers.png", 300, 450);
        Carte mondeMedievale = new Carte(icone, "Ferte Ylia", "images/placeMarche.jpg");
        mondeMedievale.setDescriptif("<html>C'est dans ce monde qui tu trouveras les meilleurs ingrédients ! Et des cuisiniers à leurs hauteurs ...</html>");
        
        icone = new Icone((float) 0.3, (float) 0.1, "images/mondeArcheologue.png", 350, 400);
        Carte mondeArcheologue = new Carte(icone, "Monde des Archeologue", "images/mondeA.jpg");
        mondeArcheologue.setDescriptif("<html> Si vous suportez la poussiere, <br> et retournez la terre, <br>vous trouverez trésors, <br> et bien plus encore.</html>");
        icone = new Icone((float) 0.6, (float) 0.3, "images/mondeLasVegas.png", 350, 400);
        Carte MondeLasVegas = new Carte(icone, "Le Refuge", "images/mondeLasVegas.jpg");
        MondeLasVegas.setDescriptif("<html>La gaité n'est qu'apparente, mais l'espoir subsiste... Lorena a trouvée ce monde, pour tout ceux qui ont perdu le leur.</html>");
        monde.addContien(mondeMedievale);
        monde.addContien(mondeArcheologue);
        monde.addContien(MondeLasVegas);
        
        ///////////////////////////////PERSONAGE ET ENIGMES/////////////////////////////////////
        //monde de la nouriture
        icone = new Icone((float) 0.38, (float) 0.30, null, 300, 200);
        EnigmeComposite andreLePatissier = new EnigmeComposite(icone, "André le Boulanger", "images/vueJeu.png");  
        andreLePatissier.setDescriptif("<html>Ma famille et moi même sommes boulanger-pâtissier depuis des générations ! Je travaille avec les fournisseurs de notre monde pour vous offrir mes plus belles créations ! <br> Et si vous, Merlin ou un autre monde avez besoin de mes talents, n'hésitez pas ! </html>");
        mondeMedievale.addContien(andreLePatissier);
        Carte ivanLePaysan = new Carte(new Icone((float) 0.75, (float) 0.35, null, 300, 200),"Ivan Le Paysant",null);
        ivanLePaysan.setDescriptif("<html>Aaaaah... avoir la main verte... C'est innée chez moi, l'amour de tout ce qui pousse. Le respect des terres et des plantes, c'est le secret pour faire pousser les meilleurs ingrédients, pour les meilleurs cuisiniers !</html>");
         mondeMedievale.addContien(ivanLePaysan);
        //EnigmeChemin psoupe = new EnigmeChemin(new Icone((float) 0.10, (float) 0.39, null, 200, 200), "Les Machines a sous", null,2,3,1);
        //mMedie.addContien(psoupe);
        EnigmeChampsDeTexte berengereLaBergere =new EnigmeChampsDeTexte(new Icone((float) 0.10, (float) 0.39, null, 200, 200),"Bérengere la bergere","images/prés_final_couleur.jpg");
        berengereLaBergere.setDescriptif("<html>J'adore l'air de la montagne. Les paturages à pertes de vue, l'odeur des sous-bois, marcher au milieu des moutons ... <br>Tu devrais faire une nuit à la belle étoile au milieu des moutons un jour, y'a rien de plus reposant !</html>");
        mondeMedievale.addContien(berengereLaBergere);
        //monde des archéologues
        icone = new Icone((float) 0.40, (float) 0.35, null, 300, 200);
        EnigmeComposite porteDeLaPyramide = new EnigmeComposite(icone, "La Porte de La Pyramide", "images/enigme 1.jpg");
        porteDeLaPyramide.setDescriptif("<html>C'est très dur d'avancer dans cette pyramide.Ceux qui vivaient ici étaient sans doute de brillant mathématiciens. On ne peut avancer qu'en resolvant des éngimes.  </html>");
        mondeArcheologue.addContien(porteDeLaPyramide);
        
        //les fouilles
        Carte lesFuilles = new Carte(new Icone((float) 0.05, (float) 0.55, null, 300, 200),"Fouilles abandonnées",null);
        lesFuilles.setDescriptif("<html>Ces sites de fouilles ont été abandonnés suite à une invasion de scorpion. Si tu souhaite continuer à fouiller va falloir que tu comprenne leur comportement !</html>");
        mondeArcheologue.addContien(lesFuilles);
        //la grotte
        Carte laGrotte = new Carte(new Icone((float) 0.75, (float) 0.50, null, 300, 200),"Grotte",null);
        laGrotte.setDescriptif("<html>Voici les grottes, elles sont truffées de pièges, si tu veux les eviter il va te falloir un compagon programmable afin de passer dans les endroits les plus étriqués. </html>");
        mondeArcheologue.addContien(laGrotte);
        //Monde de LasVegas
        
        EnigmeChemin machines = new EnigmeChemin(new Icone((float) 0.0, (float) 0.2, null, 300, 600), "Vo, Ame et Hune", "images/jeuMachines.jpg",3,3,1);
        machines.setDescriptif("<html>C'est assez perturbant d'être avec des créatures aussi grandes ! C'est triste d'avoir perdu notre monde mais on s'amuse bien ici. C'est mieux que dériver dans l'espace en tout cas ! <br> Bon, tu joues avec nous maintenant ?</html>");
        MondeLasVegas.addContien(machines);
        //le poulpe
        Carte lePoulpe = new Carte(new Icone((float) 0.30, (float) 0.15, null, 300, 200),"Grasvz'in",null);
        lePoulpe.setDescriptif("<html>Le Refuge... Ce monde porte bien son nom. Peu nombreux sont ceux qui viennent vivre ici de leur plein grès. Ceux que tu vois autour de toi ont tout perdu. Lorena et son ancien apprenti nous on sauvés lorsque les déstructeurs sont venu dans nos mondes, les réduisants à l'état de débris. La joie et l'amusement ne sont qu'une facade, c'est la tristesse et la nostalgie qui s'emparent de nos coeur... Jamais nous ne retrouverons nos foyers. <br> L'air empeste la peur, les destructeurs, avec Vagnar à leur tête, reviendront plus puissant que jamais. Soyez à la hauteur, et faites les bon choix ...<html>");
        MondeLasVegas.addContien(lePoulpe);
        ///////////////////////////////ENIGMES/////////////////////////////////////
        ////////////////////////////////HISTOIRE////////////////////////////////////
        Histoire etape1=new Histoire(monde,"test histoire");
        histoire.add(etape1);
        Histoire etape2=new Histoire(mondeMedievale,"lasuite");
        histoire.add(etape2);
        
    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        if (m.getEtat() == "retour") {
            retourCarte();
        } ////////////////////////Initialisation d'énigme//////////////////////////////////////////////
        else if (m.getMessage() == "André le Boulanger") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeVolume();
            addCarte(enigmeCoutante);
            //trouve la carte énigme volume et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
        } else if (m.getMessage() == "La Porte de La Pyramide") {
            EnigmeComposite e = (EnigmeComposite) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.enigmeExpression();
            addCarte(enigmeCoutante);
            //trouve la carte énigme expression et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeComposite((EnigmeComposite) enigmeCoutante);
        }else if(m.getMessage() == "Vo, Ame et Hune"){
            EnigmeChemin e = (EnigmeChemin) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.initialiserEnigme();
            addCarte(enigmeCoutante);
            //trouve la carte énigme expression et la met en enigme courante
            fenetrePrincipale.creeVueEnigmeChemin((EnigmeChemin) enigmeCoutante);
        } else if (m.getMessage() == "Bérengere la bergere") {
            EnigmeChampsDeTexte e = (EnigmeChampsDeTexte) ((Carte) this.cartes.peek()).getContiens().get(m.getMessage());
            enigmeCoutante = e;
            e.initialiseEnigme1();
            addCarte(enigmeCoutante);
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

    private void addCarte(Lieu lieu) {
        this.cartes.push(lieu);
        checkHistoire();
    }

    private void delCarte() {
        this.cartes.pop();
        checkHistoire();
    }
    public void checkHistoire(){
        if(histoire.get(iterHistoire).getLieu()==cartes.peek()){
            FenetreScenario fenetreScen = new FenetreScenario(histoire.get(iterHistoire).getSenario());
            fenetreScen.setVisible(true);
            this.iterHistoire++;
        }
    }
}
//histoire[iterHistoire].getLieu()==cartes.peek(
