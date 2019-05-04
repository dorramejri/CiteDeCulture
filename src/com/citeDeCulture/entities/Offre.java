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
public class Offre {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private double tauxRemise;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getTauxRemise() {
        return tauxRemise;
    }

    public void setTauxRemise(double tauxRemise) {
        this.tauxRemise = tauxRemise;
    }

    public Offre(int id, Date dateDebut, Date dateFin, double tauxRemise) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tauxRemise = tauxRemise;
    }

    public Offre(Date dateDebut, Date dateFin, double tauxRemise) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tauxRemise = tauxRemise;
    }

    public Offre() {
    }

    @Override
    public String toString() {
        return "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", tauxRemise=" + tauxRemise;
    }
    
}
