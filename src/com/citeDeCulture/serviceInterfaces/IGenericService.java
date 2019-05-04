/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.serviceInterfaces;

import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public interface IGenericService<T> {
    
        
    public T  findById(int id);
    public List<T> findAll();
    public int create (T espace);
    public int edit (T espace);
    public int delete(T espace);
    
}
