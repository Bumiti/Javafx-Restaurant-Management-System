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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.*;

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
    @FXML
    private BorderPane bpLogin;
    @FXML
    public Label lbRole;

    /**
     * Initializes the controller class.
     */
    public String getLbRole() {
        return lbRole.getText();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnLogin) {
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

    private void getStaffScene(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        StaffSceneController userRole = loader.getController();
        userRole.setName(lbRole.getText());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }

    private void getCusScene(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
//        StaffSceneController userRole = loader.getController();
//        userRole.setName(lbRole.getText());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }
//    public void changeScene(String fxml) throws IOException {
//        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
//
//        Scene scene = new Scene(pane);
//        
//    }
    public void login() {
        String sql = "select accountRole,accountFullname from Account where accountUserName='" + tfUsername.getText() + "' and accountPassWord='" + tfPassword.getText() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Stage stage = (Stage) bpLogin.getScene().getWindow();
                stage.close();
//                lbCheck.setText("");
                String userName = rs.getString("accountFullname");
                lbRole.setText(userName);
                String role = rs.getString("accountRole");
                switch (role) {
                    case "Manager","Supervior","Waiter" -> {
                        getStaffScene("/FXMLFile/StaffScene.fxml", "Staff");
                    }
                    case "Customer" -> {
                        getCusScene("/FXMLFile/CustomerScene.fxml", "Customer");
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
