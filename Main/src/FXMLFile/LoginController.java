/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import com.gluonhq.charm.glisten.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.ButtonType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
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
    private javafx.scene.control.TextField tfUsername;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private BorderPane bpLogin;
    @FXML
    public Label lbRole;
    @FXML
    private Hyperlink btnSignUp;
    @FXML
    private Hyperlink btnForgotPassword;
    @FXML
    private Label lbCheck;
    @FXML
    private Label lbStaffRole1;
    @FXML
    private Label lbUserName;
    @FXML
    private Label lbPhone;
    @FXML
    private Label lbMail;

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
    public void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnLogin) {
            login();
        }
    }

    @FXML
    private void handleClickAction(MouseEvent event) throws IOException {
        if (event.getSource() == btnSignUp) {
            modalBox("/FXMLFile/SignUp.fxml", "Sign Up");
        }
        if (event.getSource() == btnForgotPassword) {
            modalBox("/FXMLFile/ResetPassword.fxml", "Forget Password");
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

    private void modalBox(String fxmlFile, String Title) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }

    private void getManagerScene(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        StaffSceneController userRole = loader.getController();
        userRole.setName(lbRole.getText());
        StaffSceneController userStaffRole = loader.getController();
        userStaffRole.setRole(lbStaffRole1.getText());

        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }

    private void getSupervisorScene(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        StaffSceneController userRole = loader.getController();
        userRole.setName(lbRole.getText());
        StaffSceneController userStaffRole = loader.getController();
        userStaffRole.setRole(lbStaffRole1.getText());
        userStaffRole.btnInventoryDelete.setDisable(true);
        userStaffRole.btnStaffCreate.setDisable(true);
        userStaffRole.btnStaffDelete.setDisable(true);
        userStaffRole.btnReceiptDelete.setDisable(true);
        userStaffRole.btnPaymentDelete.setDisable(true);
        userStaffRole.tabReport.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.btnAccountDelete.setDisable(true);
        userStaffRole.tabLog.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.btnCodeCreate.setDisable(true);
        userStaffRole.btnCodeUpdate.setDisable(true);
        userStaffRole.btnCodeDelete.setDisable(true);
        userStaffRole.tabAccount.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.btnCodeClear.setDisable(true);

        
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }

    private void getWaiterScene(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        StaffSceneController userRole = loader.getController();
        userRole.setName(lbRole.getText());
        StaffSceneController userStaffRole = loader.getController();
        userStaffRole.setRole(lbStaffRole1.getText());
        userStaffRole.btnInventoryAdd.setDisable(true);
        userStaffRole.btnInventoryBrowser.setDisable(true);
        userStaffRole.btnInventoryRemove.setDisable(true);
        userStaffRole.btnInventoryCreate.setDisable(true);
        userStaffRole.btnInventoryDelete.setDisable(true);
        userStaffRole.btnInventoryUpdate.setDisable(true);
        userStaffRole.btnInventoryClear.setDisable(true);
        userStaffRole.btnStaffCreate.setDisable(true);
        userStaffRole.btnStaffBrowser.setDisable(true);
        userStaffRole.btnStaffClear.setDisable(true);
        userStaffRole.btnStaffDelete.setDisable(true);
        userStaffRole.btnStaffUpdate.setDisable(true);
        userStaffRole.btnDishBrowser.setDisable(true);
        userStaffRole.btnDishClear.setDisable(true);
        userStaffRole.btnDishCreate.setDisable(true);
        userStaffRole.btnDishDelete.setDisable(true);
        userStaffRole.btnDishUpdate.setDisable(true);
        userStaffRole.tabReceipts.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.tabPayments.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.tabReport.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.tabAccount.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.tabLog.setStyle("-fx-pref-width: 0;" + "-fx-opacity: 0;");
        userStaffRole.btnCodeCreate.setDisable(true);
        userStaffRole.btnCodeUpdate.setDisable(true);
        userStaffRole.btnCodeDelete.setDisable(true);
        userStaffRole.btnCodeClear.setDisable(true);
        
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.showAndWait();
    }

    private void getCusScene(String fxmlFile, String Title) throws IOException {
        Locale locale = new Locale("en_US");
        ResourceBundle bundle = ResourceBundle.getBundle("resources.labelText", locale);
        FXMLLoader fXmlLoader = new FXMLLoader(getClass().getResource(fxmlFile), bundle);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        //Parent root = fXmlLoader.load(getClass().getResource(fxmlFile), bundle);
        Parent root = fXmlLoader.load();
        Locale currentLocale = Locale.getDefault();

        CustomerSceneController userRole = fXmlLoader.getController();
        userRole.setName(lbRole.getText());
        userRole.setUserName(lbUserName.getText());

        Stage primaryStage = new Stage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Title);
        primaryStage.show();
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mess, ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
    }

    private void alert(String mess) {
        Alert alert = new Alert(Alert.AlertType.WARNING, mess, ButtonType.OK);
        Optional<ButtonType> result = alert.showAndWait();
    }

    public void login() {
        String sql = "select accountRole,accountUserName from Account where accountUserName='" + tfUsername.getText() + "' and accountPassWord='" + tfPassword.getText() + "'";
        Connection cn = getConnect();
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
//                lbCheck.setText("");
                String role = rs.getString("accountRole");
                lbStaffRole1.setText(role);
                String cusUserName = rs.getString("accountUserName");
                lbRole.setText(cusUserName);
                Stage stage = (Stage) bpLogin.getScene().getWindow();
                stage.close();
                switch (role) {
                    case "Manager" -> {
                        getManagerScene("/FXMLFile/StaffScene.fxml", "Staff");
                    }
                    case "Supervisor" -> {
                        getSupervisorScene("/FXMLFile/StaffScene.fxml", "Staff");
                    }
                    case "Waiter" -> {
                        getWaiterScene("/FXMLFile/StaffScene.fxml", "Staff");
                    }
                    case "Customer" -> {
                        getCusScene("/FXMLFile/CustomerScene.fxml", "Customer");
                    }
                }
            } else {
                alert("Invalid Account!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
