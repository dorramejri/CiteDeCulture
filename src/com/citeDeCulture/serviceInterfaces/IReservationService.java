/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.entities.Reservation;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public interface IReservationService extends IGenericService<Reservation>{
    public List<Espace> findEspace(Date date);
    //public Concours find(String nom); 
}
