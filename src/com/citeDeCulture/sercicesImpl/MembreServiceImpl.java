/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Club;
import com.citeDeCulture.entities.Membre;
import com.citeDeCulture.serviceInterfaces.IMembre;
import com.citeDeCulture.utils.DataSource;
import static com.citeDeCulture.view.club.EditClubController.id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sawssen Toumi
 */
public class MembreServiceImpl implements IMembre {

    Connection connection = null;

    public MembreServiceImpl() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public Membre findById(int id) {
        Membre membre = null;
        String query = "SELECT * FROM membre where id = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next(); // No while loop needed Only one result is returned 
            // from the database the id is UNIQUE;
            membre = new Membre(resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getInt("id_club"),
                    resultSet.getInt("id_user"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return membre;

    }

    @Override
    public List<Membre> findAll() {
        List<Membre> all = new ArrayList<>();
        String query = "SELECT * FROM membre";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                all.add(new Membre(resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getInt("id_club"),
                        resultSet.getInt("id_user")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return all;
    }

    public int create(Club espace) {
        int rowInserted = 0;
        String query = "INSERT INTO `club`(`nom`, `membre`, `activite`, `description`) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, espace.getNom());
            preparedStatement.setInt(2, espace.getMembre());
            preparedStatement.setString(3, espace.getActivite());
                        preparedStatement.setString(4, espace.getDescription());

            rowInserted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return rowInserted;
    }

    @Override
    public int edit(Membre espace) {
        int updated = 0;
        String query = "UPDATE membre SET"
                + "(nom=? , id_club=? , id_user=? )"
                + " WHERE id=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, espace.getNom());
            //preparedStatement.setInt(2,event.getMembre());
            preparedStatement.setInt(2, espace.getId_club());
            preparedStatement.setInt(3, espace.getId_User());

            //preparedStatement.setString(7, event.getDescription());
            updated = preparedStatement.executeUpdate();

            if (updated > 0) {
                System.out.println("An Event was updated successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    @Override
    public int delete(Membre espace) {
        int rowDeleted = 0;
        String query = "DELETE FROM club WHERE id=" + espace.getId();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            rowDeleted = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

  
@Override
        public List<Membre> findByNom(String nom) {
              List<Membre> membre = new ArrayList<>();

String query="SELECT * FROM membre where nom = "+nom;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) // No while loop needed Only one result is returned 
                        {			// from the database the id is UNIQUE;
			membre.add( new Membre(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("id_club"),
                                
				resultSet.getInt("id_user")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return membre;


}
   /* @Override
    public List<Membre> findByMembre(int membre) {
              //<Membre> membre = new ArrayList<>();
        <Membre> membre = new ArrayList<>();
		String query="SELECT * FROM membre where id = "+id;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) // No while loop needed Only one result is returned 
                        {			// from the database the id is UNIQUE;
			membre.add( new Membre(resultSet.getInt("id"),
                                
                                resultSet.getString("nom"),
                                
                                resultSet.getInt("id_club"),
                                
				resultSet.getInt("id_User")));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return membre;
    }*/
        @Override
    public Membre rechercherMembre(int membre) {
                

        Membre m = new Membre();
       //Membre membre=new  Membre();
        
        String req="select * from membre where id="+id;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet =statement.executeQuery(req);
            while (resultSet.next()) {
                Membre e=new Membre(resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                m=e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MembreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
        
    }
    @Override
    public Club rechercherClubParNom(String nom) {
        Club cb=new  Club();     
        String req="select * from club where nom='"+nom;
        try {
            Statement statement=connection.createStatement();
            ResultSet resultSet =statement.executeQuery(req);
            while (resultSet.next()) {
                Club e=new Club(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3), resultSet.getString(4),resultSet.getString(5));
                cb=e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClubServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cb;
        
    }

   /*@Override
    public Club createClub(Club espace) {
       // int rowInserted = 0;
        Club club = new Club();
		String query = "INSERT INTO club"
				+ " (nom, activite, description )"
				+ " VALUES ( ?,?,? )";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        
                        preparedStatement.setString(1, espace.getNom());
                        preparedStatement.setString(2, espace.getActivite());
			preparedStatement.setString(3, espace.getDescription());
                        rowInserted = preparedStatement.executeUpdate();		
		} 
                catch (SQLException e)
                {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    

    return club;
}*/

    @Override
    public int createClub(Club espace) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    

