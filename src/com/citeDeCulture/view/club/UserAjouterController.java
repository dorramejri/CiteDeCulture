/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.club;

import com.citeDeCulture.entities.Club;
import com.citeDeCulture.sercicesImpl.MembreServiceImpl;
import com.citeDeCulture.utils.AlertMaker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sawssen Toumi
 */
public class UserAjouterController implements Initializable {
    @FXML
    private TextArea description;
    @FXML
    private TextField nom;
    @FXML
    private TextField activite;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private TextField membre;
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addClub(ActionEvent event) {
        //Club club = new Club(nom.getText(), activite.getText(), description.getText());
        Club club = new Club(nom.getText(), activite.getText(), description.getText());
        club.setMembre(Integer.parseInt(membre.getText()));
        MembreServiceImpl csi = new MembreServiceImpl();
                //int x= csi.create(club);
        int x=csi.create(club);
                if (x==0){
                    AlertMaker.showErrorMessage("erreur", "Erreur d'ajout !!");
                }
                else
                    AlertMaker.showSimpleAlert("succes", "Club ajoute ");
       
                  
                
    }

    @FXML
    private void annuler(ActionEvent event) {
        nom.clear();
        activite.clear();
        description.clear();
    }
    
}
