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
    private ArrayList<Film> listFilm = new ArrayList<>();
    private ArrayList<Evenement> listEvenement;
    private ArrayList<Salle> listSalle;
    private Date dateDebut;

    public Planning(int id, ArrayList<Film> listFilm, String dateDebut) {
        this.id = id;
        this.listFilm = listFilm;
        try {
            this.dateDebut = Evenement.getDateFormat().parse(dateDebut);
        } catch (Exception e) {
            System.out.println("Erreur Format Date");
        }

        DateFormat formatHoraire = Salle.getHoraireFormat();
        DateFormat dateFormat = Evenement.getDateFormat();

        ArrayList<Date> listHoraireGTL = null;
        ArrayList<Date> listHoraireDeb = null;
        ArrayList<Date> listHoraireBun = null;
        ArrayList<Date> listHoraireSoi = null;
        ArrayList<Date> listHoraireBaz = null;

        try {

            //<editor-fold defaultstate="collapsed" desc="List Horaire Salle">
            listHoraireGTL.add(formatHoraire.parse("08:30:00"));
            listHoraireGTL.add(formatHoraire.parse("11:30:00"));
            listHoraireGTL.add(formatHoraire.parse("14:00:00"));
            listHoraireGTL.add(formatHoraire.parse("15:00:00"));
            listHoraireGTL.add(formatHoraire.parse("16:00:00"));
            listHoraireGTL.add(formatHoraire.parse("18:00:00"));
            listHoraireGTL.add(formatHoraire.parse("19:00:00"));
            listHoraireGTL.add(formatHoraire.parse("21:00:00"));
            listHoraireGTL.add(formatHoraire.parse("22:00:00"));

            listHoraireDeb.add(formatHoraire.parse("08:30:00"));
            listHoraireDeb.add(formatHoraire.parse("11:30:00"));
            listHoraireDeb.add(formatHoraire.parse("14:00:00"));
            listHoraireDeb.add(formatHoraire.parse("15:00:00"));
            listHoraireDeb.add(formatHoraire.parse("16:00:00"));
            listHoraireDeb.add(formatHoraire.parse("18:00:00"));
            listHoraireDeb.add(formatHoraire.parse("19:00:00"));
            listHoraireDeb.add(formatHoraire.parse("21:00:00"));
            listHoraireDeb.add(formatHoraire.parse("22:00:00"));

            listHoraireBun.add(formatHoraire.parse("08:30:00"));
            listHoraireBun.add(formatHoraire.parse("18:00:00"));
            listHoraireBun.add(formatHoraire.parse("19:00:00"));

            listHoraireSoi.add(formatHoraire.parse("08:30:00"));
            listHoraireSoi.add(formatHoraire.parse("11:30:00"));
            listHoraireSoi.add(formatHoraire.parse("14:00:00"));
            listHoraireSoi.add(formatHoraire.parse("15:00:00"));
            listHoraireSoi.add(formatHoraire.parse("16:00:00"));
            listHoraireSoi.add(formatHoraire.parse("18:00:00"));
            listHoraireSoi.add(formatHoraire.parse("19:00:00"));
            listHoraireSoi.add(formatHoraire.parse("21:00:00"));
            listHoraireSoi.add(formatHoraire.parse("22:00:00"));

            listHoraireBaz.add(formatHoraire.parse("08:30:00"));
            listHoraireBaz.add(formatHoraire.parse("11:30:00"));
            listHoraireBaz.add(formatHoraire.parse("14:00:00"));
            listHoraireBaz.add(formatHoraire.parse("15:00:00"));
            listHoraireBaz.add(formatHoraire.parse("16:00:00"));
            listHoraireBaz.add(formatHoraire.parse("18:00:00"));
            listHoraireBaz.add(formatHoraire.parse("19:00:00"));
            listHoraireBaz.add(formatHoraire.parse("21:00:00"));
            listHoraireBaz.add(formatHoraire.parse("22:00:00"));
//</editor-fold>

            this.listSalle.add(new Salle("Le Grand Théatre Lumière", listHoraireGTL));
            this.listSalle.add(new Salle("La salle Debussy", listHoraireDeb));
            this.listSalle.add(new Salle("La salle Buñuel", listHoraireBun));
            this.listSalle.add(new Salle("La salle du Soixantième", listHoraireSoi));
            this.listSalle.add(new Salle("La salle Bazin", listHoraireBaz));
            
            
            
            
            
            
        } catch (Exception e) {
            System.out.println("Erreur Format Date");
        }

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

    //<editor-fold defaultstate="collapsed" desc="Getter">
    public int getId() {
        return id;
    }

    public ArrayList<Evenement> getListEvenement() {
        return listEvenement;
    }

//</editor-fold>
}
