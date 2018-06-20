/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.*;
import java.util.*;
import java.time.*;

/**
 *
 * @author Toussaint
 */
public class Film {

    private int ID;
    private String nom;
    private String realisateur;
    private String type;
    private Duration duree;

    public Film(int ID, String nom, String realisateur, String type, Duration duree) {
        this.ID = ID;
        this.nom = nom;
        this.realisateur = realisateur;
        this.type = type;
        this.duree = duree;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public Duration getDuree() {
        return duree;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }

    //</editor-fold>
}
