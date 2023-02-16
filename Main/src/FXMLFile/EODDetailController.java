/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jdbcDAO.*;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class EODDetailController implements Initializable {

    @FXML
    private Label lbDayDetail;
    @FXML
    private TableView<EODThuDetailDB> tvThu;
    @FXML
    private TableColumn<EODThuDetailDB, Integer> colThuID;
    @FXML
    private TableColumn<EODThuDetailDB, String> colThuTime;
    @FXML
    private TableColumn<EODThuDetailDB, String> colThuCatalog;
    @FXML
    private TableColumn<EODThuDetailDB, Integer> colThuPrice;
    @FXML
    private TableColumn<EODThuDetailDB, String> colThuNote;
    @FXML
    private Button btnClose;
    @FXML
    private TableView<EODChiDetailDB> tvChi;
    @FXML
    private TableColumn<EODChiDetailDB, Integer> colChiID;
    @FXML
    private TableColumn<EODChiDetailDB, String> colChiTime;
    @FXML
    private TableColumn<EODChiDetailDB, String> colChiCatalog;
    @FXML
    private TableColumn<EODChiDetailDB, Integer> colChiPrice;
    @FXML
    private TableColumn<EODChiDetailDB, String> colChiNote;
    @FXML
    private BorderPane bpEODDetails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLFile/EOD.fxml"));
//        EODController userRole = loader.getController();
//        EOD i = userRole.tvEOD.getSelectionModel().getSelectedItem();
//        showChiEOD(i.getEodTime().toString());
//        showThuEOD(i.getEodTime().toString());

    }

    public void setName(String name) {
        lbDayDetail.setText(name);
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

    public ObservableList<EODChiDetailDB> getEODChi(LocalDate time) {
        ObservableList<EODChiDetailDB> eodChi = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select eodDetailChiID,eodDetailChiTime,eodDetailChiCatalog,eodDetailChiPrice,eodDetailChiNote from EODDetailChi where eodDetailChiTime ='" + time + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            EODChiDetailDB c = null;
            while (rs.next()) {
                c = new EODChiDetailDB(rs.getInt("eodDetailChiID"), rs.getDate("eodDetailChiTime").toLocalDate(), rs.getString("eodDetailChiCatalog"), rs.getInt("eodDetailChiPrice"), rs.getString("eodDetailChiNote"));
                eodChi.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eodChi;
    }

    public void showChiEOD(LocalDate time) {
        ObservableList<EODChiDetailDB> list = getEODChi(time);
        colChiID.setCellValueFactory(new PropertyValueFactory<EODChiDetailDB, Integer>("eodChiDetailID"));
        colChiTime.setCellValueFactory(new PropertyValueFactory<EODChiDetailDB, String>("eodChiDetailDate"));
        colChiCatalog.setCellValueFactory(new PropertyValueFactory<EODChiDetailDB, String>("eodChiDetailCatalog"));
        colChiPrice.setCellValueFactory(new PropertyValueFactory<EODChiDetailDB, Integer>("eodChiDetailPrice"));
        colChiNote.setCellValueFactory(new PropertyValueFactory<EODChiDetailDB, String>("eodChiDetailNote"));
        tvChi.setItems(list);
    }

    public ObservableList<EODThuDetailDB> getEODThu(LocalDate time) {
        ObservableList<EODThuDetailDB> eodThu = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select eodDetailThuID,eodDetailThuTime,eodDetailThuCatalog,eodDetailThuPrice,eodDetailThuNote from EODDetailThu where eodDetailThuTime ='" + time + "'";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            EODThuDetailDB t = null;
            while (rs.next()) {
                t = new EODThuDetailDB(rs.getInt("eodDetailThuID"), rs.getDate("eodDetailThuTime").toLocalDate(), rs.getString("eodDetailThuCatalog"), rs.getInt("eodDetailThuPrice"), rs.getString("eodDetailThuNote"));
                eodThu.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eodThu;
    }

    public void showThuEOD(LocalDate time) {
        ObservableList<EODThuDetailDB> list = getEODThu(time);
        colThuID.setCellValueFactory(new PropertyValueFactory<EODThuDetailDB, Integer>("eodThuDetailID"));
        colThuTime.setCellValueFactory(new PropertyValueFactory<EODThuDetailDB, String>("eodThuDetailDate"));
        colThuCatalog.setCellValueFactory(new PropertyValueFactory<EODThuDetailDB, String>("eodThuDetailCatalog"));
        colThuPrice.setCellValueFactory(new PropertyValueFactory<EODThuDetailDB, Integer>("eodThuDetailPrice"));
        colThuNote.setCellValueFactory(new PropertyValueFactory<EODThuDetailDB, String>("eodThuDetailNote"));
        tvThu.setItems(list);
    }

    @FXML
    private void handleMouseAction(MouseEvent event) {
        if (event.getSource() == btnClose) {
            Stage stage = (Stage) bpEODDetails.getScene().getWindow();
            stage.close();
        }
    }
}
