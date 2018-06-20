/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Toussaint
 */
public class Personne {

    private final int id;
    private String nom;
    private String prenom;
    private String mdp;
    private String type;
    
    
    public Personne(int id) {
        this.id = id;
    }

    public Personne(int id, String nom, String prenom, String type, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.type = type;
    }
    
//<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getMdp() {
        return mdp;
    }
    public int getid() {
        return id;
    }
    
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
//</editor-fold>
    
}
