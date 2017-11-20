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
public class Expression extends Element {

    private static int MAXa = 1;
    private static int MINa = 10;
    private static int MAXb = 20;
    private static int MINb = 0;
    private static int MAXx = 5;
    private static int MINx = 1;

    private int a;
    private int b;
    private float x;

    public Expression(String nom, Icone icone) {
        super(nom, icone);
        //initialiser a et b
        init();
    }

    @Override
    public String affichage() {
        if (b > 0) {
            return a + "x + " + b + " = 0";
        } else if (b < 0) {
            return a + "x " + b + " = 0";
        } else {
            return a + "x" + " = 0";
        }

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    private void init() {
        this.a = (int) (Math.random() * (MAXa + 1 - MINa) + MINa);
        this.b = (int) (Math.random() * (MAXb + 1 - MINb) + MINb);
        this.x = (int) (Math.random() * (MAXx + 1 - MINx) + MINx);
        int i =(int) (a*x+b);
        b=b-i;
    }
    public float getX(){
        return this.x;
    }
}
