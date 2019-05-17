/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.club;

import com.citeDeCulture.entities.Club;
import com.citeDeCulture.sercicesImpl.ClubServiceImpl;
import com.citeDeCulture.sercicesImpl.MembreServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sawssen Toumi
 */
public class MembreController implements Initializable {

    @FXML
    private AnchorPane tousClubs;
    @FXML
    private Label nom;
    @FXML
    private Label description;
    @FXML
    private Label activite;
    @FXML
    private Label membre;
    @FXML
    private MenuButton mesClubs;
    @FXML
    private Button connexion;
    @FXML
    private Button inscrire;
    @FXML
    private TextField rechercher;
    @FXML
    private ListView<Club> listeClubs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClubServiceImpl es = new ClubServiceImpl();
        ArrayList arrayList = (ArrayList) es.findAll();
        System.out.println(arrayList);
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
//        listeClub.setItems(observableList);
    }

    @FXML
    private void rechercherClub(ActionEvent event) throws IOException {

        ClubServiceImpl es = new ClubServiceImpl();
        ArrayList arrayList = (ArrayList) es.findAll();
        ObservableList observableList = FXCollections.observableArrayList(arrayList);
        FilteredList<Club> filteredData = new FilteredList<>(observableList, e -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(e -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (e.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });

        SortedList<Club> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // sortedData.comparatorProperty().bind(listeEvents.co);
        // 5. Add sorted (and filtered) data to the table.
        //System.out.println(sortedData);
        listeClubs.setItems(sortedData);
    }

}
