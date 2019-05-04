/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view;

import com.citeDeCulture.entities.Participant;
import com.citeDeCulture.sercicesImpl.ParticipantServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class AjouterParticipantController implements Initializable {

    @FXML
    private TextField image;
    @FXML
    private TextField nom;
    @FXML
    private TextField sexe;
    @FXML
    private TextField prenom;
    @FXML
    private TextField information;
    @FXML
    private TextField vote;
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        ajouter.setOnAction((ActionEvent e) -> {
            Participant p = new Participant();
            p.setNomImage(image.getText());
            p.setNom(nom.getText());
            p.setPrenom(prenom.getText());
            p.setSexe(sexe.getText());
            p.setInformation(information.getText());
            p.setVote(Integer.parseInt(vote.getText()));
            ParticipantServiceImpl psi =new  ParticipantServiceImpl();
            int x=psi.create(p);
            if(x==0){
            
                        alert.setTitle("error");
                        alert.setContentText("participant non ajouté" );
                        alert.show();
            }
            else
            {
            
                        alert.setTitle("success");
                        alert.setContentText("participant ajouté" );
                        alert.show();
            }
        });
        annuler.setOnAction((ActionEvent e) -> {
            image.clear();
            nom.clear();
            prenom.clear();
            information.clear();
            sexe.clear();
            vote.clear();
        });
    }    
    
}
