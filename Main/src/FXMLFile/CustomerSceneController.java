/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class CustomerSceneController implements Initializable {

    @FXML
    private BorderPane bpHomepage;
    @FXML
    private BorderPane bpMenu;
    @FXML
    private BorderPane bpBook;
    @FXML
    private BorderPane bpMyRestaurant;
    @FXML
    private BorderPane bpAboutUs;
    @FXML
    private Button btnHomepage;
    @FXML
    private Button btnMenu;
    @FXML
    private Button btnMyRestaurant;
    @FXML
    private Button btnAboutUS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        bpHomepage.setVisible(true);
    }

    @FXML
    private void handleClickAction(MouseEvent event) {
        if (event.getSource() == btnHomepage) {
            bpHomepage.setVisible(true);
            bpMenu.setVisible(false);
            bpBook.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
        }
//        if(event.getSource()==btnHomepage){
//            bpHomepage.setVisible(false);
//            bpMenu.setVisible(false);
//            bpBook.setVisible(false);
//            bpMyRestaurant.setVisible(false);
//            bpAboutUs.setVisible(false);
//        }
        if (event.getSource() == btnMenu) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(true);
            bpBook.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(false);
        }
        if (event.getSource() == btnMyRestaurant) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpBook.setVisible(false);
            bpMyRestaurant.setVisible(true);
            bpAboutUs.setVisible(false);
        }
        if (event.getSource() == btnAboutUS) {
            bpHomepage.setVisible(false);
            bpMenu.setVisible(false);
            bpBook.setVisible(false);
            bpMyRestaurant.setVisible(false);
            bpAboutUs.setVisible(true);
        }
    }

}
