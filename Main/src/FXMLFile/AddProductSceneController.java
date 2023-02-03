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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class AddProductSceneController implements Initializable {

    @FXML
    private TextField tfProductName;
    @FXML
    private Spinner<Integer> snProductQOH;
    @FXML
    private TextField tfProductPrice;
    @FXML
    private Button btnProductAdd;
    @FXML
    private Label lbTime;
    @FXML
    private Label lbStaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        snProductQOH.setValueFactory(productSpinner);
        Timenow();
    }

    private static final SpinnerValueFactory<Integer> productSpinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 1, 1);

    public void setName(String name) {
        tfProductName.setText(name);
    }

    public void setStaff(String name) {
        lbStaff.setText(name);
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

    private void log(String mess) {
        Logger.getLogger(AddProductSceneController.class.getName()).info(mess);
    }

    private void alertSuccess(String mess) {
        Alert alert = new Alert(Alert.AlertType.NONE, mess, ButtonType.OK);
        alert.setTitle("Notification!");
        Optional<ButtonType> result = alert.showAndWait();
    }

    private void Timenow() {
        Thread thread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy hh:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e);
                }
                final String timenow = sdf.format(new Date());
                Platform.runLater(() -> {
                    lbTime.setText(timenow); // This is the label
                });
            }
        });
        thread.start();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnProductAdd) {
            update("UPDATE Inventory set productQOH+=" + snProductQOH.getValue() + " where productName='" + tfProductName.getText() + "'");
            update("insert into Chi values(1,'" + lbTime.getText() + "','Product' , " + Integer.parseInt(tfProductPrice.getText()) * snProductQOH.getValue() + ",'Paid for " + tfProductName.getText() + ", create by " + lbStaff.getText() + "')");
            update("update Menu set dishStatus='Available' where dishIngredient ='" + tfProductName.getText() + "'");
            log("" + lbStaff.getText() + " have update inventory!");
            alertSuccess("Add successfully");
        }
    }
}
