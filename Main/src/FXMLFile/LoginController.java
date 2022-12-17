/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import com.gluonhq.charm.glisten.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource()== btnLogin){
            login();
        }
    }
    
    public static Connection getConnect() {
        Connection cn = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433;database=Project";
        String uid = "sa";
        String pwd = "123";
        try {
            //1. dang ky driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //2 tao ket noi den co so du lieu
            cn = DriverManager.getConnection(url, uid, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }
    
    private void getScene(String fxmlFile, String Title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }
    
    private void login() {
        String sql = "select accountRoll from Account where accountUserName='" + tfUsername.getText() + "' and accountPassWord='" + tfPassword.getText() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
//                lbCheck.setText("");
                String role = rs.getString("accountRoll");
                switch (role) {
                    case "M","S","W" -> {
                        getScene("/FXMLFile/StaffScene.fxml", "Staff");
                    }
                    case "C" -> {
                        getScene("/FXMLFile/CustomerScene.fxml", "Customer");
                    }
                }
            } 
//            else {
//                lbCheck.setText("Your account not exits");
//            }
            //close?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
