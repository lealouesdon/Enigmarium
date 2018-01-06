/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.io.Serializable;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

/**
 *
 * @author Tangui
 */
public class Sauvegarde implements Serializable{
    private String pseudo, sex;
    private double score;
    private int histoire;

    public Sauvegarde(){
        this.pseudo = null;
        this.sex = null;
        this.score = 0;
        this.histoire = 0;        
    }
    
    public Sauvegarde(String pseudo, String sex, double score, int histoire) {
        this.pseudo = pseudo;
        this.sex = sex;
        this.score = score;
        this.histoire = histoire;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
       
    public int getHistoire() {
        return histoire;
    }

    public void setHistoire(int histoire) {
        this.histoire = histoire;
    }
    
    
    @Override
    public String toString(){
        return "Pseudo: " + this.getPseudo() + "\n"
                + "Sexe : " + this.getSex() + "\n"
                + "Score : " + this.getScore() + "\n"
                + "Avancée dans l'histoire : " + this.getHistoire();
    }
}

