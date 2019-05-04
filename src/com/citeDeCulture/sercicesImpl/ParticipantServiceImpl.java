/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Concours;
import com.citeDeCulture.entities.Participant;
import com.citeDeCulture.serviceInterfaces.IParticipantService;
import com.citeDeCulture.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public class ParticipantServiceImpl implements IParticipantService{

    Connection connection=null;
    
    public ParticipantServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }
    @Override
    public Participant findById(int id) {
        Participant participant = null;
		String query="SELECT * FROM participant where idp="+id;
		
		try {
			Statement statement=connection.createStatement();
                        ResultSet resultSet =statement.executeQuery(query);
                        resultSet.next();
			participant = new Participant(
                                resultSet.getString("nom_image"),
				resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("sexe"),
                                resultSet.getString("information"),
				resultSet.getInt("vote")
				);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participant;
    }

    @Override
    public List<Participant> findAll() {
       List<Participant> participant =new ArrayList() ;
		String query="SELECT * FROM participant";
		
		try {
			Statement statement=connection.createStatement();
                        ResultSet resultSet =statement.executeQuery(query);
                        while(resultSet.next())
                        {
			participant.add(new Participant(
                                resultSet.getInt("idp"),
                                resultSet.getString("nom_image"),
				resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("sexe"),
                                resultSet.getString("information"),
				resultSet.getInt("vote")
				));
                        }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participant;
    }

    @Override
    public int create(Participant espace) {
        int rowInserted = 0;
		String query = "INSERT INTO participant"
				+ "( nom_image, nom, prenom, sexe, information, vote )"
				+ " VALUES (?,?,?,?,?,?)";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setString(1, espace.getNomImage());
			preparedStatement.setString(2, espace.getNom());
			preparedStatement.setString(3, espace.getPrenom());
			preparedStatement.setString(4,espace.getSexe());
                        preparedStatement.setString(5,espace.getInformation());
                        preparedStatement.setInt(6,espace.getVote());
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
    public int edit(Participant espace) {
        int updated = 0;
		String query = "UPDATE participant SET"
				+ " nom_image=?, nom=?, prenom=?, sexe=?, information=?, vote=? " 
				+ " WHERE idp=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setString(1, espace.getNomImage());
			preparedStatement.setString(2, espace.getNom());
			preparedStatement.setString(3, espace.getPrenom());
			preparedStatement.setString(4,espace.getSexe());
                        preparedStatement.setString(5,espace.getInformation());
                        preparedStatement.setInt(6,espace.getVote());
			preparedStatement.setInt(7,espace.getIdp());
			updated = preparedStatement.executeUpdate();
			
                        if (updated>0) 
                        {
				System.out.println("Participant was updated successfully");
			}
			
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return updated;
    }

    @Override
    public int delete(Participant espace) {
        int rowDeleted = 0;
		String query = "DELETE FROM participant WHERE idp ="+espace.getIdp();
		
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

    @Override
    public int nombreVote(Participant participant) {
        int id = participant.getIdp();
        Participant participant1=findById(id);
        int i = participant1.getVote();
        return i;
    }

    @Override
    public Participant findByNom(String nom) {
        Participant participant = null;
		String query="SELECT * FROM participant where nom="+nom;
		
		try {
			Statement statement=connection.createStatement();
                        ResultSet resultSet =statement.executeQuery(query);
                        resultSet.next();
			participant = new Participant(
                                resultSet.getString("nom_image"),
				resultSet.getString("nom"),
                                resultSet.getString("prenom"),
                                resultSet.getString("sex"),
                                resultSet.getString("information"),
				resultSet.getInt("vote")
				);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participant;
    }
}
