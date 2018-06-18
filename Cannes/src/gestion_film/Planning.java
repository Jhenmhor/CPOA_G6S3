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
public class Planning {

    private final int id;
    ArrayList<Film> listFilm = new ArrayList<>();
    private ArrayList<Evenement> listEvenement;

    public Planning(int id, ArrayList<Film> listFilm) {
        this.id = id;
        this.listFilm = listFilm;
    }

    public boolean addEvenement(Evenement e) {

        for (Evenement event : this.listEvenement) {
            if (e.getLieu() == event.getLieu()) {
                if ((e.getDateDebut().compareTo(event.getDateDebut()) == -1 && e.getDateFin().compareTo(event.getDateDebut()) == 1)
                        || (e.getDateFin().compareTo(event.getDateFin()) == 1 && e.getDateDebut().compareTo(event.getDateFin()) == -1)) {

                    return false;
                }
            }
        }
        this.listEvenement.add(e);
        return true;
    }

    public void delEvenement(Evenement e) {
        ListIterator<Evenement> iter = this.listEvenement.listIterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == e.getId()) {
                iter.remove();
            }
        }
    }

    public String checkPlanning() {

        for (Film film : this.listFilm) {

            int nbevent = 0;

            for (Evenement event : this.listEvenement) {
                if (event.getFilm().getType().equals(film.getType())) {
                    nbevent += 1;
                }
            }

            switch (film.getType()) {
                case "LM": {
                    if (nbevent < 2) {
                        System.out.println(film.getNom() + "n'est pas diffusé deux fois.\n");
                    }
                    break;
                }
                case "HC": {
                    if (nbevent < 1) {
                        System.out.println(film.getNom() + "n'est pas diffusé.\n");
                    }
                    break;
                }
                case "UCR": {
                    if (nbevent < 1) {
                        System.out.println(film.getNom() + "n'est pas diffusé.\n");
                    }
                    break;
                }
                case "CM": {
                    if (nbevent < 1) {
                        System.out.println(film.getNom() + "n'est pas diffusé.\n");
                    }
                    break;
                }
            }

        }
        return "Planning Bon";
    }
    
    public
    
    
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Getter">

    public int getId() {
        return id;
    }

    public ArrayList<Evenement> getListEvenement() {
        return listEvenement;
    }

//</editor-fold>
}
