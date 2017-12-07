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
        this.valAttendu="10";
        this.question="La reponce est dix en chifre";
        
    }

    public String getValAttendu() {
        return valAttendu;
    }

    public String getQuestion() {
        return question;
    }
    
    @Override
    public boolean proposition(Message m){
        return m.getAtt1().equals(valAttendu);
        
    }
    
    
}
