/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Produit;
import com.citeDeCulture.serviceInterfaces.IProduitService;
import com.citeDeCulture.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public class ProduitServiceImpl implements IProduitService{
    Connection connection=null;
    
    public ProduitServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }

    @Override
    public Produit findByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> findByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> findByPrix(double prix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produit findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produit> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int create(Produit espace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int edit(Produit espace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Produit espace) {
        int rowDeleted = 0;
		String query = "DELETE FROM event WHERE idevent ="+espace.getIdProduit();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			rowDeleted = preparedStatement.executeUpdate();		
			
		}
                catch (SQLException e)
                {
			e.printStackTrace();
		}		
		return rowDeleted;    }
    
}
