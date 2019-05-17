/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import com.citeDeCulture.entities.Club;
import com.citeDeCulture.entities.Membre;
import java.util.List;

/**
 *
 * @author Sawssen Toumi
 */
public interface IMembre {
     public Membre findById(int id);

    public List<Membre> findAll();

    public int create(Club espace);

    public int edit(Membre espace);

    public int delete(Membre espace);
    public int createClub(Club espace);


    public List<Membre> findByNom(String nom);
    public Membre rechercherMembre(int id);
            public Club rechercherClubParNom(String nom);


    //public List<Membre> findByMembre(int membre);

}

