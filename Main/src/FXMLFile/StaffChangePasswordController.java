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
import java.util.regex.Pattern;
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
    @FXML
    private Button btnShowPass1;
    @FXML
    private PasswordField tfConfirmPassword;
    @FXML
    private Button btnShowPass2;

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

    private void alert(String mess) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mess, ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
    }
    private String password1;
    private String password2;

    @FXML
    private void showPassword1() {
        password1 = tfPassword.getText();
        tfPassword.clear();
        tfPassword.setPromptText(password1);
    }

    @FXML
    private void hidePassword1() {
        password1 = tfPassword.getPromptText();
        tfPassword.setText(password1);
        tfPassword.setPromptText("Password");
    }

    @FXML
    private void showPassword2() {
        password2 = tfConfirmPassword.getText();
        tfConfirmPassword.clear();
        tfConfirmPassword.setPromptText(password2);
    }

    @FXML
    private void hidePassword2() {
        password1 = tfConfirmPassword.getPromptText();
        tfConfirmPassword.setText(password2);
        tfConfirmPassword.setPromptText("Enter your Password again");
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnOK) {
            if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", tfPassword.getText())) {
                alert("Password must contain at least 1 digit [0-9],\n"
                        + "One lowercase [a-z],"
                        + "One uppercase [A-Z],\n"
                        + "One special character like !@#.\n"
                        + "8-20 characters");
            } else if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", tfConfirmPassword.getText())) {
                alert("Confirm Password must contain at least 1 digit [0-9],\n"
                        + "One lowercase [a-z],"
                        + "One uppercase [A-Z],\n"
                        + "One special character like !@#.\n"
                        + "8-20 characters");
            } else if (!Pattern.matches(tfPassword.getText(), tfConfirmPassword.getText())) {
                alert("Password not the same");
            } else {
                update("update Account set accountPassWord='" + tfPassword.getText() + "' where accountUserName='" + lbStaffName.getText() + "'");
                alertSuccess("Change Password Successfully!");
            }
        }
    }

}
