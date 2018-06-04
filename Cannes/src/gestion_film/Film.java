/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_film;
import java.text.*;
import java.util.*;
import java.time.*;

/**
 *
 * @author Toussaint
 */
public class Film {
    
    private final String nom;
    private final String auteur;
    private final String type;
    private final Duration duree;

    public Film(String nom, String auteur, String type, Duration duree) {
        this.nom = nom;
        this.auteur = auteur;
        this.type = type;
        this.duree = duree;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public String getNom() {
        return nom;
    }
    
    public String getType() {
        return type;
    }
    
    public Duration getDuree() {
        return duree;
    }
    //</editor-fold>
    
}
