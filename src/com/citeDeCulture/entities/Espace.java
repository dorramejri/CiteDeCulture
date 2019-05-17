/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public class Espace {
        private int id ;
        private String libelle;
        private int nombrePlace;
        private String typeEspace;
        private String status;
        private double prix;
        private String image;

    public Espace(int id, String libelle, int nombrePlace, String typeEspace, String status,double prix,String image) {
        this.id = id;
         this.libelle = libelle;
        this.nombrePlace = nombrePlace;
        this.typeEspace = typeEspace;
        this.image=image;
        this.status = status;
        this.prix=prix;
    }

    public Espace(String libelle, int nombrePlace, String typeEspace, String status,double prix,String image) {
        this.libelle = libelle;
        this.nombrePlace = nombrePlace;
        this.typeEspace = typeEspace;
        this.status = status;
        this.prix=prix;
        this.image=image;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Espace() {
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public String getTypeEspace() {
        return typeEspace;
    }

    public void setTypeEspace(String typeEspace) {
        this.typeEspace = typeEspace;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    @Override
    public String toString() {
                return "id= " + id + ", libelle= " + libelle + "\n, nombrePlace= " + nombrePlace + ", typeEspace= " + typeEspace + "\n, status=" + status ;
    }
  public boolean verifier(String libelle, int nombrePlace, String typeEspace, String status,double prix){
  return libelle.equals("")||nombrePlace<0||prix<=0||status.equals("")||typeEspace.equals("") ;
  }
        
        


}
