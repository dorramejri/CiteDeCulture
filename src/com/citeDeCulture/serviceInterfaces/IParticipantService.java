/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import com.citeDeCulture.entities.Participant;

/**
 *
 * @author Mejri Dorra
 */
public interface IParticipantService extends IGenericService<Participant>{
 public int nombreVote(Participant participant);
 public Participant findByNom(String nom);

}
