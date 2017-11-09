/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Léa
 */
public class Composition {
    private Element elem1;
    private Element elem2;
    
    Composition(Element elem1,Element elem2){
        this.elem1=elem1;
        this.elem2=elem2;
    }

    public Element getElem1() {
        return elem1;
    }

    public Element getElem2() {
        return elem2;
    }
    
}
