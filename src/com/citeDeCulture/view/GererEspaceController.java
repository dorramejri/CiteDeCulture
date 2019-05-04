/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view;

import com.citeDeCulture.utils.LibraryAssistantUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class GererEspaceController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void home(MouseEvent event) {
    }

    @FXML
    private void foundEspace(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("FoundEspace.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Found Space");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void ajoutEspace(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("AjouterEspace.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Found Space");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void consulter(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("AfficherEspace.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Found Space");
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void logout(MouseEvent event) {
    }

    @FXML
    private void baxk(MouseEvent event) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("GererEspace.fxml"));
       Scene scene = new Scene(root);
       Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Found Space");
            stage.setScene(scene);
            stage.show();
    }
    
}
