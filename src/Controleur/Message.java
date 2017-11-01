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
public class Message {
    //messages entre l'observateur et l'observé
    private String message;
    private String etat;
    private String att1;
    private String att2;
    
    public Message(){}

    public String getMessage() {
        return message;
    }

    public void setAtt1(String att1) {
        this.att1 = att1;
    }

    public void setAtt2(String att2) {
        this.att2 = att2;
    }

    public String getAtt1() {
        return att1;
    }

    public String getAtt2() {
        return att2;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }
    
}
