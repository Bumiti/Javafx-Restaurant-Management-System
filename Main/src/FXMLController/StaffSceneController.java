/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLController;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.log4j.Logger;
import jdbcDAO.*;
/**
 * FXML Controller class
 *
 * @author Admin
 */
public class StaffSceneController implements Initializable {

    @FXML
    private Label lbUser;

    /**
     * Initializes the controller class.
     */
    @FXML
    private Tab tabLog;
    @FXML
    private TableView<LogDB> tvLogger;
    @FXML
    private TableColumn<LogDB, Integer> colLoggerID;
    @FXML
    private TableColumn<LogDB, String> colLoggerDateTime;
    @FXML
    private TableColumn<LogDB, String> colLoggerMethod;
    @FXML
    private TableColumn<LogDB, String> colLoggerLevel;
    @FXML
    private TableColumn<LogDB, String> colLoggerMessage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showLogDB();
    }
    
    public static final Logger log = Logger.getLogger(StaffSceneController.class);

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
    
    public static ObservableList<LogDB> getLogDB() {
        ObservableList<LogDB> LogList = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select * from Logger";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            LogDB l = null;
            while (rs.next()) {
                l = new LogDB(rs.getInt("id"), rs.getString("datetime"), rs.getString("method_name"), rs.getString("level"), rs.getString("message"));
                LogList.add(l);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LogList;
    }
    
    public void showLogDB() {
        ObservableList<LogDB> list = getLogDB();
        colLoggerID.setCellValueFactory(new PropertyValueFactory<LogDB, Integer>("loggerID"));
        colLoggerDateTime.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerDateTime"));
        colLoggerMethod.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerMethod"));
        colLoggerLevel.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerLevel"));
        colLoggerMessage.setCellValueFactory(new PropertyValueFactory<LogDB, String>("loggerMessage"));
        tvLogger.setItems(list);
    }

}
