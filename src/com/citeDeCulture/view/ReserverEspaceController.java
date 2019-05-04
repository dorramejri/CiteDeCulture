/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view;

import com.citeDeCulture.entities.Espace;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class ReserverEspaceController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void inflateUI(Espace e) {
       nom.setText(e.getLibelle());
    }
    @FXML
    private void home(MouseEvent event) {
    }

    @FXML
    private void reserver(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }

    @FXML
    private void back(MouseEvent event) {
    }
    
}
