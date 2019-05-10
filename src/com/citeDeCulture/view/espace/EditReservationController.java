/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.espace;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.entities.Reservation;
import com.citeDeCulture.sercicesImpl.ReservationServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class EditReservationController implements Initializable {

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

    @FXML
    private void reserver(ActionEvent event) throws IOException {
        Reservation r =new  Reservation(Integer.parseInt(nom.getText()), Date.from(date.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ReservationServiceImpl rsi = new ReservationServiceImpl();
           int x= rsi.create(r);
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
        date.getEditor().clear();
        nom.clear();
    }
void inflateUI(Reservation e) {
       nom.setText(String.valueOf(e.getIdes()));
       date.getEditor().clear();
        
    }    
}
