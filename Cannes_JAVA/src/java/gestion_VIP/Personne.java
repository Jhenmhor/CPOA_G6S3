/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_VIP;

/**
 *
 * @author Toussaint
 */
public class Personne {
    
    private final int id;
    private String nom;
    private String prenom;
    private int idPhoto;

    public Personne(int id) {
        this.id = id;
    }

    public Personne(int id, String nom, String prenom, int idPhoto) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.idPhoto = idPhoto;
    }
    
    
    
}
