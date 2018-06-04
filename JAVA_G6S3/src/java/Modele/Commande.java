/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.text.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Toussaint
 */
public class Commande {
    private final int numCommande; 
    private int idClient;
    private ArrayList<Produit> listProduit;

    public Commande(int numCommande) {
        this.numCommande = numCommande;
    }

    public Commande(int numCommande, int idClient) {
        this.numCommande = numCommande;
        this.idClient = idClient;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter & Setter">
    public int getIdClient() {
        return idClient;
    }
    
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    public ArrayList<Produit> getListProduit() {
        return listProduit;
    }
    
    public void setListProduit(ArrayList<Produit> listProduit) {
        this.listProduit = listProduit;
    }
//</editor-fold>
    
    
}
