/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_film;

import gestion_VIP.Personne;

import java.text.*;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author Toussaint
 */
public class Jury {
    
    private final int id;
    private ArrayList<Personne> membres;

    public Jury(int id, ArrayList<Personne> membres) {
        this.id = id;
        this.membres = membres;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Personne> getMembres() {
        return membres;
    }
    
}
