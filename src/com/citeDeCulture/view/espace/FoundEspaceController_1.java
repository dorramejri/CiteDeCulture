/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.espace;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.sercicesImpl.EspaceServiceImpl;
import com.citeDeCulture.utils.DataSource;
import com.citeDeCulture.utils.LibraryAssistantUtil;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class FoundEspaceController_1 implements Initializable {
ObservableList<Espace> list = FXCollections.observableArrayList();
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
    Connection connection=null;
    
    public FoundEspaceController_1() {
        connection=DataSource.getInstance().getConnection();
    }
    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void handleBookEditOption(ActionEvent event) {
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
                    .getResource("/Com/citeDeCulture/view/EditEspace.fxml"));
            Parent parent = loader.load();
            EditEspaceController controller = (EditEspaceController) loader.getController();
            controller.inflateUI(selectedForEdit);
           esi.delete(selectedForEdit);
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("edit Space");
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
    private void handleBookDeleteOption(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        EspaceServiceImpl esi =new EspaceServiceImpl();
        Espace selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
                        alert.setTitle("error");
                        alert.setContentText("No Space selected ,Please select a Space for edit" );
                        alert.show();
            return;
        }
        else if (selectedForDeletion != null)
            {
        alert.setTitle("Deleting Space");
        alert.setContentText("Are you sure want to delete the Space " + selectedForDeletion.getLibelle() + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            int result = esi.delete(selectedForDeletion);
            if (result!=0) 
             {
                        alert.setTitle("success");
                        alert.setContentText("Space deleted "+ selectedForDeletion.getLibelle() + " was deleted successfully.");
                        alert.show();
                        list.remove(selectedForDeletion);
            }
            else
            {
                        alert.setTitle("echec");
                        alert.setContentText("Failed "+selectedForDeletion.getLibelle() +  " could not be deleted");
                        alert.show();
            }
        }
}
        else 
        {
            alert.setTitle("Cancelled");
                        alert.setContentText("Deletion cancelled "+ selectedForDeletion.getLibelle() + "Deletion process cancelled");
                        alert.show();
        }
    }
    
}
