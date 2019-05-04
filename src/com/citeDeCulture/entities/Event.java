/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.entities;

import java.util.Date;

/**
 *
 * @author Mejri Dorra
 */
public class Event {
    
    private int idevent ;
    private Date dateDebut;
    private String lieu;
    private String libelle;
    private int nombreTicket;
    private Date dateFin;
    private double prixUnitaire;
    private String type;

    public Event(Date dateDebut, String lieu, String libelle, int nombreTicket, Date dateFin, double prixUnitaire, String type) {
        this.dateDebut = dateDebut;
        this.lieu = lieu;
        this.libelle = libelle;
        this.nombreTicket = nombreTicket;
        this.dateFin = dateFin;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
    }

    public Event(String libelle) {
        this.libelle = libelle;
    }

    public Event(int idevent, Date dateDebut, String lieu, String libelle, int nombreTicket, Date dateFin, double prixUnitaire, String type) {
        this.idevent = idevent;
        this.dateDebut = dateDebut;
        this.lieu = lieu;
        this.libelle = libelle;
        this.nombreTicket = nombreTicket;
        this.dateFin = dateFin;
        this.prixUnitaire = prixUnitaire;
        this.type = type;
    }
    

    public Event() {
    }

    @Override
    public String toString() {
        return "id=" + idevent + ", dateDebut=" + dateDebut 
                + ", lieu=" + lieu + ", libelle=" + libelle 
                + ", nombreTicket=" + nombreTicket 
                + ", dateFin=" + dateFin + ", prixUnitaire=" 
                + prixUnitaire + ", type=" + type;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int id) {
        this.idevent = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNombreTicket() {
        return nombreTicket;
    }

    public void setNombreTicket(int nombreTicket) {
        this.nombreTicket = nombreTicket;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   }
