/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class StaffChangePasswordController implements Initializable {

    @FXML
    private Label lbStaffName;
    @FXML
    private Button btnOK;
    @FXML
    private PasswordField tfPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setName(String name) {
        lbStaffName.setText(name);
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

    private void executeQuery(String sql) {
        Connection cn = getConnect();
        java.sql.Statement st;
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void update(String query) {
        String sql = query;
        executeQuery(sql);
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.NONE, mess, ButtonType.OK);
        alert.setTitle("Notification!");
        Optional<ButtonType> result = alert.showAndWait();
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnOK) {
            update("update Account set accountPassWord='" + tfPassword.getText() + "' where accountFullname='" + lbStaffName.getText() + "'");
            alertSuccess("Change Password Successfully!");
        }
    }

}
