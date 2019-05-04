/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.utils.DataSource;
import com.citeDeCulture.serviceInterfaces.IServiceEspace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Mejri Dorra
 */
public class EspaceServiceImpl implements IServiceEspace{
        Connection connection=null;
    
    public EspaceServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }

    @Override
    public List<Espace> findByType(String type) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where typeespace = '"+type+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }

    @Override
    public List<Espace> findByStatus(String status) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where status = '"+status+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),
                                 resultSet.getString("image")
                         ));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }

    @Override
    public List<Espace> findByLibelle(String libelle) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where libelle = '"+libelle+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }
    @Override
    public List<Espace> findByNombrePlaceDisponible(int nbrPlace) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where nombreplace >='"+nbrPlace+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }
    @Override
        public List<Espace> findByIlyPlace(){
            List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where nombreplace != 0 ";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
        
        }


    @Override
    public List<Espace> findByPrix(double prix) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where prix ='"+prix+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }

    @Override
    public List<Espace> findByMaxPrix(double prix) {
         List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where prix >'"+prix+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }

    @Override
    public List<Espace> findByMinPrix(double prix) {
         List<Espace> listEspaces;
        listEspaces = new ArrayList();
		String query="SELECT * FROM espace where prix <'"+prix+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEspaces;
    }

    @Override
    public Espace findById(int id) {
         Espace espace=null ;
		String query="SELECT * FROM espace where id = "+id;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next(); // No while loop needed Only one result is returned 
						// from the database the id is UNIQUE;
			espace = new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")

                        );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return espace;
    }

    @Override
    public int create(Espace espace) {
         int rowInserted = 0;
		String query = "INSERT INTO espace"
                                 +"(libelle, nombreplace, typeespace, status, prix, image)"
				+ " VALUES ( ?,?,?,?,?,?)";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, espace.getLibelle());
			preparedStatement.setInt(2, espace.getNombrePlace());
			preparedStatement.setString(3, espace.getTypeEspace());
			preparedStatement.setString(4, espace.getStatus());
			preparedStatement.setDouble(5,espace.getPrix());
                        preparedStatement.setString(6, espace.getImage());
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
    public int edit(Espace espace) {
         int updated = 0;
		String query = "UPDATE espace SET"
				+ " libelle=?, nombreplace=?, typeespace=?, status=?, prix=?, image=?"
				+ " WHERE id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, espace.getLibelle());
			preparedStatement.setInt(2, espace.getNombrePlace());
			preparedStatement.setString(3, espace.getTypeEspace());
			preparedStatement.setString(4, espace.getStatus());
			preparedStatement.setDouble(5,espace.getPrix());
                        preparedStatement.setString(6, espace.getImage());
			preparedStatement.setInt(7,espace.getId());
			updated = preparedStatement.executeUpdate();
			
                        if (updated>0) 
                        {
				System.out.println("An space was updated successfully");
			}
			
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return updated;
    }

    @Override
    public int delete(Espace espace) {
        int rowDeleted = 0;
		String query = "DELETE FROM espace WHERE id ="+espace.getId() ;
		
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
    public List<Espace> findAll() {
        
                List<Espace> allEspaces = new ArrayList<>();

		String query="SELECT * FROM espace ";
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
			allEspaces.add(new Espace(resultSet.getInt("id"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("nombreplace"),
                                resultSet.getString("typeespace"),
				resultSet.getString("status"),
                                resultSet.getDouble("prix"),resultSet.getString("image")

                        )
                        );
                        }
                } 
                catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return allEspaces;
    }
    
}
