/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.espace;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.sercicesImpl.EspaceServiceImpl;
import com.citeDeCulture.utils.LibraryAssistantUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class AfficherEspaceController implements Initializable {
ObservableList<Espace> list = FXCollections.observableArrayList();

    @FXML
    private TableView<Espace> tableView;
    @FXML
    private StackPane rootPane;
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
    @FXML
    private TableColumn<Espace, String> imageCol;
    @FXML
    private TableColumn<Espace, String> eventCol;
     @FXML
    private AnchorPane contentPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
        initCol();
    }   
     private Stage getStage() {
        return (Stage) tableView.getScene().getWindow();
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
    private void handleRefresh(ActionEvent event) {
        loadData();
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
            stage.setTitle("Edit Space");
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

    @FXML
    private void exportAsPDF(ActionEvent event) {
         List<List> printData = new ArrayList<>();
        String[] headers = {" ID ", "  LIBELLE ", "  PLACE DISPONIBLE  ", "  TYPE ", " STATUS ", " PRIX "};
        printData.add(Arrays.asList(headers));
        for (Espace book : list) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(book.getId()));
            row.add(book.getLibelle());
            row.add(String.valueOf(book.getNombrePlace()));
            row.add(book.getTypeEspace());
            row.add(book.getStatus());
            row.add(String.valueOf(book.getPrix()));
            printData.add(row);
        }
        LibraryAssistantUtil.initPDFExprot(rootPane, contentPane, getStage(), printData);

    }

    @FXML
    private void closeStage(ActionEvent event) {
        getStage().close();
    }
    
    
public static class espace {

        private final SimpleStringProperty id;
        private final SimpleStringProperty libelle;
        private final SimpleStringProperty nombrePlace;
        private final SimpleStringProperty typeEspace;
        private final SimpleStringProperty status;
        private final SimpleStringProperty prix;
        

        public espace(int a, String b, int c, String d, String e, double f) {
            this.id = new SimpleStringProperty(String.valueOf(a));
            this.libelle = new SimpleStringProperty(b);
            this.nombrePlace = new SimpleStringProperty(String.valueOf(c));
            this.typeEspace = new SimpleStringProperty(d);
            this.status = new SimpleStringProperty(e);
            this.prix = new SimpleStringProperty(String.valueOf(f));
           
        }

    public SimpleStringProperty getId() {
        return id;
    }

    public SimpleStringProperty getLibelle() {
        return libelle;
    }

    public SimpleStringProperty getNombrePlace() {
        return nombrePlace;
    }

    public SimpleStringProperty getTypeEspace() {
        return typeEspace;
    }

    public SimpleStringProperty getStatus() {
        return status;
    }

    public SimpleStringProperty getPrix() {
        return prix;
    }
}
}
