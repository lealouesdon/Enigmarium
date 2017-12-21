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
        //créeation d un triangle rectange ave des valeurs de coter comprise entre 1 et 20
        int a= (int) (Math.random() * (1 + 1 - 20) + 20);
        int b=(int) (Math.random() * (1 + 1 - 20) + 20);
        int c=a*a+b*b;
        System.out.println(c);
        this.valAttendu= String.valueOf(c);
        this.question="<html>Coter a= "+String.valueOf(a)+" <br /> "+"Coter b= "+String.valueOf(b)+" <br /> "+"rep "+String.valueOf(this.valAttendu)+"</html>";
    }

    public String getValAttendu() {
        return valAttendu;
    }

    public String getQuestion() {
        return question;
    }
    
    @Override
    //proposition verifi que la valeur envoyer dans le message 
    //correspond a valAttendu.
    public boolean proposition(Message m){
        return m.getAtt1().equals(valAttendu);
        
    }
    
    
}
