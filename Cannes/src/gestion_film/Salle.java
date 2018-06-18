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
    private final ArrayList<Date> horaires;

    public Salle(String nom, ArrayList<Date> horaires) {
        this.nom = nom;
        this.horaires = horaires;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public static DateFormat getHoraireFormat() {
        return horaireFormat;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Date> getHoraires() {
        return horaires;
    }
//</editor-fold>

}
