/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ResetController implements Initializable {

    @FXML
    private BorderPane bpForgetMail;
    @FXML
    private TextField tfForgetMail;
    @FXML
    private Hyperlink lkForgetPhone;
    @FXML
    private Button btnChange1;
    @FXML
    private Button btnClose1;
    @FXML
    private BorderPane bpForgetPhone;
    @FXML
    private TextField tfForgetPhone;
    @FXML
    private Hyperlink lkForgetMail;
    @FXML
    private Button btnChange2;
    @FXML
    private Button btnClose2;
    @FXML
    private BorderPane bpChangePassword;
    @FXML
    private TextField tfUserName;
    @FXML
    private TextField tfPassWord1;
    @FXML
    private TextField tfPassWord2;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnClose3;
    @FXML
    private BorderPane bpForgotPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnClose1) {
            Stage stage = (Stage) bpForgotPassword.getScene().getWindow();
            stage.close();
        }
        if (event.getSource() == btnClose2) {
            Stage stage = (Stage) bpForgotPassword.getScene().getWindow();
            stage.close();
        }
        if (event.getSource() == btnClose3) {
            Stage stage = (Stage) bpForgotPassword.getScene().getWindow();
            stage.close();
        }
        if (event.getSource() == lkForgetPhone) {
            bpForgetMail.setVisible(false);
            bpForgetPhone.setVisible(true);
        }
        if (event.getSource() == lkForgetMail) {
            bpForgetMail.setVisible(true);
            bpForgetPhone.setVisible(false);
        }
        if (event.getSource() == btnChange1) {
            if (!Pattern.matches("\\w{3,30}@([a-z0-9]{3,10}\\.){1,2}[a-z]{2,3}", tfForgetMail.getText())) {
                alert("Mail wrong form");
            } else {
                getMail();
                getUserNameByMail(tfForgetMail);
            }
        }
        if (event.getSource() == btnChange2) {
            if (!Pattern.matches("\\d{8,12}", tfForgetPhone.getText())) {
                alert("Phone from 8-12");
            } else {
                getPhone();
                getUserNameByPhone(tfForgetPhone);
            }
        }
        if (event.getSource() == btnSubmit) {
            if (Pattern.matches(tfPassWord1.getText(), tfPassWord2.getText())) {
                insert("update Account set accountPassWord='" + tfPassWord1.getText() + "' where accountUserName='" + tfUserName.getText() + "'");
                alertSuccess("Change Password Suscessfully");

            } else {
                alert("Password not same");
            }
        }
    }

    private void getMail() {
        Connection cn = getConnect();
        String sql = "select * from Customer where customerMail ='" + tfForgetMail.getText() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                alertSuccess("Please Change your password");
                bpForgetMail.setVisible(false);
                bpForgetPhone.setVisible(false);
                bpChangePassword.setVisible(true);
            } else {
                alert("Invalid Mail");
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPhone() {
        Connection cn = getConnect();
        String sql = "select * from Customer where customerPhone=" + tfForgetPhone.getText() + "";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                alertSuccess("Please Change your password");
                bpForgetMail.setVisible(false);
                bpForgetPhone.setVisible(false);
                bpChangePassword.setVisible(true);
            } else {
                alert("Invalid Phone");
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUserNameByPhone(TextField tf) {
        Connection cn = getConnect();
        String sql = "select customerUserName from Customer where customerPhone='" + tf.getText() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String userName = rs.getString("customerUserName");
                tfUserName.setText(userName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUserNameByMail(TextField tf) {
        Connection cn = getConnect();
        String sql = "select customerUserName from Customer where customerMail='" + tf.getText() + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String userName = rs.getString("customerUserName");
                tfUserName.setText(userName);
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void alert(String mess) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mess, ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.NONE, mess, ButtonType.OK);
        alert.setTitle("Notification!");
        Optional<ButtonType> result = alert.showAndWait();
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
        Statement st;
        try {
            st = cn.createStatement();
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert(String query) {
        String sql = query;
        executeQuery(sql);
    }

}
