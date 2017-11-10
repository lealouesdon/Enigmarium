/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author Léa
 */
public abstract class Enigme extends Lieu {

    private static String DESCRIPTION;
    private String indice;

    public Enigme(Icone icone,String nom, String fond) {
       super(icone,nom,fond);
       
    }
    
    public static void setDESCRIPTION(String DESCRIPTION) {
        Enigme.DESCRIPTION = DESCRIPTION;
    }

    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }
    
    

    public String getIndice() {
        return indice;
    }
    
    
    public void setIndice(String indice){
        this.indice=indice;
    }
    
   
    
    
}
