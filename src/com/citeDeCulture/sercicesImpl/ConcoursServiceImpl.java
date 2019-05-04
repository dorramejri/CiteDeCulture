/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Concours;
import com.citeDeCulture.entities.Event;
import com.citeDeCulture.serviceInterfaces.IConcoursService;
import com.citeDeCulture.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public class ConcoursServiceImpl implements IConcoursService{

     Connection connection=null;
    
    public ConcoursServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }

    @Override
    public List<Concours> findByDateDebut(Date date) {
                List<Concours> concours =new ArrayList();
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String query="SELECT * FROM concours where date_debut = '"+sdf.format(date)+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 concours.add(new Concours(
                                resultSet.getInt("id"),
                                resultSet.getString("titre"),
                                resultSet.getString("description"),
				resultSet.getDate("date_debut"),
				resultSet.getDate("date_fin")));
		
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return concours;   
    
    }
 @Override
    public List<Concours> findByDateFin(Date date) {
                List<Concours> concours =new ArrayList();
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String query="SELECT * FROM concours where date_fin = '"+sdf.format(date)+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 concours.add(new Concours(
                                resultSet.getInt("id"),
                                resultSet.getString("titre"),
                                resultSet.getString("description"),
				resultSet.getDate("date_debut"),
				resultSet.getDate("date_fin")));
		
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return concours;   
    
    }

    @Override
    public Concours findByName(String nom) {
        Concours concours=null;
		String query="SELECT * FROM concours where type = '"+nom+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 concours=new Concours
        (
                                resultSet.getInt("id"),
                                resultSet.getString("titre"),
                                resultSet.getString("description"),
				resultSet.getDate("date_debut"),
                                resultSet.getDate("date_fin")
                         );
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return concours;
    }   
    @Override
    public Concours findById(int id) {
        Concours concours = null;
		String query="SELECT * FROM concours where id="+id;
		
		try {
			Statement statement=connection.createStatement();
                        ResultSet resultSet =statement.executeQuery(query);
                        resultSet.next();
			concours = new Concours(
                                resultSet.getInt("id"),
                                resultSet.getString("titre"),
                                resultSet.getString("description"),
				resultSet.getDate("date_debut"),
				resultSet.getDate("date_fin"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concours; 
    }

    @Override
    public List<Concours> findAll() {
        List<Concours> concours =new ArrayList();
		String query="SELECT * FROM concours ";
		
		try {
			Statement statement=connection.createStatement();
                        ResultSet resultSet =statement.executeQuery(query);
                        while(resultSet.next())
                        {
			concours.add( new Concours(
                                resultSet.getInt("id"),
                                resultSet.getString("titre"),
                                resultSet.getString("description"),
				resultSet.getDate("date_debut"),
				resultSet.getDate("date_fin")));
		
		} }
                catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return concours; 
    }

    @Override
    public int create(Concours espace) {
        int rowInserted = 0;
		String query = "INSERT INTO concours"
				+ "(titre, description, date_debut, date_fin)"
				+ " VALUES (?,?,?,?)";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setString(1, espace.getTitre());
			preparedStatement.setString(2, espace.getDescription());
			preparedStatement.setDate(3,new java.sql.Date(espace.getDateDebut().getTime()));
                        preparedStatement.setDate(4,new java.sql.Date(espace.getDateFin().getTime()));
                        rowInserted = preparedStatement.executeUpdate();		
		} 
                catch (SQLException e)
                {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return rowInserted;
    }

    @Override
    public int edit(Concours espace) {
         int updated = 0;
		String query = "UPDATE concours SET"
				+ " titre=?, description=?, date_debut=?, date_fin=?"
				+ " WHERE id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setString(1, espace.getTitre());
			preparedStatement.setString(2, espace.getDescription());
			preparedStatement.setDate(3,new java.sql.Date(espace.getDateDebut().getTime()));
                        preparedStatement.setDate(4,new java.sql.Date(espace.getDateFin().getTime()));
			preparedStatement.setInt(5,espace.getId());
			updated = preparedStatement.executeUpdate();
			
                        if (updated>0) 
                        {
				System.out.println("An Coucours was updated successfully");
			}
			
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return updated;
    }

    @Override
    public int delete(Concours espace) {
                int rowDeleted = 0;
		String query = "DELETE FROM concours WHERE id ="+espace.getId();
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			rowDeleted = preparedStatement.executeUpdate();		
			
		}
                catch (SQLException e)
                {
			e.printStackTrace();
		}		
		return rowDeleted;   
    }
    
}
