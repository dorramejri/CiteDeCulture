/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.club;

import com.citeDeCulture.utils.AlertMaker;
import com.citeDeCulture.entities.Club;
import com.citeDeCulture.sercicesImpl.ClubServiceImpl;
import com.citeDeCulture.mail.EmailUtil;
import com.citeDeCulture.utils.LibraryAssistantUtil;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class AjouterClubController implements Initializable {

    @FXML
    private TextField libelle;
    @FXML
    private TextField membre;
    @FXML
    private TextField activite;
    @FXML
    private TextField description;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addClub(ActionEvent event) {
        Club club = new Club(libelle.getText(), Integer.parseInt(membre.getText()), activite.getText(), description.getText());
        ClubServiceImpl csi = new ClubServiceImpl();
                int x= csi.create(club);
                if (x==0){
                    AlertMaker.showErrorMessage("erreur", "Erreur d'ajout !!");
                }
                else{
                    AlertMaker.showSimpleAlert("succes", "Club ajoute ");
                    String toAddress = "rihab.grech@esprit.tn";
        if (LibraryAssistantUtil.validateEmailAddress(toAddress)) {
            EmailUtil.sendTestMail(toAddress, "reservation ", "reserver ya dorra !");
        AlertMaker.showSimpleAlert("Success", "Reservation effectuer avec succeé !");
        
       } 
              
                }           
    }

    @FXML
    private void annuler(ActionEvent event) {
        libelle.clear();
        activite.clear();
        description.clear();
        membre.clear();
    }
    
}
