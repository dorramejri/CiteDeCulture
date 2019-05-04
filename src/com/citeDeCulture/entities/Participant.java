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
public class Participant {
private int idp;
private String nomImage ;
private String nom;
private String prenom;
private String sexe;
private String information;
private int vote;
private List<Concours> concourses = new ArrayList();

    public List<Concours> getConcourses() {
        return concourses;
    }

    public void setConcourses(List<Concours> concourses) {
        this.concourses = concourses;
    }

    public Participant(int id, String nomImage, String nom, String prenom, String sexe, String information, int vote) {
        this.idp = id;
        this.nomImage = nomImage;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.information = information;
        this.vote = vote;
    }

    public Participant(String nomImage, String nom, String prenom, String sexe, String information, int vote) {
        this.nomImage = nomImage;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.information = information;
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "id=" + idp + ", nomImage=" + nomImage + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", information=" + information + ", vote=" + vote  ;
    }

    public Participant() {
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int id) {
        this.idp = id;
    }

    public String getNomImage() {
        return nomImage;
    }

    public void setNomImage(String nomImage) {
        this.nomImage = nomImage;
    }

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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

}
