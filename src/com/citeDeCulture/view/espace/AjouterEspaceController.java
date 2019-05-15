/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.espace;

import com.citeDeCulture.entities.Espace;
import com.citeDeCulture.sercicesImpl.EspaceServiceImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Mejri Dorra
 */
public class AjouterEspaceController implements Initializable {

    @FXML
    private TextField libelle;
    @FXML
    private TextField place;
    @FXML
    private TextField type;
    @FXML
    private TextField statut;
    @FXML
    private TextField prix;
    @FXML
    private Button ajouter;
    @FXML
    private Button annuler;
    @FXML
    private Button img;
    @FXML
    private ImageView imag;
    String image="ff.png";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

   @FXML
    private void addEspace(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if(libelle.getText().equals("")
                ||place.getText().contains("")
                ||type.getText().equals("")||
                statut.getText().equals("")||
                prix.getText().equals(""))
        {
            alert.setTitle("error");
                        alert.setContentText("verifier champs" );
                        alert.show();
        }
        else
        {
         Espace espace = new Espace(libelle.getText(),Integer.parseInt(place.getText()),type.getText(),statut.getText(),Double.parseDouble(prix.getText()),image);
         
         EspaceServiceImpl esi = new EspaceServiceImpl();
           int x= esi.create(espace);
            if(x==0){
            
                        alert.setTitle("error");
                        alert.setContentText("Espace non ajouté" );
                        alert.show();
            }
            else
            {
            
                        alert.setTitle("success");
                        alert.setContentText("Espace ajouté" );
                        alert.show();
            }
         }
    }
    @FXML
    private void annuler(ActionEvent event) throws Exception {
    libelle.clear();
    place.clear();
    type.clear();
    statut.clear();
     prix.clear();
    
    
            
    }

    @FXML
    private void parcouririmage(ActionEvent event) throws Exception {
         FileChooser fc = new FileChooser();
       File selectedFile = fc.showOpenDialog(null);
       if (selectedFile != null)
       {
           String fileExtension = selectedFile.getName().substring(selectedFile.getName().lastIndexOf("."),selectedFile.getName().length());
           if(Arrays.asList(VALID_EXTENSIONS).contains(fileExtension))
           {    
           image = selectedFile.getName();
           File source = new File(selectedFile.getPath());
           File dest = new File("C:\\Users\\Mejri Dorra\\Documents\\NetBeansProjects\\CiteDeLaCulture\\src\\com\\citeDeCulture\\Uploads"+selectedFile.getName());
           
           
           }
           
       }
       
        
    }
 private static final String[] VALID_EXTENSIONS = new String[] {".png", ".jpg", "jpeg", "gif", "bmp"};
     private static boolean copyFileUsingStream(File source, File dest) throws Exception 
    {
        InputStream is = null;
        OutputStream os = null;
        try 
        {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);}
        } finally {
            is.close();
            os.close();
        }
        return true;
    } 

    

}
