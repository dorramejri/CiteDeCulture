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
public class Reservation {
    private int idres;
    private int idev;
    private int ides;
    private Date dateRES;

    public Reservation(int idres, int idev, int ides,Date dateRES) {
        this.idres = idres;
        this.idev = idev;
        this.ides = ides;
        this.dateRES=dateRES;
    }

    public Reservation() {
    }

    public Reservation(int idev, int ides,Date dateRES) {
        this.idev = idev;
        this.ides = ides;
        this.dateRES=dateRES;
    }

    public int getIdres() {
        return idres;
    }

    public void setIdres(int idres) {
        this.idres = idres;
    }

    public Date getDateRES() {
        return dateRES;
    }

    public void setDateRES(Date dateRES) {
        this.dateRES = dateRES;
    }

    public int getIdev() {
        return idev;
    }

    public void setIdev(int idev) {
        this.idev = idev;
    }

    public int getIdes() {
        return ides;
    }

    public void setIdes(int ides) {
        this.ides = ides;
    }
    
}
