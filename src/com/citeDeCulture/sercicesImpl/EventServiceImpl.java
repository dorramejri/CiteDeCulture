/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.sercicesImpl;

import com.citeDeCulture.entities.Event;
import com.citeDeCulture.serviceInterfaces.IEventService;
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
public class EventServiceImpl implements IEventService{

    Connection connection=null;
    
    public EventServiceImpl() {
        connection=DataSource.getInstance().getConnection();
    }
    @Override
    public Event findById(int id) {
		Event event=null ;
		String query="SELECT * FROM event where idevent = "+id;
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			resultSet.next(); // No while loop needed Only one result is returned 
						// from the database the id is UNIQUE;
			event = new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return event;
    }

    @Override
    public List<Event> findAll() {
        List<Event> allEvents = new ArrayList<>();
		String query="SELECT * FROM event ";
		try {
                        Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 allEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return allEvents;
    }

    @Override
    public int create(Event event) {
        int rowInserted = 0;
		String query = "INSERT INTO event"
				+ " (datedebut, lieu, libelle, ticket, datefin, prixunitaire,type )"
				+ " VALUES ( ?,?,?,?,?,?,?)";
		
		try {
                        PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setDate(1,new java.sql.Date(event.getDateDebut().getTime()));
                        preparedStatement.setString(2, event.getLieu());
			preparedStatement.setString(3, event.getLibelle());
                        preparedStatement.setInt(4,event.getNombreTicket());
                        preparedStatement.setDate(5,new java.sql.Date(event.getDateFin().getTime()));
			preparedStatement.setDouble(6, event.getPrixUnitaire());
			preparedStatement.setString(7, event.getType());
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
    public int edit(Event event) {
        int updated = 0;
		String query = "UPDATE event SET"
				+ " libelle=?, prixunitaire=?, type=?, lieu=?, nombreticket=?, datedebut=?,datefin=?"
				+ " WHERE id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, event.getLibelle());
			preparedStatement.setDouble(2, event.getPrixUnitaire());
			preparedStatement.setString(3, event.getType());
			preparedStatement.setString(4, event.getLieu());
			preparedStatement.setInt(5,event.getNombreTicket());
			preparedStatement.setDate(6,new java.sql.Date(event.getDateDebut().getTime()));
                        preparedStatement.setDate(7,new java.sql.Date(event.getDateFin().getTime()));
			preparedStatement.setInt(8,event.getIdevent());
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

    @Override
    public int delete(Event event) {
        int rowDeleted = 0;
		String query = "DELETE FROM event WHERE idevent ="+event.getIdevent();
		
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
    public List<Event> findByType(String type) {
        List<Event> listEvents;
        listEvents = new ArrayList();
		String query="SELECT * FROM event where type = '"+type+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;
    }

    @Override
    public List<Event> findByDate(Date date) {       
        List<Event> listEvents;
        listEvents = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String query="SELECT * FROM event where datefin = '"+sdf.format(date)+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;   
    }
    @Override
    public List<Event> findAfterDate(Date date) {
        
        List<Event> listEvents;
        listEvents = new ArrayList();
        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String query="SELECT * FROM event where datefin < '"+sdf.format(date)+"'";
                
                try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;   
    }

    @Override
    public List<Event> findBeforeDate(Date date) {
        List<Event> listEvents;
        listEvents = new ArrayList();
        
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String query="SELECT * FROM event where datefin > '"+sdf.format(date)+"'";
                
                try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;   
    }

    @Override
    public List<Event> findByPrix(double prix) {
        List<Event> listEvents;
        listEvents = new ArrayList();
		String query="SELECT * FROM event where prixunitaire = '"+prix+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;
    }

    @Override
    public List<Event> findByLieu(String lieu) {
        List<Event> listEvents;
        listEvents = new ArrayList();
		String query="SELECT * FROM event where lieu = '"+lieu+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;
    }

    @Override
    public List<Event> findByNombreTicketDispo(int nbrTicket) {
        List<Event> listEvents;
        listEvents = new ArrayList();
		String query="SELECT * FROM event where nombreticket= '"+nbrTicket+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;
    }

    @Override
    public List<Event> findByMaxPrix(double prix) {
List<Event> listEvents;
        listEvents = new ArrayList();
		String query="SELECT * FROM event where prixunitaire < '"+prix+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;    }

    @Override
    public List<Event> findByMinPrix(double prix) {
        List<Event> listEvents;
        listEvents = new ArrayList();
		String query="SELECT * FROM event where prixunitaire >'"+prix+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next())
                        { 
			 listEvents.add(new Event(resultSet.getInt("idevent"),
                                resultSet.getDate("datedebut"),
                                resultSet.getString("lieu"),
                                resultSet.getString("libelle"),
                                resultSet.getInt("ticket"),
                                resultSet.getDate("datefin"),
                                resultSet.getDouble("prixunitaire"),
				resultSet.getString("type")));
                        }
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}
		return listEvents;
    }

    @Override
    public List<Event> searchByPrice (EventPrixTicketSearchFields field, Object value) {
        switch (field) {
		case MAXPRIX:
			return this.findByMaxPrix((double)value);
		case MINPRIX:
			return this.findByMinPrix((double)value);
		case PRIXFIXE:
			return this.findByPrix((double)value);
		default:
			return null;
		}
    }

    @Override
    public List<Event> searchByDate(EventDateSearchFields field, Object value) {
        switch (field) {
		case DATE:
			return this.findByDate((Date)value);
		case BEFOREDATE:
			return this.findBeforeDate((Date) value);
		case AFTERDATE:
			return this.findAfterDate((Date) value);
		default:
			return null;
		}
    }   
}
