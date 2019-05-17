/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import com.citeDeCulture.entities.Espace;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public interface IServiceEspace extends IGenericService<Espace>{
    

    
    public List<Espace> findByType(String type);
    public List<Espace> findByStatus(String status);
    public List<Espace> findByLibelle(String libelle);

  
    public List<Espace> findByNombrePlaceDisponible(int nbrPlace);
    public List<Espace> findByIlyPlace();


    public List<Espace> findByPrix(double prix);
    public List<Espace> findByMaxPrix(double prix);
    public List<Espace> findByMinPrix(double prix);
           
    /*public enum EspacePrixSearchFields{
		MAXPRIX, 
                MINPRIX ,
                PRIXFIXE ;		
	}
	List<Espace> searchByPrice ( EspacePrixSearchFields  field,Object value  );
 */       
}
