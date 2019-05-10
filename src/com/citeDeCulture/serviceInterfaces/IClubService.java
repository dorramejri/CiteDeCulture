/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citedeculture.serviceInterfaces;

import com.citeDeCulture.entities.Event;
import com.citedeculture.entities.Club;
import java.util.List;

/**
 *
 * @author Sawssen Toumi
 */
public interface IClubService extends IGenericService <Club>{
   
    public List<Club> findByActivite(String activite);
    public List<Club> findByNom(String nom);
    public List<Club> findByMembre(int membre);
    
}
