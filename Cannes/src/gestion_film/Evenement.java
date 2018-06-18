/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_film;

import java.text.*;
import java.util.*;

/**
 *
 * @author Toussaint
 */
public class Evenement {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final int id;
    private String info;
    private Film film;
    private Salle lieu;
    private Date dateDebut;
    private Date dateFin;

    public Evenement(int id) {
        this.id = id;
    }

    public Evenement(int id, String info, Film film, Salle lieu, String dateDebut, String dateFin) {
        this.id = id;
        this.info = info;
        this.lieu = lieu;
        this.film = film;
        try {
            this.dateDebut = dateFormat.parse(dateDebut);
            this.dateFin = dateFormat.parse(dateFin);

        } catch (Exception e) {
            System.out.println("Erreur format Date");
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Salle getLieu() {
        return lieu;
    }

    public void setInfo(Salle lieu) {
        this.lieu = lieu;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        try {
            this.dateDebut = dateFormat.parse(dateDebut);
        } catch (Exception e) {
            System.out.println("Erreur format Date");
        }
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        try {
            this.dateDebut = dateFormat.parse(dateFin);
        } catch (Exception e) {
            System.out.println("Erreur format Date");
        }
    }
    //</editor-fold>

}
