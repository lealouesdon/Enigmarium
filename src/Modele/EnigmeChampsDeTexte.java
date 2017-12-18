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
    
    public void initialiseEnigme1(){
        int a= (int) (Math.random() * (1 + 1 - 20) + 20);
        int b=(int) (Math.random() * (1 + 1 - 20) + 20);
        int c=a*a+b*b;
        System.out.println(c);
        this.valAttendu= String.valueOf(c);
        this.question="Coter a= "+String.valueOf(a)+" Coter b= "+String.valueOf(b)+"rep "+String.valueOf(this.valAttendu);
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
