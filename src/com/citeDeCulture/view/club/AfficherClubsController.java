/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.citeDeCulture.view.club;

import com.citeDeCulture.entities.Club;
import com.citeDeCulture.sercicesImpl.ClubServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Sawssen Toumi
 */
public class AfficherClubsController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label activite;
    @FXML
    private Label membre;
    @FXML
    private Label description;

//   private TableView mytable ;
//    @FXML
//    private TableColumn<?, ?> nom;
//    @FXML
//    private TableColumn<?, ?> activite;
//    @FXML
//    private TableColumn<?, ?> membre;
//    @FXML
//    private TableColumn<?, ?> descrip;
    ObservableList<Club> Oreservations;

    ClubServiceImpl csi = new ClubServiceImpl();
    @FXML
    private ListView<Club> listview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Oreservations = FXCollections.observableArrayList(csi.findAll());
        listview.setItems(Oreservations);
        listview.setCellFactory(new Callback<ListView<Club>, ListCell<Club>>() {

            @Override
            public ListCell<Club> call(ListView<Club> param) {

                ListCell<Club> cell = new ListCell<Club>() {
                    protected void updateItem(Club item, boolean empty) {
                        if (item != null) {
                            HBox hbox = new HBox();
                            hbox.setSpacing(100);
                            Label l = new Label(item.getNom());
                            Label l2 = new Label("" + item.getMembre());
                            Label l3 = new Label(item.getActivite());
                            Label l4 = new Label(item.getDescription());
                            l.setStyle("-fx-font-weight: bold");
                            l2.setStyle("-fx-font-weight: bold");
                            l3.setStyle("-fx-font-weight: bold");
                            l4.setStyle("-fx-font-weight: bold");

                            hbox.getChildren().add(l);
                            hbox.getChildren().add(l2);
                            hbox.getChildren().add(l3);
                            hbox.getChildren().add(l4);
                            setGraphic(hbox);
                            hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {

                                @Override
                                public void handle(MouseEvent event) {
                                    EditClubController.id = item.getId();
                                    Parent root;
                                    /*
                                     try {
                                     // Construct data
                                     String apiKey = "apikey=" + "b/6H9CyfX/0-gc2d43E3UnLu3MJTD06WOUbuXomS4g	";
                                     String message = "&message=" + "ROURI";
                                     String sender = "&sender=" + "Jims Autos";
                                     String numbers = "&numbers=" + "21620211206";

                                     // Send data
                                     HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
                                     String data = apiKey + numbers + message + sender;
                                     conn.setDoOutput(true);
                                     conn.setRequestMethod("POST");
                                     conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                                     conn.getOutputStream().write(data.getBytes("UTF-8"));
                                     final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                     final StringBuffer stringBuffer = new StringBuffer();
                                     String line;
                                     while ((line = rd.readLine()) != null) {
                                     stringBuffer.append(line);
                                     }
                                     rd.close();

                                     } catch (Exception e) {
                                     System.out.println("Error SMS " + e);
                                     }
                                    
                                     */

                                    try {
                                        root = FXMLLoader.load(getClass().getResource("EditClub.fxml"));
                                        Scene scene = new Scene(root);
                                        Stage stage = new Stage(StageStyle.DECORATED);

                                        stage.setScene(scene);
                                        stage.show();
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }

                                }
                            });
                        }
                    }
                };

                return cell;
            }

        }
        );

//        TableColumn nom = new TableColumn("nom");
//        TableColumn activite = new TableColumn("activite");
//        TableColumn membre = new TableColumn("membre");
//        TableColumn description = new TableColumn("description");
//        mytable.getColumns().addAll(nom , activite , membre , description);
        // final ObservableList<Club> data =FXCollections.observableArrayList(
        // new Club("liberta", membre, "Sportif", "club du sport"));
    }

}
