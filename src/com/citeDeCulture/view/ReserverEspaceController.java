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
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
       nom.setText(String.valueOf(e.getId()));
    }

    @FXML
    private void reserver(ActionEvent event) throws IOException {
        Reservation r =new  Reservation(Integer.parseInt(nom.getText()), Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ReservationServiceImpl rsi = new ReservationServiceImpl();
           int x= rsi.create(r);
            Stage s = (Stage) nom.getScene().getWindow();
            s.close();
            if(x!=0)
            {
                    FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/Com/citeDeCulture/view/ConfirmerReservation.fxml"));
                    Parent parent = loader.load();
            ConfirmerReservationController controller = (ConfirmerReservationController) loader.getController();

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Confirmer Reservation");
            stage.setScene(new Scene(parent));
            stage.show();  
            }
             
            
            
    }

    @FXML
    private void annuler(ActionEvent event) {
        nom.clear();
        date.getEditor().clear();
    }

    
}
