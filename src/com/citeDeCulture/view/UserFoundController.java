/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view;
import com.citedeCuture.image.GalleryFXDemo;
import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.sercicesImpl.EspaceServiceImpl;
import com.citeDeCulture.utils.DataSource;
import com.citeDeCulture.utils.LibraryAssistantUtil;
import com.citedeCuture.image.DisplayShelfSample;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class UserFoundController implements Initializable {

    @FXML
    private TextField libelle;
    @FXML
    private MenuItem name;
    @FXML
    private MenuItem ty;
    @FXML
    private MenuItem st;
    @FXML
    private MenuItem pl;
    @FXML
    private MenuItem ypl;
    @FXML
    private MenuItem pr;
    @FXML
    private MenuItem prma;
    @FXML
    private MenuItem prmi;
   @FXML
    private TableView<Espace> tableView;
    @FXML
    private TableColumn<Espace, String> libelleCol;
    @FXML
    private TableColumn<Espace, Integer> nombrePlaceCol;
    @FXML
    private TableColumn<Espace, String> typeEspaceCol;
    @FXML
    private TableColumn<Espace, String> statusCol;
    @FXML
    private TableColumn<Espace, Double> prixCol;
    ObservableList<Espace> list = FXCollections.observableArrayList();
    public static final double WIDTH = 450;
        private static final double HEIGHT = 300;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    Connection connection=null;
    
    public UserFoundController() {
        connection=DataSource.getInstance().getConnection();
    }
    private void initCol() {
        libelleCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        nombrePlaceCol.setCellValueFactory(new PropertyValueFactory<>("nombrePlace"));
        typeEspaceCol.setCellValueFactory(new PropertyValueFactory<>("typeEspace"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        //imageCol.setCellValueFactory(new PropertyValueFactory<>("image"));
        //eventCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
    }
    @FXML
    private void fbnom(ActionEvent event) {
        list.clear();
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByLibelle(libelle.getText());
        for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
        initCol();
    }

    @FXML
    private void fbty(ActionEvent event) {
        list.clear();
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByType(libelle.getText());
        for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
        initCol();
    }

    @FXML
    private void fbs(ActionEvent event) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByStatus(libelle.getText());
        for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);}

    @FXML
    private void fbpd(ActionEvent event) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByNombrePlaceDisponible(Integer.parseInt(libelle.getText()));
       for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
    }
 
    @FXML
    private void fbp(ActionEvent event) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByIlyPlace();
       for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
        
    }

    @FXML
    private void fbpr(ActionEvent event) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByPrix(Integer.parseInt(libelle.getText()));
       for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
    }

    @FXML
    private void fbprma(ActionEvent event) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByMaxPrix(Integer.parseInt(libelle.getText()));
       for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
    }

    @FXML
    private void fbprmi(ActionEvent event) {
        List<Espace> listEspaces;
        listEspaces = new ArrayList();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        listEspaces=esi.findByMinPrix(Integer.parseInt(libelle.getText()));
       for (int i = 0; i < listEspaces.size(); i++) {
            list.add(listEspaces.get(i));
        }
        tableView.setItems(list);
    }

    @FXML
    private void handleRefresh(ActionEvent event) {
        loadData();
    }
    private void loadData() {
        List<Espace> prov = new ArrayList<>();
        list.clear();
        EspaceServiceImpl esi =new EspaceServiceImpl();
        prov=esi.findAll();
        for (int i = 0; i < prov.size(); i++) {
            list.add(prov.get(i));
        }
        tableView.setItems(list);
        
    }
    @FXML
    private void reserver(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        EspaceServiceImpl esi =new EspaceServiceImpl();
         Espace selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
                        alert.setTitle("error");
                        alert.setContentText("No Space selected ,Please select a Space for edit" );
                        alert.show();
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/Com/citeDeCulture/view/ReserverEspace.fxml"));
            Parent parent = loader.load();
            ReserverEspaceController controller = (ReserverEspaceController) loader.getController();
            controller.inflateUI(selectedForEdit);
            String status="reserver";
            int updated = 0;
		String query = "UPDATE espace SET"
				+ " libelle=?, nombreplace=?, typeespace=?, status=?, prix=?, image=?"
				+ " WHERE id=?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(query);
                        preparedStatement.setString(1, selectedForEdit.getLibelle());
			preparedStatement.setInt(2, selectedForEdit.getNombrePlace());
			preparedStatement.setString(3, selectedForEdit.getTypeEspace());
			preparedStatement.setString(4, status);
			preparedStatement.setDouble(5,selectedForEdit.getPrix());
                        preparedStatement.setString(6, selectedForEdit.getImage());
			preparedStatement.setInt(7,selectedForEdit.getId());
                        updated = preparedStatement.executeUpdate();
		} 
                catch (SQLException e) 
                {
			e.printStackTrace();
		}

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Reserver Space");
            stage.setScene(new Scene(parent));
            stage.show();

            stage.setOnHiding((e) -> {
                handleRefresh(new ActionEvent());
            });
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
 
    @FXML
    private void image(ActionEvent event) {
        Stage stage = new Stage(StageStyle.DECORATED);
         stage.setTitle("Gallery FX Demo");
        Group root = new Group();
        stage.setResizable(false);
        stage.setScene(new Scene(root, 440,290));
         // load images
        Image[] images = new Image[2];
        for (int i = 0; i <2; i++) {
            images[i] = new Image( DisplayShelfSample.class.getResource("es"+(i+1)+".jpg").toExternalForm(),false);
        }
        // create display shelf
        GalleryFXDemo.DisplayShelf displayShelf = new GalleryFXDemo.DisplayShelf(images);
        displayShelf.setPrefSize(WIDTH, HEIGHT);
        root.getChildren().add(displayShelf);
        stage.show();  
        
    }

    @FXML
    private void handleBookEditOption(ActionEvent event) {
    }

    @FXML
    private void handleBookDeleteOption(ActionEvent event) {    
    }
    
    @FXML
    private void home(MouseEvent event) {
    }
    
}
