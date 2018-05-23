/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_film;
import java.text.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Toussaint
 */
public class Salle {
    
    private static final DateFormat horaireFormat = new SimpleDateFormat("HH:mm:ss");
    private final String nom;
    private final ArrayList<SimpleDateFormat> horaires;

    public Salle(String nom, ArrayList<SimpleDateFormat> horaires) {
        this.nom = nom;
        this.horaires = horaires;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<SimpleDateFormat> getHoraires() {
        return horaires;
    }
    
    
}
