/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.entities;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;

/**
 *
 * @author Sawssen Toumi
 */
public class Club {

    private int id ;
    private String nom;
    private int membre;
    private String activite;
    private String description; 
            List<Club> club = new ArrayList<>();


    public Club() {
    }

    public Club(int id, String nom, int membre, String activite, String description) {
        this.id = id;
        this.nom = nom;
        this.membre = membre;
        this.activite = activite;
        this.description = description;
    }

    public Club(String nom, String activite, String description) {
        this.nom = nom;
        this.activite = activite;
        this.description = description;
    }

    public Club(String nom, int membre, String activite, String description) {
        this.nom = nom;
        this.membre = membre;
        this.activite = activite;
        this.description = description;
    }

    public Club(String nom, String activite) {
        this.nom = nom;
        this.activite = activite;
    }

    public Club(String nom) {
        this.nom = nom;
    }

    public Club(int id) {
        this.id = id;
    }

    public Club(String liberta, TableColumn membre, String sportif, String club_du_sport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMembre() {
        return membre;
    }

    public void setMembre(int membre) {
        this.membre = membre;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", nom=" + nom + ", membre=" + membre + ", activite=" + activite + ", description=" + description + '}';
    }
    
    
}
