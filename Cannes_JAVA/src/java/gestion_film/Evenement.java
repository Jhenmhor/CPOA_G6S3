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
    private DateFormat dateDebut;
    private DateFormat dateFin;

    public Evenement(int id) {
        this.id = id;
    }

    public Evenement(int id, String info, DateFormat dateDebut, DateFormat dateFin) {
        this.id = id;
        this.info = info;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public String getInfo() {
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public DateFormat getDateDebut() {
        return dateDebut;
    }
    
    public void setDateDebut(DateFormat dateDebut) {
        this.dateDebut = dateDebut;
    }
    
    public DateFormat getDateFin() {
        return dateFin;
    }
    
    public void setDateFin(DateFormat dateFin) {
        this.dateFin = dateFin;
    }
    //</editor-fold>
    
      
}
