/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author etien
 */
public class Fraction extends Place{
    
    private String fraction;
    
    public Fraction(float res) {
        super(res);
        this.fraction=toFraction(super.getRes(),1000000);
    }
    
    public static String toFraction(float d, int factor) {
    StringBuilder sb = new StringBuilder();
    if (d < 0) {
        sb.append('-');
        d = -d;
    }
    long l = (long) d;
    double nbpile=0;
    if (l != 0) nbpile=l;
    d -= l;
    float error = Math.abs(d);
    int bestDenominator = 1;
    for(int i=2;i<=factor;i++) {
        float error2 = Math.abs(d - (float) Math.round(d * i) / i);
        if (error2 < error) {
            error = error2;
            bestDenominator = i;
        }
    }
    if (bestDenominator > 1)
        sb.append(' ').append(Math.round(nbpile*bestDenominator+d * bestDenominator)).append('/') .append(bestDenominator);
    return sb.toString();
}

    public String getFraction() {
        return fraction;
    }
    
    
}
