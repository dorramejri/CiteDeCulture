/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import com.citeDeCulture.entities.Concours;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public interface IConcoursService extends IGenericService<Concours>{
    public List<Concours>findByDateDebut(Date date);
    public List<Concours>findByDateFin(Date date);
    public Concours findByName(String nom);
}
