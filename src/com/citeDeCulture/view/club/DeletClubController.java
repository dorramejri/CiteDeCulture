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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Sawssen Toumi
 */
public class DeletClubController implements Initializable {
    @FXML
    private Button supprimer;
    @FXML
    private Button annuler;
    @FXML
    private Text modifierClub;
    @FXML
    private TextField nomClub;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void deleteClub(ActionEvent event) {
        
        
//            Club club = new Club(nomClub.getText());
//        ClubServiceImpl csi = new ClubServiceImpl();
//                int x= csi.create(club);
//                if (x==0){
//                    AlertMaker.showErrorMessage("erreur", "Erreur suppression !!");
//                }
//                else
//                    AlertMaker.showSimpleAlert("succes", "Club supprimer ");
              ClubServiceImpl csi = new ClubServiceImpl();

        Club c=csi.findById(Integer.parseInt(nomClub.getText()));
        csi.delete(c);
        System.out.println("okaaay w byy");
                  
                
    }
                

   
    

    @FXML
    private void annuler(ActionEvent event) {
        nomClub.clear();
       
    
}
}