/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package FXMLFile;

import static FXMLFile.StaffSceneController.getConnect;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MenuDetailSceneController implements Initializable {

    @FXML
    private Button btnClose;
    @FXML
    private Label lbName;
    @FXML
    private Label lbPrice;
    @FXML
    private TextArea lbDescription;
    @FXML
    private BorderPane bpMenuDetail;
    private Image image;
    @FXML
    private ImageView imgDish;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setName(String name) {
        lbName.setText(name);
    }

    public void setPrice(String name) {
        lbPrice.setText(name);
    }

    public void setDescription(String name) {
        lbDescription.setText(name);
    }
    
    public void setImage(Image name) {
        imgDish.setImage(name);
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnClose) {
            Stage stage = (Stage) bpMenuDetail.getScene().getWindow();
            stage.close();
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
    
    public void showImage(String query, String staffID, ImageView img) {
        String sql = query;
        java.sql.Connection cn = getConnect();
        try {
            PreparedStatement st = cn.prepareStatement(sql);
            st.setString(1, staffID);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                InputStream is = rs.getBinaryStream(1);
                OutputStream os = new FileOutputStream(new File("photo.jpg"));
                byte[] contents = new byte[1024];
                int size = 0;
                while ((size = is.read(contents)) != -1) {
                    os.write(contents, 0, size);
                }
                image = new Image("file:photo.jpg", img.getFitHeight(), img.getFitWidth(), true, true);
                img.setImage(image);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(StaffSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
