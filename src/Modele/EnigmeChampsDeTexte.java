/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Controleur.Message;

/**
 *
 * @author Léa
 */
public class EnigmeChampsDeTexte extends Enigme{
    
    private String valAttendu;
    private String question;
    
    public EnigmeChampsDeTexte(Icone icone, String nom, String fond) {
        super(icone, nom, fond);
    }
    
    public void initialiseEnigme1(){//initialisation pour l'enigme de Bérangere la bergere
        //créeation d un triangle rectange avec des valeurs de coter comprise entre 1 et 20
        int a= (int) (Math.random() * (1 + 1 - 20) + 20);
        int b=(int) (Math.random() * (1 + 1 - 20) + 20);
        int c=a*a+b*b;
        this.valAttendu= String.valueOf(((int)((Math.sqrt(c))*100))/100f);
        this.question="<html><center><br><br>Il faut chercher le côté Bleu.<br> Berangère sait que: <br> -le côté Jaune mesure " + String.valueOf(a) + " mètres" + "<br>-le côté Rouge mesure " + String.valueOf(b) + " mètres<br> "+"La barrière Rouge est perpendiculaire a la barrière Jaune" + "(rep " + String.valueOf(this.valAttendu) + ")" + "</center></html>";
        //indice
        super.setIndice("images/indices/indice_pytha.png");
        super.setRegle("<html>Vous devez trouver la longueur de la clôture que Bérangère devras acheter.</html>");
    }

    public String getValAttendu() {
        return valAttendu;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    

    public String getQuestion() {
        return question;
    }
    
    @Override
    //proposition verifi que la valeur envoyer dans le message 
    //correspond a valAttendu.
    public boolean proposition(Message m){
        String unZero=m.getAtt1()+"0";
        String deuxZero=m.getAtt1()+".00";
        return m.getAtt1().equals(valAttendu) ||unZero.equals(valAttendu)||deuxZero.equals(valAttendu);
        
    }
    
    public int getPoint(){
        return 100;
    }
    
    
}
