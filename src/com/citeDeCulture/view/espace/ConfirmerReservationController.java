/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.espace;


import com.citeDeCulture.mail.EmailUtil;
import com.citeDeCulture.utils.AlertMaker;
import com.citeDeCulture.utils.LibraryAssistantUtil;
import com.jfoenix.controls.JFXProgressBar;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class ConfirmerReservationController implements Initializable {

    
    @FXML
    private TextField recepientAddressInput;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleStartAction(ActionEvent event) {
    
        String toAddress = recepientAddressInput.getText();
        if (LibraryAssistantUtil.validateEmailAddress(toAddress)) {
            EmailUtil.sendTestMail(toAddress, "reservation ", "reserver ya dorra !");
        AlertMaker.showSimpleAlert("Success", "Reservation effectuer avec succeé !");
        
       
        } 
        Stage stage = (Stage) recepientAddressInput.getScene().getWindow();
        stage.close();
        
    }
   
}
