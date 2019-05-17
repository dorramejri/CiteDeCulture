/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.club;

import com.citeDeCulture.utils.AlertMaker;
import com.citeDeCulture.entities.Club;
import com.citeDeCulture.sercicesImpl.ClubServiceImpl;
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
 * @author Sawssen Toumi
 */
public class EditClubController implements Initializable {

    @FXML
    private TextField nomClub;
    @FXML
    private TextField activite;
    @FXML
    private Button modifier;
    @FXML
    private Button annuler;

    public static int id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ClubServiceImpl cs = new ClubServiceImpl();
        Club c = cs.findById(id);
        nomClub.setText(c.getNom());
        activite.setText(c.getActivite());
    }

    @FXML
    private void editClub(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Club club = new Club(nomClub.getText(), activite.getText());
        ClubServiceImpl csi = new ClubServiceImpl();
        Club Clubb = null;
        club.setId(id);
        int x = csi.edit(club);
        if (x == 0) {
            AlertMaker.showErrorMessage("erreur", "Erreur de modification !!");
        } else {
            AlertMaker.showSimpleAlert("succes", "Club modifier ");
        }
    }

    @FXML
    private void annuler(ActionEvent event) throws Exception {
        nomClub.clear();
        activite.clear();
    }

    void inflateUI(Club selectedForEdit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
