/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.entities.Reservation;
import com.citeDeCulture.sercicesImpl.EspaceServiceImpl;
import com.citeDeCulture.sercicesImpl.ReservationServiceImpl;
import com.citeDeCulture.utils.AlertMaker;
import com.citeDeCulture.utils.LibraryAssistantUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
public class ShowAllReservationController implements Initializable {
ObservableList<Reservation> list = FXCollections.observableArrayList();
    @FXML
    private TableView<Reservation> tableView;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane contentPane;
    @FXML
    private TableColumn<Reservation, Integer> nom;
    @FXML
    private TableColumn<Reservation, Date> date;

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
        nom.setCellValueFactory(new PropertyValueFactory<>("ides"));
        date.setCellValueFactory(new PropertyValueFactory<>("dateRES"));
    }
   private void loadData() {
        List<Reservation> prov = new ArrayList<>();
        list.clear();
        ReservationServiceImpl esi =new ReservationServiceImpl();
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
       
       ReservationServiceImpl esi =new ReservationServiceImpl();
         Reservation selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            AlertMaker.showSimpleAlert("error", "No Reservation selected ,Please select a Reservation for edit");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/Com/citeDeCulture/view/EditReservation.fxml"));
            Parent parent = loader.load();
            EditReservationController controller = (EditReservationController) loader.getController();
            controller.inflateUI(selectedForEdit);
            esi.delete(selectedForEdit);

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Edit Reservation");
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
        ReservationServiceImpl esi =new ReservationServiceImpl();
        Reservation selectedForDeletion = tableView.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {
                        alert.setTitle("error");
                        alert.setContentText("No Reservation selected ,Please select a reservation for edit" );
                        alert.show();
            return;
        }
        else if (selectedForDeletion != null)
            {
        alert.setTitle("Deleting Reservation");
        alert.setContentText("Are you sure want to delete the reservation ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            int result = esi.delete(selectedForDeletion);
            if (result!=0) 
             {
                        alert.setTitle("success");
                        alert.setContentText("Reservation was deleted successfully.");
                        alert.show();
                        list.remove(selectedForDeletion);
            }
            else
            {
                        alert.setTitle("echec");
                        alert.setContentText("Failed reservation could not be deleted");
                        alert.show();
            }
        }
}
        else 
        {
            alert.setTitle("Cancelled");
                        alert.setContentText("Deletion cancelled Deletion process cancelled");
                        alert.show();
        }
    }

    @FXML
    private void exportAsPDF(ActionEvent event) {
        List<List> printData = new ArrayList<>();
        String[] headers = {" ID RESERVATION ", " DATE RESERVATION "," ID ESPACE "};
        printData.add(Arrays.asList(headers));
        for (Reservation book : list) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(book.getIdres()));
            row.add(String.valueOf(book.getDateRES()));
            row.add(String.valueOf(book.getIdes()));
            printData.add(row);
        }
        LibraryAssistantUtil.initPDFExprot(rootPane, contentPane, getStage(), printData);

    
    }

    @FXML
    private void closeStage(ActionEvent event) {
        getStage().close();
    }
    @FXML
    private void handleSpaceDetaille(ActionEvent event) {
        ReservationServiceImpl esi =new ReservationServiceImpl();
         Reservation selectedForEdit = tableView.getSelectionModel().getSelectedItem();
        if (selectedForEdit == null) {
            AlertMaker.showSimpleAlert("error", "No Reservation selected ,Please select a Reservation for edit");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/Com/citeDeCulture/view/FoundReservation.fxml"));
            Parent parent = loader.load();
            FoundReservationController controller = (FoundReservationController) loader.getController();
            controller.inflateUI(selectedForEdit);
            
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Detaille Espace");
            stage.setScene(new Scene(parent));
            stage.show();
           

            stage.setOnHiding((e) -> {
                handleRefresh(new ActionEvent());
            });
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
