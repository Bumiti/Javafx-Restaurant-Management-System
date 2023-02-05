/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.PropertyConfigurator;
import FXMLFile.*;
import static FXMLFile.StaffSceneController.log;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class Main extends Application {

    //FXMLDocument
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLFile/LoginScene.fxml"));
        PropertyConfigurator.configure(getClass().getResource("log4j.properties"));
//        log.info("Add");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
