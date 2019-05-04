/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.entities;

/**
 *
 * @author Mejri Dorra
 */
public class Produit {
    private int idProduit ;
    private int idOffre;
    private String libelle;
    private double prix;
    private String type;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Produit(int idProduit, int idOffre, String libelle, double prix, String type) {
        this.idProduit = idProduit;
        this.idOffre = idOffre;
        this.libelle = libelle;
        this.prix = prix;
        this.type = type;
    }

    public Produit(int idProduit, String libelle, double prix, String type) {
        this.idProduit = idProduit;
        this.libelle = libelle;
        this.prix = prix;
        this.type = type;
    }

    public Produit(String libelle, double prix, String type) {
        this.libelle = libelle;
        this.prix = prix;
        this.type = type;
    }

    public Produit() {
    }

    @Override
    public String toString() {
        return "idProduit=" + idProduit + ", idOffre=" + idOffre + ", libelle=" + libelle + ", prix=" + prix + ", type=" + type ;
    }
    
}
