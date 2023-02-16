/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jdbcDAO.*;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class EODController implements Initializable {

    @FXML
    private TableColumn<EOD, Integer> colEODID;
    @FXML
    private TableColumn<EOD, String> colEODTime;
    @FXML
    private TableColumn<EOD, Integer> colEODReceipt;
    @FXML
    private TableColumn<EOD, Integer> colEODPayment;
    @FXML
    private Button btnClose;
    @FXML
    public TableView<EOD> tvEOD;
    @FXML
    private BorderPane bpEOD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showReceiptDB();
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

    public ObservableList<EOD> getEOD() {
        ObservableList<EOD> eod = FXCollections.observableArrayList();
        java.sql.Connection cn = getConnect();
        String sql = "select eodID,eodTime,eodThu,eodChi from EOD";
        Statement st;
        ResultSet rs;
        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            EOD r = null;
            while (rs.next()) {
                r = new EOD(rs.getInt("eodID"), rs.getDate("eodTime").toLocalDate(), rs.getInt("eodThu"), rs.getInt("eodChi"));
                eod.add(r);
            }
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eod;
    }

    public void showReceiptDB() {
        ObservableList<EOD> list = getEOD();
        colEODID.setCellValueFactory(new PropertyValueFactory<EOD, Integer>("eodID"));
        colEODTime.setCellValueFactory(new PropertyValueFactory<EOD, String>("eodTime"));
        colEODReceipt.setCellValueFactory(new PropertyValueFactory<EOD, Integer>("eodThu"));
        colEODPayment.setCellValueFactory(new PropertyValueFactory<EOD, Integer>("eodChi"));
        tvEOD.setItems(list);
    }

    private void modalBoxEODDetail(String fxmlFile, String Title) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        EODDetailController userRole = loader.getController();
        EOD i = tvEOD.getSelectionModel().getSelectedItem();
        userRole.setName(i.getEodTime().toString());
        userRole.getEODChi(i.getEodTime());
        userRole.getEODThu(i.getEodTime());
        userRole.showChiEOD(i.getEodTime());
        userRole.showThuEOD(i.getEodTime());
        Stage window = new Stage();
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(Title);
        window.show();
    }

    @FXML
    private void handleMouseAction(MouseEvent event) throws IOException {
        if (event.getSource() == tvEOD && event.getClickCount() == 2) {
            modalBoxEODDetail("/FXMLFile/EODDetail.fxml", "EODDetail");
        }
        if (event.getSource() == btnClose) {
            Stage stage = (Stage) bpEOD.getScene().getWindow();
            stage.close();
        }
    }
}
