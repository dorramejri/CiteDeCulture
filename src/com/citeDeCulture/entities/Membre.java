/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.entities;

/**
 *
 * @author Sawssen Toumi
 */
public class Membre {
    private int id ;
    private String nom;
    private int id_club ;
    private int id_User;

    public Membre(int id, String nom, int id_club, int id_User) {
        this.id = id;
        this.nom = nom;
        this.id_club = id_club;
        this.id_User = id_User;
    }
public Membre(){}

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

    public int getId_club() {
        return id_club;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    @Override
    public String toString() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", id_club=" + id_club + ", id_User=" + id_User + '}';
    }
    
    
}
