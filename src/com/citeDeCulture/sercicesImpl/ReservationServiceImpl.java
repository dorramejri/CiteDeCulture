/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.entities.Reservation;
import com.citeDeCulture.serviceInterfaces.IReservationService;
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
public class ReservationServiceImpl implements IReservationService{
        Connection connection=null;

    public ReservationServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }
        
   
    @Override
    public List<Espace> findEspace(Date date) {
        List<Espace> e=new ArrayList<>() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        String query="select e.* from espace e join reservation r on e.id = r.ides "
                + "where r.dateres = " +sdf.format(date);
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) // No while loop needed Only one result is returned 
                        {			// from the database the id is UNIQUE;
			e.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
                                resultSet.getString("status"),
                                resultSet.getDouble("prix"),
                                resultSet.getString("image")));
		}} 
                catch (SQLException ex) 
                {
			ex.printStackTrace();
		}
		return e;
    }

    @Override
    public Reservation findById(int id) {
        Reservation all = null;
		String query="SELECT * FROM reservation where idres="+id;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next();
                        
			 all=new Reservation(resultSet.getInt("idres"),
                                 resultSet.getInt("idres"),
                                resultSet.getDate("dateres")
                                );
                        
		} 
                        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return all;
    }

    @Override
    public List<Reservation> findAll() {
        List<Reservation> all = new ArrayList<>();
		String query="SELECT * FROM reservation ";
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 all.add(new Reservation(resultSet.getInt("idres"),
                                 resultSet.getInt("idres"),
                                resultSet.getDate("dateres"))
                                );
                        }
		} 
                        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return all;
    }

    @Override
    public int create(Reservation espace) {
        int rowInserted = 0;
		String query = "INSERT INTO reservation"
				+ "(ides, dateres)"
				+ " VALUES (?,?)";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setInt(1, espace.getIdes());
			preparedStatement.setDate(2,new java.sql.Date(espace.getDateRES().getTime()));
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
    public int edit(Reservation espace) {
        int updated = 0;
		String query = "UPDATE reservation SET"
				+ "ides=?, dateres=?"
				+ " WHERE idres=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setInt(1, espace.getIdes());
			preparedStatement.setDate(2,new java.sql.Date(espace.getDateRES().getTime()));
			preparedStatement.setInt(3,espace.getIdres());
			updated = preparedStatement.executeUpdate();
			
                        if (updated>0) 
                        {
				System.out.println("An reservation was updated successfully");
			}
			
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return updated;
    }

    @Override
    public int delete(Reservation espace) {
        int rowDeleted = 0;
		String query = "DELETE FROM reservation WHERE idres ="+espace.getIdres();
		
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
