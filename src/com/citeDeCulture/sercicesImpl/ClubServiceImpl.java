/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citedeculture.sercicesImpl;

import com.citeDeCulture.entities.Event;
import com.citeDeCulture.utils.DataSource;
import com.citedeculture.entities.Club;
import com.citedeculture.serviceInterfaces.IClubService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sawssen Toumi
 */
public class ClubServiceImpl implements IClubService{
    Connection connection=null;
    
    public ClubServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }

    @Override
    public List<Club> findByActivite(String activite) {
       List<Club> club = new ArrayList<>();
		String query="SELECT * FROM club where activite = "+activite;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) // No while loop needed Only one result is returned 
                        {			// from the database the id is UNIQUE;
			club.add( new Club(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("membre"),
                                resultSet.getString("activite"),
                                
				resultSet.getString("description")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return club;
    }

    @Override
    public List<Club> findByNom(String nom) {
        List<Club> club = new ArrayList<>();
		String query="SELECT * FROM club where nom = "+nom;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) // No while loop needed Only one result is returned 
                        {			// from the database the id is UNIQUE;
			club.add( new Club(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("membre"),
                                resultSet.getString("activite"),
                                
				resultSet.getString("description")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return club;
    }

    @Override
    public List<Club> findByMembre(int membre) {
        List<Club> club = new ArrayList<>();
		String query="SELECT * FROM club where membre = "+membre;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) // No while loop needed Only one result is returned 
                        {			// from the database the id is UNIQUE;
			club.add( new Club(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("membre"),
                                resultSet.getString("activite"),
                                
				resultSet.getString("description")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return club;
    }
    
    public Club findById(int id) {
		Club club=null ;
		String query="SELECT * FROM club where id = "+id;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next(); // No while loop needed Only one result is returned 
						// from the database the id is UNIQUE;
			club = new Club(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("membre"),
                                resultSet.getString("activite"),
                                
				resultSet.getString("description"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return club;
    }

    
    public List<Club> findAll() {
        List<Club> all = new ArrayList<>();
		String query="SELECT * FROM club ";
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 all.add(new Club(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("membre"),
                                resultSet.getString("activite"),
                                
				resultSet.getString("description")));
                        }
		} 
                        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return all;
    }

    
    public int create(Club event) {
        int rowInserted = 0;
		String query = "INSERT INTO club"
				+ " (nom, membre, activite, description )"
				+ " VALUES ( ?,?,?,? )";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        
                        preparedStatement.setString(1, event.getNom());
                        preparedStatement.setInt(2,event.getMembre());
                        preparedStatement.setString(3, event.getActivite());
			preparedStatement.setString(4, event.getDescription());
                        rowInserted = preparedStatement.executeUpdate();		
		} 
                catch (SQLException e)
                {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return rowInserted;
	}

    public int edit(Club event) {
        int updated = 0;
		String query = "UPDATE club SET"
				+ "(nom=? , membre=? , activite=? , description=? )"
				+ " WHERE id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, event.getNom());
                        preparedStatement.setInt(2,event.getMembre());
                        preparedStatement.setString(3, event.getActivite());
			preparedStatement.setString(7, event.getDescription());
			updated = preparedStatement.executeUpdate();
			
                        if (updated>0) 
                        {
				System.out.println("An Event was updated successfully");
			}
			
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return updated;
    }

    public int delete(Club event) {
        int rowDeleted = 0;
		String query = "DELETE FROM club WHERE idevent ="+event.getId();
		
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
