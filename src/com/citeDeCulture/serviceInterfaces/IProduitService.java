/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import com.citeDeCulture.entities.Produit;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public interface IProduitService extends IGenericService<Produit>{
    public Produit findByName(String nom);
    public List<Produit> findByType(String type);
    public List<Produit> findByPrix(double prix);

}
