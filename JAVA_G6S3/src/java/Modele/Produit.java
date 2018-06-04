/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Toussaint
 */
public class Produit {
    private final int idProduit;
    private String nom;
    private float prix;
    private int stock;

    public Produit(int idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(int idProduit, String nom, float prix, int stock) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.prix = prix;
        this.stock = stock;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public float getPrix() {
        return prix;
    }
    
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
//</editor-fold>
    
}
