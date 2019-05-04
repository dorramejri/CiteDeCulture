/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view;

import com.citeDeCulture.entities.Concours;
import com.citeDeCulture.sercicesImpl.ConcoursServiceImpl;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class AjouterConcoursController implements Initializable {

    @FXML
    private TextField titre;
    @FXML
    private TextField description;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;
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
            Concours concours = new Concours();
            concours.setTitre(titre.getText());
            concours.setDescription(description.getText());
            concours.setDateDebut( Date.from(debut.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            concours.setDateFin(Date.from(fin.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            ConcoursServiceImpl csi = new ConcoursServiceImpl();
            int x=csi.create(concours);
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
            titre.clear();
            description.clear();
            debut.setValue(null);
            fin.setValue(null);
        });
    }    
    
}
