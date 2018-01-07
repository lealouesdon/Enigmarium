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
import Modele.Histoire;
import Modele.Icone;
import Modele.Lieu;
import Vue.FenetreIntro;
import Vue.FenetrePrincipale;
import Vue.FenetreResultat;
import Vue.FenetreScenario;
import java.util.ArrayList;
import java.util.Stack;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Controleur implements Observateur {

    //attributs
    private static String NOMSAUVEGARDE = "sauvegarde";
    private Stack<Lieu> cartes;
    private FenetrePrincipale fenetrePrincipale;
    private Enigme enigmeCoutante;
    private ArrayList<Histoire> histoire;
    private Sauvegarde save;

    //Constructeur
    public Controleur() {
        this.histoire = new ArrayList<Histoire>();
        cartes = new Stack();
        this.chargerPartie();
        InitialiserModel();
        FenetreIntro fIntro = new FenetreIntro();
        fIntro.score(save);
        fIntro.setObservateur(this);
        fIntro.setVisible(true);

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
        Carte mondeMedievale = new Carte(icone, "Ferte Ylia", "images/placeMarche.jpg");
        mondeMedievale.setDescriptif("<html>C'est dans ce monde que tu trouveras les meilleurs ingrédients ! Et des cuisiniers à leur hauteur ...</html>");
        icone = new Icone((float) 0.3, (float) 0.1, "images/mondeArcheologue.png", 350, 400);
        Carte mondeArcheologue = new Carte(icone, "Vuyala", "images/mondeA.jpg");
        mondeArcheologue.setDescriptif("<html> Si vous supportez la poussière, <br> et retournez la terre, <br>vous trouverez trésors, <br> et bien plus encore.</html>");
        icone = new Icone((float) 0.6, (float) 0.3, "images/mondeLasVegas.png", 350, 400);
        Carte MondeLasVegas = new Carte(icone, "Le Refuge", "images/mondeLasVegas.jpg");
        MondeLasVegas.setDescriptif("<html>La gaïté n'est qu'apparente, mais l'espoir subsiste... Lorena a trouvé ce monde, pour tout ceux qui ont perdu les leurs.</html>");
        monde.addContien(mondeMedievale);
        monde.addContien(mondeArcheologue);
        monde.addContien(MondeLasVegas);

        ///////////////////////////////PERSONNAGE ET ENIGMES/////////////////////////////////////
        //monde de la nouriture
        icone = new Icone((float) 0.38, (float) 0.30, null, 300, 200);
        EnigmeComposite andreLePatissier = new EnigmeComposite(icone, "André le Boulanger", "images/vueJeu.png");
        andreLePatissier.setDescriptif("<html>Ma famille et moi même sommes boulanger-pâtissier depuis des générations ! Je travaille avec les fournisseurs de notre monde pour vous offrir mes plus belles créations ! <br> Et si vous, Merlin ou un autre monde avez besoin de mes talents, n'hésitez pas ! </html>");
        mondeMedievale.addContien(andreLePatissier);
        Carte ivanLePaysan = new Carte(new Icone((float) 0.75, (float) 0.35, null, 300, 200), "Ivan Le Paysan", "images/WorkInProgress.png");
        ivanLePaysan.setDescriptif("<html>Aaaaah... avoir la main verte... C'est inné chez moi, l'amour de tout ce qui pousse. Le respect des terres et des plantes, c'est le secret pour faire pousser les meilleurs ingrédients, pour les meilleurs cuisiniers !</html>");
        mondeMedievale.addContien(ivanLePaysan);
        EnigmeChampsDeTexte berengereLaBergere = new EnigmeChampsDeTexte(new Icone((float) 0.10, (float) 0.39, null, 200, 200), "Bérengere la bergere", "images/prés_final_couleur.jpg");
        berengereLaBergere.setDescriptif("<html>J'adore l'air de la montagne. Les paturages à perte de vue, l'odeur des sous-bois, marcher au milieu des moutons ... <br>Tu devrais faire une nuit à la belle étoile au milieu des moutons un jour, y'a rien de plus reposant !</html>");
        mondeMedievale.addContien(berengereLaBergere);
        //monde des archéologues
        icone = new Icone((float) 0.40, (float) 0.35, null, 300, 200);
        EnigmeComposite porteDeLaPyramide = new EnigmeComposite(icone, "La Porte de La Pyramide", "images/enigme 1.jpg");
        porteDeLaPyramide.setDescriptif("<html>C'est très dur d'avancer dans cette pyramide. Ceux qui vivaient ici étaient sans doute de brillants mathématiciens. On ne peut avancer qu'en resolvant des éngimes.  </html>");
        mondeArcheologue.addContien(porteDeLaPyramide);

        //les fouilles
        Carte lesFuilles = new Carte(new Icone((float) 0.05, (float) 0.55, null, 300, 200), "Fouilles abandonnées", "images/WorkInProgress.png");
        lesFuilles.setDescriptif("<html>Ces sites de fouilles ont été abandonnés suite à une invasion de scorpions. Si tu souhaites continuer à fouiller, il va falloir que tu comprennes leur comportement !</html>");
        mondeArcheologue.addContien(lesFuilles);
        //la grotte
        Carte laGrotte = new Carte(new Icone((float) 0.75, (float) 0.50, null, 300, 200), "Grotte", "images/WorkInProgress.png");
        laGrotte.setDescriptif("<html>Voici les grottes, elles sont truffées de pièges, si tu veux les éviter il va te falloir un compagnon programmable afin de passer dans les endroits les plus étriqués. </html>");
        mondeArcheologue.addContien(laGrotte);
        //Monde de LasVegas

        EnigmeChemin machines = new EnigmeChemin(new Icone((float) 0.0, (float) 0.2, null, 300, 600), "Vo, Ame et Hune", "images/jeuMachines.jpg", 3, 3, 1);
        machines.setDescriptif("<html>C'est assez perturbant d'être avec des créatures aussi grandes ! C'est triste d'avoir perdu notre monde mais on s'amuse bien ici. C'est mieux que de dériver dans l'espace en tout cas ! <br> Bon, tu joues avec nous maintenant ?</html>");
        MondeLasVegas.addContien(machines);
        //le poulpe
        Carte lePoulpe = new Carte(new Icone((float) 0.40, (float) 0.2, null, 300, 500), "Grasvz'in", "images/WorkInProgress.png");
        lePoulpe.setDescriptif("<html>Le Refuge... Ce monde porte bien son nom. Peu nombreux sont ceux qui viennent vivre ici de leur plein grès. Ceux que tu vois autour de toi ont tout perdu. Lorena et son ancien apprenti nous ont sauvés lorsque les destructeurs sont venus dans nos mondes, les réduisants à l'état de débris. La joie et l'amusement ne sont qu'une facade, c'est la tristesse et la nostalgie qui s'emparent de nos coeurs... Jamais nous ne retrouverons nos foyers. <br> L'air empeste la peur, les destructeurs, avec Vagnar à leur tête, reviendront plus puissants que jamais. Soyez à la hauteur, et faites les bons choix ...<html>");
        MondeLasVegas.addContien(lePoulpe);
        ///////////////////////////////ENIGMES/////////////////////////////////////
        ////////////////////////////////HISTOIRE DEBUT/////////////////////////////

        //////////////////////////////CECI EST UN APPERCU DE SCENARIO//////////////
        ArrayList personnageEtape1 = new ArrayList<String>();

        personnageEtape1.add("Merlin");
        Histoire etape1 = new Histoire(monde, "<html> <style>html {margin:15px;}</style> "
                + "<p>Le grincement du vieux plancher de ma cabane me sorti de ma somnolence. Je n’étais pas seul. J’entrouvris les yeux pour observer discrètement qui venait donc me rendre visite : un vieil homme se tenait là, versant un thé fumant dans deux de mes tasses en céramique. Une longue cape grise couvrait ses épaules et sa longue barbe grisonnante descendait jusqu’à son poitrail. Un grand bâton, surmonté d’un cristal bleu glace était posé sur l’encadrement de la fenêtre et un grimoire reposait sur le coffre, au pied de mon lit.\n"
                + "S’apercevant que je l’observais, le vieil homme se tourna vers moi : <br>\n"
                + "-	Je me suis permis de faire du thé, dit-il en souriant. <br>\n"
                + "-	Euh… Merci, je suppose. <br>\n"
                + "-	Sais-tu qui je suis ? <br>\n"
                + "-	Merlin, c’est ça ? Je l’avais déjà aperçu sur la place du marché, discutant avec André, notre pâtissier. <br>\n"
                + "-	En effet, et connais-tu mon rôle ? <br>\n"
                + "-	André est resté vague à ce sujet répondis-je, l’esprit encore embrumé. <br>\n"
                + "-	J’espère que tu ne lui en voudras pas, je sais que vous êtes très proche mais c’est aussi un vieil ami. Et je ne tiens pas à ce que tout le monde soit au courant de ma situation. Ainsi, je tiens à ce que toi aussi tu puisses tenir ta langue, peux-tu faire ça pour moi ? <br>\n"
                + "  Je me lève, tire une de mes chaise et m’assois. Je ne reconnais pas l’odeur du thé, Merlin a dû l’apporter. Je trempe mes lèvres et repose la tasse aussitôt, le thé était encore brulant.  <br>\n"
                + "-	Je ne suis pas du genre à divulguer les secrets des autres Merlin, soyez en assuré. Je vous écoute. <br>\n"
                + "-	Voilà une bonne chose...  <br>\n"
                + "Il marque une pause, sont regard dirigé sur les vastes champs et collines que l’on apercevait par la fenêtre. </p> <br></html>", personnageEtape1);
        histoire.add(etape1);

        ArrayList personnageEtape2 = new ArrayList<String>();

        personnageEtape2.add("Merlin");
        Histoire etape2 = new Histoire(monde, "<html>  <style>html {margin:15px;}</style>"
                + "<p>\n"
                + "-	Je suis celui qu’on appelle le Gardien Des Mondes. Ferte Ylia, le monde dans lequel tu vis, n’en n’est qu’un parmi tant d’autres. Mon rôle est de veiller sur ces mondes. Je m’assure que tout ce passe au mieux pour eux et j’interviens régulièrement pour aider leurs habitants, le plus souvent sans qu’ils s’en aperçoivent. <br>\n"
                + "  Il commence sincèrement à m’intriguer. J’avais déjà entendu parler des mondes d’ailleurs, certaines légendes les mentionnaient. Enfant, après la disparition de mes parents, je passais beaucoup de temps à consulter des livres sur le Mythes et Légendes que les habitants du village avaient la gentillesse de me donner. Je commence à en avoir une sacrée collection d’ailleurs. Mais jusqu’alors, c’était seulement des mythes, seul André semblait y croire encore. <br>\n"
                + "-	J’avais fini par me persuader que ce n’était que des histoires. Peu de gens semblent réellement y croire. <br>\n"
                + "-	Parce que peu de gens ont la chance de pouvoir parcourir les mondes. \n"
                + "-	Pourquoi me racontez-vous tout ceci Merlin ? <br>\n"
                + "-	Je te suis depuis la disparition de tes parents et …<br>\n"
                + "-	Vous savez quelques choses ? l’interrompis-je brutalement, soudain très réveillé. <br>\n"
                + "-	Il y’a des choses que tu te dois de découvrir par toi-même, mais laisse-moi répondre à ta précédente question si tu veux bien. <br>\n"
                + "  Je fais la moue mais, résolu à obtenir des réponses plus tard, je continue de l’écouter. <br>\n"
                + "-	Les villageois t’apprécient beaucoup, repris-t-il, et notre cher pâtissier m’a dit beaucoup de bien sur toi. Tu es apparemment très altruiste, curieux et chacun sait ici qu’ils peuvent compter sur toi. Et ce que j’ai vu en t’observant, depuis plus d’un an me conforte dans cette idée. Ainsi j’ai une proposition à te faire. <br>\n"
                + "-	Je vous écoute, répondis-je, curieux. <br>\n"
                + "-	J’aimerais que tu m’accompagne aujourd’hui, que je te montre ce que je fais. Je vieillis, tu es encore jeune et j’aurais besoin de quelqu’un pour prendre la relève quand je ne serais plus capable de tenir mon rôle. <br>\n"
                + "-	Ce qui signifie ? Je ne suis pas sûr de comprendre. <br>\n"
                + "-	Si cette journée te plais et après t’avoir tout expliqué, j’aimerais que tu deviennes mon apprenti. <br></p><br></html>", personnageEtape2);
        histoire.add(etape2);

        ArrayList personnageEtape3 = new ArrayList<String>();

        personnageEtape3.add("Merlin");
        Histoire etape3 = new Histoire(monde, "<html>  <style>html {margin:15px;}</style>"
                + "<p> J’ai le souffle court. Je suis resté dubitatif tout au long de la conversation, ne sachant pas si tout ce qu’il me disait était réel. Ce sont des légendes, des contes qui ont bercés mon enfance et qui me font encore rêver aujourd’hui, mais je pensais encore hier que ce n’était que ça… C’est difficile d’y croire. Et ce vieil homme, s’il n’était un ami d’André, je crois que je l’aurais cru complètement sénile.<br>\n"
                + "  Et voilà qu’il me propose de me montrer tout ça, me donne l’opportunité de constater que les légendes n’en sont pas. Qui sait, j’en deviendrais peut-être une? Cette idée me fit sourire : .<br>\n"
                + "-	Dit, me sermonne-t-il, tu pourrais essayer de me donner une réponse au lieu de sourire comme un idiot! .<br>\n"
                + "  Je vois néanmoins une esquisse de sourire apparaître sous sa longue barbe et son visage s’adoucit. Je me lance : .<br>\n"
                + "-	Je serai honoré de pouvoir vous accompagner aujourd’hui Merlin. .<br>\n"
                + "-	Alors c’est oui! Prépare toi jeune homme, prend de quoi voyager. Ce ne sera pas une journée de tout repos. .<br>\n"
                + "  Sur-ce, il finit sa tasse et commence à rassembler ses affaires. De mon côté, je me précipite pour m’habiller et regrouper ce dont j’aurais besoin. Je prends des chaussures de marche que m’avait donné Bérengère pour que je l’aide pendant les périodes de pâturages. Saisissant mon balluchon pour y mettre quelques bricoles et pris avec moi mon exemplaire des Mondes Merveilleux d’Aryena Muly. Il ne manquait que mon calepin, ma plume et mon encrier et j’étais prêt à partir. .<br>\n"
                + "-	Je suis prêt! Dis-je avec enthousiasme. .<br>\n"
                + "-	Allons-y, prend ma main. .<br>\n"
                + "-	Euh… attendez… On va où et comment là? .<br>\n"
                + "-	Si tu veux m’accompagner, il va falloir que tu me fasses confiance jeune homme! .<br>\n"
                + "Encore hésitant, je prends quand même sa main. .<br>\n"
                + "  Une lumière bleue s’échappe de sa main droite. En regardant de plus près, je vois qu’il porte une chevalière à son doigt. C’est elle qui s’illumine. .<br>\n"
                + "-	Qu’est-ce que ….<br>\n"
                + " </p><br></html>", personnageEtape3);

        histoire.add(etape3);

        ArrayList personnageEtape5 = new ArrayList<String>();
        personnageEtape5.add("Merlin");
        Histoire etape5 = new Histoire(monde, "<html><style>html {margin:15px;}</style>"
                + "<p>Je n’ai pas le temps de terminer ma phrase que tout bascule. C’est indescriptible, tout se distord autour de moi. Les couleurs changent, les formes se tassent et s’étirent, les sons deviennent sourds. J’ai l’impression de voir à une distance infinie sans pouvoir réellement distinguer quoi que ce soit, d’être dans un magma de son, d’images, d’odeurs et de sensations indiscernables. C’est comme si l’univers en entier s’était regroupé autour de moi. Puis tout commença à s’assombrir. <br>\n"
                + "-	Alors ce voyage? <br>\n"
                + "-	Euh… surprenant, je crois m’être évanoui un moment. Dis-je en reprenant mes esprits. Tout était tellement étrange que je n’en suis même pas sûr. <br>\n"
                + "-	Bienvenue dans l’Antre Du gardien! <br>\n"
                + "  Je m’assois doucement et prend le temps d’observer autour de moi. Nous sommes dans une sorte de grotte très confortable. Merlin était assis sur un grand fauteuil en bois, aux coussins pourpres. Je vis deux sortes de miroirs qui attirèrent mon attention. On dirait qu’ils donnent sur d’autres mondes. L’un sur une forêt aux feuilles écarlates et l’autre sur des îles qui semblent suspendues dans les airs. La pièce dans laquelle nous nous situons est assez grande et semble s’ouvrir sur deux autres pièces dont j'ai encore du mal à en distinguer le contenu. Une grande bibliothèque orne le mur derrière le fauteuil de Merlin. Un petit ruisseau surgit d’un mur sur ma gauche, traverse la pièce en son centre avant de disparaître dans le mur situé sur ma droite. Une grande table en pierre se dresse au milieu de la pièce, séparant le ruisseau en deux. Je remarque que l’eau semble remonter sur la table. Cet endroit est de plus en plus étrange. Au vue du sourire de Merlin, Je dois encore prendre mon air idiot. Je décide de me relever. <br>\n"
                + "-	Vas doucement, me conseil-t-il. <br>\n"
                + "  J’aurais mieux fait de l’écouter étant donné que je retombe lamentablement sur mon derrière. Bon, on va essayer une autre approche. Je me mets à quatre pattes et avance doucement vers le ruisseau, encore chancelant. Entendant Merlin tentant de cacher son rire, je me rends compte que je dois avoir l’air vraiment pitoyable. Tant pis, avec ce qu’il se passe ce matin je pense que c’est assez légitime. J’arrive tant bien que mal à atteindre le ruisseau et m’asperge le visage pour essayer de reprendre mes esprits. L’eau tiède me fait du bien. Je tente de m’accrocher à la table pour me relever, glisse et me cogne la tête contre la pierre. Décidément…<br>\n"
                + "-	Prend ma main, Il s’est approché sans que je m’en rende compte. Ne t’en fais pas, on s’y habitue vite. <br>\n"
                + "-	J’espère…<br>\n"
                + "  Il me tire vers le haut. Sacré poigne pour un vieillard! Je prend appui sur la table tout en essayant de garder l’équilibre. Je pose mon regard sur la table. C’est magnifique. Sous mes yeux émerveillés des parties de mondes flottants dans un univers sombre et constellé d’étoiles. <br>\n"
                + "-	Voici la Carte Des Mondes jeunes homme, tu peux y voir tout les mondes sur lesquels je veille depuis l’Antre. <br>\n"
                + "-	Combien est-ce qu’il y en a ? <br>\n"
                + "-	Un bon nombre, et potentiellement une infinité. Il en reste de nombreux à découvrir, tous ne sont pas agréables cependant. <br>\n"
                + "-	Et nous ou somme-nous ? <br>\n"
                + "-	Aucune idée ! Aucun des Gardiens n’est parvenu à trouver l’emplacement de l’Antre, c’est comme si elle était en dehors de l’univers. <br>\n"
                + "-	Ah. J’ai un peu du mal à comprendre le concept, mais je suppose que ça viendra avec le temps. <br>\n"
                + "Merlin dessine un cercle avec son doigt sur la surface de la carte, ce qui a pour effet de zoomer sur trois des mondes. Je crois y reconnaitre le mien, Ferte Ylia.\n"
                + "-	Voici les trois mondes que nous allons visiter aujourd’hui. Ferte Ylia, duquel tu viens, 	Vuyala et Le Refuge. On va commencer par aller voir André, j’aimerais lui annoncer la nouvelle. <br>\n"
                + "-	Eh! On était à côté! <br>\n"
                + "-	Je sais, me répond-t-il avec un grand sourire. <br>\n"
                + "Je sens qu’il se paye vraiment ma tête. Je souris néanmoins. Je suis content de retrouver mon pâtissier. Enfin quelque chose de normal dans cette journée ! <br>\n"
                + "-	Les Archéologues de Vuyala m’ont fait une commande très spéciale, on va avoir besoin des cuisines et du livre de recette d’André. <br>\n"
                + "-	Ils ne peuvent pas le faire là-bas ? <br>\n"
                + "-	Les ingrédients et les techniques de cuisines de ton monde te semblent peut-être familières mais ce sont des choses propres à Ferte Ylia. Chaque monde à ses spécificités. Le rôle du Gardien est de les connaitre afin leurs permettre de s’entraider. <br>\n"
                + "Sur-ce, il me tend la main. Non sans quelques réticences, je ferme les yeux et l’attrape. <br>\n"
                + "</p><br></html>", personnageEtape5);
        histoire.add(etape5);
        

        ArrayList personnageEtape6 = new ArrayList<String>();
        personnageEtape6.add("Merlin");
        personnageEtape6.add("André");
        Histoire etape6 = new Histoire(mondeMedievale, "<html><style>html {margin:15px;}</style>"
                + "<p> Il semble en effet qu’on s’y habitue rapidement. Mise à part un léger déséquilibre, je me sens plutôt bien. Me voilà rassuré."
                + "-	En route jeune homme !"
                + "Nous sommes dans le bois derrière le village. Nous avons quelques minutes à pied avant d’arriver chez André. Je langui de lui parler. Le trajet se passe silencieusement, je suis encore un peu confus et j’essaie de faire le tri dans ma tête mais cela s’avère assez compliqué. Je décide de reporter ça à plus tard lorsque nous arrivons en vue du marché."
                + "J’aperçois André qui, de son étal, me fait de grands signes. J’accours dans sa direction. <br>\n"
                + "-	André! J’ai plein de trucs à te raconter! <br>\n"
                + "-	Bonjour mon petit! Alors Merlin s’est enfin décidé? <br>\n"
                + "-	En effet mon ami, répondit celui-ci. <br>\n"
                + "-	Alors, qu’en penses-tu? me demande André, le sourire jusqu’aux oreilles. <br>\n"
                + "-	J’ai seulement visité la grotte de Merlin pour l’instant mais ça à l’air passionnant! <br>\n"
                + "-	Il ne peut pas en juger pour l’instant, me repris Merlin. Dis moi André, peut-on emprunter ta cuisine un moment? J’aurais besoin de faire un cake à la pieuvre pour nos amis archéologues. Mon jeune compagnon va m’aider. <br>\n"
                + "-	Vas-y, tu connais la route. Toujours leurs problèmes de scorpion ? <br>\n"
                + "-	Oui, je te remercie. Désolé, mais tu vas devoir attendre avant de parler à ton ami jeune homme. Cette journée sera chargée. </p><br></html>", personnageEtape6);
        histoire.add(etape6);

        ArrayList personnageEtape7 = new ArrayList<String>();
        personnageEtape7.add("Merlin");
        personnageEtape7.add("André");
        Histoire etape7 = new Histoire(andreLePatissier, "<html><style>html {margin:15px;}</style>"
                + "<p>   Nous nous dirigeons vers les cuisines, du côté pâtisserie lorsque que Merlin me demande :\n"
                + "-	Tu as déjà réalisé une recette d’André ?\n"
                + "-	Je l’ai déjà regardé, je lui donnais des fois ce dont il avait besoin mais je n’ai jamais fait une recette tout seul.\n"
                + " Nous entrons dans la cuisine, le livre de recette est posé sur son plan de travail et les ingrédients sur des étagères en bois. Tout les ustensiles sont étiquetés et organisés en dessous des ingrédients. Un vrai maniaque ce moustachu! Merlin ouvre le livre à la page du cake à la pieuvre et me montre la recette : <br> \n"
                + "-	Tiens, ce sera simple. Tu as les mesures des pots et les quantités nécessaires pour chaque ingrédient. À toi de trouver le bon contenant, et de les associer aux bons aliments! Si tu as besoins d’aide, tu peux me demander. <br> </p><br></html>", personnageEtape6);
        histoire.add(etape7);
        ////////////////////////////////HISTOIRE FIN/////////////////////////////        
        histoire.add(null);// tres important pour qu'il n'y ai pas d'erreur une fois l'histoire fini

    }

    //controleur et un observateur de la fenetre principale, la fenetre parametre et la fenetre 
    @Override
    public void notification(Message m) {
        if (m.getEtat() == "retour") {
            retourCarte();
        } else if (m.getEtat() == "suivantHistoire") {
            checkHistoire();
        } else if (m.getEtat() == "start") {
            if (m.getAtt1() != null) {
                if (m.getAtt1() == "fille" || m.getAtt1() == "garçon") {
                    this.save = new Sauvegarde(m.getAtt2(), m.getAtt1(), 0, 0);
                }
            }

            if (fenetrePrincipale == null || (m.getMessage() != null && m.getMessage().equals("new"))) {
                InitialiserVue();
                fenetrePrincipale.creeVue((Carte) this.cartes.peek());
                fenetrePrincipale.setVisible(true);//lance la vue pour pouveoir jouer
                this.checkHistoire();
            } else {
                fenetrePrincipale.setVisible(true);

            }

        } else if (m.getEtat() == "menu") {
            FenetreIntro f = new FenetreIntro();
            f.setObservateur(this);
            f.score(save);
            f.setVisible(true);

        } else if (m.getEtat() == "fermer") {
            this.enregistrerPartie();
            System.exit(0);
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
        } else if (m.getMessage() == "Vo, Ame et Hune") {
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
        } ////////////////////////////Navigation///////////////////// //////////////////////
        else if (m.getEtat() == "carteChoisi") {
            this.carteChoisi(m.getMessage());
            checkHistoire();
        } //////////////////////////Traitement Message énigme///////////////////////////////
        else if (m.getEtat() == "MessageComposite") {
            //anayler comment lire la répose
            EnigmeComposite e = (EnigmeComposite) enigmeCoutante;
            boolean fini = e.proposition(m);
            if (fini) {
                //ouvrir une fenetre resultat
                FenetreResultat f = new FenetreResultat();
                this.save.setScore(this.save.getScore() + e.getPoint());
                f.setPoints(String.valueOf(e.getPoint()));
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
                this.save.setScore(this.save.getScore() + e.getPoint());
                f.setPoints(String.valueOf(e.getPoint()));
                f.setVisible(true);
                retourCarte();
            } else {
                fenetrePrincipale.creeVueEnigmeChampsDeTexte((EnigmeChampsDeTexte) enigmeCoutante);
            }
        } else if (m.getEtat() == "MessageChemin") {
            EnigmeChemin e = (EnigmeChemin) enigmeCoutante;
            if (e.proposition(m)) {
                FenetreResultat f = new FenetreResultat();
                this.save.setScore(this.save.getScore() + e.getPoint());
                f.setPoints(String.valueOf(e.getPoint()));
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

    public void checkHistoire() {
        int iterHistoire = this.save.getHistoire();
        if (histoire.get(iterHistoire) != null && histoire.get(iterHistoire).getLieu() == cartes.peek()) {
            FenetreScenario fenetreScen = new FenetreScenario(histoire.get(iterHistoire).getSenario(), histoire.get(iterHistoire).getPersonnages(), save.getSex());
            fenetreScen.setObservateur(this);
            fenetreScen.setVisible(true);
            this.save.setHistoire(this.save.getHistoire() + 1);
        }
    }

    public static String getNOMSAUVEGARDE() {
        return NOMSAUVEGARDE;
    }

    private void enregistrerPartie() {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(this.getNOMSAUVEGARDE()))));
            oos.writeObject(this.save);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void chargerPartie() {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File(this.getNOMSAUVEGARDE()))));
            this.save = (Sauvegarde) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            this.save = new Sauvegarde();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
//histoire[iterHistoire].getLieu()==cartes.peek(
